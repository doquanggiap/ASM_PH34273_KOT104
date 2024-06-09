package fpoly.giapdqph34273.testloginapi.service

import fpoly.giapdqph34273.asm_ph34273_kot104.request.LoginRequest
import fpoly.giapdqph34273.asm_ph34273_kot104.request.RegisterRequest
import fpoly.giapdqph34273.asm_ph34273_kot104.response.CategoryResponse
import fpoly.giapdqph34273.asm_ph34273_kot104.response.ProductResponse
import fpoly.giapdqph34273.testloginapi.response.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {
    @POST("register")
    suspend fun register(@Body registerReq: RegisterRequest): Response?

    @POST("login")
    suspend fun login(@Body loginRequest: LoginRequest): Response?

    @GET("categories")
    suspend fun getCategories(): List<CategoryResponse>

    @GET("products")
    suspend fun getProducts(@Query("cateID") cateID: String?): List<ProductResponse>
//
    @GET("get-product-by-id/{productID}")
    suspend fun getProductByID(@Path("productID") productID: String?): ProductResponse?



}