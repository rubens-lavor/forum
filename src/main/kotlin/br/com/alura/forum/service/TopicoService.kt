package br.com.alura.forum.service

import br.com.alura.forum.dto.NovoTopicoDto
import br.com.alura.forum.model.Curso
import br.com.alura.forum.model.Topico
import br.com.alura.forum.model.Usuario
import org.springframework.stereotype.Service

@Service
class TopicoService(
    private val topicos: MutableList<Topico>,
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService
) {

    init {
        val topico = Topico(
            id = 1,
            titulo = "Duvida kotlin",
            mensagem = "Variáveis no kotlin",
            curso = Curso(
                id = 1,
                nome = "kotlin",
                categoria = "Programação"
            ),
            autor = Usuario(
                id = 1,
                nome = "josé",
                email = "jose@mail.com"
            )
        )
        topicos.add(topico)
    }

    fun listar(): List<Topico> {
        return topicos
    }

    fun buscarPorId(id: Long): Topico {
        return topicos.filter { it.id == id }.get(0)
    }

    fun cadrastrar(dto: NovoTopicoDto) {
        val topico = Topico(
            id = topicos.size.inc().toLong(),
            titulo = dto.titulo,
            mensagem = dto.mensagem,
            curso = cursoService.buscarPorId(dto.idCurso),
            autor = usuarioService.buscarPorId(dto.idAutor)
        )
        topicos.add(topico)
    }

}
