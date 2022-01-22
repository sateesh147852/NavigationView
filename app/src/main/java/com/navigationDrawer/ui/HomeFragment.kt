package com.navigationDrawer.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.navigationDrawer.R


class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    companion object {
        private var homeFragment: HomeFragment? = null

        fun getInstance() : HomeFragment {
            if (homeFragment == null){
                synchronized(this){
                    homeFragment = HomeFragment()
                }
            }
            return homeFragment!!
        }
    }
}