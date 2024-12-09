package horizonleap.gestao.pedido.api.model;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import horizonleap.gestao.pedido.model.DTO.ItemRequisicao;
import horizonleap.gestao.pedido.model.DTO.RegistrarPedidoRequisicao;
import horizonleap.gestao.pedido.service.PedidoService;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class GeradorPedidos{

    @Autowired
    private PedidoService service;

    private List<Integer> listaDeProdutos = Arrays.asList(1, 2, 3, 4);
    private List<Integer> listaDeClientes = Arrays.asList(100, 200, 300, 400);

    @Scheduled(fixedRate = 1000) // uma execução por segundo
    public void inventarPedido() {
        ItemRequisicao item1 = new ItemRequisicao(quantidadeAleatoria() , produtoAleatorio());
        ItemRequisicao item2 = new ItemRequisicao(quantidadeAleatoria() , produtoAleatorio());
        List<ItemRequisicao> listaItems = Arrays.asList(item1 , item2);
        Integer clienteAleatorio = clienteAleatorio();
        log.info("Pedido para cliente {} , item1 {} , item2 {} " , clienteAleatorio.toString(), item1.toString(), item2.toString());
        service.gravarPedido(new RegistrarPedidoRequisicao(listaItems,clienteAleatorio));
    }

    private Integer produtoAleatorio(){
        return listaDeProdutos.get(new Random().nextInt(listaDeProdutos.size()));
    }

    private Integer clienteAleatorio(){
        return listaDeClientes.get(new Random().nextInt(listaDeClientes.size()));
    }

    private Integer quantidadeAleatoria(){
        return new Random().nextInt(100);
    }
}
