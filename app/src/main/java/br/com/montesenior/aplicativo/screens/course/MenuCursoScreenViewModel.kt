package br.com.montesenior.aplicativo.screens.course

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.montesenior.aplicativo.data.model.ProgressoModulo
import br.com.montesenior.aplicativo.data.repository.MaterialCursoRepository
import br.com.montesenior.aplicativo.data.repository.UsuariosRepository
import kotlinx.coroutines.launch

class MenuCursoScreenViewModel: ViewModel() {
    private val usuariosRepository = UsuariosRepository()

    private val _listaProgressoModulo = MutableLiveData<List<ProgressoModulo>?>()
    val listaProgressoModulo: LiveData<List<ProgressoModulo>?> = _listaProgressoModulo

    private val _progressoCurso = MutableLiveData<Double>()
    val progressoCurso: LiveData<Double> = _progressoCurso

    fun carregarProgressoModulos(uid: String, cursoId: String) {
        viewModelScope.launch {
            val progressoModulos = usuariosRepository.carregarProgressoModulos(uid, cursoId)
            _listaProgressoModulo.value = progressoModulos
            if (!progressoModulos.isNullOrEmpty()) {
                val cursoMaterial = MaterialCursoRepository.materialCursos[cursoId]
                if (cursoMaterial != null) {
                    val modulosConcluidos = progressoModulos.count { it.concluido }
                    _progressoCurso.value = (modulosConcluidos.toDouble() / cursoMaterial.modulos.size) * 100
                } else {
                    _progressoCurso.value = 0.0
                    Log.e("MenuCursoViewModel", "Material do curso não encontrado para cursoId: $cursoId")
                }
            } else {
                _progressoCurso.value = 0.0
                Log.e("MenuCursoViewModel", "Progresso dos módulos não encontrado para uid: $uid e cursoId: $cursoId")
            }
        }
    }
}