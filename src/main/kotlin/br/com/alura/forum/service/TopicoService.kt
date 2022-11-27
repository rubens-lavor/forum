package br.com.alura.forum.service

import br.com.alura.forum.dto.AtualizacaoTopicoForm
import br.com.alura.forum.dto.NovoTopicoForm
import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.exception.NotFoundException
import br.com.alura.forum.mapper.TopicoFormMapper
import br.com.alura.forum.mapper.TopicoViewMapper
import br.com.alura.forum.model.Curso
import br.com.alura.forum.model.Topico
import br.com.alura.forum.model.Usuario
import br.com.alura.forum.repository.CursoRepository
import br.com.alura.forum.repository.TopicoRepository
import br.com.alura.forum.repository.UsuarioRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class TopicoService(
    private val topicoRepository: TopicoRepository,
    private val topicoViewMapper:TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    val cursoRepository: CursoRepository,
    val usuarioRepository: UsuarioRepository
) {

    fun listar(nomeCurso: String?): List<TopicoView> {
        val topicos:List<Topico> = if (nomeCurso == null) {
            topicoRepository.findAll()
        } else {
            topicoRepository.findByCursoNome(nomeCurso)
        }
        return topicos.map { topico: Topico ->
            topicoViewMapper.map(topico)
        }
    }

    fun buscarPorId(id: Long): TopicoView {

        val topico = buscaTopico(id)

        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm): TopicoView {
        val topico = topicoFormMapper.map(form)
        topicoRepository.save(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm): TopicoView {
        val id = form.id
        val topico = buscaTopico(id)
        topico.titulo = form.titulo
        topico.mensagem = form.mensagem

        /*  não precisa salvar! ao carregar uma entidade via banco de dados, qualquer alteração em seus atributos,
         *  o JPA dispara um update quando a transação for comitada.
         * */

        return topicoViewMapper.map(topico)
    }

    fun deletar(id: Long) {
        topicoRepository.deleteById(id)
    }

    private fun buscaTopico(id: Long): Topico {
        return topicoRepository
            .findByIdOrNull(id)
            ?: throw NotFoundException("Tópico não encontrado pelo id: $id")
    }

    fun listarCursos(): List<Curso> {
        return cursoRepository.findAll()
    }

    fun listarUsuarios(): List<Usuario> {
        return usuarioRepository.findAll()
    }

}
