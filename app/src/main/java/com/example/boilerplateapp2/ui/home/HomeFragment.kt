package com.example.boilerplateapp2.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.boilerplateapp2.R
import com.example.boilerplateapp2.databinding.FragmentHomeBinding
import com.example.boilerplateapp2.mainfragment.MainViewModel

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        /*homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/
        //homeviewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        val btn : Button = binding.homeFragButton
        //val btn : Button = root.findViewById(R.id.home_frag_button)
        //Log.v(activity?.supportFragmentManager?.findFragmentById(R.id.nav_main_host_fragment).toString(), "111111111")
        //val nav_host_frag = childFragmentManager.findFragmentById(R.id.nav_main_host_fragment) as NavHostFragment
        //val nav_host_frag = activity?.supportFragmentManager?.findFragmentById(R.id.nav_main_host_fragment) as NavHostFragment
        //val nav_controller = nav_host_frag.navController
        btn.setOnClickListener{
            val nav_host_frag = activity?.supportFragmentManager?.findFragmentById(R.id.nav_host_fragment_activity_bottom) as NavHostFragment
            val nav_controller = nav_host_frag.navController
            nav_controller.navigate(R.id.navigation_dashboard)
            Log.v(nav_controller.toString(), "222222222222")
            //nav_controller.(R.id.action_homeFragment_to_dashboardFragment)
        }
        homeViewModel.request_cities().observe(viewLifecycleOwner, {
            textView.text = it[0].Country
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}