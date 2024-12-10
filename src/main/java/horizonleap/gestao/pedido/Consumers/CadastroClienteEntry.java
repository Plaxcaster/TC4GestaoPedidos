package horizonleap.gestao.pedido.Consumers;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import horizonleap.gestao.pedido.api.model.DadosCliente;
import horizonleap.gestao.pedido.repository.DadosClienteRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@AllArgsConstructor
public class CadastroClienteEntry {

    private final DadosClienteRepository repository;

    @Bean
    public Consumer<DadosCliente> clienteCriado() {
        return cliente -> {
            log.info("Recebida uma mensagem");
            repository.save(cliente);
        };
    }
}
