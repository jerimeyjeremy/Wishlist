package com.example.wishlist

class ItemFetcher {
    companion object {
        private var itemList: MutableList<Item> = ArrayList()

        fun getItemList(): MutableList<Item> {
            return itemList
        }

        fun addItem(item: Item) {
            itemList.add(item)
        }
    }
}
