package fpoly.giapdqph34273.asm_ph34273_kot104

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt

class Login : ComponentActivity() {
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
    getLayout()
}

@Composable
fun getLayout() {
    Column(
        Modifier
            .background(color = Color("#E0E0E0".toColorInt()))
            .fillMaxSize()

    ) {

        Image(
            painter = painterResource(id = R.drawable.sofa_login),
            contentDescription = "",
            Modifier
                .width(35.dp)
                .height(44.dp)
        )

    }
}

