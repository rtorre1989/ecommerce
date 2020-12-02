package br.com.ecommerce.backend.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstoqueProdutoVo {

    private Integer id;
    private String descricao;
    private Integer estoque;
    private Double valor;
    private String urlImagem;
    
}
