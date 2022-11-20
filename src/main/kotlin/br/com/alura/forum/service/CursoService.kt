package br.com.alura.forum.service

import br.com.alura.forum.model.Curso
import org.springframework.stereotype.Service

@Service
class CursoService(private val cursos: MutableList<Curso>) {
    init {
        val curso = Curso(
            id = 1,
            nome = "kotlin",
            categoria = "Programação"
        )
        cursos.add(curso)
    }

    fun buscarPorId(id: Long): Curso {
        return cursos.filter { it.id == id }.get(0)
    }
}
