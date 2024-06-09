package fpoly.giapdqph34273.asm_ph34273_kot104.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import fpoly.giapdqph34273.asm_ph34273_kot104.R
import fpoly.giapdqph34273.asm_ph34273_kot104.navigation.Screen
import fpoly.giapdqph34273.asm_ph34273_kot104.response.ProductResponse
import fpoly.giapdqph34273.asm_ph34273_kot104.viewModel.ViewModelCategory
import fpoly.giapdqph34273.asm_ph34273_kot104.viewModel.ViewModelProduct

@Composable
fun Home(navController: NavController? = null) {

    Scaffold(
        topBar = {
            thanhTopbar(navController)
        },
        content = {
            NoiDung(it, navController)
        }
    )
}


@Composable
private fun NoiDung(paddingValues: PaddingValues, navController: NavController? = null) {

    val viewModelProduct: ViewModelProduct = viewModel()
    val listProduct by viewModelProduct.listProduct


    var cateID by remember { mutableStateOf("") }

    fun categoryClick(id: String, index: Int) {
        cateID = if (index == 0) "" else id
    }

    LaunchedEffect(cateID) {
        viewModelProduct.listProductViewModel(cateID)
    }


    Column(
        modifier = Modifier
            .background(Color("#fefefe".toColorInt()))
            .fillMaxSize()
            .padding(top = paddingValues.calculateTopPadding()),
//            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        typeList(categoryClick = { id, index -> categoryClick(id, index) })

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(
                start = 16.dp,
                top = 25.dp,
                end = 16.dp,
                bottom = 16.dp
            )

        ) {
            items(listProduct) { model ->
                ItemGrid(model, navController)
            }
        }
    }
}

@Composable
fun ItemGrid(model: ProductResponse, navController: NavController? = null) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(
                bottom = 16.dp
            )

    ) {
        Box(
            modifier = Modifier
                .clickable(
                    onClick = {
                        navController?.navigate(Screen.ProductDetail.route)
                    }
                )
        ) {
            AsyncImage(
                model = model.image,
                contentDescription = "",
                modifier = Modifier
                    .height(200.dp)
                    .width(157.dp)
            )


            Image(
                painter = painterResource(id = R.drawable.addtocart),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .align(Alignment.BottomEnd)
                    .padding(8.dp)
            )
        }


        Column(
            modifier = Modifier
                .padding(
                    start = 15.dp
                )
                .align(Alignment.Start)
        ) {
            Text(
                text = model.productName,
                color = Color("#606060".toColorInt()),
                fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                fontWeight = FontWeight(400),
                fontSize = 14.sp
            )

            Text(
                text = "$${model.price}",
                color = Color("#303030".toColorInt()),
                fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                fontWeight = FontWeight(700),
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun typeList(
    categoryClick: (id: String, index: Int) -> Unit
) {
    val scrollState = rememberScrollState()

    val viewModelCategory: ViewModelCategory = viewModel()
    val categories by viewModelCategory.categories

    LaunchedEffect(Unit) {
        viewModelCategory.categoryViewModel()
    }

    Row(
        modifier = Modifier
            .horizontalScroll(scrollState)
    ) {
        categories.forEachIndexed { index, i ->

            Button(
                onClick = {
                    categoryClick(i.cateID, index)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                )

            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .background(
                                if (index == 0) Color("#303030".toColorInt()) else Color("#F5F5F5".toColorInt()),
                                RoundedCornerShape(12.dp)
                            )
                            .height(44.dp)
                            .width(44.dp)
                    ) {

                        AsyncImage(
                            model = i.image,
                            contentDescription = "",
                            modifier = Modifier.size(28.dp)
                        )
                    }
                    Text(
                        text = i.cateName,
                        fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                        fontWeight = FontWeight(600),
                        fontSize = 14.sp,
                        color = if (index == 0) Color("#242424".toColorInt()) else Color("#808080".toColorInt())
                    )
                }
            }
        }
    }
}

@Composable
private fun thanhTopbar(navController: NavController? = null) {
    Row(
        modifier = Modifier
            .background(Color("#fefefe".toColorInt()))
            .fillMaxWidth()
            .padding(
                start = 16.dp,
                top = 30.dp,
                end = 16.dp,
                bottom = 16.dp
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(onClick = { }) {
            Image(
                painter = painterResource(id = R.drawable.search_icon),
                contentDescription = "search_icon",
                modifier = Modifier
                    .height(24.dp)
                    .width(24.dp)
            )
        }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Make home",
                fontFamily = FontFamily(Font(R.font.gelasio_regular)),
                fontWeight = FontWeight(400),
                fontSize = 18.sp,
                color = Color("#909090".toColorInt())
            )
            Text(
                text = "BEAUTIFUL",
                fontFamily = FontFamily(Font(R.font.gelasio_regular)),
                fontWeight = FontWeight(700),
                fontSize = 18.sp,
                color = Color("#242424".toColorInt())
            )
        }

        IconButton(onClick = {
            navController?.navigate(Screen.Cart.route)
        }) {
            Image(
                painter = painterResource(id = R.drawable.cart_icon),
                contentDescription = "",
                modifier = Modifier
                    .height(24.dp)
                    .width(24.dp)
            )
        }
    }
}