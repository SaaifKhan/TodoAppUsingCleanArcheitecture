package com.example.presenter.ui

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.Fragment
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.presenter.R
import com.example.presenter.databinding.FragmentListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ListFragment : Fragment(R.layout.fragment_list), SearchView.OnQueryTextListener {

    private val viewModel: ListViewModel by viewModels()
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding

    lateinit var adapter: ListAdapter
    lateinit var layoutManager: LinearLayoutManager


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.list_fragment_menu, menu)


                val search = menu.findItem(R.id.menu_search)
                val searchView = search.actionView as? SearchView
                searchView?.isSubmitButtonEnabled = true
                searchView?.setOnQueryTextListener(this@ListFragment)


            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return true
            }

        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
        _binding = FragmentListBinding.bind(view)
        binding?.viewmodel = viewModel
        binding?.lifecycleOwner = viewLifecycleOwner

        setupAdapter(binding?.recyclerView)
        setupObservers()
    }

    private fun setupObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.dataState.filterNotNull().distinctUntilChanged().collectLatest {
                    adapter.addItems(it)
                    binding?.recyclerView?.scheduleLayoutAnimation()
                }
            viewModel.dataStateSearched.filterNotNull().distinctUntilChanged().collectLatest {
                    adapter.addItems(it)
                    binding?.recyclerView?.scheduleLayoutAnimation()

                }
        }

    }


    private fun setupAdapter(view: RecyclerView?) {
        try {

            adapter = ListAdapter()
            view?.adapter = adapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            view?.layoutManager = layoutManager
        } catch (e: Exception) {
            print(e.printStackTrace())
        }
    }

    private fun searchThroughDatabase(query: String) {
        val searchQuery = "%$query%"
        viewModel.searchData(searchQuery)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (query != null) {
            searchThroughDatabase(query)
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if (newText != null) {
            searchThroughDatabase(newText)
        }
        return true
    }
}


