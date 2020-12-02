package br.com.ecommerce.estoqueprodutos.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.ecommerce.estoqueprodutos.dao.model.EstoqueProduto;

@Repository
public interface EstoqueProdutoRepository extends CrudRepository<EstoqueProduto, Integer> {
    
}
