package br.com.alura.forum.model

import java.time.LocalDate

data class Resposta (
    val id: Long? = null,
    val messagem: String,
    val dataCriacao: LocalDate = LocalDate.now(),
    val autor: Usuario,
    val topico: Topico,
    val solucao: Boolean
)
