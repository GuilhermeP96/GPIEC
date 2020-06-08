CREATE SCHEMA `gpiec`;

/*FLUSH PRIVILEGES;
CREATE USER 'Administrador'@'localhost' IDENTIFIED BY 'GpiecAdmin';

GRANT ALL PRIVILEGES ON *.* TO 'Administrador'@'localhost' WITH GRANT OPTION;*/

USE gpiec;

/*  Retirada tabela login, anexado login e senha na tabela usuario */
/*  Alterada data para pegar apenas a data e não mais a hora  */
/*  Alterado campo cpf na tabela usuario de numeric para varchar  */

/* exclusão da tabela telefone, anexei os campos de telefone na tabela Usuario e a tabela de DDD será puxada como FK da mesma */

/*  alterada tabela local2, acrescetado campo descrição na tabela */

/* alterada tabela tipousuario, acrescentado 22 campos de valor booleano (provavelmente deverá ser alterada no futuro) */

/* acrescentada a tabela statusos que contem a situação da os */

/* alterada tabela de ordem de serviço, acrescentado um campo de data de fechamento e a fk do status (em aberto, em andamento ou fechado) */

/*select tipousuario from tipousuario inner join usuario on usuario.fkidtipousuario = tipousuario.idtipousuario where usuario.fkidtipousuario like 2;

select tipousuario from tipousuario inner join usuario where idtipousuario like 1;

select * from usuario;
select * from tipousuario;*/

CREATE TABLE mouse (
  idmouse INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  contemmouse VARCHAR(3) NOT NULL UNIQUE,
PRIMARY KEY(idmouse));

CREATE TABLE memoria (
  idmemoria INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  marca VARCHAR(50)  NULL UNIQUE ,
  frequencia VARCHAR(10) NULL,
  tamanho VARCHAR(10) NOT NULL UNIQUE,
  systemdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY(idmemoria));

CREATE TABLE teclado (
  idteclado INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  contemteclado VARCHAR(3)  NOT NULL UNIQUE,
PRIMARY KEY(idteclado));

CREATE TABLE processador (
  idprocessador INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  marca VARCHAR(50)  NULL ,
  nome VARCHAR(50) NOT NULL UNIQUE,
  systemdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY(idprocessador));

CREATE TABLE software (
  idsoftware INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  nome VARCHAR(50) UNIQUE NOT NULL ,
  descricao VARCHAR(100)  NOT NULL    ,
  systemdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY(idsoftware));

CREATE TABLE status_2 (
  idstatus_2 INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  status_2 VARCHAR(100)  NOT NULL UNIQUE   ,
PRIMARY KEY(idstatus_2));

CREATE TABLE hd (
  idhd INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  marca VARCHAR(50)  NULL,
  capacidade VARCHAR(10) NOT NULL,
  rpm VARCHAR (10) NOT NULL,
  systemdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY(idhd));

CREATE TABLE tipoproblema (
  idtipoproblema INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  tipoproblema VARCHAR(50)  NOT NULL  UNIQUE  ,
PRIMARY KEY(idtipoproblema));

CREATE TABLE ddd (
  idddd INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  ddd NUMERIC(2)  NOT NULL UNIQUE   ,
PRIMARY KEY(idddd));

CREATE TABLE local_2 (
  idlocal_2 INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  local_2 VARCHAR(50)  NOT NULL  UNIQUE  ,
  desc_local VARCHAR(80) NULL ,
PRIMARY KEY(idlocal_2));

CREATE TABLE ip (
  idip INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  ip VARCHAR(15)  NOT NULL  UNIQUE  ,
PRIMARY KEY(idip));

CREATE TABLE tipousuario (
  idtipousuario INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  tipousuario VARCHAR(50)  NOT NULL UNIQUE   ,
  cad_user BOOLEAN NOT NULL,
  cad_grupo BOOLEAN NOT NULL,
  cad_patrimonio BOOLEAN NOT NULL,
  cad_local BOOLEAN NOT NULL,
  cad_soft BOOLEAN NOT NULL,
  cad_hard BOOLEAN NOT NULL,
  cons_user BOOLEAN NOT NULL,
  cons_grupo BOOLEAN NOT NULL,
  cons_patrimonio BOOLEAN NOT NULL,
  cons_local BOOLEAN NOT NULL,
  cons_soft BOOLEAN NOT NULL,
  cons_hard BOOLEAN NOT NULL,
  edit_user BOOLEAN NOT NULL,
  edit_grupo BOOLEAN NOT NULL,
  edit_patrimonio BOOLEAN NOT NULL,
  edit_local BOOLEAN NOT NULL,
  edit_soft BOOLEAN NOT NULL,
  edit_hard BOOLEAN NOT NULL,
  abrir_os BOOLEAN NOT NULL,
  fechar_os BOOLEAN NOT NULL,
  edit_os BOOLEAN NOT NULL,
  relat_os BOOLEAN NOT NULL,
PRIMARY KEY(idtipousuario));



CREATE TABLE tipousuario2 (
  idtipousuario INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  tipousuario VARCHAR(50)  NOT NULL UNIQUE   ,
  cad_user INTEGER NOT NULL,
  cad_grupo INTEGER NOT NULL,
  cad_patrimonio INTEGER NOT NULL,
  cad_local INTEGER NOT NULL,
  cad_soft INTEGER NOT NULL,
  cad_hard INTEGER NOT NULL,
  cons_user INTEGER NOT NULL,
  cons_grupo INTEGER NOT NULL,
  cons_patrimonio INTEGER NOT NULL,
  cons_local INTEGER NOT NULL,
  cons_soft INTEGER NOT NULL,
  cons_hard INTEGER NOT NULL,
  edit_user INTEGER NOT NULL,
  edit_grupo INTEGER NOT NULL,
  edit_patrimonio INTEGER NOT NULL,
  edit_local INTEGER NOT NULL,
  edit_soft INTEGER NOT NULL,
  edit_hard INTEGER NOT NULL,
  abrir_os INTEGER NOT NULL,
  fechar_os INTEGER NOT NULL,
  edit_os INTEGER NOT NULL,
  relat_os INTEGER NOT NULL,
PRIMARY KEY(idtipousuario));



CREATE TABLE tipopatrimonio (
  idtipopatrimonio INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  tipo VARCHAR(100)  NOT NULL  UNIQUE  ,
PRIMARY KEY(idtipopatrimonio));

CREATE TABLE patrimonio (
  idpatrimonio INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  fkidtipopatrimonio INTEGER UNSIGNED  NOT NULL  ,
  numero NUMERIC(9,0)  NOT NULL  ,
  systemdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY(idpatrimonio)  ,
INDEX patrimonio_FKIndex1(fkidtipopatrimonio),
  FOREIGN KEY(fkidtipopatrimonio)
    REFERENCES tipopatrimonio(idtipopatrimonio)
      ON DELETE CASCADE
      ON UPDATE CASCADE);

CREATE TABLE estabilizador (
  idestabilizador INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  descricao VARCHAR(100)  NOT NULL ,
  systemdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY(idestabilizador));

CREATE TABLE monitor (
  idmonitor INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  descricao VARCHAR(100)  NOT NULL ,
  systemdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY(idmonitor));

CREATE TABLE usuario (
  idusuario INTEGER UNSIGNED  NOT NULL  AUTO_INCREMENT ,
  fkidtipousuario INTEGER UNSIGNED  NOT NULL  ,
  nome VARCHAR(50)  NOT NULL  ,
  sobrenome VARCHAR(100)  NOT NULL  ,
  cpf VARCHAR(14)  NOT NULL UNIQUE ,
  telefone VARCHAR(13) NOT NULL ,
  email VARCHAR(100)  NOT NULL  ,
  systemdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  login VARCHAR(20)  NOT NULL UNIQUE  ,
  senha VARCHAR(20)  NOT NULL  ,
  fkddd INTEGER UNSIGNED NOT NULL ,
PRIMARY KEY(idusuario)  ,
INDEX usuario_FKIndex1(fkidtipousuario),
  FOREIGN KEY(fkidtipousuario)
    REFERENCES tipousuario(idtipousuario)
      ON DELETE CASCADE
      ON UPDATE CASCADE);

/*CREATE TABLE telefone (
  idtelefone INTEGER UNSIGNED  NOT NULL AUTO_INCREMENT  ,
  fkidddd INTEGER UNSIGNED  NOT NULL  ,
  fkidusuario INTEGER UNSIGNED  NOT NULL  ,
  numero NUMERIC(9)  NOT NULL    ,
PRIMARY KEY(idtelefone)  ,
INDEX telefone_FKIndex1(fkidddd)  ,
INDEX telefone_FKIndex2(fkidusuario),
  FOREIGN KEY(fkidddd)
    REFERENCES ddd(idddd)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(fkidusuario)
    REFERENCES usuario(idusuario)
      ON DELETE CASCADE
      ON UPDATE CASCADE);*/

CREATE TABLE gabinete (
  idgabinete INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  fkidhd INTEGER UNSIGNED  NOT NULL  ,
  fkidmemoria INTEGER UNSIGNED  NOT NULL  ,
  fkidprocessador INTEGER UNSIGNED  NOT NULL  ,
  systemdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY(idgabinete)  ,
INDEX pc_FKIndex1(fkidprocessador)  ,
INDEX pc_FKIndex2(fkidmemoria)  ,
INDEX pc_FKIndex3(fkidhd)  ,
  FOREIGN KEY(fkidprocessador)
    REFERENCES processador(idprocessador)
      ON DELETE CASCADE
      ON UPDATE CASCADE,
  FOREIGN KEY(fkidmemoria)
    REFERENCES memoria(idmemoria)
      ON DELETE CASCADE
      ON UPDATE CASCADE,
  FOREIGN KEY(fkidhd)
    REFERENCES hd(idhd)
      ON DELETE CASCADE
      ON UPDATE CASCADE);

CREATE TABLE nseriegabinete(
  idnseriegabinete INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  fkidpatrimonio INTEGER UNSIGNED  NOT NULL UNIQUE ,
  nseriefabricante VARCHAR(20) NOT NULL UNIQUE,
  fkidgabinete INTEGER UNSIGNED NOT NULL,
  nomesystem VARCHAR(50) NOT NULL,
  systemdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (idnseriegabinete, fkidpatrimonio),
  INDEX nseriegabinete_FKIndex1(fkidgabinete),
  INDEX nseriegabinete_FKIndex2(fkidpatrimonio),
    FOREIGN KEY(fkidgabinete)
      REFERENCES gabinete(idgabinete)
		ON DELETE CASCADE
        ON UPDATE CASCADE,
  FOREIGN KEY(fkidpatrimonio)
    REFERENCES patrimonio(idpatrimonio)
      ON DELETE CASCADE
      ON UPDATE CASCADE);

CREATE TABLE nseriemonitor(
  idnseriemonitor INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  fkidpatrimonio INTEGER UNSIGNED  NOT NULL UNIQUE ,
  nseriefabricante VARCHAR(20) NOT NULL UNIQUE,
  fkidmonitor INTEGER UNSIGNED NOT NULL,
  systemdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (idnseriemonitor, fkidpatrimonio),
  INDEX nseriemonitor_FKIndex1(fkidmonitor),
INDEX nseriemonitor_FKIndex2(fkidpatrimonio),
    FOREIGN KEY(fkidmonitor)
      REFERENCES monitor(idmonitor)
		ON DELETE CASCADE
        ON UPDATE CASCADE,
  FOREIGN KEY(fkidpatrimonio)
    REFERENCES patrimonio(idpatrimonio)
      ON DELETE CASCADE
      ON UPDATE CASCADE);

CREATE TABLE nserieestabilizador(
  idnserieestabilizador INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  fkidpatrimonio INTEGER UNSIGNED  NOT NULL UNIQUE  ,
  nseriefabricante VARCHAR(20) NOT NULL UNIQUE,
  fkidestabilizador INTEGER UNSIGNED NOT NULL,
  systemdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (idnserieestabilizador, fkidpatrimonio),
   INDEX nserieestabilizador_FKIndex1(fkidestabilizador),
   INDEX nserieestabilizador_FKIndex2(fkidpatrimonio),
    FOREIGN KEY(fkidestabilizador)
      REFERENCES estabilizador(idestabilizador)
		ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY(fkidpatrimonio)
	  REFERENCES patrimonio(idpatrimonio)
        ON DELETE CASCADE
        ON UPDATE CASCADE);

CREATE TABLE pc (
  idpc INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  fkidmouse INTEGER UNSIGNED  NOT NULL  ,
  fkidteclado INTEGER UNSIGNED  NOT NULL  ,
  fkidnseriemonitor INTEGER UNSIGNED  NOT NULL  ,
  fkidnserieestabilizador INTEGER UNSIGNED  NOT NULL  ,
  fkidlocal_2 INTEGER UNSIGNED  NOT NULL  ,
  fkidstatus_2 INTEGER UNSIGNED  NOT NULL  ,
  fkidnseriegabinete INTEGER UNSIGNED  NOT NULL UNIQUE ,
  nomepc VARCHAR(50)  NOT NULL  ,
PRIMARY KEY(idpc)  ,
INDEX pc_FKIndex1(fkidstatus_2)  ,
INDEX pc_FKIndex2(fkidlocal_2)  ,
INDEX pc_FKIndex3(fkidnserieestabilizador)  ,
INDEX pc_FKIndex4(fkidnseriemonitor)  ,
INDEX pc_FKIndex5(fkidteclado)  ,
INDEX pc_FKIndex6(fkidmouse),
INDEX pc_FKindex7(fkidnseriegabinete),
  FOREIGN KEY(fkidstatus_2)
    REFERENCES status_2(idstatus_2)
      ON DELETE CASCADE
      ON UPDATE CASCADE,
  FOREIGN KEY(fkidlocal_2)
    REFERENCES local_2(idlocal_2)
      ON DELETE CASCADE
      ON UPDATE CASCADE,
  FOREIGN KEY(fkidnserieestabilizador)
    REFERENCES nserieestabilizador(idnserieestabilizador)
      ON DELETE CASCADE
      ON UPDATE CASCADE,
  FOREIGN KEY(fkidnseriemonitor)
    REFERENCES nseriemonitor(idnseriemonitor)
      ON DELETE CASCADE
      ON UPDATE CASCADE,
  FOREIGN KEY(fkidteclado)
    REFERENCES teclado(idteclado)
      ON DELETE CASCADE
      ON UPDATE CASCADE,
  FOREIGN KEY(fkidmouse)
    REFERENCES mouse(idMouse)
      ON DELETE CASCADE
      ON UPDATE CASCADE,
  FOREIGN KEY(fkidnseriegabinete)
    REFERENCES nseriegabinete(idnseriegabinete)
      ON DELETE CASCADE
      ON UPDATE CASCADE);

CREATE TABLE lan (
  idlan INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  fkidip INTEGER UNSIGNED  NOT NULL  ,
  fkidpc INTEGER UNSIGNED  NOT NULL  ,
  systemdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY(idlan)  ,
INDEX lanFKIndex1(fkidip)  ,
INDEX lanFKIndex2(fkidpc),
  FOREIGN KEY(fkidip)
    REFERENCES ip(idip)
      ON DELETE CASCADE
      ON UPDATE CASCADE,
  FOREIGN KEY(fkidpc)
    REFERENCES pc(idpc)
      ON DELETE CASCADE
      ON UPDATE CASCADE);

CREATE TABLE problema(
  idproblema INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  problema VARCHAR(100) NOT NULL UNIQUE,
  fkidtipoproblema INTEGER UNSIGNED  NOT NULL  ,
  systemdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY(idproblema),
   INDEX problema_FKIndex1(fkidtipoproblema),
  FOREIGN KEY(fkidtipoproblema)
    REFERENCES tipoproblema(idtipoproblema)
      ON DELETE CASCADE
      ON UPDATE CASCADE);

CREATE TABLE statusos (
  idstatusos INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  situacao VARCHAR(30) NOT NULL,
PRIMARY KEY(idstatusos)
);

CREATE TABLE ordemservico (
  idordemservico INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  fkidpc INTEGER UNSIGNED  NOT NULL  ,
  fkidusuario INTEGER UNSIGNED  NOT NULL  ,
  fkidtipoproblema INTEGER UNSIGNED NOT NULL,
  fkidstatusos INTEGER UNSIGNED NOT NULL,
  tituloproblema VARCHAR(50) NOT NULL,
  detalhesproblema VARCHAR(200) NOT NULL  ,
  systemdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  data_fechamento VARCHAR(10) NULL,
PRIMARY KEY(idordemservico)  ,
INDEX ordemservico_FKIndex1(fkidusuario)  ,
INDEX ordemservico_FKIndex2(fkidpc)  ,
INDEX ordemservico_FKIndex3(fkidtipoproblema),
INDEX ordemservico_FKIndex4(fkidstatusos),
  FOREIGN KEY(fkidusuario)
    REFERENCES usuario(idusuario)
      ON DELETE CASCADE
      ON UPDATE CASCADE,
  FOREIGN KEY(fkidpc)
    REFERENCES pc(idpc)
      ON DELETE CASCADE
      ON UPDATE CASCADE,
  FOREIGN KEY(fkidtipoproblema)
    REFERENCES tipoproblema(idtipoproblema)
      ON DELETE CASCADE
      ON UPDATE CASCADE,
  FOREIGN KEY(fkidstatusos)
    REFERENCES statusos(idstatusos)
      ON DELETE CASCADE
      ON UPDATE CASCADE);

/*CREATE TABLE ordemok (
  idordemok INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  fkidordemservico INTEGER UNSIGNED NOT NULL,
  statusos VARCHAR(30) NOT NULL,
  systemdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY(idordemok),
INDEX ordemok_fkidordemservico(fkidordemservico),
  FOREIGN KEY (fkidordemservico)
    REFERENCES ordemservico(idordemservico)
      ON DELETE CASCADE
      ON UPDATE CASCADE);
*/

CREATE TABLE placasadicionais (
  idplacasadicionais INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  fkidnseriegabinete INTEGER UNSIGNED  NOT NULL  ,
  nome VARCHAR(50)  NOT NULL UNIQUE ,
  descricao VARCHAR(100)  NOT NULL ,
  systemdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY(idplacasadicionais)  ,
INDEX placasadicionais_FKIndex1(fkidnseriegabinete),
  FOREIGN KEY(fkidnseriegabinete)
    REFERENCES nseriegabinete(idnseriegabinete)
      ON DELETE CASCADE
      ON UPDATE CASCADE);

CREATE TABLE softwaresinstalados (
  idsoftwaresinstalados INTEGER UNSIGNED  NOT NULL   AUTO_INCREMENT,
  fkidsoftware INTEGER UNSIGNED  NOT NULL  ,
  fkidnseriegabinete INTEGER UNSIGNED  NOT NULL  ,
  observacao VARCHAR(300) NULL,
  systemdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY(idsoftwaresinstalados)  ,
INDEX softwareinstalados_FKIndex1(fkidsoftware)  ,
INDEX softwareinstalados_FKIndex2(fkidnseriegabinete),
  FOREIGN KEY(fkidsoftware)
    REFERENCES software(idsoftware)
      ON DELETE CASCADE
      ON UPDATE CASCADE,
  FOREIGN KEY(fkidnseriegabinete)
    REFERENCES nseriegabinete(idnseriegabinete)
      ON DELETE CASCADE
      ON UPDATE CASCADE);

CREATE TABLE log (
  idlog BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  fkidusuario INTEGER UNSIGNED NOT NULL,
  alteracao VARCHAR(500) NOT NULL,
  systemdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY(idlog, fkidusuario),
INDEX log_FKIndex1(fkidusuario),
  FOREIGN KEY(fkidusuario)
    REFERENCES usuario(idusuario)
      ON DELETE CASCADE
      ON UPDATE CASCADE);