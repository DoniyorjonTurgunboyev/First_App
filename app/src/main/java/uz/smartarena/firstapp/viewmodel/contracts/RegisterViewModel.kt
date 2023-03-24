package uz.smartarena.firstapp.viewmodel.contracts

import androidx.lifecycle.LiveData

interface RegisterViewModel {
    val errorLiveData: LiveData<String>
    val successLiveData: LiveData<Unit>
    fun createUser(email: String, password: String)
}