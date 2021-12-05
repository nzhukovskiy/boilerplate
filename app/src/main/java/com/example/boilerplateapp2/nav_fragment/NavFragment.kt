package com.example.boilerplateapp2.nav_fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.boilerplateapp2.R

class NavFragment : Fragment() {

    companion object {
        fun newInstance() = NavFragment()
    }

    private lateinit var viewModel: NavViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.nav_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NavViewModel::class.java)
        // TODO: Use the ViewModel
    }

}