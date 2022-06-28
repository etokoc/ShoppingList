package com.ertugrulkc.shoppinglist.data.repositories

import com.ertugrulkc.shoppinglist.data.db.ShoppingDatabase
import com.ertugrulkc.shoppinglist.data.db.entities.ShoppinItem

class ShoppingRepository(
    private val db: ShoppingDatabase
) {
   suspend fun upsert(item: ShoppinItem) = db.getShoppingDao().upsert(item)
   suspend fun delete(item: ShoppinItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItems()

}