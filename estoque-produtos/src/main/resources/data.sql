DROP TABLE IF EXISTS TB_ESTOQUE_PRODUTOS;

CREATE TABLE TB_ESTOQUE_PRODUTOS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  descricao VARCHAR(250) NOT NULL,
  estoque INT NOT NULL,
  valor DECIMAL(10, 2)  DEFAULT NULL,
  imagem VARCHAR(250)
);

INSERT INTO TB_ESTOQUE_PRODUTOS (descricao, estoque, valor, imagem) VALUES 
('Produto 1', 2, 100, 'assets/images/produto1.jfif'),
  ('Produto 2', 2, 250.99, 'assets/images/produto2.jfif'),
  ('Produto 3', 2, 1999.99, 'assets/images/produto3.jfif'),
  ('Produto 4', 2, 849.50, 'assets/images/produto4.jfif');