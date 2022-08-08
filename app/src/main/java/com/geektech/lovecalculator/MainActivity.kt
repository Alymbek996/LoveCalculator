package com.geektech.lovecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geektech.lovecalculator.databinding.ActivityMainBinding
import com.geektech.lovecalculator.netWork.App
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
  private  lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}