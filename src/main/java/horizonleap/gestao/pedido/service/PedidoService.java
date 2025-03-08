package horizonleap.gestao.pedido.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

import horizonleap.gestao.pedido.api.model.DadosCliente;
import horizonleap.gestao.pedido.api.model.PedidoProntoEnvio;
import horizonleap.gestao.pedido.gateway.PedidoEventGateway;
import horizonleap.gestao.pedido.model.ItemModel;
import horizonleap.gestao.pedido.model.PedidoModel;
import horizonleap.gestao.pedido.model.dto.RegistrarPedidoRequisicao;
import horizonleap.gestao.pedido.repository.DadosClienteRepository;
import horizonleap.gestao.pedido.repository.ItemRepository;
import horizonleap.gestao.pedido.repository.PedidoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PedidoService {

    private final PedidoRepository repository;
    private final ItemRepository itemRepository;
    private final DadosClienteRepository clienteRepository;
    private final PedidoEventGateway eventGateway;

    // Constructor injection
    public PedidoService(PedidoRepository repository, ItemRepository itemRepository,
            DadosClienteRepository clienteRepository, PedidoEventGateway eventGateway) {
        this.repository = repository;
        this.itemRepository = itemRepository;
        this.clienteRepository = clienteRepository;
        this.eventGateway = eventGateway;
    }

    public PedidoModel gravarPedido(RegistrarPedidoRequisicao pedido) {

        List<ItemModel> listaItens = new LinkedList<>();

        pedido.getListaItens().forEach(
                item -> listaItens.add(itemRepository.save(new ItemModel(item.getQuantidade(), item.getIdProduto()))));
        PedidoModel pedidoSalvo = repository.save(new PedidoModel(listaItens, pedido.getCliente()));

        PedidoProntoEnvio pedidoPronto = prepararPedido(pedidoSalvo);

        eventGateway.pedidoFeitoEvent(pedidoPronto);

        return pedidoSalvo;
    }

    private PedidoProntoEnvio prepararPedido(PedidoModel pedido) {

        DadosCliente cliente = clienteRepository.findById(pedido.getCliente()).orElseThrow();

        return PedidoProntoEnvio.builder()
                .CPF(cliente.getCpf())
                .cliente(pedido.getCliente())
                .endereco(cliente.getEndereco())
                .id(pedido.getId())
                .listaItens(pedido.getListaItens())
                .nomeCliente(cliente.getNome())
                .build();

    }

}
