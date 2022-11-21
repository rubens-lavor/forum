package br.com.alura.forum.service

import br.com.alura.forum.exception.NotFoundException
import br.com.alura.forum.model.Usuario
import br.com.alura.forum.repository.UsuarioRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UsuarioService(private val usuarioRepository: UsuarioRepository) {

    fun buscarPorId(id: Long): Usuario {
        return usuarioRepository
            .findByIdOrNull(id)
            ?: throw NotFoundException("Usuário não encontrado pelo id: $id")
    }

    fun listar(): List<Usuario> {
        val usuarios = usuarioRepository.findAll()
        if (usuarios.isEmpty()) {
            usuarioRepository.save(Usuario(
                nome = "jose",
                email = "jose@email.com"
            ))

            return usuarioRepository.findAll()
        }

        return usuarios
    }

}
