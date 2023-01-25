package com.example.home_6_android_3_version_2.ui.fragments.get

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.home_6_android_3_version_2.databinding.FragmentPhotoBinding
import com.example.home_6_android_3_version_2.ui.adapters.PhotoAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotoFragment : Fragment() {

    private var binding: FragmentPhotoBinding? = null
    private val viewModel by viewModels<PhotoViewModel>()
    private var photoAdapter = PhotoAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPhotoBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupObserve()
    }

    private fun initialize() {
        binding?.rvList?.adapter = photoAdapter
    }

    private fun setupObserve() {
        viewModel.photoLiveData.observe(viewLifecycleOwner) {
            photoAdapter.submitList(it)
        }
        viewModel.errorPhotoLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
    }
}
