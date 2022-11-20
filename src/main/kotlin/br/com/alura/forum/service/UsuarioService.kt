package br.com.alura.forum.service

import br.com.alura.forum.model.Usuario
import org.springframework.stereotype.Service

@Service
class UsuarioService(private val usuarios: MutableList<Usuario>) {
    init {
        val usuario = Usuario(
            id = 1,
            nome = "josé",
            email = "jose@mail.com"
        )
        usuarios.add(usuario)
    }

    fun buscarPorId(idAutor: Long): Usuario {
        return usuarios.filter { it.id == idAutor }.get(0)
    }

}
