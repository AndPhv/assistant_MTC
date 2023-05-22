package com.example.assistant_mtc.screen.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.assistant_mtc.R
import com.example.assistant_mtc.databinding.FragmentAuthBinding

class AuthFragment : Fragment(R.layout.fragment_auth) {
    private var _binding: FragmentAuthBinding? = null
    private val binding get() = _binding!!
    private val vm: AuthVM by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAuthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            buttonLogIn.setOnClickListener {
                findNavController().navigate(
                    R.id.action_authFragment_to_homeFragment,
                    bundleOf(),
                    navOptions = navOptions {
                        launchSingleTop = true
                        popUpTo(R.id.nav_graph) {
                            inclusive = true
                        }
                    })
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}