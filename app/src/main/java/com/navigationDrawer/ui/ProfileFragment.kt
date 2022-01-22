package com.navigationDrawer.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.navigationDrawer.R
import com.navigationDrawer.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    private lateinit var binding : FragmentProfileBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentProfileBinding.inflate(inflater,container,false)
        return binding.root
    }

    companion object {

        private var profileFragment: ProfileFragment? = null

        fun getInstance() : ProfileFragment {
            if (profileFragment == null){
                synchronized(this){
                    profileFragment = ProfileFragment()
                }
            }
            return profileFragment!!
        }
    }
}