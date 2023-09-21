package com.example.presenter.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
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
        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.add_fragment_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                if (menuItem.itemId == R.id.menu_add){
                    Toast.makeText(requireContext(),"Add",Toast.LENGTH_LONG).show()
                }else if (menuItem.itemId == androidx.appcompat.R.id.home){
                    requireActivity().onBackPressedDispatcher.onBackPressed()


                }
                return true
            }

        },viewLifecycleOwner,Lifecycle.State.RESUMED)


    }




}