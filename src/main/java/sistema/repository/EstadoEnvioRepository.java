
package sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sistema.model.EstadoEnvio;
import java.util.List;

public interface EstadoEnvioRepository extends JpaRepository<EstadoEnvio, Long> {
    
    // Usamos una consulta explícita para evitar que Spring se confunda con los nombres de variables
    @Query("SELECT e FROM EstadoEnvio e WHERE e.id_pedido = :idPedido")
    List<EstadoEnvio> findByIdPedido(@Param("idPedido") Long idPedido);
}
