CREATE TABLE lotes (
    id BIGSERIAL PRIMARY KEY,
    leilao_id BIGINT NOT NULL,
    numero_lote INTEGER NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    CONSTRAINT fk_lotes_leilao FOREIGN KEY (leilao_id) REFERENCES leiloes(id)
);