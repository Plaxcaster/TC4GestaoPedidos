package horizonleap.gestao.pedido.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
public class PedidoModel {

    @Column
    @Id
    @GeneratedValue()
    private UUID id;

    @Column
    @OneToMany
    private List<ItemModel> listaItens;

    @Column
    private Integer cliente;

    public PedidoModel(List<ItemModel> listaItens , Integer cliente ){
        this.listaItens = listaItens;
        this.cliente = cliente;
    }
}
