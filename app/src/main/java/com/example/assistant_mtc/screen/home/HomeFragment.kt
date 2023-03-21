package com.example.assistant_mtc.screen.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assistant_mtc.R
import com.example.assistant_mtc.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {
    //Binding это замена findViewById
    private lateinit var binding:FragmentHomeBinding
    private val vm: HomeVM by viewModels()
    private val homeAdapter = HomeAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        vm.getHomeLiveData().observe(viewLifecycleOwner) {
            homeAdapter.updateHomeList(it)
        }
    }

    //Вся работа с view происзодит в этом методе, оналог onCreate() у активити
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            //Здесь работаем с эелементами, достаточно написать его id

            rcView.adapter = homeAdapter
            rcView.layoutManager = LinearLayoutManager(requireContext())
        }
    }
}