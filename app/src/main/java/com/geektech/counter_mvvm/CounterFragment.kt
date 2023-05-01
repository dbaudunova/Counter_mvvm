package com.geektech.counter_mvvm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.geektech.counter_mvvm.databinding.FragmentCounterBinding

class CounterFragment : Fragment() {

    private lateinit var binding: FragmentCounterBinding
    private lateinit var viewModel: CounterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCounterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[CounterViewModel::class.java]
        initListener()
        initObserver()
    }

    private fun initObserver() {
        viewModel.countLiveData.observe(viewLifecycleOwner){
            binding.tvNumber.text = it.toString()
        }
    }

    private fun initListener() {
        binding.btnPlus.setOnClickListener {
            viewModel.getPlusCount()
        }

        binding.btnMinus.setOnClickListener {
            viewModel.getMinusCount()
        }

        binding.btnReset.setOnClickListener {
            viewModel.getReset()
        }
    }
}