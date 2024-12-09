package horizonleap.gestao.pedido.gateway;

import horizonleap.gestao.pedido.model.DTO.RegistrarPedidoRequisicao;

public interface PedidoEventGateway {

    void pedidoFeitoEvent(RegistrarPedidoRequisicao pedido);
}
