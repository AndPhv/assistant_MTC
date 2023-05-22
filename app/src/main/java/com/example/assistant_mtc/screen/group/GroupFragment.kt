package com.example.assistant_mtc.screen.group

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.assistant_mtc.R
import com.example.assistant_mtc.databinding.FragmentGroupBinding

class GroupFragment : Fragment(R.layout.fragment_group) {
    private var _binding:FragmentGroupBinding? = null
    private val binding get() = _binding!!
    private val vm: GroupVM by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGroupBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            textViewGroup.text = "Учебный взвод 551"
            textViewCourse.text = "Курс: 4"
            textViewDepartament.text ="Кафедра: ВКС (Воздушно-космические силы)"
            textViewSpecialization.text = "Направление: Эксплуатация и ремонт бортовых авиационных средств РЭБ (541100)"
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}