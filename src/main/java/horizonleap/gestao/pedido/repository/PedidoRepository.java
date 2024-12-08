package horizonleap.gestao.pedido.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import horizonleap.gestao.pedido.model.PedidoModel;

public interface PedidoRepository extends JpaRepository<PedidoModel, UUID> {
}
