package kr.co.lee.navigationcomponentexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import kr.co.lee.navigationcomponentexample.databinding.FragmentDataBinding

class DataFragment: Fragment() {
    private var _binding: FragmentDataBinding? = null
    private val binding: FragmentDataBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_data, container, false)

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        
        arguments?.let {
            // DataFragmentArgs는 Args에 대해 자동으로 생성된 클래스
            val args = DataFragmentArgs.fromBundle(it)
            binding.tvMessage.text = args.message
        }
    }
}