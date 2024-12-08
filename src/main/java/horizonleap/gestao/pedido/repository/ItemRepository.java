package horizonleap.gestao.pedido.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;


import horizonleap.gestao.pedido.model.ItemModel;

public interface ItemRepository extends JpaRepository<ItemModel, UUID>{

}
