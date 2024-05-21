package fpoly.giapdqph34273.asm_ph34273_kot104

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            preview()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun preview() {
    manHinhChao()
}

@Composable
fun manHinhChao() {
    val backgroundPainter: Painter = painterResource(id = R.drawable.anh_man_hinh_chao)

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = backgroundPainter,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 40.dp,
                    end = 40.dp,
                    top = 250.dp,
                    bottom = 16.dp
                )
        ) {
            Text(
                text = "MAKE YOUR",
                fontSize = 24.sp,
                color = Color("#606060".toColorInt()),
                fontWeight = FontWeight(600),
                fontFamily = FontFamily(Font(R.font.gelasio_regular))
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "HOME BEAUTYFUL",
                fontSize = 30.sp,
                color = Color("#303030".toColorInt()),
                fontWeight = FontWeight(700),
                fontFamily = FontFamily(Font(R.font.gelasio_regular))
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "The best simple place where you discover most wonderful furnitures and make your home beautiful",
                fontWeight = FontWeight(400),
                fontSize = 18.sp,
                color = Color("#808080".toColorInt()),
                modifier = Modifier.padding(
                    start = 17.dp,
                ),
                lineHeight = 35.sp,
                fontFamily = FontFamily(Font(R.font.nunitosans_regular))
            )

            Spacer(modifier = Modifier.height(220.dp))

            Column(
                Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(
                        Color("#242424".toColorInt())
                    ),
                    modifier = Modifier
                        .background(
                            Color("#242424".toColorInt()),
                            shape = RoundedCornerShape(4.dp)
                        )
                ) {
                    Text(
                        text = "Get Started",
                        fontWeight = FontWeight(600),
                        fontSize = 18.sp,
                    )
                }
            }
        }
    }
}