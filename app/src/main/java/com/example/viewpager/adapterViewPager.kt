package com.example.viewpager

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.viewpager.databinding.PagerBinding


class adapterViewPager(var items:ArrayList<MyItems>):RecyclerView.Adapter<adapterViewPager.ContentViews>() {

    class ContentViews(v:PagerBinding):RecyclerView.ViewHolder(v.root) {

        val avatar: ImageView
        val name:TextView

        init {
            avatar=v.imgAvatar
            name=v.txtName
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): adapterViewPager.ContentViews {

        val views=PagerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ContentViews(views)

    }

    override fun onBindViewHolder(holder: adapterViewPager.ContentViews, position: Int) {

        var element=items.get(position)

        holder.name.text=element.nombre
        Glide
            .with(holder.avatar.context)
            .load(element.res)

            .placeholder(R.drawable.ic_baseline_question_mark_24)
            .into(holder.avatar);

    }

    override fun getItemCount()=items.size


}