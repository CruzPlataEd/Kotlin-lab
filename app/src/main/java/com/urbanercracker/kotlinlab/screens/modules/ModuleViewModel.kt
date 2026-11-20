package com.urbanercracker.kotlinlab.screens.modules

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.viewModelScope
import com.urbanercracker.kotlinlab.model.dto.ModuloDTO
import com.urbanercracker.kotlinlab.repository.ModulesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ModuleViewModel @Inject constructor(
    private val moduleRepository: ModulesRepository
): ViewModel() {
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _messageError = MutableLiveData<String>()
    val messageError: LiveData<String> get() = _messageError

    private val _modulesList = MutableLiveData<List<ModuloDTO>>()
    val modulesList: LiveData<List<ModuloDTO>> get() = _modulesList

    init {
        getAllModules()
    }

    fun getAllModules(){
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val result = moduleRepository.getAllModules()
                if (result.status){
                    _modulesList.value = result.data ?: emptyList()
                }else{
                    _messageError.value = result.message
                }
            }catch (e: Exception){
                _messageError.value = e.message
            }finally {
                _isLoading.value = false
            }
        }
    }
}