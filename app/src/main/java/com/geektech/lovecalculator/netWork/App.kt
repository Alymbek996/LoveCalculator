package com.geektech.lovecalculator.netWork

import android.app.Application

class App :Application(){
    companion object{
        lateinit var api: LoveApi
    }


    override fun onCreate() {
        super.onCreate()
        val retrofit = RetrofitService()
        api  = retrofit.api
    }
}