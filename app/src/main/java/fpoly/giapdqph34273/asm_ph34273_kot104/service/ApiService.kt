package fpoly.giapdqph34273.testloginapi.service

import fpoly.giapdqph34273.asm_ph34273_kot104.request.LoginRequest
import fpoly.giapdqph34273.asm_ph34273_kot104.request.RegisterRequest
import fpoly.giapdqph34273.testloginapi.response.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiService {
    @POST("register")
    suspend fun register(@Body registerReq: RegisterRequest): Response?

    @POST("login")
    suspend fun login(@Body loginRequest: LoginRequest): Response?



}