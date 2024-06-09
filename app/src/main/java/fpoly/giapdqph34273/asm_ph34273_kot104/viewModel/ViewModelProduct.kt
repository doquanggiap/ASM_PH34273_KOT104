package fpoly.giapdqph34273.asm_ph34273_kot104.viewModel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fpoly.giapdqph34273.asm_ph34273_kot104.response.ProductResponse
import fpoly.giapdqph34273.testloginapi.service.RetrofitInstance
import kotlinx.coroutines.launch

class ViewModelProduct: ViewModel() {

    private val _listProduct = mutableStateOf<List<ProductResponse>>(emptyList())
    val listProduct: State<List<ProductResponse>> = _listProduct

    fun listProductViewModel(cateID: String?) {
        viewModelScope.launch {
            try {
                _listProduct.value = RetrofitInstance.apiService.getProducts(cateID)
                Log.d("TAG", "thanhcong: ${_listProduct.value}")
            } catch (e: Exception) {
                Log.d("TAG", "thatbai: ${e.message}")
            }
        }
    }

    private val _detailProduct = mutableStateOf<ProductResponse?>(null)
    val detailProduct: State<ProductResponse?> = _detailProduct

    fun detailProductViewModel(productId: String?) {
        viewModelScope.launch {
            try {
                _detailProduct.value = RetrofitInstance.apiService.getProductByID(productId)
                Log.d("TAG", "thanhcong: ${_detailProduct.value}")
            } catch (e: Exception) {
                Log.d("TAG", "thatbai: ${e.message}")
            }
        }
    }
}