DROP TABLE language if exists;

CREATE TABLE language
(
  code VARCHAR2(12) PRIMARY KEY ,
  name VARCHAR2(50) NOT NULL

);

DROP TABLE tipologia if exists;

CREATE TABLE tipologia
(
  code VARCHAR2(20) PRIMARY KEY,
  description VARCHAR2(25) NOT NULL
  
);

DROP TABLE tipologia_i18n if exists;

CREATE TABLE tipologia_i18n
(
  id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  description VARCHAR2(25) NOT NULL,
  language VARCHAR2(12) NOT NULL,
  tipologia_id VARCHAR2(20) NOT NULL,
  FOREIGN KEY (tipologia_id) REFERENCES tipologia(code), 
  FOREIGN KEY (language) REFERENCES language(code)  
);



INSERT INTO tipologia(code, description) VALUES (1, 'descrizione');

INSERT INTO language(code, name) VALUES('en', 'English');
INSERT INTO language(code, name) VALUES('it', 'Italian');
INSERT INTO language(code, name) VALUES('es', 'Spanish');

INSERT INTO tipologia_i18n(id, description, language, tipologia_id) VALUES (1,'description', 'en', 1);
INSERT INTO tipologia_i18n(id, description, language, tipologia_id) VALUES (2,'descripción', 'es', 1);

