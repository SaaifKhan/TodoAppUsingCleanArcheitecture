package com.example.presenter.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.example.domain.model.ToDoData
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
        binding?.model = viewModel.request
        setupListener()
        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.add_fragment_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                if (menuItem.itemId == R.id.menu_add){
                    insertDataToDb()
                }else if (menuItem.itemId == androidx.appcompat.R.id.home){
                    requireActivity().onBackPressedDispatcher.onBackPressed()


                }
                return true
            }

        },viewLifecycleOwner,Lifecycle.State.RESUMED)


    }

    private fun setupListener() {

    }

    private fun insertDataToDb() {
        val mTitle = binding?.titleEt?.text.toString()
        val mPriority = binding?.prioritiesSpinner?.selectedItem.toString()
        val mDescription = binding?.descriptionEt?.text.toString()

        val validation = viewModel.verifyDataFromUser(mTitle, mDescription)
        if (validation) {
            // Insert Data to Database
//            val newData = ToDoData(
//                0,
//                mTitle,
//                viewModel.parsePriority(mPriority),
//                mDescription
//            )
            viewModel.request.priority = viewModel.parsePriority(mPriority)
            viewModel.request = binding?.model!!

            viewModel.insertData()
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_insertFragment_to_listFragment)
            // Navigate Back
//            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_SHORT)
                .show()
        }
    }


}