package com.demo.recyclerview

class UserRepository {

    fun getUserData():List<UserData> {
        val userList = ArrayList<UserData>()
        userList.add(UserData(R.drawable.ic_launcher_background,"jayant"))
        userList.add(UserData(R.drawable.ic_launcher_background,"aman"))
        userList.add(UserData(R.drawable.ic_launcher_background,"priya"))
        userList.add(UserData(R.drawable.ic_launcher_background,"nitin"))
        userList.add(UserData(R.drawable.ic_launcher_background,"naman"))
        userList.add(UserData(R.drawable.ic_launcher_background,"tina"))
        userList.add(UserData(R.drawable.ic_launcher_background,"ketan"))
        userList.add(UserData(R.drawable.ic_launcher_background,"ashu"))
        userList.add(UserData(R.drawable.ic_launcher_background,"nayan"))
        return userList
    }
}