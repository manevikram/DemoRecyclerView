package com.demo.recyclerview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _userLiveData : MutableLiveData<List<UserData>> = MutableLiveData()

    val userLiveData : LiveData<List<UserData>>
        get() = _userLiveData

    fun getUserData() {
        val userData = userRepository.getUserData()
        _userLiveData.value = userData
    }
}