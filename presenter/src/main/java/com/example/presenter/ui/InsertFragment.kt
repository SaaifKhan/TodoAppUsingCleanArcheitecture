package com.example.presenter.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.presenter.R
import com.example.presenter.databinding.FragmentInsertBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class InsertFragment : Fragment(R.layout.fragment_insert) {

    private val viewModel: InsertViewModel by viewModels()


    private var _binding: FragmentInsertBinding? = null
    private val binding get() = _binding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentInsertBinding.bind(view)
        binding?.viewmodel = viewModel
        binding?.lifecycleOwner = viewLifecycleOwner


    }




}