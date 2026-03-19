package br.com.boleiroOn.domain.leilao.repository;

import br.com.boleiroOn.domain.leilao.entity.LeilaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeilaoRepository extends JpaRepository<LeilaoEntity, Long> {
}
