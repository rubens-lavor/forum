package br.com.alura.forum.service

import br.com.alura.forum.model.Curso
import br.com.alura.forum.model.Topico
import br.com.alura.forum.model.Usuario
import org.springframework.stereotype.Service

@Service
class TopicoService(
    private var topicos: List<Topico>
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

        val topico1 = Topico(
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

        val topico2 = Topico(
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

        topicos = listOf(topico, topico1, topico2)
    }

    fun listar(): List<Topico> {

        return topicos
    }

    fun buscarPorId(id: Long): Topico {
        return topicos.filter { it.id == id }.get(0)
    }

}
