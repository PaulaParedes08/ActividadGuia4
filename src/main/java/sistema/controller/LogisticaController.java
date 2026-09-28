
package sistema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sistema.model.EstadoEnvio;
import sistema.model.Pedido;
import sistema.repository.EstadoEnvioRepository;
import sistema.repository.PedidoRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // Permite que las pantallas HTML se conecten sin bloqueos de seguridad
public class LogisticaController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private EstadoEnvioRepository estadoEnvioRepository;

    // 1. OBTENER TODOS LOS PEDIDOS (Para la tabla de gestión de la web)
    @GetMapping("/pedidos")
    public List<Pedido> obtenerPedidos() {
        return pedidoRepository.findAll();
    }

    // 2. CREAR UN NUEVO PEDIDO
    @PostMapping("/pedidos")
    public Pedido crearPedido(@RequestBody Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    // 3. SEGUIMIENTO EN TIEMPO REAL: Obtener el histórico de rutas/estados de un pedido
    @GetMapping("/rastreo/{idPedido}")
    public List<EstadoEnvio> obtenerRastreo(@PathVariable Long idPedido) {
        return estadoEnvioRepository.findByIdPedido(idPedido);
    }

    // 4. ACTUALIZAR UBICACIÓN (Simula el movimiento del transportista guardando nuevas coordenadas)
    @PostMapping("/rastreo")
    public EstadoEnvio actualizarUbicacion(@RequestBody EstadoEnvio nuevoEstado) {
        return estadoEnvioRepository.save(nuevoEstado);
    }
}
