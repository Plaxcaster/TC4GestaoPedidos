package horizonleap.gestao.pedido.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Entity
@NoArgsConstructor
public class ItemModel {

    @Column
    @Id 
    @GeneratedValue
    private UUID id;

    @Column
    private Integer quantidade;

    @Column
    private Integer idProduto;



    public ItemModel(Integer quantidade , Integer idProduto){
        this.quantidade = quantidade;
        this.idProduto = idProduto;
    }
}
