package com.example.fragment_api

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentResultListener
import androidx.fragment.app.setFragmentResultListener
import kotlinx.android.synthetic.main.fragment_a.*


// nhan kêt quả
class Fragment_a : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        childFragmentManager.setFragmentResultListener(
            REQUEST_KEY,
            this, FragmentResultListener{ requestKey, result ->
                val number = result.getInt(KEY_NUMBER)
                edt_address.text = getString (R.string.app_name, number)
            })
            Fragment_a.beginTransaction().add(R.id.fragment_a, Fragment_a::class.java, null).commit()
    }

    companion object {
        const val REQUEST_KEY = "parent-request-key"
        const val KEY_NUMBER = "key-number"
    }
}


