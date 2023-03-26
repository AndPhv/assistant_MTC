package com.example.assistant_mtc.screen.lesson

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assistant_mtc.R
import com.example.assistant_mtc.databinding.FragmentLessonBinding

class LessonFragment: Fragment(R.layout.fragment_lesson) {
    private lateinit var binding: FragmentLessonBinding
    private val vm: LessonVM by viewModels()
    private val lessonAdapter = LessonAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLessonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        vm.getLessonLiveData().observe(viewLifecycleOwner) {
            lessonAdapter.updateLessonList(it)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            recyclerViewLesson.adapter = lessonAdapter
            recyclerViewLesson.layoutManager = LinearLayoutManager(requireContext())
        }
    }
}