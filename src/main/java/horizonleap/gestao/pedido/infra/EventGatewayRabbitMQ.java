package horizonleap.gestao.pedido.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

import horizonleap.gestao.pedido.config.StreamProperties;
import horizonleap.gestao.pedido.gateway.PedidoEventGateway;
import horizonleap.gestao.pedido.model.DTO.RegistrarPedidoRequisicao;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EventGatewayRabbitMQ implements PedidoEventGateway {

    @Autowired
    private final StreamBridge bridge;
    @Autowired
    private final StreamProperties properties;
    @Override
    public void pedidoFeitoEvent(RegistrarPedidoRequisicao pedido) {
        bridge.send(properties.getPedidoFeitoChanel(),pedido);
    }


}