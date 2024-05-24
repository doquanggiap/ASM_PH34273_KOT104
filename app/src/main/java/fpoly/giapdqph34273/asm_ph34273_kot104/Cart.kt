package fpoly.giapdqph34273.asm_ph34273_kot104

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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

@Preview(showBackground = true)
@Composable
fun Cart(navController: NavController? = null) {
    Scaffold(
        topBar = {
            thanhTopbar()
        },
        content = {
            Column(
                Modifier.padding(it)
            ) {
                Text(text = "haha")
            }
        }
    )
}

@Composable
private fun thanhTopbar() {
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
    }
}