package com.demo.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserListAdapter(private var userListData : List<UserData>) : RecyclerView.Adapter<UserListAdapter.UserListItemViewHolder>() {

    var onItemClick : ((UserData) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_row, parent, false)
        return UserListItemViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: UserListItemViewHolder, position: Int) {
        val itemData = userListData[position]
        viewHolder.userImage.setImageResource(itemData.image)
        viewHolder.userName.text = itemData.name
        viewHolder.itemView.setOnClickListener {
            onItemClick?.invoke(itemData)
        }
    }

    override fun getItemCount() : Int {
        return userListData.size
    }

    class UserListItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userImage : ImageView = itemView.findViewById(R.id.userImage)
        val userName : TextView = itemView.findViewById(R.id.username)
    }

    fun setUserData(userListData: List<UserData>){
        this.userListData = userListData
    }
}