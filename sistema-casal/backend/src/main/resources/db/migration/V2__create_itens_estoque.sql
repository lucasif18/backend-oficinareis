CREATE TABLE itens_estoque (

    id BIGSERIAL PRIMARY KEY,

    casal_id BIGINT NOT NULL,

    nome VARCHAR(100) NOT NULL,

    categoria VARCHAR(50),

    marca VARCHAR(50),

    lote VARCHAR(50),

    fabricante VARCHAR(100),

    quantidade INTEGER NOT NULL DEFAULT 0,

    unidade_medida VARCHAR(20),

    quantidade_minima INTEGER NOT NULL DEFAULT 0,

    data_validade DATE,

    data_abertura DATE,

    dias_validade_apos_aberto INTEGER,

    local_armazenamento VARCHAR(100),

    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_itens_estoque_casal
        FOREIGN KEY (casal_id)
        REFERENCES casais(id)
        ON DELETE CASCADE
);