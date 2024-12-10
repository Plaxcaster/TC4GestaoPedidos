package horizonleap.gestao.pedido.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

import horizonleap.gestao.pedido.config.StreamProperties;
import horizonleap.gestao.pedido.gateway.ClienteGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class dadosClienteRabbitMQ implements ClienteGateway {
    @Autowired
    private final StreamBridge bridge;
    @Autowired
    private final StreamProperties properties;
    @Override
    public void consultarDadosCliente(Integer id) {
       bridge.send(properties.getConsultaDadosClienteChanel(), id);
    
    }

}
