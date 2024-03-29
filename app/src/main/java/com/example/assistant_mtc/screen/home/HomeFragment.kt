package com.example.assistant_mtc.screen.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assistant_mtc.R
import com.example.assistant_mtc.databinding.FragmentHomeBinding
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home), HomeAdapter.HomeOnClickListener {
    private lateinit var binding: FragmentHomeBinding
    private val vm: HomeVM by viewModels()
    private val homeAdapter = HomeAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        vm.getHomeLiveData().observe(viewLifecycleOwner) {
            homeAdapter.updateLessonList(it)
        }
        vm.getErrorLiveData().observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            recyclerViewHome.adapter = homeAdapter
            recyclerViewHome.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onClick(command: Int) {
        findNavController().navigate(R.id.action_homeFragment_to_lessonFragment)
    }
}