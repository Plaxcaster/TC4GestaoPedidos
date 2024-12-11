package horizonleap.gestao.pedido.api.model;

import java.util.List;
import java.util.UUID;

import horizonleap.gestao.pedido.model.ItemModel;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PedidoProntoEnvio {
    private UUID id;

    private List<ItemModel> listaItens;

    private Integer cliente;

    private String nomeCliente;

    private String endereco;

    private String CPF;
}
