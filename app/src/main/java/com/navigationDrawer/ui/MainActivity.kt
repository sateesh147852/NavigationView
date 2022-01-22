package com.navigationDrawer.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import com.navigationDrawer.R
import com.navigationDrawer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeNavigationDrawer()
        fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction()
            .replace(binding.flContainer.id, HomeFragment.getInstance())
            .commit()

    }

    private fun initializeNavigationDrawer() {

        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item))
            return true
        return super.onOptionsItemSelected(item)

    }

    override fun onBackPressed() {
        closeNavigationView()

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

        when (item.itemId) {

            R.id.home -> {
                fragmentTransaction.replace(binding.flContainer.id, HomeFragment.getInstance())
            }

            R.id.profile -> {
                fragmentTransaction.replace(binding.flContainer.id, ProfileFragment.getInstance())
            }

            R.id.settings -> {
                fragmentTransaction.replace(binding.flContainer.id, SettingsFragment.getInstance())
            }

            R.id.wallet -> {
                fragmentTransaction.replace(binding.flContainer.id, WalletFragment.getInstance())
            }

            R.id.chat -> {
                fragmentTransaction.replace(binding.flContainer.id, ChatFragment.getInstance())
            }

            R.id.notification -> {
                fragmentTransaction.replace(binding.flContainer.id, NotificationFragment.getInstance())
            }

        }
        fragmentTransaction.commit()
        closeNavigationView()
        return true
    }

    private fun closeNavigationView(){
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START))
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        else {
            finish()
        }
    }


}