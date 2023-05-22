package com.example.assistant_mtc.screen.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assistant_mtc.R
import com.example.assistant_mtc.databinding.FragmentHomeBinding

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

    override fun onResume() {
        super.onResume()
        vm.getHomeLiveData().observe(viewLifecycleOwner) {
            homeAdapter.updateHomeList(it)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            recyclerViewHome.adapter = homeAdapter
            recyclerViewHome.layoutManager = LinearLayoutManager(requireContext())
            textViewGroupNum.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_groupFragment)
            }
        }
    }

    override fun onClick(command: Int) {
       findNavController().navigate(R.id.action_homeFragment_to_lessonFragment)
    }
}