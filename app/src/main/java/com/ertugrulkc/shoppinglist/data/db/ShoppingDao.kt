package com.ertugrulkc.shoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ertugrulkc.shoppinglist.data.db.entities.ShoppinItem

@Dao
interface ShoppingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppinItem)

    @Delete
    suspend fun delete(item: ShoppinItem)

    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItems() : LiveData<List<ShoppinItem>>
}