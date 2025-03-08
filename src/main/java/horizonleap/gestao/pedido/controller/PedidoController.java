package horizonleap.gestao.pedido.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import horizonleap.gestao.pedido.model.PedidoModel;
import horizonleap.gestao.pedido.model.dto.RegistrarPedidoRequisicao;
import horizonleap.gestao.pedido.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
public class PedidoController {

    private final PedidoService service;

    public PedidoController (PedidoService service){
      this.service = service;
    }

   @Operation(summary = "Realizar Pedido", tags = { "Pedido" })
   @PostMapping
   public ResponseEntity<PedidoModel> realizarPedido(@RequestBody RegistrarPedidoRequisicao pedido) {
      
      return ResponseEntity.ok(service.gravarPedido(pedido));

   }

}
