package br.com.ecommerce.estoqueprodutos.dao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * EstoqueProduto
 */
@Table(name = "TB_ESTOQUE_PRODUTOS")
@Entity
@Data
public class EstoqueProduto {

    @Id
    @GeneratedValue
    private int id;

    private String descricao;

    private int estoque;

    private Double valor;

    private String imagem;
}