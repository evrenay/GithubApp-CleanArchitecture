package com.evren.github.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.evren.github.R
import com.evren.github.base.BaseFragment
import com.evren.github.common.observe
import com.evren.github.databinding.FragmentRepositoryDetailBinding
import com.evren.github.util.ext.executeWithAction
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RepositoryDetailFragment() : BaseFragment<FragmentRepositoryDetailBinding>() {

    override val layoutRes: Int = R.layout.fragment_repository_detail

    private val viewModel: RepositoryDetailViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
        getDataFromRepositories()

        binding.ivAvatar.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("owner",viewModel.ownerName)
            findNavController().navigate(R.id.action_navigationRepositoryDetail_to_navigationOwnerRepositories,bundle)
        }
        binding.imgBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun getDataFromRepositories() {
        arguments?.getString("repositoryName")?.let { repo->
            arguments?.getString("ownerName")?.let { owner->
                viewModel.ownerName = owner
                viewModel.getRepository(repo,owner)
            }
        }
    }


    private fun observeData() {
        observe(viewModel.contents_){
            binding.executeWithAction {
                repositoryViewState = it
            }
        }
        observe(viewModel.status_){
            binding.executeWithAction {
                statusViewState = it
            }
        }
    }
}