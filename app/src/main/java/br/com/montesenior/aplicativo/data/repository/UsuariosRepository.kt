package br.com.montesenior.aplicativo.data.repository

import android.util.Log
import br.com.montesenior.aplicativo.data.model.Matricula
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
                    .document()
                    .get()
                    .await()
            if (matricula.exists()) {
                matricula.toObject(Matricula::class.java)
            } else {
                Log.d("UsuariosRepository", "Matrícula do usuario $uid não encontrada: $cursoId")
                null
            }
        } catch (e: Exception){
            Log.e("UsuariosRepository", "Erro ao obter matrícula: ${e.message}")
            null
        }
    }
}