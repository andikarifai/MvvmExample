package com.and.mvvmexample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.and.mvvmexample.R
import com.and.mvvmexample.databinding.ActivityMainBinding
import com.and.mvvmexample.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var userAdapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setVmAdapter()
    }
    fun setVmAdapter(){
        val viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        viewModel.getLiveDataUser().observe(this, Observer {
            userAdapter = UserAdapter(it)
            val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding.rvHome.layoutManager = layoutManager
            binding.rvHome.adapter = userAdapter
        })
    }
}