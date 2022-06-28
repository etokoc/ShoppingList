package com.ertugrulkc.shoppinglist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.ertugrulkc.shoppinglist.data.db.entities.ShoppinItem
import com.ertugrulkc.shoppinglist.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(private val repository:ShoppingRepository):ViewModel() {
    
    fun upsert(item: ShoppinItem) = CoroutineScope(Dispatchers.Main).launch { 
        repository.upsert(item)
    }
    fun delete(item: ShoppinItem) = CoroutineScope(Dispatchers.Main).launch { 
        repository.delete(item)
    }
    
    fun getAllShoppingItems() = repository.getAllShoppingItems()
}