package br.com.montesenior.aplicativo.screens.course

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.montesenior.aplicativo.data.repository.UsuariosRepository
import kotlinx.coroutines.launch

class QuizScreenViewModel: ViewModel() {
    private val usuariosRepository = UsuariosRepository()

    private val _currentQuestion = MutableLiveData<Int>(0)
    val currentQuestion: LiveData<Int> = _currentQuestion

    private val _score = MutableLiveData<Int>(0)
    val score: LiveData<Int> = _score

    private val _isCompleted = MutableLiveData<Boolean>(false)
    val isCompleted: LiveData<Boolean> = _isCompleted

    private val _selectedAnswer = MutableLiveData<Int?>(null)
    val selectedAnswer: LiveData<Int?> = _selectedAnswer

    fun onRetry() {
        _currentQuestion.value = 0
        _score.value = 0
        _selectedAnswer.value = null
        _isCompleted.value = false
    }

    fun onAnswerSelected(answer: Int) {
        _selectedAnswer.value = answer
    }

    fun onNextQuestion(correctQuestion: Int, questionsSize: Int) {
        if (_selectedAnswer.value == correctQuestion) {
            _score.value = score.value?.plus(1)
        }
        if (_currentQuestion.value!!.plus(1) < questionsSize) {
            _currentQuestion.value = currentQuestion.value?.plus(1)
            _selectedAnswer.value = null
        } else {
            _isCompleted.value = true
        }
    }

    fun onQuizCompleted(uid: String, cursoId: String, moduloId: String, tarefaId: String) {
        viewModelScope.launch {
            try {
                usuariosRepository.marcarTarefaConcluida(uid, cursoId, moduloId, tarefaId)
                Log.d("QuizScreenViewModel", "Tarefa concluída com sucesso: $tarefaId")
            } catch (e: Exception) {
                Log.e("QuizScreenViewModel", "Erro ao marcar tarefa concluída", e)
            }
        }
    }
}