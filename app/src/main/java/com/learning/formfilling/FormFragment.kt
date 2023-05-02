package com.learning.formfilling

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.learning.formfilling.data.User
import com.learning.formfilling.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
private const val TAG = "FormFragment"
class FormFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveBT.setOnClickListener {
            saveUserDetails()
        }
    }

    private fun saveUserDetails() {
        val user = User(
            1,
            binding.firstNameTie.text.toString(),
            binding.lastNameTie.text.toString(),
            binding.phoneNoTie.text.toString().toIntOrNull() ?: 0,
            binding.cityTie.text.toString(),
            binding.stateTie.text.toString(),
            binding.countryTie.text.toString(),
            binding.pincodeTie.text.toString().toIntOrNull() ?: 0
        ).also {
            Log.d(TAG, "saveUserDetails: $it saved")
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}