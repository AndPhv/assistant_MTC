package com.example.assistant_mtc.screen

import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.assistant_mtc.R
import com.example.assistant_mtc.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupNavigation()
        navController.addOnDestinationChangedListener { _, destination, _ ->
            supportActionBar?.title = destination.label
            when (destination.id) {
                R.id.authFragment -> {
                    binding.bottomNavMenu.visibility = View.GONE
                    binding.topAppBar.visibility = View.GONE
                }

                else -> {
                    binding.bottomNavMenu.visibility = View.VISIBLE
                    binding.topAppBar.visibility = View.VISIBLE
                }
            }
        }
        binding.topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.settingsFragment -> {
                    navController.navigate(it.itemId)
                    true
                }

                R.id.groupFragment -> {
                    navController.navigate(it.itemId)
                    true
                }

                else -> false
            }
        }
        binding.topAppBar.title = "Учебный взвод 551"

    }

    private fun setupNavigation() {
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController
        binding.bottomNavMenu.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.appbar_menu, menu)
        return true
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        super.onBackPressed()
        for (i in 0 until supportFragmentManager.backStackEntryCount) {
            supportFragmentManager.popBackStack()
        }
    }
}