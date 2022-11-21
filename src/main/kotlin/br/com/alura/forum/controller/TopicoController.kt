package br.com.alura.forum.controller

import br.com.alura.forum.dto.AtualizacaoTopicoForm
import br.com.alura.forum.dto.NovoTopicoForm
import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.model.Curso
import br.com.alura.forum.model.Usuario
import br.com.alura.forum.service.TopicoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/topicos")
class TopicoController(private val topicoService: TopicoService) {

    @GetMapping
    fun listar(): List<TopicoView> {
        return topicoService.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): TopicoView {
        return topicoService.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadrastrar(
        @RequestBody @Valid form: NovoTopicoForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicoView> {
        val topicoView = topicoService.cadastrar(form)
        val uri = uriBuilder.path("/topicos/${topicoView.id}").build().toUri()

        return ResponseEntity.created(uri).body(topicoView)
    }

    @PutMapping
    @Transactional
    fun atualizar(@RequestBody @Valid form: AtualizacaoTopicoForm): ResponseEntity<TopicoView> {
        val topicoView = topicoService.atualizar(form)
        return ResponseEntity.ok(topicoView)
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long) {
        topicoService.deletar(id)
    }
}
