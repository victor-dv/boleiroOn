package br.com.boleiroOn.domain.lote.repository;

import br.com.boleiroOn.domain.lote.entity.LoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoteRepository extends JpaRepository<LoteEntity, Long> {
    boolean existsByLeilaoIdAndNumeroLote(Long leilaoId, Integer numeroLote);
}
