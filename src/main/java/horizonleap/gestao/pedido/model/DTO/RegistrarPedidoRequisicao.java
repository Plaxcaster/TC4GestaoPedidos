package horizonleap.gestao.pedido.model.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class RegistrarPedidoRequisicao {
    private final List<ItemRequisicao> listaItens;

    private final Integer cliente; 

}
