package com.example.myproject

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.myproject.Fragment.HomeFragment
import com.example.myproject.Fragment.ProfileFragment
import com.example.myproject.Fragment.SearchFragment
import com.example.myproject.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {
    lateinit var dashboardBinding: ActivityDashboardBinding
    private fun replaceFragment( fragment : Fragment) {

        var fragmentManager : FragmentManager = supportFragmentManager
        var fragmentTransaction : FragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.dashframlayout,fragment)
        fragmentTransaction.commit()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dashboardBinding= ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(dashboardBinding.root)



        dashboardBinding.dashnav.setOnItemSelectedListener {
            when(it.itemId){

                R.id.home -> replaceFragment(HomeFragment())
                R.id.profile-> replaceFragment(ProfileFragment())
                R.id.search -> replaceFragment((SearchFragment()))

                else -> {}
            }
            true

        }


}}