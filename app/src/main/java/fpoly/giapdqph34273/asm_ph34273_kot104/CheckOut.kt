package fpoly.giapdqph34273.asm_ph34273_kot104

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController

@Composable
@Preview(showBackground = true)
fun CheckOut(navController: NavController? = null) {
    Scaffold(
        topBar = {
            thanhTopbar()
        },
        content = {
            NoiDung(it)
        }
    )
}

@Composable
private fun thanhTopbar() {

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
                text = "Check out",
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
                onClick = { },
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

@Composable
private fun NoiDung(paddingValues: PaddingValues) {
    Box(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
    ) {

        Column {
            ItemThongTin("Shipping Address", content = { shippingAddress() }
            )

            ItemThongTin("Payment Method", content = { paymentMethod() })

            ItemThongTin("Delivery method", content = { deliveryMethod() })
        }







        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 20.dp)
        ) {

            tinhTien()

            Spacer(modifier = Modifier.height(10.dp))

            checkOut()
        }

    }
}

@Composable
private fun deliveryMethod() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .height(68.dp)
            .padding(
                start = 16.dp,
            )
    ) {
        Image(
            painter = painterResource(id = R.drawable.dhl),
            contentDescription = null,
            modifier = Modifier
                .height(20.dp)
                .width(90.dp)
        )

        Text(
            text = "Fast (2-3days)",
            fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
            fontWeight = FontWeight(600),
            fontSize = 14.sp,
            color = Color("#242424".toColorInt()),
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
private fun paymentMethod() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .height(68.dp)
            .padding(
                start = 16.dp,
            )
    ) {
        Image(
            painter = painterResource(id = R.drawable.mastercard),
            contentDescription = null,
            modifier = Modifier
                .height(38.dp)
                .width(64.dp)
                .shadow(
                    elevation = 10.dp,
                    spotColor = Color("#f4f5f6".toColorInt()),
                )
        )

        Text(
            text = "**** **** **** 1234",
            fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
            fontWeight = FontWeight(600),
            fontSize = 14.sp,
            color = Color("#242424".toColorInt()),
            modifier = Modifier.padding(16.dp)
        )
    }

}

@Composable
private fun tinhTien() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 16.dp,
                bottom = 16.dp
            )
            .background(
                Color.White,
                RoundedCornerShape(8.dp)
            )
            .shadow(
                elevation = 10.dp,
                spotColor = Color("#f4f5f6".toColorInt()),
            )
    ) {
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
                text = "Order:",
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

        Spacer(modifier = Modifier.height(10.dp))

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
                text = "Delivery:",
                fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                fontWeight = FontWeight(700),
                fontSize = 20.sp,
                color = Color("#808080".toColorInt())
            )

            Text(
                text = "$ 5.00",
                fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                fontWeight = FontWeight(700),
                fontSize = 20.sp,
                color = Color("#303030".toColorInt())
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

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
                text = "$ 100.00",
                fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                fontWeight = FontWeight(700),
                fontSize = 20.sp,
                color = Color("#303030".toColorInt())
            )
        }
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
private fun ItemThongTin(title: String, content: @Composable () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 10.dp,
                bottom = 10.dp
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = title,
                fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                fontWeight = FontWeight(600),
                fontSize = 18.sp,
                color = Color("#909090".toColorInt()),
            )

            IconButton(onClick = {}) {
                Image(
                    painter = painterResource(id = R.drawable.edit_icon),
                    contentDescription = "",
                    modifier = Modifier
                        .height(20.dp)
                        .width(16.dp)

                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 60.dp)
                .shadow(
                    elevation = 10.dp,
                    spotColor = Color("#f4f5f6".toColorInt()),
                )
                .background(
                    Color.White,
                    RoundedCornerShape(10.dp)
                ),
        ) {
            content()

        }
    }
}

@Composable
private fun shippingAddress() {
    Text(
        text = "Bruno Fernandes",
        fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
        fontWeight = FontWeight(700),
        fontSize = 20.sp,
        color = Color("#303030".toColorInt()),
        modifier = Modifier.padding(16.dp)
    )

    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(2.dp)
            .background(color = Color("#F0F0F0".toColorInt()))
    )

    Text(
        text = "25 rue Robert Latouche, Nice, " +
                "06200, Côte D’azur, France",
        fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
        fontWeight = FontWeight(400),
        fontSize = 16.sp,
        color = Color("#808080".toColorInt()),
        modifier = Modifier.padding(16.dp)
    )
}