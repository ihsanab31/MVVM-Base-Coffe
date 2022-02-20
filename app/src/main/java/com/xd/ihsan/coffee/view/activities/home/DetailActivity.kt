package com.xd.ihsan.coffee.view.activities.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.xd.ihsan.coffee.R
import com.xd.ihsan.coffee.view.activities.home.adapter.IngredientsAdapter
import com.xd.ihsan.core.data.model.Coffee
import com.xd.ihsan.core.data.model.Ingredients
import com.xd.ihsan.core.utils.COFFEE
import com.xd.ihsan.core.utils.SELECTED_COFFEE
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    private lateinit var coffee: Coffee
    private var ingredientsAdapter: IngredientsAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        iniView()
    }

    private fun iniView() {
        val bundle = intent.getBundleExtra(COFFEE)
        coffee = bundle!!.getParcelable<Coffee>(SELECTED_COFFEE) as Coffee
        txt_title_detail.text = coffee.title
        txt_description_detail.text = coffee.description!!

        val ingredientsList = ArrayList<Ingredients>()
        ingredientsAdapter = IngredientsAdapter(ingredientsList)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_ingredients.layoutManager = layoutManager
        rv_ingredients.adapter = ingredientsAdapter
        for (i in 0 until coffee.ingredients!!.size) {
            val ingredients = Ingredients(coffee.ingredients!![i])
            ingredientsList.add(ingredients)
        }
        btn_tutup.setOnClickListener { finish() }
    }
}