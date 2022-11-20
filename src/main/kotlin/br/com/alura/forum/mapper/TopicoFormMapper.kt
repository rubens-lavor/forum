package br.com.alura.forum.mapper

import br.com.alura.forum.dto.NovoTopicoForm
import br.com.alura.forum.model.Topico
import br.com.alura.forum.service.CursoService
import br.com.alura.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService
): Mapper<NovoTopicoForm, Topico> {
    override fun map(t: NovoTopicoForm): Topico {
        return with(t) {
            Topico(
                titulo = titulo,
                mensagem = mensagem,
                curso = cursoService.buscarPorId(idCurso),
                autor = usuarioService.buscarPorId(idAutor)
            )
        }
    }
}
