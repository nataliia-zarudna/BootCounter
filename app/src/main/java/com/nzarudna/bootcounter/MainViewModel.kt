package com.nzarudna.bootcounter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nzarudna.bootcounter.data.BootLogsRepository
import com.nzarudna.bootcounter.data.db.entity.BootLog
import com.nzarudna.bootcounter.domain.FormatLogStringUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val bootLogsRepository: BootLogsRepository,
    private val formatLogStringUseCase: FormatLogStringUseCase = FormatLogStringUseCase()
) : ViewModel() {

    private val _uiState: MutableStateFlow<String> = MutableStateFlow("")
    val uiState: StateFlow<String> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            val lastLogs = bootLogsRepository.getLastLogs()
            _uiState.update {
                formatLogStringUseCase(lastLogs)
            }
        }
    }
}