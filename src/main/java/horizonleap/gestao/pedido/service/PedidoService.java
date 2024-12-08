package horizonleap.gestao.pedido.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import horizonleap.gestao.pedido.model.ItemModel;
import horizonleap.gestao.pedido.model.PedidoModel;
import horizonleap.gestao.pedido.model.DTO.RegistrarPedidoRequisicao;
import horizonleap.gestao.pedido.repository.PedidoRepository;
import horizonleap.gestao.pedido.repository.ItemRepository;

@Component
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private ItemRepository itemRepository;

    public PedidoModel gravarPedido(RegistrarPedidoRequisicao pedido) {
        List<ItemModel> listaItens = new LinkedList<ItemModel>();
        pedido.getListaItens().forEach(
                item -> listaItens.add(itemRepository.save(new ItemModel(item.getQuantidade(), item.getIdProduto()))));
        return repository.save(new PedidoModel(listaItens, pedido.getCliente()));
    }

}
