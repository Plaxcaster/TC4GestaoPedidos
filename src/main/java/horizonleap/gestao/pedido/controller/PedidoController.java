package horizonleap.gestao.pedido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import horizonleap.gestao.pedido.model.PedidoModel;
import horizonleap.gestao.pedido.model.DTO.RegistrarPedidoRequisicao;
import horizonleap.gestao.pedido.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
public class PedidoController {

    @Autowired
    PedidoService service;

   @Operation(summary = "Realizar Pedido", tags = { "Pedido" })
   @PostMapping
   public ResponseEntity<PedidoModel> realizarPedido(@RequestBody RegistrarPedidoRequisicao pedido) {
      
      return ResponseEntity.ok(service.gravarPedido(pedido));

   }

}
