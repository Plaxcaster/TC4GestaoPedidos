package horizonleap.gestao.pedido.api.model;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import horizonleap.gestao.pedido.model.ItemModel;
import horizonleap.gestao.pedido.model.PedidoModel;
import horizonleap.gestao.pedido.model.DTO.ItemRequisicao;
import horizonleap.gestao.pedido.model.DTO.RegistrarPedidoRequisicao;
import horizonleap.gestao.pedido.service.PedidoService;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PedidosSuplier implements Supplier<PedidoModel> {

    @Autowired
    private PedidoService service;

    @Override
    public PedidoModel get() {
        log.info("Pedido feito");
        List<ItemRequisicao> lista = Arrays.asList(new ItemRequisicao(10, 1), new ItemRequisicao(20, 2));
        return service.gravarPedido(new RegistrarPedidoRequisicao(lista, 171));
    }

}
