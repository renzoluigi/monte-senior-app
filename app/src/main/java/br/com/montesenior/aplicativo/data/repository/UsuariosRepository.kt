package br.com.montesenior.aplicativo.data.repository

import android.util.Log
import br.com.montesenior.aplicativo.data.model.Matricula
import br.com.montesenior.aplicativo.data.model.ProgressoModulo
import br.com.montesenior.aplicativo.data.model.Usuario
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class UsuariosRepository {

    private val db = Firebase.firestore //instancia do Firestore
    private val usuariosCollection = db.collection("usuarios") //referencia a colecao usuarios

    suspend fun adicionarUsuario(uid: String, usuario: Usuario) {
        try {
            usuariosCollection.document(uid).set(usuario).await()
            Log.d("UsuariosRepository", "Usuário adicionado com sucesso!")
        } catch (e: Exception) {
            Log.e("UsuariosRepository", "Erro ao adicionar/atualizar usuário: $e")
            throw e
        }
    }

    suspend fun getUsuario(uid: String): Usuario? {
        return try {
            val documento = usuariosCollection
                .document(uid)
                .get()
                .await()
            if (documento.exists()) {
                documento.toObject(Usuario::class.java)
            } else {
                Log.d("UsuariosRepository", "Usuário não encontrado: $uid")
                null
            }
        } catch (e: Exception) {
            Log.e("UsuariosRepository", "Erro ao obter usuário: $e")
            null
        }
    }

    suspend fun adicionarMatricula(uid: String, novaMatricula: Matricula) {
        try {
            db.collection("usuarios")
                .document(uid)
                .collection("matriculas")
                .document(novaMatricula.cursoId)
                .set(novaMatricula)
                .await()
        } catch (e: Exception) {
            Log.e("UsuariosRepository", "Falha ao adicionar matrícula ao usuario ${e.message}")
        }
    }

    suspend fun getMatricula(uid: String, cursoId: String): Matricula? {
        return try {
            val matricula =
                usuariosCollection.document(uid)
                    .collection("matriculas")
                    .document(cursoId)
                    .get()
                    .await()
            if (matricula.exists()) {
                matricula.toObject(Matricula::class.java)
            } else {
                Log.d("UsuariosRepository", "Matrícula do usuario $uid não encontrada: $cursoId")
                null
            }
        } catch (e: Exception) {
            Log.e("UsuariosRepository", "Erro ao obter matrícula: ${e.message}")
            null
        }
    }

    suspend fun marcarTarefaConcluida(
        uid: String,
        cursoId: String,
        moduloId: String,
        tarefaId: String
    ) {
        val matriculaRef = usuariosCollection
            .document(uid)
            .collection("matriculas")
            .document(cursoId)

        val matriculaSnap = matriculaRef.get().await()
        if (!matriculaSnap.exists()) {
            Log.d("UsuariosRepository", "Matrícula não encontrada: $cursoId")
            return
        }
        val matricula = matriculaSnap.toObject(Matricula::class.java)
        if (matricula == null) {
            Log.d("UsuariosRepository", "Matrícula não encontrada: $uid/$cursoId")
            return
        }
        val modulosAtualizados = matricula.progressoModulos.toMutableList()
        val moduloIndex = modulosAtualizados.indexOfFirst { it.moduloId == moduloId }

        if (moduloIndex != -1) { //
            val modulo = modulosAtualizados[moduloIndex]
            if (!modulo.tarefasConcluidas.contains(tarefaId)) {
                val tarefasAtualizadas = modulo.tarefasConcluidas.toMutableList().apply { add(tarefaId) }
                var moduloAtualizado = modulo.copy(tarefasConcluidas = tarefasAtualizadas)
                val totalTarefasModulo = MaterialCursoRepository.materialCursos.getValue(cursoId)
                    .modulos.find { it.id == moduloId }?.tarefas?.size ?: 0
                if (tarefasAtualizadas.size == totalTarefasModulo && totalTarefasModulo > 0) {
                    moduloAtualizado = moduloAtualizado.copy(concluido = true)
                }
                modulosAtualizados[moduloIndex] = moduloAtualizado
            }
        } else { //adicionar um novo modulo se ele nao for achado
            val totalTarefasNoModulo = MaterialCursoRepository.materialCursos.getValue(cursoId)
                .modulos.find { it.id == moduloId }?.tarefas?.size ?: 0
            val moduloConcluido = (totalTarefasNoModulo == 1)

            modulosAtualizados.add(ProgressoModulo(moduloId, listOf(tarefaId), moduloConcluido))
        }
        //calculo do progresso
        val modulosConcluidos = modulosAtualizados.count { it.concluido }
        val totalModulos = MaterialCursoRepository.materialCursos.getValue(cursoId).modulos.size
        val progressoGeral = if (totalModulos > 0) {
            modulosConcluidos.toDouble() / totalModulos
        } else {
            0.0
            Log.d("UsuariosRepository", "Total de módulos não encontrado para cursoId: $cursoId")
        }

        matriculaRef.update(
            mapOf(
                "progressoModulos" to modulosAtualizados,
                "progresso" to progressoGeral,
                "concluido" to modulosAtualizados.all { it.concluido }
            )
        ).await()
    }

    suspend fun carregarProgressoModulos(
        uid: String,
        cursoId: String
    ): List<ProgressoModulo>? {
        return try {
            val matriculaRef = usuariosCollection
                .document(uid)
                .collection("matriculas")
                .document(cursoId)
                .get()
                .await()
            if (matriculaRef.exists()) {
                val matricula = matriculaRef.toObject(Matricula::class.java)
                matricula?.progressoModulos
            } else {
                null
            }
        } catch (e: Exception) {
            Log.e("UsuariosRepository", "Erro ao obter progresso do módulo: ${e.message}")
            null
        }
    }
}