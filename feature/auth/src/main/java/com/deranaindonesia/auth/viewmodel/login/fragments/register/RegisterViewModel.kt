package com.deranaindonesia.auth.viewmodel.login.fragments.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Delay
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {
    //live data
    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>get() = _isLoading

    //live data success login
    private val _isSuccess = MutableLiveData<Boolean>()
    val isSuccess: LiveData<Boolean>get() = _isSuccess

    //live data error
    private val _isError = MutableLiveData<String?>()
    val isError: LiveData<String?>get() = _isError

    // register Function
    fun register(
        namaLengkap: String,
        nomorTelepon: String,
        email: String,
        password: String
    ){
        //Validasi
        if(namaLengkap.isEmpty() || nomorTelepon.isEmpty() || email.isEmpty() || password.isEmpty()){
            _isError.value = "Semua kolom harus diisi"
            return
        }
        _isLoading.value = true
        viewModelScope.launch {
            try {
                simulateRegister(namaLengkap, nomorTelepon, email, password)
                _isSuccess.value = true
                _isError.value =null
            } catch (e: Exception){
                _isSuccess.value = false
                _isError.value = e.message ?: "Terjadi Kesalahan"
            } finally {
                _isLoading.value = false
            }
        }
    }

    private suspend fun simulateRegister(namaLengkap: String, nomorTelepon: String, email: String, password: String) {
        //simulasi delay register
        kotlinx.coroutines.delay(2000)
        if (email == "test@gmail.com") {
            throw Exception("Email sudah digunakan")
        }
    }
    fun resetErrorMessage(){
        _isError.value = null
    }

    //retrofit
//    private suspend fun registerToServer(name: String, phone: String, email: String, password: String): ApiResponse {
//        val response = apiService.register(name, phone, email, password)
//        if (!response.isSuccessful) {
//            throw Exception("Registrasi gagal: ${response.errorBody()?.string()}")
//        }
//        return response.body() ?: throw Exception("Response kosong")
//    }
}