package com.example.myproject.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.myproject.ui.fragments.HomeFragment
import com.example.myproject.ui.fragments.ProfileFragment
import com.example.myproject.ui.fragments.SearchFragment
import com.example.myproject.R
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



//        dashboardBinding.dashnav.setOnItemSelectedListener {
//            when(it.itemId){
//
//                R.id.home -> replaceFragment(HomeFragment())
//                R.id.profile -> replaceFragment(ProfileFragment())
//                R.id.search -> replaceFragment((SearchFragment()))
//
//                else -> {}
//            }
//            true

        }


}