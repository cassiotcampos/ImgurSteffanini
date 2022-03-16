package com.example.imgursteffanini.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.imgursteffanini.R
import com.example.imgursteffanini.api.Resource
import com.example.imgursteffanini.api.RetrofitBuilder
import com.example.imgursteffanini.api.Status
import com.example.imgursteffanini.databinding.MainFragmentBinding
import com.example.imgursteffanini.model.ImgurData
import com.example.imgursteffanini.viewmodel.MainViewModel
import com.example.imgursteffanini.viewmodel.ViewModelFactory


class MainFragment : Fragment() {

    private val galleryAdapter by lazy { GalleryAdapter() }

    private lateinit var binding: MainFragmentBinding

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(layoutInflater)
        binding.rvCats.adapter = galleryAdapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        observeGetGallery()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(
            requireActivity(),
            ViewModelFactory(RetrofitBuilder.apiService)
        )[MainViewModel::class.java]
    }

    private fun observeGetGallery() {
        viewModel.getCats().observe(this.viewLifecycleOwner) { imgurData ->
            imgurData?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> loadCats(imgurData)
                    Status.LOADING -> viewModel.setLoading(true)
                    Status.ERROR -> viewModel.setLoading (false)
                    else -> viewModel.setLoading (false)
                }
            }
        }
    }

    private fun loadCats(imgurData: Resource<ImgurData?>) {
        galleryAdapter.submitList(imgurData.data?.data)
        viewModel.setLoading(false)
    }
}