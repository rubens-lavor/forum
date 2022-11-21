package br.com.alura.forum.service

import br.com.alura.forum.exception.NotFoundException
import br.com.alura.forum.model.Curso
import br.com.alura.forum.model.Usuario
import br.com.alura.forum.repository.CursoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CursoService(private val cursoRepository: CursoRepository) {

    fun buscarPorId(id: Long): Curso {
        return cursoRepository
            .findByIdOrNull(id)
            ?: throw NotFoundException("Curso não encontrado pelo id: $id")
    }

    fun listar(): List<Curso> {
        val curso = cursoRepository.findAll()
        if (curso.isEmpty()) {
            cursoRepository.save(
                Curso(
                nome = "kotlin",
                categoria = "Programacao"
            )
            )

            return cursoRepository.findAll()
        }

        return curso
    }
}
