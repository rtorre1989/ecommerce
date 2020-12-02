package br.com.ecommerce.backend.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerce.backend.service.EstoqueProdutosService;
import br.com.ecommerce.backend.vo.EstoqueProdutoVo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ProdutosController
 */

@RestController()
@RequestMapping("produtos")
@CrossOrigin(allowedHeaders = "*", maxAge = -1, origins = "*", methods = { RequestMethod.OPTIONS, RequestMethod.GET,
    RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class ProdutosController {

    @Autowired
    private EstoqueProdutosService estoqueProdutosService;

    @GetMapping(value = "estoque")
    @CrossOrigin(allowedHeaders = "*", maxAge = -1, origins = "*", methods = { RequestMethod.OPTIONS, RequestMethod.GET,
        RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
    public List<EstoqueProdutoVo> getEstoqueProdutos() {
        return estoqueProdutosService.obterProdutos();
    }

}