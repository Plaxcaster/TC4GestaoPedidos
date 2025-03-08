package horizonleap.gestao.pedido.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ItemRequisicao {

    private final Integer quantidade;
    private final Integer idProduto;

    @Override
    public String toString() {
        return " qt=" + quantidade + ",prd=" + idProduto;
    }
}
