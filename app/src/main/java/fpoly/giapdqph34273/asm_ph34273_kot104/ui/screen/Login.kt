package fpoly.giapdqph34273.asm_ph34273_kot104.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import fpoly.giapdqph34273.asm_ph34273_kot104.R
import fpoly.giapdqph34273.asm_ph34273_kot104.navigation.Screen
import kotlinx.coroutines.launch


@Composable
fun Login(navController: NavController) {
    preview(navController)
}

@Preview(showBackground = true)
@Composable
private fun preview(navController: NavController? = null) {
    getLayout(navController)
}

@Composable
private fun getLayout(navController: NavController? = null) {

    //trạng thái snackBarHost
    val snackbarHostState = remember { SnackbarHostState() }


    // Tạo một CoroutineScope bằng cách sử dụng hàm rememberCoroutineScope().
    // CoroutineScope này sẽ tồn tại cho đến khi Composable bị hủy.
    // Điều này giúp quản lý vòng đời của các coroutine mà bạn khởi chạy từ CoroutineScope này,
    // tức là các coroutine sẽ tự động hủy khi Composable không còn tồn tại, giúp tránh rò rỉ bộ nhớ.
    val coroutineScope = rememberCoroutineScope()

    var email by remember { mutableStateOf("") }

    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }

    var keyboardCtrl = LocalSoftwareKeyboardController.current


    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) {
        Column(
            Modifier
                .background(color = Color("#E0E0E0".toColorInt()))
                .fillMaxSize()
                .background(color = Color.White)
                .padding(it)

        ) {

            Spacer(modifier = Modifier.height(80.dp))

            thanhNgangIcon()

            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    text = "Hello !",
                    fontFamily = FontFamily(Font(R.font.merriweather_regular)),
                    color = Color("#909090".toColorInt()),
                    fontSize = 30.sp,
                    modifier = Modifier.padding(bottom = 10.dp),
                    fontWeight = FontWeight(400)
                )

                Text(
                    text = "WELCOME BACK",
                    fontFamily = FontFamily(Font(R.font.merriweather_regular)),
                    fontSize = 24.sp,
                    fontWeight = FontWeight(700)
                )
            }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth(0.9f)
                    .fillMaxHeight(0.8f)
                    .shadow(
                        elevation = 10.dp,
                        spotColor = Color("#f4f5f6".toColorInt()),
                    )
            ) {
                Column {

                    // nhập email
                    Text(
                        text = "Email",
                        color = Color("#909090".toColorInt()),
                        fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                        fontWeight = FontWeight(400),
                        fontSize = 14.sp,
                    )

                    TextField(
                        value = email,
                        onValueChange = { email = it },
                        modifier = Modifier.fillMaxWidth(0.8f),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            unfocusedIndicatorColor = Color("#E0E0E0".toColorInt()),
                            focusedIndicatorColor = Color.Gray
                        ),
                        singleLine = true,
                        trailingIcon = {
                            if (email.isNotEmpty()) {
                                IconButton(onClick = { email = "" }) {

                                    Icon(
                                        imageVector = Icons.Filled.Clear,
                                        contentDescription = "",
                                        modifier = Modifier
                                            .height(20.dp)
                                            .width(20.dp)
                                    )
                                }
                            }
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next
                        )
                    )

                    Spacer(modifier = Modifier.height(30.dp))


                    // nhập password
                    Text(
                        text = "Password",
                        color = Color("#909090".toColorInt()),
                        fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                        fontWeight = FontWeight(400),
                        fontSize = 14.sp,
                    )

                    TextField(
                        value = password,
                        onValueChange = { password = it },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            unfocusedIndicatorColor = Color("#E0E0E0".toColorInt()),
                            focusedIndicatorColor = Color.Gray
                        ),
                        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Done
                        ),
                        trailingIcon = {
                            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                                Image(
                                    painter = painterResource(id = if (passwordVisibility) R.drawable.eye_slash_icon else R.drawable.eye_icon),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .height(20.dp)
                                        .width(20.dp)
                                )
                            }
                        },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                keyboardCtrl?.hide()
                                if (email.isBlank() || password.isBlank()) {
                                    coroutineScope.launch {
                                        snackbarHostState.showSnackbar("Không được để trống")
                                    }
                                } else {
                                    navController?.navigate(Screen.MyBottombar.route)
                                }
                            })
                    )
                }

                Spacer(modifier = Modifier.height(30.dp))

                // quên mật khẩu
                TextButton(onClick = {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar("Chưa có chức năng này")
                    }
                }) {
                    Text(
                        text = "Forgot Password",
                        fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                        fontWeight = FontWeight(600),
                        fontSize = 18.sp,
                        color = Color("#303030".toColorInt()),
                    )
                }

                Spacer(modifier = Modifier.height(30.dp))

                // nút đăng nhập
                Button(
                    onClick = {
                        if (email.isBlank() || password.isBlank()) {
                            coroutineScope.launch {
                                snackbarHostState.showSnackbar("Không được để trống")
                            }
                        } else {
                            navController?.navigate(Screen.MyBottombar.route)
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        Color("#242424".toColorInt())
                    ),
                    modifier = Modifier
                        .background(
                            Color("#242424".toColorInt()),
                            shape = RoundedCornerShape(4.dp)
                        )
                        .height(50.dp)
                        .width(285.dp)
                ) {
                    Text(
                        text = "Log in",
                        fontWeight = FontWeight(600),
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                    )
                }

                Spacer(modifier = Modifier.height(30.dp))

                // chuyển sang trang đăng ký
                chuyenSangDangKy(navController)
            }


        }
    }
}

@Composable
private fun chuyenSangDangKy(navController: NavController? = null) {
    TextButton(onClick = {
        navController?.navigate(Screen.SignUp.route)
    }) {
        Text(
            text = "SIGN UP",
            fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
            fontWeight = FontWeight(600),
            fontSize = 18.sp,
            color = Color("#303030".toColorInt()),
        )
    }
}

@Composable
private fun thanhNgangIcon() {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ) {

        Spacer(
            modifier = Modifier
                .height(1.dp)
                .background(Color("#BDBDBD".toColorInt()))
                .width(105.dp)
        )

        sofaIcon()

        Spacer(
            modifier = Modifier
                .height(1.dp)
                .background(Color("#BDBDBD".toColorInt()))
                .width(105.dp)
        )
    }
}

@Composable
fun sofaIcon() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .height(64.dp)
            .width(64.dp)
            .border(1.dp, Color("#303030".toColorInt()), RoundedCornerShape(50.dp))

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



