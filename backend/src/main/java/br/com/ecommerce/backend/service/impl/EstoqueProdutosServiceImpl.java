package br.com.ecommerce.backend.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ecommerce.backend.service.EstoqueProdutosService;
import br.com.ecommerce.backend.vo.EstoqueProdutoVo;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import net.ecommerce.estoque.produtos.EstoqueProdutosServiceGrpc;
import net.ecommerce.estoque.produtos.EstoqueProduto.Produto;
import net.ecommerce.estoque.produtos.EstoqueProduto.ProdutoReq;
import net.ecommerce.estoque.produtos.EstoqueProduto.ProdutosEstoqueRes;
import net.ecommerce.estoque.produtos.EstoqueProdutosServiceGrpc.EstoqueProdutosServiceBlockingStub;

@Service
public class EstoqueProdutosServiceImpl implements EstoqueProdutosService {

    private static final String ADRESS_GRPC_SERVE = "localhost";
    private static final Integer PORT_GRPC_SERVE = 6565;
    @Override
    public List<EstoqueProdutoVo> obterProdutos() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(ADRESS_GRPC_SERVE, PORT_GRPC_SERVE).usePlaintext()
                .build();

        EstoqueProdutosServiceBlockingStub stub = EstoqueProdutosServiceGrpc.newBlockingStub(channel);

        ProdutosEstoqueRes response = stub.produtos(ProdutoReq.newBuilder().setReq("value").build());

        channel.shutdown();

        List<EstoqueProdutoVo> produtosResp = new ArrayList<>();
        EstoqueProdutoVo produto = null;

        for (Produto resp : response.getProdutosList()) {
            produto = new EstoqueProdutoVo(resp.getId(), resp.getDescricao(), resp.getEstoque(), resp.getValor(), resp.getUrlImagem() );
            produtosResp.add(produto);
        }

        return produtosResp;
    }

}
