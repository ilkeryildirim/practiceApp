package com.ilkeryildirim.vitrinova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.ilkeryildirim.vitrinova.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = findNavController(R.id.hostFragment)
        setupBottomNavigation()
    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()

    }

    private fun setupBottomNavigation() {
       binding.bottomNavigation.setupWithNavController(navController)
        appBarConfiguration = AppBarConfiguration(navController.graph,binding.drawerLayout)
        NavigationUI.setupActionBarWithNavController(this,navController,binding.drawerLayout)
    }

}