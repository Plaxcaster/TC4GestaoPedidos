package horizonleap.gestao.pedido.infra;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

import horizonleap.gestao.pedido.api.model.PedidoProntoEnvio;
import horizonleap.gestao.pedido.config.StreamProperties;
import horizonleap.gestao.pedido.gateway.PedidoEventGateway;

@Component
public class EventGatewayRabbitMQ implements PedidoEventGateway {

    private final StreamBridge bridge;
    private final StreamProperties properties;

    // Constructor injection
    public EventGatewayRabbitMQ(StreamBridge bridge, StreamProperties properties) {
        this.bridge = bridge;
        this.properties = properties;
    }


    @Override
    public void pedidoFeitoEvent(PedidoProntoEnvio pedido) {
        bridge.send(properties.getPedidoFeitoChanel(),pedido);
    }


}
