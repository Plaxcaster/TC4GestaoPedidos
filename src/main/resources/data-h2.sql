-- Create table if it doesn't exist
CREATE TABLE IF NOT EXISTS dados_cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    endereco VARCHAR(255),
    info_contato VARCHAR(255),
    cpf VARCHAR(11),
    endereco_uf VARCHAR(2)
);

-- Check if the new columns exist, and if not, add them
ALTER TABLE dados_cliente DROP COLUMN IF EXISTS enderecoUF;
ALTER TABLE dados_cliente ADD COLUMN IF NOT EXISTS cpf VARCHAR(11);
ALTER TABLE dados_cliente ADD COLUMN IF NOT EXISTS endereco_uf VARCHAR(2);

-- -- Insert initial data into the table
INSERT INTO dados_cliente (id , endereco, info_contato, nome, cpf, endereco_uf) VALUES
(1, 'Sobradinho', '61993253661', 'Gustavo Alves', '12345678901', 'DF'),
(2,'Rio de Janeiro', '11111111', 'Pedro Santos', '23456789012', 'RJ'),
(3, 'Fortaleza', '2222222', 'Thiago Sobral', '34567890123', 'CE');
