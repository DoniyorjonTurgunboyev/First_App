package uz.smartarena.firstapp.viewmodel.contracts

import androidx.lifecycle.LiveData

interface LoginViewModel {
    val errorLiveData: LiveData<String>
    val successLiveData: LiveData<Unit>
    val openRegisterScreenLiveData: LiveData<Unit>
    val openMainScreenLiveData: LiveData<Unit>
    fun login(email: String, password: String)
    fun openRegister()
}