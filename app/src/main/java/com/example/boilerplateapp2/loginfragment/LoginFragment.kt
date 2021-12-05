package com.example.boilerplateapp2.loginfragment

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.NavHostFragment
import com.example.boilerplateapp2.BottomActivity
import com.example.boilerplateapp2.R

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root=  inflater.inflate(R.layout.login_fragment, container, false)
        val btn : Button = root.findViewById(R.id.button)
        //val nav_frag = activity?.supportFragmentManager?.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        //val nav_controller = nav_frag.navController
        btn.setOnClickListener{
            val intent = Intent(activity, BottomActivity::class.java).apply {  }
            startActivity(intent)
            //nav_controller.navigate(R.id.action_loginFragment_to_mainFragment)
        }
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        // TODO: Use the ViewModel
    }

}