DROP TABLE IF EXISTS users;
CREATE TABLE users (
  userId INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  cidade VARCHAR(100) NOT NULL,
  endereco VARCHAR(100) NOT NULL,
  PRIMARY KEY (userId));