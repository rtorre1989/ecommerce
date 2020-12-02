package br.com.ecommerce.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ecommerce.backend.vo.EstoqueProdutoVo;

/**
 * EstoqueProdutosService
 */
@Service
public interface EstoqueProdutosService {

    List<EstoqueProdutoVo> obterProdutos();
    
}