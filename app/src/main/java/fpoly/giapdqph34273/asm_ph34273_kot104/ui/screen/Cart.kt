package fpoly.giapdqph34273.asm_ph34273_kot104.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import fpoly.giapdqph34273.asm_ph34273_kot104.R
import fpoly.giapdqph34273.asm_ph34273_kot104.navigation.Screen

@Preview(showBackground = true)
@Composable
fun Cart(navController: NavController? = null) {
    Scaffold(
        topBar = {
            thanhTopbar(navController)
        },
        content = {
            NoiDung(it,navController)
        }
    )
}
data class ProductModel(val name: String, val image: Int, val price: Float)

@Composable
private fun NoiDung(paddingValues: PaddingValues,navController: NavController? = null) {
    val cartList = mutableListOf<ProductModel>()
    cartList.add(ProductModel("Product 1", R.drawable.minimalstand, 10.0f))
    cartList.add(ProductModel("Product 2", R.drawable.lamp, 20.0f))
    cartList.add(ProductModel("Product 3", R.drawable.chair, 30.0f))
    cartList.add(ProductModel("Product 3", R.drawable.chair, 30.0f))
    cartList.add(ProductModel("Product 3", R.drawable.chair, 30.0f))
    cartList.add(ProductModel("Product 3", R.drawable.chair, 30.0f))
    cartList.add(ProductModel("Product 4", R.drawable.chair, 30.0f))

    Box(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxHeight(0.8f)
                .padding(bottom = 20.dp)
        ) {
            items(cartList) { item ->
                ItemCart(
                    image = item.image,
                    name = item.name,
                    price = item.price
                )
            }
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 20.dp)
        ) {
            enterCode()

            Spacer(modifier = Modifier.height(10.dp))

            tinhTien()

            Spacer(modifier = Modifier.height(10.dp))

            checkOut(navController)
        }

    }
}

@Composable
fun enterCode() {
    var code by remember { mutableStateOf("") }

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box {
            TextField(
                value = code,
                onValueChange = { code = it },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    unfocusedIndicatorColor = Color.White,
                    focusedIndicatorColor = Color.White
                ),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .width(358.dp),
                placeholder = {
                    Text(
                        text = "Enter your promo code",
                        color = Color("#999999".toColorInt()),
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                        fontWeight = FontWeight(400)
                    )
                }
            )

            IconButton(
                onClick = { },
                Modifier
                    .background(
                        Color("#303030".toColorInt()),
                        shape = RoundedCornerShape(6.dp)
                    )
                    .width(55.dp)
                    .height(55.dp)
                    .align(Alignment.CenterEnd)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.enter_icon),
                    contentDescription = "search_icon",
                    modifier = Modifier
                        .height(24.dp)
                        .width(24.dp)
                )
            }


        }

    }
}

@Composable
private fun tinhTien() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 16.dp,
                end = 16.dp,

                ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,

    ) {
        Text(
            text = "Total:",
            fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
            fontWeight = FontWeight(700),
            fontSize = 20.sp,
            color = Color("#808080".toColorInt())
        )

        Text(
            text = "$ 95.00",
            fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
            fontWeight = FontWeight(700),
            fontSize = 20.sp,
            color = Color("#303030".toColorInt())
        )
    }
}

@Composable
private fun checkOut(navController: NavController? = null) {
    Button(
        onClick = {
            navController?.navigate(Screen.CheckOut.route)
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color("#242424".toColorInt())
        ),
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
            .padding(
                start = 16.dp,
                end = 16.dp,
            )
            .background(
                Color("#242424".toColorInt()),
                RoundedCornerShape(8.dp)
            )
    ) {
        Text(
            text = "Check out",
            color = Color.White,
            fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
            fontWeight = FontWeight(600),
            fontSize = 20.sp,
        )
    }
}

@Composable
fun ItemCart(image: Int, name: String, price: Float) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {

        // ảnh sản phẩm
        Column(
            modifier = Modifier
                .weight(1f),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                Modifier
                    .size(100.dp)
                    .background(
                        Color("#F0F0F0".toColorInt()),
                        shape = RoundedCornerShape(10.dp)
                    ),
                contentScale = ContentScale.FillBounds
            )
        }

        // thông tin sản phẩm
        Column(
            modifier = Modifier
                .padding(start = 16.dp)
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = name,
                fontSize = 14.sp,
                fontWeight = FontWeight(600),
                fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                color = Color("#999999".toColorInt())
            )

            Text(
                text = "$ $price",
                fontSize = 16.sp,
                fontWeight = FontWeight(700),
                fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                color = Color("#242424".toColorInt())
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .width(113.dp)
            ) {

                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .size(30.dp)
                        .background(
                            Color("#F0F0F0".toColorInt()),
                            shape = RoundedCornerShape(10.dp)
                        )
                ) {
                    Text(
                        text = "+",
                        color = Color("#242424".toColorInt()),
                        fontSize = 20.sp,
                    )
                }

                Text(
                    text = "1",
                    fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                    fontWeight = FontWeight(600),
                    fontSize = 18.sp,
                    color = Color("#242424".toColorInt()),
                    modifier = Modifier.padding(
                        start = 10.dp,
                        end = 10.dp
                    )
                )

                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .size(30.dp)
                        .background(
                            Color("#F0F0F0".toColorInt()),
                            shape = RoundedCornerShape(10.dp)
                        )
                ) {
                    Text(
                        text = "-",
                        color = Color("#242424".toColorInt()),
                        fontSize = 20.sp,
                    )
                }
            }
        }

        // xóa sản phẩm
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            IconButton(
                onClick = { },
                modifier = Modifier
                    .align(Alignment.End)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.close_icon),
                    contentDescription = "",
                    modifier = Modifier
                        .height(24.dp)
                        .width(24.dp)
                )
            }
        }
    }
}

@Composable
private fun thanhTopbar(navController: NavController? = null) {

    Box(
        Modifier.padding(top = 20.dp)
    ) {
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
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "My Cart",
                fontFamily = FontFamily(Font(R.font.merriweather_regular)),
                fontWeight = FontWeight(700),
                fontSize = 16.sp,
                color = Color("#303030".toColorInt())
            )
        }

        Box(
            Modifier.padding(16.dp)
        ) {
            IconButton(
                onClick = {
                    navController?.popBackStack()
                },
            ) {
                Image(
                    painter = painterResource(id = R.drawable.back_icon),
                    contentDescription = "search_icon",
                    modifier = Modifier
                        .height(24.dp)
                        .width(24.dp)
                )
            }
        }
    }

}