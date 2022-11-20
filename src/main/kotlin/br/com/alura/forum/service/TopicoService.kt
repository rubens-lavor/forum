package br.com.alura.forum.service

import br.com.alura.forum.dto.NovoTopicoForm
import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.mapper.TopicoFormMapper
import br.com.alura.forum.mapper.TopicoViewMapper
import br.com.alura.forum.model.Curso
import br.com.alura.forum.model.Topico
import br.com.alura.forum.model.Usuario
import org.springframework.stereotype.Service

@Service
class TopicoService(
    private val topicos: MutableList<Topico>,
    private val topicoViewMapper:TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper
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

    fun listar(): List<TopicoView> {
        return topicos.map { topico: Topico ->
            topicoViewMapper.map(topico)
        }
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = topicos.filter { it.id == id }.get(0)
        return topicoViewMapper.map(topico)
    }

    fun cadrastrar(dto: NovoTopicoForm) {
        val topico = topicoFormMapper.map(dto)
        topico.id = topicos.size.inc().toLong()
        topicos.add(topico)
    }

}
