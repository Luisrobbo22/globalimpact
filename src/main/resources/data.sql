CREATE TABLE CLIENTE(
                        codigo bigint primary key auto_increment,
                        nome varchar(200),
                        descricao varchar(200),
                        contato varchar(200),
                        status varchar(1200),
                        produto_id int
);

CREATE TABLE PRODUTO(
                        codigo bigint primary key auto_increment,
                        descricao varchar(200),
                        descricao_resumida varchar(200),
                        tipo_produto varchar(200),
                        unidade_medida varchar(200),
                        cliente_id int,
                        fornecedor_id int
);


CREATE TABLE FORNECEDOR(
                           codigo bigint primary key auto_increment,
                           descricao varchar(200),
                           nome varchar(200),
                           contato varchar(200),
                           tipo_fornecedor varchar(200),
                           produto_id int
);

INSERT INTO PRODUTO (descricao, descricao_resumida, tipo_produto, unidade_medida) VALUES
('Alimentos', 'Alimento tipo xpto', 'Alimento', 'Kg'),
('Mão de obra para auxiliar entrega produtos doados', 'Serviços', 'Serviços', 'unid'),
('Roupas e calçados', 'Vestimentas', 'Roupas', 'fardos');


INSERT INTO CLIENTE (nome, descricao, contato, status, produto_id) VALUES
('Ong 01', 'Ong voltada para auxilio alimentar', 'ong01@email.com', null, 1),
('Ong 02', 'Ong voltada para auxilio de vestimentas', 'ong02@email.com', null, 3),
('Ong 03', 'Ong voltada para auxilio de serviços', 'ong03@email.com', null, 2),
('Ong 04', 'Ong voltada para auxilio gerais', 'ong04@email.com', null, 2);


INSERT INTO FORNECEDOR (nome, descricao, contato, tipo_fornecedor, produto_id) VALUES
('Fornecedor 01', 'Empresa do ramo tecnológico',  'fornecedor01@email.com', 'Pessoa Jurídica', 1),
('Fornecedor 02', 'Pessoa que ama ajudar os necessitados',  'fornecedor02@email.com', 'Pessoa Física', 3),
('Fornecedor 03', 'Empresa do ramo farmaceutico',  'fornecedor03@email.com', 'Pessoa Jurídica', 2);
