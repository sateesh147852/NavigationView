package com.navigationDrawer.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.navigationDrawer.R


class WalletFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_wallet, container, false)
    }

    companion object {

        private var walletFragment: WalletFragment? = null
        fun getInstance(): WalletFragment {
            if (walletFragment == null) {
                synchronized(this) {
                    walletFragment = WalletFragment()
                }

            }
            return walletFragment!!
        }
    }
}