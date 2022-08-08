package com.geektech.lovecalculator.netWork

import com.geektech.lovecalculator.LoveModel
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {

    @GET ("getPercentage")
    fun  calculate (
        @Query("fname" ) firstname : String,
        @Query("sname" ) secondname : String,
        @Header("X-RapidAPI-Key") key : String = "d9c69eb852mshd6d8b36b8bcbba3p12fd8cjsn77bed9ffbdeb",
        @Header("X-RapidAPI-Host") host : String = "love-calculator.p.rapidapi.com"
    ): retrofit2.Call<LoveModel>
}