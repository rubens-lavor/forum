package br.com.alura.forum.mapper

import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.model.Topico
import org.springframework.stereotype.Component

@Component
class TopicoViewMapper: Mapper<Topico, TopicoView> {
    override fun map(t: Topico): TopicoView {
        return with(t) {
            TopicoView(
                id = id,
                titulo = titulo,
                mensagem = mensagem,
                dataCriacao = dataCriacao,
                status = status
            )
        }
    }
}