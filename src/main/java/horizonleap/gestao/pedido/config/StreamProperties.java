package horizonleap.gestao.pedido.config;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class StreamProperties {
    private String pedidoFeitoChanel = "pedidosSuplier-out-0";
}
