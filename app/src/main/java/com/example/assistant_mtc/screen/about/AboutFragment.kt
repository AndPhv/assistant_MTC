package com.example.assistant_mtc.screen.about

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assistant_mtc.R
import com.example.assistant_mtc.databinding.FragmentAboutBinding
import com.sogya.mtc.domain.utils.CallbackListener

class AboutFragment : Fragment(R.layout.fragment_about), AboutAdapter.AboutOnClickListener {
    private lateinit var binding: FragmentAboutBinding
    private val vm: AboutVM by viewModels()
    private val aboutAdapter = AboutAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        vm.getAboutLiveData().observe(viewLifecycleOwner) {
            aboutAdapter.updateAboutList(it)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            rcView.adapter = aboutAdapter
            rcView.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onClick(command: String) {
        vm.openTelegramByCommand(command, object : CallbackListener<Intent> {
            override fun data(data: Intent) {
                startActivity(data)
            }

            override fun error(error: String) {
                Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
            }
        })
    }
}