package fpoly.giapdqph34273.asm_ph34273_kot104

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
fun Home(navController: NavController) {
    preview()
}

@Preview(showBackground = true)
@Composable
private fun preview() {
    getLayout()
}

@Composable
private fun getLayout() {

    Scaffold(
        topBar = {
            thanhTopbar()
        },
        content = {
            NoiDung(it)
        },
        bottomBar = {
            thanhBottomBar()
        }
    )
}

@Composable
fun thanhBottomBar() {
    Row(
        modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .height(75.dp),
    ) {

    }
}

@Composable
fun NoiDung(paddingValues: PaddingValues) {

    Column(
        modifier = Modifier
            .background(Color("#fefefe".toColorInt()))
            .padding(paddingValues)
            .fillMaxSize(),
    ) {
        typeList()
    }


}

@Composable
fun typeList() {
    val scrollState = rememberScrollState()

    data class Item(val name: String, val imageId: Int)

    val images = listOf(
        Item("Popular", R.drawable.star_icon),
        Item("Chair", R.drawable.chair_icon),
        Item("Table", R.drawable.table_icon),
        Item("Armchair", R.drawable.armchair_icon),
        Item("Bed", R.drawable.bed_icon),
        Item("Lamp", R.drawable.lamp_icon),
    )

    Row(
        modifier = Modifier
            .horizontalScroll(scrollState)
    ) {
        images.forEachIndexed { index, i ->

            Button(
                onClick = {},
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
                        Image(
                            painter = painterResource(id = i.imageId),
                            contentDescription = "icon",
                            modifier = Modifier
                                .height(28.dp)
                                .width(28.dp)
                        )
                    }
                    Text(
                        text = i.name,
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
fun thanhTopbar() {
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

        IconButton(onClick = { }) {
            Image(
                painter = painterResource(id = R.drawable.cart_icon),
                contentDescription = "search_icon",
                modifier = Modifier
                    .height(24.dp)
                    .width(24.dp)
            )
        }
    }
}