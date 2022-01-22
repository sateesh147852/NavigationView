package com.navigationDrawer.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.navigationDrawer.R


class NotificationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notification, container, false)
    }

    companion object {

        private var notificationFragment: NotificationFragment? = null
        fun getInstance(): NotificationFragment {
            if (notificationFragment == null) {
                synchronized(this) {
                    notificationFragment = NotificationFragment()
                }

            }
            return notificationFragment!!
        }
    }
}