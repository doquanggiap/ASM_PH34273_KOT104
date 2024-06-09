package fpoly.giapdqph34273.asm_ph34273_kot104.response

import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("_id") val productID: String,
    val productName: String,
    val price: Int,
    val image: String,
    val description: String,
    val cateID: String
)