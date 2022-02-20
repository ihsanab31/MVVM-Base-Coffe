package com.xd.ihsan.coffee.view.activities.home.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xd.ihsan.coffee.R
import com.xd.ihsan.coffee.view.activities.home.DetailActivity
import com.xd.ihsan.coffee.view.activities.home.HomeActivity
import com.xd.ihsan.core.data.model.Coffee
import com.xd.ihsan.core.data.model.Ingredients
import com.xd.ihsan.core.utils.COFFEE
import com.xd.ihsan.core.utils.SELECTED_COFFEE
import kotlinx.android.synthetic.main.item_coffee.view.*

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
class CoffeeAdapter(
    private val coffee: MutableList<Coffee>,
    private val activity: Context,
) : RecyclerView.Adapter<CoffeeAdapter.CoffeeViewHolder>() {
    private var ingredientsAdapter: IngredientsAdapter? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeeViewHolder {
        return CoffeeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_coffee, parent, false)
        )
    }

    override fun getItemCount(): Int = coffee.size

    override fun onBindViewHolder(holder: CoffeeViewHolder, position: Int) {
        holder.bind(coffee[position])
        holder.setIsRecyclable(false)

    }

    inner class CoffeeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("NotifyDataSetChanged", "SetTextI18n")
        fun bind(coffeeItem: Coffee) = with(itemView) {
            txt_title.text = coffeeItem.title
            if (coffeeItem.description!!.length > 100) {
                txt_description.text = coffeeItem.description!!.substring(0, 100) + "........."
            } else {
                txt_description.text = coffeeItem.description!!
            }
            txt_show.setOnClickListener {
                val intent = Intent(activity, DetailActivity::class.java)
                val bundle = Bundle()
                bundle.putParcelable(SELECTED_COFFEE, coffeeItem)
                intent.putExtra(COFFEE, bundle)
                activity.startActivity(intent)
            }
            val ingredientsList = ArrayList<Ingredients>()
            ingredientsAdapter = IngredientsAdapter(ingredientsList)
            val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            rv_ingredients.layoutManager = layoutManager
            rv_ingredients.adapter = ingredientsAdapter
            for (i in 0 until coffeeItem.ingredients!!.size) {
                val ingredients = Ingredients(coffeeItem.ingredients!![i])
                ingredientsList.add(ingredients)
            }
            ingredientsAdapter!!.notifyDataSetChanged()
        }
    }


}