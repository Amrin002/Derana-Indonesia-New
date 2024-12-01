package com.deranaindonesia.auth.viewmodel.login.fragments.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    // Live Data Loading
    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>get() = _isLoading

    //live data error
    private val _isError = MutableLiveData<String?>()
    val isError: LiveData<String?>get() = _isError

    //live data success login
    private val _isSuccess = MutableLiveData<Boolean>()
    val isSuccess: LiveData<Boolean>get() = _isSuccess

    // fungsi login
    fun login(email: String, password: String) {
        //validasi
        if (email.isEmpty() || password.isEmpty()) {
            _isError.value = "Email atau password tidak boleh kosong"
            return
        }
        _isLoading.value = true

        simulateLogin(email, password)
    }

    private fun simulateLogin(email: String, password: String) {
        //simulasi delay login
        Thread {
            Thread.sleep(2000)
            if (email == "admin@gmail.com" && password == "12345678") {
                _isSuccess.postValue(true)
                _isError.postValue(null)
            }else{
                _isSuccess.postValue(false)
                _isError.postValue("Email atau password salah")
            }
            _isLoading.postValue(false)
        }.start()
    }



    //fungsi reset
    fun resetErrorMessage() {
        _isError.value = null
    }

}