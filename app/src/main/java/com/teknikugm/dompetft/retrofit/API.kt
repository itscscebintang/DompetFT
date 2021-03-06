package com.teknikugm.dompetft.retrofit

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Path

interface API {

    @POST("index.php/User/login")
    @FormUrlEncoded
    fun loginUser (@Field("username") username:String,
                   @Field("password") password:String): Call<ResponseLogin>

    @POST("appkantin/register.php")
    @FormUrlEncoded
    fun registeruser (@Field("username") username:String,
                      @Field("name") name:String,
                      @Field("password") password:String): Observable<String>

    @POST("index.php/User/saldo_c/{key}")
    fun getsaldo(
        @Path("key") key: String?
    ): retrofit2.Call<ResponseSaldo>
}