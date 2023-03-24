package uz.smartarena.firstapp.viewmodel

import android.accounts.Account
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import uz.smartarena.firstapp.app.App
import uz.smartarena.firstapp.authentication.AccountHelper
import uz.smartarena.firstapp.viewmodel.contracts.LoginViewModel

class LoginViewModelImpl : ViewModel(), LoginViewModel {
    private val auth = Firebase.auth
    private val accountHelper = AccountHelper.getInstance(App.instance)
    override val errorLiveData = MutableLiveData<String>()
    override val successLiveData = MutableLiveData<Unit>()
    override val openRegisterScreenLiveData = MutableLiveData<Unit>()
    override val openMainScreenLiveData = MutableLiveData<Unit>()

    override fun login(email: String, password: String) {
        if (email.isEmpty()) {
            errorLiveData.value = "Emailni kiriting"
        } else if (password.isEmpty()) {
            errorLiveData.value = "Parolni kiriting"
        } else {
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                if (it.isSuccessful) {
                    successLiveData.value = Unit
                    val account = Account(email, App.accountType)
                    accountHelper.addAccountExplicitly(account, password, null)
                    openMainScreenLiveData.value = Unit
                } else {
                    errorLiveData.value = "So'rov bekor qilindi"
                }
            }.addOnFailureListener {
                errorLiveData.value = it.message
            }
        }
    }

    override fun openRegister() {
        openRegisterScreenLiveData.value = Unit
    }
}