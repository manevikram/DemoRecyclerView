package com.demo.recyclerview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class UserListActivity : AppCompatActivity() {

    private lateinit var recyclerview : RecyclerView
    private lateinit var userViewModel : UserViewModel
    private lateinit var userAdapter : UserListAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        supportActionBar?.title = "List Items"

        val userRepository = UserRepository()
        val userViewModelFactory = UserViewModelFactory(userRepository)
        userViewModel = ViewModelProvider(this, userViewModelFactory)[UserViewModel::class.java]
        userViewModel.getUserData()
        userViewModel.userLiveData.observe(this, Observer {
            userAdapter.setUserData(it as ArrayList<UserData>)
        })
        intiRecyclerView()
    }

    private fun intiRecyclerView() {
        recyclerview = findViewById (R.id.recyclerView)
        userAdapter = UserListAdapter(ArrayList())
        recyclerview.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@UserListActivity)
            adapter = userAdapter
        }
        userAdapter.onItemClick = {
            Toast.makeText(this, "Clicked - ${it.name}", Toast.LENGTH_SHORT).show()
        }
    }
}