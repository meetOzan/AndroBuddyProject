package com.mertozan.androbuddyproject.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mertozan.androbuddyproject.data.model.ValorantModel
import com.mertozan.androbuddyproject.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var _binding: FragmentHomeBinding
    val binding get() = _binding

    private lateinit var adapter: CharacterListAdapter
    private val homeViewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,

        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            headerCardFragment.tvHeaderPlay.setOnClickListener {
                Toast.makeText(
                    requireContext(),
                    "Video Header Clicked",
                    Toast.LENGTH_SHORT
                ).show()
            }
            headerCardFragment.headerPlayArrow.setOnClickListener {
                Toast.makeText(
                    requireContext(),
                    "Video Header Clicked",
                    Toast.LENGTH_SHORT
                ).show()
            }
            /*
            recyclerView.adapter = CharacterListAdapter()
            recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)*/
        }

        observeData()
    }


    private fun observeData() {
        homeViewModel.homeUiState.observe(viewLifecycleOwner) { uiState ->
            when {
                uiState.isLoading -> {
                    binding.progressCircularBar.visibility = View.VISIBLE
                }

                uiState.isError -> {
                    Toast.makeText(requireContext(), uiState.errorMessage, Toast.LENGTH_SHORT)
                        .show()
                }

                else -> {
                    initCharacterList(uiState.characterList)
                }
            }
        }
    }

    private fun initCharacterList(characterList: List<ValorantModel>) {
        with(binding) {
            adapter = CharacterListAdapter(characterList)
            recyclerView.adapter = adapter
            progressCircularBar.visibility = View.INVISIBLE
        }
    }

}