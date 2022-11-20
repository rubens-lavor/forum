package br.com.alura.forum.model

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
data class Resposta (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val messagem: String,
    val dataCriacao: LocalDate = LocalDate.now(),

    @ManyToOne
    val autor: Usuario,

    @ManyToOne
    val topico: Topico,
    val solucao: Boolean
)
