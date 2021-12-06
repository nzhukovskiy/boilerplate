package com.example.boilerplateapp2.loginfragment

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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
        val add_btn :Button = root.findViewById(R.id.add_to_shared)
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
        add_btn.setOnClickListener {
            val text_edit : EditText = root.findViewById(R.id.edit_text)
            //val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
            if (!sharedPref!!.contains("SAVED")) {
                with (sharedPref!!.edit()) {
                    putString("SAVED", text_edit.text.toString())
                    apply()
                }
            }



        }
        val text_view : TextView = root.findViewById(R.id.login_text_view)
        text_view.text =  sharedPref!!.getString("SAVED", "No value")
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        // TODO: Use the ViewModel
    }

}