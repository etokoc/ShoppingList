package com.ertugrulkc.shoppinglist.ui.shoppinglist

import com.ertugrulkc.shoppinglist.data.db.entities.ShoppinItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppinItem)
}