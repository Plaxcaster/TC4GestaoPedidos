package horizonleap.gestao.pedido.gateway;

import horizonleap.gestao.pedido.api.model.PedidoProntoEnvio;

public interface PedidoEventGateway {

    void pedidoFeitoEvent(PedidoProntoEnvio pedido);
}
