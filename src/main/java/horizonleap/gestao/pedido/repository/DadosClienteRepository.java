package horizonleap.gestao.pedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import horizonleap.gestao.pedido.api.model.DadosCliente;

public interface DadosClienteRepository extends JpaRepository<DadosCliente, Integer> {
}
