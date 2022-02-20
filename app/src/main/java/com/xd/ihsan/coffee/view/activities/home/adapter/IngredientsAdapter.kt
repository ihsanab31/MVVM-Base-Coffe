package com.xd.ihsan.coffee.view.activities.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xd.ihsan.coffee.R
import com.xd.ihsan.core.data.model.Ingredients
import kotlinx.android.synthetic.main.item_ingredients.view.*

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 085749729115
 * Date     : 2/20/2022
 * ------------------------------
 * This class for
 */
// Copyright (c) 2022 Ihsan Abdurahman. All rights reserved.
class IngredientsAdapter (
    private val ingredients: MutableList<Ingredients>,
) : RecyclerView.Adapter<IngredientsAdapter.IngredientsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientsViewHolder {
        return IngredientsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_ingredients, parent, false)
        )
    }

    override fun getItemCount(): Int = ingredients.size

    override fun onBindViewHolder(holder: IngredientsViewHolder, position: Int) {
        holder.bind(ingredients[position])
        holder.setIsRecyclable(false)

    }

    inner class IngredientsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(ingredientsItem: Ingredients) = with(itemView) {
            btn_ingredients.text = ingredientsItem.getName()

        }
    }
}
