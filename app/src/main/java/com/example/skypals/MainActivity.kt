package com.example.skypals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.skypals.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var fragmentManager: FragmentManager
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val toggle = ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar, R.string.nav_open, R.string.nav_close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navigationDrawer.setNavigationItemSelectedListener(this)

        binding.bottomNavigation.background = null
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.bottom_home -> openFragment(HomeFragment())
                R.id.bottom_discover -> openFragment(DiscoverFragment())
                R.id.bottom_collection -> openFragment(CollectionFragment())
                R.id.bottom_settings -> openFragment(SettingsFragment())
            }
            true
        }
        fragmentManager = supportFragmentManager
        openFragment(HomeFragment())

        binding.fab.setOnClickListener {
            Toast.makeText(this, "Camera", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_profile -> openFragment(ProfileFragment())
            R.id.nav_birdpacks -> openFragment(BirdPacksFragment())
            R.id.nav_feedback -> openFragment(FeedbackFragment())
            R.id.nav_support -> openFragment(SupportFragment())
            R.id.nav_terms -> openFragment(TermsOfUseFragment())
            R.id.nav_privacy -> openFragment(PrivacyPolicyFragment())
            R.id.nav_logout -> {
                // Redirect to LoginActivity (or your login activity)
                val intent = Intent(this, Login::class.java)
                startActivity(intent)
                // You can also finish the current activity to close it
                finish()
            }
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            super.getOnBackPressedDispatcher().onBackPressed()
        }
    }
    private fun openFragment(fragment: Fragment){
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }
}