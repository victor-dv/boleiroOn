package br.com.boleiroOn.domain.leilao.service;

import br.com.boleiroOn.domain.leilao.dto.LeilaoRequestDto;
import br.com.boleiroOn.domain.leilao.entity.LeilaoEntity;
import br.com.boleiroOn.domain.leilao.repository.LeilaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LeilaoService {

    private final LeilaoRepository leilaoRepository;
    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    public LeilaoEntity create(LeilaoRequestDto data) {
        LeilaoEntity leilao = new LeilaoEntity();
        leilao.setNome(data.nome());
        leilao.setData(data.data());
        leilao.setImageUrl(data.imageUrl());

        return leilaoRepository.save(leilao);
    }

}
