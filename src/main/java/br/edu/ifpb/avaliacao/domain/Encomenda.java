
package br.edu.ifpb.avaliacao.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author miolivc
 * @mail miolivc@outlook.com
 * @since 26/10/2017
 */

@Entity
@SequenceGenerator(name = "encomenda_seq", sequenceName = "encomenda_seq")

public class Encomenda implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "encomenda_seq")
    private int id;
    @Column(length = 70, nullable = false, unique = true)
    private String titulo;
    @Column(length = 150)
    private String descricao;
    @Temporal(TemporalType.DATE)
    private Date entrega;
    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean entregue;

    public Encomenda() {
    }

    public Encomenda(String titulo, String descricao, Date entrega) {
        this.titulo = titulo;
        this.descricao = descricao;
        setEntrega(entrega);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getEntrega() {
        return entrega;
    }

    public void setEntrega(Date entrega) {
        entrega.setDate(entrega.getDate() + 1);
        this.entrega = entrega;
    }

    public boolean isEntregue() {
        return entregue;
    }

    public void setEntregue(boolean entregue) {
        this.entregue = entregue;
    }
    
}
