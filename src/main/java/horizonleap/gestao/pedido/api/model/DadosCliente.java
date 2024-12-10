
package horizonleap.gestao.pedido.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class DadosCliente {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nome;

    @Column
    private String endereco;

    @Column
    private String infoContato;

    @Column
    private String cpf;

    @Enumerated(EnumType.STRING) 
    @Column(name = "endereco_uf")
    private EnderecoUF enderecoUF;
}
