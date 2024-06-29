package dev.scottpierce.kinject.sample.android

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TestViewModel : ViewModel() {
    private val _state: MutableStateFlow<String> = MutableStateFlow("Android2")
    val state: StateFlow<String>
        get() = _state

    fun updateName(name: String) {
        _state.value = name
    }
}
