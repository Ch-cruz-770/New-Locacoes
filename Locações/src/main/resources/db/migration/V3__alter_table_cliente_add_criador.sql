ALTER TABLE cliente
ADD COLUMN criador_usuario_id BIGINT NOT NULL;

ALTER TABLE cliente
ADD CONSTRAINT fk_criador_usuario
FOREIGN KEY (criador_usuario_id) REFERENCES usuario(id);