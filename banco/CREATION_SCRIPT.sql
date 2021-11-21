CREATE TABLE ENDERECO(
ID_ENDERECO INTEGER NOT NULL PRIMARY KEY,
RUA VARCHAR(200),
NUMERO VARCHAR(10),
BAIRRO VARCHAR(200),
COMPLEMENTO VARCHAR(200),
CEP VARCHAR(9),
CIDADE VARCHAR(200),
ESTADO VARCHAR(200));

CREATE SEQUENCE SEQ_ID_ENDERECO AS INTEGER START WITH 1 INCREMENT BY 1;

CREATE TABLE DISCIPLINA(
ID_DISCIPLINA INTEGER NOT NULL PRIMARY KEY,
DESCRICAO VARCHAR(200));

CREATE SEQUENCE SEQ_ID_DISCIPLINA AS INTEGER START WITH 1 INCREMENT BY 1;

CREATE TABLE PACIENTE(
ID_PACIENTE INTEGER NOT NULL PRIMARY KEY,
ID_ENDERECO INTEGER,
NOME VARCHAR(200),
DATA_NASCIMENTO DATE,
SEXO VARCHAR(1),
RG VARCHAR(12),
CPF VARCHAR(14),
TELEFONE VARCHAR(14),
EMAIL VARCHAR(200),
PESO NUMERIC(15,3),
ALTURA NUMERIC(15,3),
COR VARCHAR(10),
ESCOLARIDADE VARCHAR(50),
PROFISSAO VARCHAR(200),
ESTADO_CIVIL VARCHAR(50),
NATURALIDADE VARCHAR(50),
ESTADO VARCHAR(50)
);

CREATE SEQUENCE SEQ_ID_PACIENTE AS INTEGER START WITH 1 INCREMENT BY 1;

CREATE TABLE PROFISSIONAL(
ID_PROFISSIONAL INTEGER NOT NULL PRIMARY KEY,
ID_ENDERECO INTEGER,
NOME VARCHAR(200),
DATA_NASCIMENTO DATE,
SEXO VARCHAR(1),
RG VARCHAR(12),
CPF VARCHAR(14),
TELEFONE VARCHAR(14),
EMAIL VARCHAR(200),
CRO VARCHAR (10));

CREATE SEQUENCE SEQ_ID_PROFISSIONAL AS INTEGER START WITH 1 INCREMENT BY 1;

CREATE TABLE SUPERVISOR(
ID_SUPERVISOR INTEGER NOT NULL PRIMARY KEY,
ID_DISCIPLINA INTEGER,
ID_ENDERECO INTEGER,
NOME VARCHAR(200),
DATA_NASCIMENTO DATE,
SEXO VARCHAR(1),
RG VARCHAR(12),
CPF VARCHAR(14),
TELEFONE VARCHAR(14),
EMAIL VARCHAR(200),
CRO VARCHAR (10));

CREATE SEQUENCE SEQ_ID_SUPERVISOR AS INTEGER START WITH 1 INCREMENT BY 1;

--CREATING FOREIGN KEY CONSTRAINTS

ALTER TABLE SUPERVISOR ADD CONSTRAINT FK_DISCIPLINA_SUPERVISOR FOREIGN KEY(ID_DISCIPLINA) REFERENCES DISCIPLINA(ID_DISCIPLINA)
ALTER TABLE SUPERVIDOR ADD CONSTRAINT FK_ENDERECO_PACIENTE FOREIGN KEY(ID_ENDERECO) REFERENCES ENDERECO(ID_ENDERECO)
ALTER TABLE PROFISSIONAL ADD CONSTRAINT FK_ENDERECO_PROFISSIONAL FOREIGN KEY(ID_ENDERECO) REFERENCES ENDERECO(ID_ENDERECO)
ALTER TABLE PACIENTE ADD CONSTRAINT FK_ENDERECO_PACIENTE FOREIGN KEY(ID_ENDERECO) REFERENCES ENDERECO(ID_ENDERECO)

CREATE TABLE USUARIO (
ID_USUARIO INTEGER NOT NULL PRIMARY KEY,
ID_PACIENTE INTEGER,
ID_PROFISSIONAL INTEGER,
ID_SUPERVISOR INTEGER,
LOGIN VARCHAR(50),
SENHA VARCHAR(50))

CREATE SEQUENCE SEQ_ID_USUARIO AS INTEGER START WITH 1 INCREMENT BY 1;

ALTER TABLE USUARIO ADD CONSTRAINT FK_PACIENTE_USUARIO FOREIGN KEY(ID_PACIENTE) REFERENCES PACIENTE(ID_PACIENTE)
ALTER TABLE USUARIO ADD CONSTRAINT FK_PROFISSIONAL_USUARIO FOREIGN KEY(ID_PROFISSIONAL) REFERENCES PROFISSIONAL(ID_PROFISSIONAL)
ALTER TABLE USUARIO ADD CONSTRAINT FK_SUPERVISOR_USUARIO FOREIGN KEY(ID_SUPERVISOR) REFERENCES SUPERVIDOR(ID_SUPERVISOR)

CREATE TABLE ENCAMINHAMENTO(
ID_ENCAMINHAMENTO INTEGER NOT NULL PRIMARY KEY,
ID_SUPERVISOR INTEGER,
ID_PACIENTE INTEGER,
ID_PROFISSIONAL INTEGER,
DATA_ENCAMINHAMENTO VARCHAR(15),
GRADUCAO VARCHAR(200),
POS_GRADUACAO VARCHAR(200),
PROJETO_EXTENSAO VARCHAR(200)
)