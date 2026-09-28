
package sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sistema.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
