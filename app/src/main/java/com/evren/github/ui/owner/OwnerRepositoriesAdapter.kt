package com.evren.github.ui.owner

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.evren.github.databinding.ItemOwnerRepositoriesBinding
import com.evren.github.databinding.ItemRepositoriesBinding
import com.evren.github.ui.repositories.RepositoriesDiffUtil
import com.evren.github.ui.repositories.RepositoriesItemUiState
import com.evren.github.ui.repositories.RepositoriesViewHolder

class OwnerRepositoriesAdapter() :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items : List<OwnerRepositoriesUiState> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemOwnerRepositoriesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OwnerRepositoriesViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as OwnerRepositoriesViewHolder).bind(items[position])
    }

    fun update(newItems : List<OwnerRepositoriesUiState>){
        val diffCallBack = OwnerRepositoriesDiffUtil(items, newItems)
        val diffResult = DiffUtil.calculateDiff(diffCallBack)
        diffResult.dispatchUpdatesTo(this)
        items = newItems
    }

}