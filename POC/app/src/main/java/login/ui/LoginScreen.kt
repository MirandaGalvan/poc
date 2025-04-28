package login.ui
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.poc.R
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.IconButton
import Navegation.AppScreens
import androidx.compose.foundation.clickable
import androidx.navigation.NavController


@Composable
fun LoginScreen(viewModel: LoginViewModel, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp)
            .background(Color(0xFFF5F5F5))
    )

    {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Color(0xFFFFFFFF))

            )


        {

            Image(
                painter = painterResource(id = R.drawable.subtract),
                contentDescription = "Header",
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                contentScale = ContentScale.FillWidth
            )


            Text(
                text = "Bienvenido a APP",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
                    .padding(top = 35.dp),
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF070202)
            )

            Image(
                painter = painterResource(id = R.mipmap.ic_launcher_foreground),
                contentDescription = "App Icon",
                modifier = Modifier
                    .padding(start = 105.dp, top = 55.dp)
                    .height(150.dp),
                contentScale = ContentScale.Crop
            )

        }


        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        )

        {

            Login(Modifier, viewModel,navController)
        }
    }
}


@Composable
fun Login(modifier: Modifier, viewModel: LoginViewModel, navController: NavController) {

    val email: String by viewModel.email.observeAsState(initial = "")
    val password: String by viewModel.password.observeAsState(initial = "")
    val loginEnable:Boolean by viewModel.loginEnable.observeAsState(initial = false)

    Column(modifier = modifier
        .fillMaxSize()
        .background(Color(0xFFF5F5F5))

    )

         {
        GoogleButton()
      Spacer(modifier= Modifier.padding(10.dp))

        EmailField(email, {viewModel.onLoginChanged(it,password)})

        Spacer(modifier= Modifier.padding(10.dp))

        PasswordField(password) {viewModel.onLoginChanged(email,it)}

        Spacer(modifier= Modifier.padding(10.dp))

        LoginButton(loginEnable){

            viewModel.onLoginSelected()
        }

        Spacer(modifier= Modifier.padding(5.dp))
        TermsAndPrivacyText(navController)
    }
}

@Composable
fun LoginDivider() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .weight(2f)
                .height(1.dp)
                .background(Color(0xFFFF7F50))
        )

        Text(
            text = "Inicio",
            modifier = Modifier.padding(horizontal = 16.dp),
            color = Color(0xFFFF7F50),
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )


        Box(
            modifier = Modifier
                .weight(2f)
                .height(1.dp)
                .background(Color(0xFFFF7F50))
        )
    }
}

@Composable
fun GoogleButton() {
    Button(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth()
            .height(38.dp),
        enabled = true,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFFFFFFF),
            contentColor = Color.Black
        ),
        shape = RoundedCornerShape(10.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    )

    {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        )

        {
            Image(
                painter = painterResource(id = R.drawable.google_logo),
                contentDescription = "Google Logo",
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = "Iniciar sesión con Google",
                fontWeight = FontWeight.Bold
            )
        }
    }
}



@Composable
fun TermsAndPrivacyText(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
    ) {
        Row {
            Text(
                text = "No eres miembro? ",
                fontSize = 12.sp,
                color = Color(0xFF070707),
                textAlign = TextAlign.Center
            )


            Text(
                text = "Registrate ",
                fontSize = 12.sp,
                color = Color(0xFFFF7F50),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
                    navController.navigate(AppScreens.FormularioScreen.route)
                }
            )
        }

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Al iniciar sesión aceptas los",
            fontSize = 12.sp,
            color = Color(0xFF070707),
            textAlign = TextAlign.Center
        )
        Row {
            Text(
                text = "Términos",
                fontSize = 12.sp,
                color = Color(0xFF0B560E),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Text(
                text = " y la ",
                fontSize = 12.sp,
                color = Color(0xFF070707),
                textAlign = TextAlign.Center
            )
            Text(
                text = "Política de Privacidad",
                fontSize = 12.sp,
                color = Color(0xFF0B560E),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}



@Composable
fun LoginButton(loginEnable: Boolean, onLoginSelected: () -> Unit) {
    Button(
        onClick = { onLoginSelected() },
        modifier = Modifier
            .fillMaxWidth()
            .height(42.dp),
        enabled = loginEnable,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF9FD356)
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(text = " Iniciar Sesión")
    }
}

@Composable
fun PasswordField(password: String, onTextFieldChanged: (String) -> Unit) {
    val passwordVisible = remember { mutableStateOf(false) }

    TextField(
        value = password,
        onValueChange = { onTextFieldChanged(it) },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)

        ,placeholder = {
            Text(text = "Contraseña",
                fontSize = 12.sp,

            ) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        leadingIcon = {

            Icon(
                imageVector = Icons.Filled.Lock,
                contentDescription = "Password icon"
            )
        },
        trailingIcon = {
            val imageVector = if (passwordVisible.value)
                Icons.Filled.Visibility
            else
                Icons.Filled.VisibilityOff

            val description = if (passwordVisible.value) "Ocultar contraseña" else "Mostrar contraseña"

            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(imageVector = imageVector, contentDescription = description)
            }
        },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        shape = RoundedCornerShape(10.dp),
        textStyle = androidx.compose.ui.text.TextStyle(fontSize = 14.sp)

    )
}
@Composable
fun EmailField(email:String, onTextFieldChanged:(String) -> Unit) {


    TextField(
        value = email, onValueChange = {onTextFieldChanged(it)},
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)

        ,placeholder = {
            Text(text = "Email",
                fontSize = 12.sp,

                ) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        textStyle = androidx.compose.ui.text.TextStyle(fontSize = 14.sp),

        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,

        ),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.user),
                contentDescription = "Email icon"
            )
        }
                ,shape = RoundedCornerShape(10.dp)


    )
}

