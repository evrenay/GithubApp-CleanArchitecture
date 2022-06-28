package com.evren.github.ui.owner

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.evren.github.R
import com.evren.github.base.BaseFragment
import com.evren.github.common.observe
import com.evren.github.databinding.FragmentOwnerRepositoriesBinding
import com.evren.github.ui.repositories.RepositoriesAdapter
import com.evren.github.ui.repositories.RepositoriesCallbacks
import com.evren.github.util.ext.executeWithAction
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class OwnerRepositoriesFragment() : BaseFragment<FragmentOwnerRepositoriesBinding>() {

    override val layoutRes: Int = R.layout.fragment_owner_repositories

    private val viewModel: OwnerRepositoriesViewModel by viewModels()

    private var ownerRepositoriesAdapter: OwnerRepositoriesAdapter ?= null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
        getDataFromRepositoryDetail()

        binding.imgBack.setOnClickListener {
            findNavController().popBackStack()
        }

    }

    private fun getDataFromRepositoryDetail() {
        arguments?.getString("owner")?.let { user ->
            viewModel.getDataAsynchronously(user)
        }
    }

    private fun observeData() {
        observe(viewModel.ownerContents_){
            binding.executeWithAction {
                userViewState = it
            }
        }
        observe(viewModel.ownerStatus_){
            binding.executeWithAction {
                userStatusViewState = it
            }
        }

        observe(viewModel.ownerRepositoriesContents_){
            ownerRepositoriesAdapter = OwnerRepositoriesAdapter()
            binding.recyclerOwnerRepos.adapter = ownerRepositoriesAdapter
            ownerRepositoriesAdapter?.update(it)
        }
        observe(viewModel.ownerRepositoriesStatus_){
            binding.executeWithAction {
                reposStatusViewState = it
            }
        }
    }


}