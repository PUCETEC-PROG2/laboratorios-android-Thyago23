package ec.edu.puce.githubclient.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ec.edu.puce.githubclient.models.RepositoryPayload
import ec.edu.puce.githubclient.services.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RepoFormViewModel : ViewModel() {
    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _isSuccess = MutableStateFlow(false)
    val isSuccess = _isSuccess.asStateFlow()

    private val _errorMsg = MutableStateFlow<String?>(null)
    val errorMsg = _errorMsg.asStateFlow()

    fun saveRepo(name: String, description: String, owner: String? = null, isEdit: Boolean = false) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMsg.value = null
            try {
                val payload = RepositoryPayload(name, description)
                if (isEdit && owner != null) {
                    RetrofitClient.apiService.updateRepository(owner, name, payload)
                } else {
                    RetrofitClient.apiService.createRepository(payload)
                }
                _isSuccess.value = true
            } catch (e: Exception) {
                _errorMsg.value = "Error al guardar: ${e.localizedMessage}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun resetStatus() {
        _isSuccess.value = false
        _errorMsg.value = null
    }
}
