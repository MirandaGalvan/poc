package login.ui

import Navegation.AppScreens
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel(){

private val _email = MutableLiveData<String>()
    val email : LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password : LiveData<String> = _password

    private val _loginEnable = MutableLiveData<Boolean>()
    val loginEnable : LiveData<Boolean> = _loginEnable


    private var loginClickCount = 0

    fun onLoginChanged(email:String,password: String){
        _email.value=email
        _password.value=password
        _loginEnable.value = isValidEmail(email) && isValidPassword(password)

    }
    fun isValidEmail(email: String): Boolean = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    fun isValidPassword(password: String): Boolean = password.length >= 6

    fun onLoginSelected() {
        ++loginClickCount
        println("Botón de login presionado $loginClickCount veces")

        }

}