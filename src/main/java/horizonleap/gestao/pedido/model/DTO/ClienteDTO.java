
package horizonleap.gestao.pedido.model.DTO;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ClienteDTO {
    private Integer id;
    private String nome;
    private String endereco;
    private String infoContato;
}
