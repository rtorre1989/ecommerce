package br.com.ecommerce.estoqueprodutos.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecommerce.estoqueprodutos.dao.model.EstoqueProduto;
import br.com.ecommerce.estoqueprodutos.dao.repository.EstoqueProdutoRepository;
import net.ecommerce.estoque.produtos.EstoqueProduto.Produto;
import net.ecommerce.estoque.produtos.EstoqueProduto.ProdutosEstoqueRes;
import net.ecommerce.estoque.produtos.EstoqueProdutosServiceGrpc.EstoqueProdutosServiceImplBase;

@GRpcService
@Service
public class EstoqueProdutosServerService extends EstoqueProdutosServiceImplBase {

    @Autowired
    EstoqueProdutoRepository repository;

    @Override
    public void produtos(net.ecommerce.estoque.produtos.EstoqueProduto.ProdutoReq request,
            io.grpc.stub.StreamObserver<net.ecommerce.estoque.produtos.EstoqueProduto.ProdutosEstoqueRes> responseObserver) {

        Iterable<EstoqueProduto> estoque = repository.findAll();

        List<Produto> produtosEstoque = new ArrayList<>();

        for (Iterator i = estoque.iterator(); i.hasNext();) {
            EstoqueProduto item = (EstoqueProduto) i.next();
            Produto prod = Produto.newBuilder().setId(item.getId()).setDescricao(item.getDescricao())
                    .setEstoque(item.getEstoque()).setValor(item.getValor()).setUrlImagem(item.getImagem()).build();
            produtosEstoque.add(prod);
        }

        responseObserver.onNext(ProdutosEstoqueRes.newBuilder().addAllProdutos(produtosEstoque).build());
        responseObserver.onCompleted();

    }

}
