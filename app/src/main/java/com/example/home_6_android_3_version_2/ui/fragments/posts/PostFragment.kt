package com.example.home_6_android_3_version_2.ui.fragments.posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.home_6_android_3_version_2.databinding.FragmentPostBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostFragment : Fragment() {

    private var binding: FragmentPostBinding? = null
    private val viewModel by viewModels<PostsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPostBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserves()
        setupRequests()
    }

    private fun setupObserves() {
        viewModel.postLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_SHORT).show()
        }
        viewModel.errorLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupRequests() = binding?.let { binding ->
        binding.btmSendPost.setOnClickListener {
            val postId = binding.etPostNumber.text.toString().toInt()
            val postTitle = binding.etPostTitle.text.toString().trim()
            val postBody = binding.etPostDescription.text.toString().trim()
            viewModel.sendPost(
                userid = 11, id = postId, title = postTitle, body = postBody
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}