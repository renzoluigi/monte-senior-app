package br.com.montesenior.aplicativo.screens.course

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.montesenior.aplicativo.data.model.ProgressoModulo
import br.com.montesenior.aplicativo.data.repository.UsuariosRepository
import kotlinx.coroutines.launch

class MenuCursoScreenViewModel: ViewModel() {
    private val usuariosRepository = UsuariosRepository()

    private val _listaProgressoModulo = MutableLiveData<List<ProgressoModulo>>()
    val listaProgressoModulo: LiveData<List<ProgressoModulo>> = _listaProgressoModulo

    fun carregarProgressoModulos(uid: String, cursoId: String) {
        viewModelScope.launch {
            _listaProgressoModulo.value = usuariosRepository.carregarProgressoModulos(uid, cursoId)
        }
    }
}