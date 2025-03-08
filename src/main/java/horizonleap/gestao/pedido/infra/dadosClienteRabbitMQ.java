package horizonleap.gestao.pedido.infra;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

import horizonleap.gestao.pedido.config.StreamProperties;
import horizonleap.gestao.pedido.gateway.ClienteGateway;

@Component
public class DadosClienteRabbitMQ implements ClienteGateway {
    private final StreamBridge bridge;
    private final StreamProperties properties;

    // Constructor injection
    public DadosClienteRabbitMQ(StreamBridge bridge, StreamProperties properties) {
        this.bridge = bridge;
        this.properties = properties;
    }
    @Override
    public void consultarDadosCliente(Integer id) {
       bridge.send(properties.getConsultaDadosClienteChanel(), id);
    }

}
