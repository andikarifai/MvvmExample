package com.and.mvvmexample.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.and.mvvmexample.databinding.ItemUserBinding
import com.and.mvvmexample.model.ResponseDataUserItem

class UserAdapter(var ListUser:List<ResponseDataUserItem>): RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    class ViewHolder(var binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvName.text = ListUser[position].name
        holder.binding.tvUmur.text = ListUser[position].age.toString()
        holder.binding.tvAlamat.text = ListUser[position].address
    }

    override fun getItemCount(): Int {
        return ListUser.size
    }
}