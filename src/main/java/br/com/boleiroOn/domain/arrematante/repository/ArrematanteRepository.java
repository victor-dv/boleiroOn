package br.com.boleiroOn.domain.arrematante.repository;

import br.com.boleiroOn.domain.arrematante.entity.ArrematanteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArrematanteRepository extends JpaRepository<ArrematanteEntity, Long> {
    boolean existsByLeilaoIdAndPlaca(Long leilaoId, Integer placa);
    Optional<ArrematanteEntity> findByLeilaoIdAndPlaca(Long leilaoId, Integer placa);
    List<ArrematanteEntity> findAllByLeilaoId(Long leilaoId);
}
