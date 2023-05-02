package com.learning.formfilling

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.learning.formfilling.data.MainRepository
import com.learning.formfilling.data.db.AppDatabase
import com.learning.formfilling.databinding.FragmentFirstBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
private const val TAG = "ListFragment"
class ListFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

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

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onResume() {
        super.onResume()
        coroutineScope.launch {
            Log.d(TAG, "onResume: ${repository.getAllUsers()}")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}