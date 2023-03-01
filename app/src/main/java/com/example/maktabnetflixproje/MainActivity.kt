package com.example.maktabnetflixproje

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.maktabnetflixproje.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    lateinit var navHostFragment: NavHostFragment
    lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.findNavController()
        binding.bottomNav.setupWithNavController(navController)
        binding.bottomNav.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home_fragment -> navController.navigate(NavGraphDirections.actionGlobalHomeFragment())
                R.id.profile_fragment -> navController.navigate(NavGraphDirections.actionGlobalProfileFragment())
                R.id.favorite_fragment -> navController.navigate(NavGraphDirections.actionGlobalFavoriteFragment())
                R.id.coming_soon_fragment -> navController.navigate(NavGraphDirections.actionGlobalComingSoonFragment())
            }
            return@setOnItemSelectedListener true
        }
    }
}