package com.geektech.lovecalculator.netWork

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.geektech.lovecalculator.LoveModel
import com.geektech.lovecalculator.R
import com.geektech.lovecalculator.databinding.FragmentFristBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FirstFragment : Fragment() {
    lateinit var binding: FragmentFristBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFristBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()

    }

    private fun initClickers() {
        with(binding) {
            btnOk.setOnClickListener {
                val firstName = firstNameEd.text.toString()
                val secondName = secondNameEd.text.toString()
                App.api.calculate(firstName, secondName).enqueue(object : Callback<LoveModel> {
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {

                        val bundle = Bundle()
                        val result = response.body()?.result.toString()
                        val percent = response.body()?.percentage.toString()
                        bundle.putString("result", result)
                        bundle.putString("percent", percent )
                        bundle.putString("fname", firstName)
                        bundle.putString("sname", secondName)


                        findNavController().navigate(
                            R.id.action_firstFragment_to_result_Fragment,
                            bundle
                        )

                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {

                    }

                })
            }
        }
    }
}


