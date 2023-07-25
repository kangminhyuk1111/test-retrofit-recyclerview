package com.example.retrofittestapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofittestapp.databinding.RecyclerItemBinding

class Adapter(private val memberList: List<JsonDto.JsonDtoItem>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    inner class ViewHolder (val binding: RecyclerItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bindItem(memberList:JsonDto.JsonDtoItem){

            with(binding){
                title.text = memberList.title
                body.text = memberList.body
                ids.text = memberList.id.toString()
                userId.text = memberList.userId.toString()
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RecyclerItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int = memberList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = memberList[position]
        holder.bindItem(currentItem)
    }
}