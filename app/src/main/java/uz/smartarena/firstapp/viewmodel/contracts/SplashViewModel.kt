package uz.smartarena.firstapp.viewmodel.contracts

import androidx.lifecycle.LiveData

interface SplashViewModel {
    val openLoginScreenLiveData: LiveData<Unit>
    val openMainScreenLiveData: LiveData<Unit>
    val messageLiveData: LiveData<String>
}