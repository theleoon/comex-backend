#Criando a database

CREATE DATABASE comex;
----------------------------------------------------
#Criando a tabela pedidos

CREATE TABLE pedidos(
id BIGINT,
categoria VARCHAR(255),
produto VARCHAR(255),
preco DECIMAL(10,2),
quantidade INTEGER,
data DATE,
cliente VARCHAR(60));
----------------------------------------------------
#Alterando a tabela pedidos, adicionando chave primária

ALTER TABLE pedidos ADD PRIMARY KEY (id);
----------------------------------------------------
#Inserindo os 16 registros na tabela pedidos

INSERT INTO pedidos (
id, categoria, produto, preco, quantidade, data, cliente) VALUES (
01, 'INFO', 'Notebook Samsung', 3532.00, 1, '2022-01-01', 'ANA');

INSERT INTO pedidos (
id, categoria, produto, preco, quantidade, data, cliente) VALUES (
02, 'MÓVEIS', 'Sofá 3 lugares', 2500.00, 1, '2022-01-05', 'ANA');

INSERT INTO pedidos (
id, categoria, produto, preco, quantidade, data, cliente) VALUES (
03, 'LIVROS', 'Clean Architechture', 102.9, 2, '2022-01-08', 'ANA');

INSERT INTO pedidos (
id, categoria, produto, preco, quantidade, data, cliente) VALUES (
04, 'MÓVEIS', 'Mesa de jantar 6 lugares', 3678.98, 1, '2022-01-06', 'ELI');

INSERT INTO pedidos (
id, categoria, produto, preco, quantidade, data, cliente) VALUES (
05, 'CELULARES', 'iPhone 13 Pro', 9176.00, 6, '2022-01-13', 'ANA');

INSERT INTO pedidos (
id, categoria, produto, preco, quantidade, data, cliente) VALUES (
06, 'INFO', 'Monitor Dell 27"', 1889.00, 3, '2022-01-04', 'DANI');

INSERT INTO pedidos (
id, categoria, produto, preco, quantidade, data, cliente) VALUES (
07, 'LIVROS', 'Implementing Domain-Driven Design', 144.07, 3, '2022-01-10', 'GABI');

INSERT INTO pedidos (
id, categoria, produto, preco, quantidade, data, cliente) VALUES (
08, 'AUTOMOTIVA', 'Jogo de pneus', 1276.79, 1, '2022-01-15', 'BIA');

INSERT INTO pedidos (
id, categoria, produto, preco, quantidade, data, cliente) VALUES (
09, 'LIVROS', 'Clean Code', 95.17, 1, '2022-01-09', 'BIA');

INSERT INTO pedidos (
id, categoria, produto, preco, quantidade, data, cliente) VALUES (
10, 'CELULARES', 'Galaxy S22 Ultra', 8549.10, 5, '2022-01-14', 'DANI');

INSERT INTO pedidos (
id, categoria, produto, preco, quantidade, data, cliente) VALUES (
11, 'INFO', 'Macbook Pro 16', 31752.00, 1, '2022-01-03', 'CAIO');

INSERT INTO pedidos (
id, categoria, produto, preco, quantidade, data, cliente) VALUES (
12, 'LIVROS', 'Refactoring Improving the Design of Existing Code', 173.90, 1, '2022-01-12', 'DANI');

INSERT INTO pedidos (
id, categoria, produto, preco, quantidade, data, cliente) VALUES (
13, 'MÓVEIS', 'Cama queen size', 3100.00, 2, '2022-01-07', 'DANI');

INSERT INTO pedidos (
id, categoria, produto, preco, quantidade, data, cliente) VALUES (
14, 'AUTOMOTIVA', 'Central multimidia', 711.18, 1, '2022-01-16', 'CAIO');

INSERT INTO pedidos (
id, categoria, produto, preco, quantidade, data, cliente) VALUES (
15, 'LIVROS', 'Building Microservices', 300.28, 2, '2022-01-11', 'CAIO');

INSERT INTO pedidos (
id, categoria, produto, preco, quantidade, data, cliente) VALUES (
16, 'INFO', 'Galaxy Tab S8', 5939.10, 4, '2022-01-02', 'BIA');
----------------------------------------------------
Atualiazando a tabela pedidos, renomeando "info" para "informática"

UPDATE pedidos SET categoria = 'INFORMÁTICA' WHERE categoria = 'INFO';
----------------------------------------------------
Realizando as consultas na tabela pedidos

SELECT * FROM pedidos;

SELECT * FROM pedidos WHERE categoria = 'CELULARES';

SELECT * FROM pedidos WHERE preco BETWEEN 3000.00 AND 10000.00;

SELECT * FROM pedidos WHERE cliente = 'ANA' OR cliente = 'DANI';

SELECT * FROM pedidos WHERE (categoria = 'LIVROS' and quantidade > 1) OR
(categoria = 'INFORMÁTICA' and preco > 5000.00);
----------------------------------------------------
Realizando o delete da tabela pedidos onde o cliente é a bia e a quantidade é 1

DELETE FROM pedidos WHERE quantidade = 1 AND cliente = 'BIA';