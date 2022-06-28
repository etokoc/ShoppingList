package com.ertugrulkc.shoppinglist.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ertugrulkc.shoppinglist.R
import com.ertugrulkc.shoppinglist.data.db.entities.ShoppinItem
import com.ertugrulkc.shoppinglist.ui.shoppinglist.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*

class ShoppingItemAdapter(var items: List<ShoppinItem>, private val viewModel: ShoppingViewModel) :
    RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val currentShoppingItem = items[position]
        holder.itemView.apply {
            tvName.text = currentShoppingItem.name
            tvAmount.text = currentShoppingItem.amount.toString()
            ivDelete.setOnClickListener {
                viewModel.delete(currentShoppingItem)
            }
            ivPlus.setOnClickListener {
                currentShoppingItem.amount++
                viewModel.upsert(currentShoppingItem)
            }
            ivMinus.setOnClickListener {
                if (currentShoppingItem.amount > 0) {
                    currentShoppingItem.amount--
                    viewModel.upsert(currentShoppingItem)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ShoppingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}