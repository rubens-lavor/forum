package br.com.alura.forum.controller

import br.com.alura.forum.model.Usuario
import br.com.alura.forum.service.UsuarioService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/usuarios")
class UsuarioController(private val usuarioService: UsuarioService) {

    @GetMapping
    fun listar(): List<Usuario> {
        return usuarioService.listar()
    }
}
