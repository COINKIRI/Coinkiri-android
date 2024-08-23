package com.coinkiri.coinkiri.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coinkiri.coinkiri.core.datastore.TokenDataStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val tokenDataStore: TokenDataStore
) : ViewModel() {

    private val _sideEffects = MutableSharedFlow<SplashSideEffect>()
    val sideEffects: SharedFlow<SplashSideEffect> get() = _sideEffects.asSharedFlow()

    fun showSplash() {
        viewModelScope.launch {
            delay(SPLASH_DURATION)
            checkIsLogined()
        }
    }

    private suspend fun checkIsLogined() {
        val accessToken = tokenDataStore.accessTokenFlow.firstOrNull().orEmpty()
        val isLogined = accessToken.isNotEmpty()
        if (isLogined) {
            _sideEffects.emit(SplashSideEffect.NavigateToHome)
        } else {
            _sideEffects.emit(SplashSideEffect.NavigateLogin)
        }
    }

    companion object {
        const val SPLASH_DURATION = 1200L
    }
}
