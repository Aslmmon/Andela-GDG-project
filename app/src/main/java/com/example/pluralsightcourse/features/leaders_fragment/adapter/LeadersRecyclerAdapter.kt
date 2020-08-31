package com.example.pluralsightcourse.features.leaders_fragment.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import com.example.pluralsightcourse.R
import com.example.pluralsightcourse.data.model.LeadersResponse
import com.example.pluralsightcourse.data.model.LeadersResponseItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.leaders_item.view.*

class LeadersRecyclerAdapter(private val interaction: Interaction? = null) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val DIFF_CALLBACK = object : DiffUtil.ItemCallback<LeadersResponseItem>() {

        override fun areItemsTheSame(oldItem: LeadersResponseItem, newItem: LeadersResponseItem) =
            oldItem == newItem

        override fun areContentsTheSame(
            oldItem: LeadersResponseItem,
            newItem: LeadersResponseItem
        ) = oldItem.name == newItem.name

    }
    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return LeadersViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.leaders_item,
                parent,
                false
            ),
            interaction
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is LeadersViewHolder -> {
                holder.bind(differ.currentList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<LeadersResponseItem>) {
        differ.submitList(list)
    }

    class LeadersViewHolder
    constructor(
        itemView: View,
        private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(itemView) {

        @SuppressLint("SetTextI18n")
        fun bind(item: LeadersResponseItem) = with(itemView) {
            itemView.tv_name.text = item.name
            if(item.hours.toString() !=  "0") itemView.tv_score.text =  item.hours.toString() + " " + resources.getString(R.string.learning_hours)
            else itemView.tv_score.text = item.score.toString() + " " + resources.getString(R.string.skill_iq_score)
            itemView.tv_country.text = item.country
            Picasso.get().load(item.badgeUrl).into(itemView.iv_content)


        }
    }

    interface Interaction {
        fun onItemSelected(position: Int, item: LeadersResponseItem)
    }
}
