package com.evren.github.ui.repositories

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.evren.github.R
import com.evren.github.base.BaseFragment
import com.evren.github.common.observe
import com.evren.github.databinding.FragmentRepositoriesBinding
import com.evren.github.util.ext.executeWithAction
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class RepositoriesFragment() : BaseFragment<FragmentRepositoriesBinding>() {

    override val layoutRes: Int = R.layout.fragment_repositories

    private val viewModel: RepositoriesViewModel by viewModels()

    private var repositoriesAdapter: RepositoriesAdapter ?= null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
    }

    private fun observeData() {
        observe(viewModel.contents_){
            repositoriesAdapter = RepositoriesAdapter(
                RepositoriesCallbacks(::onRepositoryClicked))
            binding.recyclerRepositories.adapter = repositoriesAdapter
            repositoriesAdapter?.update(it)
        }
        observe(viewModel.status_){
            binding.executeWithAction {
                statusViewState = it
            }
        }
    }

    private fun onRepositoryClicked(selectedRepository : RepositoriesItemUiState){
        val bundle = Bundle()
        bundle.putString("repositoryName",selectedRepository.getRepoName())
        bundle.putString("ownerName",selectedRepository.getOwnerName())
        findNavController().navigate(R.id.action_navigationRepositories_to_navigationRepositoryDetail,bundle)
    }




}