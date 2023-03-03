/* INSERINDO DADOS NA TABELA */

INSERT INTO categorias (nome) VALUES ('INFO'), ('MÓVEIS'), ('LIVROS'), ('CELULARES'), ('AUTOMOTIVA');

INSERT INTO produtos (nome, preco, categoria_id) VALUES ('Notebook Samsung', 3523.00, 1), ('Sofá 3 lugares', 2500.00, 2), ('Clean Architecture', 102.90, 3), ('Mesa de jantar', 3678.98, 2), ('Iphone 13 Pro', 9176.00, 4), ('Monitor Dell 27"', 1889.00, 1), ('Implementing Domain-Driven Design', 144.07, 3), ('Jogo de pneus', 1276.79, 5), ('Clean Code', 95.17, 3), ('Galaxy S22 Ultra', 8549.10, 4), ('Macbook Pro 16', 31752.00, 1), ('Refactoring Improving the Design of Existing Code', 173.90, 3), ('Cama queen size', 3100.00, 2), ('Central multimidia', 711.18, 5), ('Building Microservices', 300.28, 3), ('Galaxy Tab S8', 5939.10, 1);

INSERT INTO clientes (nome) VALUES ('ANA'), ('ELI'), ('DANI'), ('GABI'), ('BIA'), ('CAIO');

INSERT INTO pedidos (data, cliente_id) VALUES ('2022-01-01', 1), ('2022-01-05', 1), ('2022-01-08', 1), ('2022-01-06', 2), ('2022-01-13', 1), ('2022-01-04', 3), ('2022-01-10', 4), ('2022-01-15', 5), ('2022-01-09', 5), ('2022-01-14', 3), ('2022-01-03', 6), ('2022-01-12', 3), ('2022-01-07', 3), ('2022-01-16', 6), ('2022-01-11', 6), ('2022-01-02', 5);

INSERT INTO item_pedido (quantidade, preco_unitario, pedido_id, produto_id) VALUES (1, 3523.00, 1, 1), (1, 2500.00, 2, 2), (2, 102.90, 3, 3), (1, 3678.98, 4, 4), (6, 9176.00, 5, 5), (3, 1889.00, 6, 6), (3, 144.07, 7, 7), (1, 1276.79, 8, 8), (1, 95.17, 9, 9), (5, 8549.10, 10, 10), (1, 31752.00, 11, 11), (1, 173.90, 12, 12), (2, 3100.00, 13, 13), (1, 711.18, 14, 14), (2, 300.28, 15, 15), (4, 5939.10, 16, 16);