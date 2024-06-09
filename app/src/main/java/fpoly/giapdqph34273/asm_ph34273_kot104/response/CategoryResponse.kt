package fpoly.giapdqph34273.asm_ph34273_kot104.response

import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    @SerializedName("_id") val cateID: String,
    val cateName: String,
    val image: String
)
