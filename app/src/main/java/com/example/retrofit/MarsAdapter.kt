package com.example.retrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofit.databinding.LandListBinding
import com.example.retrofit.model.local.MarsEntity

class MarsAdapter : RecyclerView.Adapter<MarsAdapter.MarsVH>() {

    private var listLand = listOf<MarsEntity>()

    fun update(list : List<MarsEntity>) {
        listLand = list
        notifyDataSetChanged()

    }

    inner class MarsVH(private val mBinding: LandListBinding) : RecyclerView.ViewHolder(mBinding.root) {
        fun bind(land : MarsEntity){
            land.imgSrc
            Glide.with(view).load(land.imgSrc).into(mBinding.ivLand)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsVH {
        return MarsVH(LandListBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MarsVH, position: Int) {
        val land = listLand[position]
        holder.bind(land)

    }

    override fun getItemCount(): Int = listLand.size






}