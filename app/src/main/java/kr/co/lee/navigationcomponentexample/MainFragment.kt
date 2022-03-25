package kr.co.lee.navigationcomponentexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kr.co.lee.navigationcomponentexample.databinding.FragmentMainBinding

class MainFragment: Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(
            layoutInflater, R.layout.fragment_main, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnMove.setOnClickListener {
                // Action 생성
                // MainFragmentDirections은 MainFragment라는 destination에 자동으로 생성된 클래스
                // ActionAToD 클래스와 actionAToD 메서드는 action_a_to_d 라는 id를 가진 action에 대해 자동으로 생성됨
                val action: MainFragmentDirections.ActionAToD = MainFragmentDirections.actionAToD()

                // Action에 전달할 Argument의 name에 해당하는 변수가 자동으로 생성
                // DataFragement에 선언한 name이 message인 Argument
                action.message = etMessage.text.toString()

                // NavController 획득
                val navController = findNavController()
                // navController를 통해 action을 실행
                navController.navigate(action)
            }
        }
    }
}