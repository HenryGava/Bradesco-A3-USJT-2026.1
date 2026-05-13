-- 1. criar e selecionar o banco
CREATE DATABASE IF NOT EXISTS Sentinela0800
  CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE Sentinela0800;

-- 2. tabela de usuários
CREATE TABLE usuario (
  id         BIGINT AUTO_INCREMENT PRIMARY KEY,
  nome       VARCHAR(100) NOT NULL,
  email      VARCHAR(150) NOT NULL UNIQUE,
  estado     CHAR(2) NOT NULL,
  criado_em  DATETIME DEFAULT NOW()
);

-- 3. tabela de telefones suspeitos
CREATE TABLE telefone_suspeito (
  id              BIGINT AUTO_INCREMENT PRIMARY KEY,
  numero         VARCHAR(20) NOT NULL UNIQUE,
  total_denuncias INT DEFAULT 0,
  bloqueado      BOOLEAN DEFAULT FALSE
);

-- 4. tabela de denúncias (principal)
CREATE TABLE denuncia (
  id          BIGINT AUTO_INCREMENT PRIMARY KEY,
  usuario_id  BIGINT NOT NULL,
  telefone_id BIGINT NOT NULL,
  tipo_golpe  VARCHAR(100) NOT NULL,
  descricao   TEXT,
  prejuizo    DECIMAL(10,2) DEFAULT 0.00,
  status      ENUM('NOVO','EM_ANALISE','CONFIRMADO','RESOLVIDO')
              DEFAULT 'NOVO',
  criado_em   DATETIME DEFAULT NOW(),
  FOREIGN KEY (usuario_id) REFERENCES usuario(id),
  FOREIGN KEY (telefone_id) REFERENCES telefone_suspeito(id)
);

-- 5. tabela de estatísticas mensais
CREATE TABLE estatistica (
  id       BIGINT AUTO_INCREMENT PRIMARY KEY,
  mes      INT NOT NULL,
  ano      INT NOT NULL,
  tipo_golpe VARCHAR(100),
  total    INT DEFAULT 0
);