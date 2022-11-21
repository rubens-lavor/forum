package br.com.alura.forum.controller

import br.com.alura.forum.model.Curso
import br.com.alura.forum.service.CursoService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cursos")
class CursoController(private val cursoService: CursoService) {

    @GetMapping
    fun listar(): List<Curso> {
        return cursoService.listar()
    }
}
