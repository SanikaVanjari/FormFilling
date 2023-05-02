package com.learning.formfilling

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.learning.formfilling.data.MainRepository
import com.learning.formfilling.data.User
import com.learning.formfilling.data.db.AppDatabase
import com.learning.formfilling.databinding.FragmentSecondBinding
import kotlinx.coroutines.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
private const val TAG = "FormFragment"

class FormFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val coroutineScope by lazy {
        CoroutineScope(Dispatchers.IO)
    }

    private val repository by lazy {
        MainRepository(database = AppDatabase.getInstance(this.requireContext()))
    }

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
            firstName = binding.firstNameTie.text.toString(),
            lastName = binding.lastNameTie.text.toString(),
            phoneNo = binding.phoneNoTie.text.toString().toIntOrNull() ?: 0,
            city = binding.cityTie.text.toString(),
            state = binding.stateTie.text.toString(),
            country = binding.countryTie.text.toString(),
            pincode = binding.pincodeTie.text.toString().toIntOrNull() ?: 0
        ).also {
            Log.d(TAG, "saveUserDetails: $it added")
        }

        coroutineScope.launch {
            repository.insertUser(user)
        }.also {
            findNavController().popBackStack()
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}