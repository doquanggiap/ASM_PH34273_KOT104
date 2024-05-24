package fpoly.giapdqph34273.asm_ph34273_kot104

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
@Preview(showBackground = true)
fun Congrats(navController: NavController? = null) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
    ) {

        Text(
            text = "Success!",
            fontFamily = FontFamily(Font(R.font.merriweather_regular)),
            fontWeight = FontWeight(700),
            fontSize = 36.sp,
            color = Color("#303030".toColorInt())
        )

        Spacer(modifier = Modifier.height(20.dp))

        Box(
            modifier = Modifier
                .height(250.dp)
        ) {
            Box {
                Image(
                    painter = painterResource(id = R.drawable.layout_congrat),
                    contentDescription = null,
                    modifier = Modifier
                        .width(270.dp)
                        .height(230.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.banghe),
                    contentDescription = null,
                    modifier = Modifier
                        .width(201.dp)
                        .height(181.dp)
                        .align(Alignment.Center)
                )

            }
            Image(
                painter = painterResource(id = R.drawable.checkmark),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .align(Alignment.BottomCenter)
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = "Your order will be delivered soon.\n" +
                    "Thank you for choosing our app!",
            fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
            fontWeight = FontWeight(400),
            fontSize = 18.sp,
            color = Color("#606060".toColorInt()),
        )

        Spacer(modifier = Modifier.height(25.dp))

        Button(
            onClick = {
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
                text = "Track your orders",
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                fontWeight = FontWeight(600),
                fontSize = 20.sp,
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        Button(
            onClick = {
                navController?.navigate(Screen.MyBottombar.route)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            ),
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                )
                .background(
                    Color.White,
                    RoundedCornerShape(8.dp)
                )
                .border(
                    width = 1.dp,
                    color = Color("#242424".toColorInt()),
                    shape = RoundedCornerShape(8.dp)
                )
        ) {
            Text(
                text = "BACK TO HOME",
                color = Color("#242424".toColorInt()),
                fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                fontWeight = FontWeight(600),
                fontSize = 20.sp,
            )
        }

    }
}