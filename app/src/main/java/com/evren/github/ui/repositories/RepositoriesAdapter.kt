package com.evren.github.ui.repositories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.evren.github.databinding.ItemRepositoriesBinding


class RepositoriesAdapter(private val repositoriesCallbacks : RepositoriesCallbacks) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items : List<RepositoriesItemUiState> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemRepositoriesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RepositoriesViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as RepositoriesViewHolder).bind(items[position],repositoriesCallbacks.onRepositoryClicked)
    }

    fun update(newItems : List<RepositoriesItemUiState>){
            val diffCallBack = RepositoriesDiffUtil(items, newItems)
            val diffResult = DiffUtil.calculateDiff(diffCallBack)
            diffResult.dispatchUpdatesTo(this)
            items = newItems
    }

}