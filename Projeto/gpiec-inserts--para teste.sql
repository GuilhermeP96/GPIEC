/*--------------------------------------------------------------------------------------------------------------------*/

/*INSERÇÕES DE TESTE*/
insert into tipousuario (tipousuario, cad_user, cad_grupo, cad_patrimonio, cad_local, cad_soft, cad_hard,
	cons_user, cons_grupo, cons_patrimonio, cons_local, cons_soft, cons_hard,
		edit_user, edit_grupo, edit_patrimonio, edit_local, edit_soft, edit_hard,
			abrir_os, fechar_os, edit_os, relat_os) values 
("Administrador", true, true, true, true, true, true, true, true, true, true, true, 
				true, true, true, true, true, true, true, true, true, true, true);

insert into tipousuario (tipousuario, cad_user, cad_grupo, cad_patrimonio, cad_local, cad_soft, cad_hard,
	cons_user, cons_grupo, cons_patrimonio, cons_local, cons_soft, cons_hard,
		edit_user, edit_grupo, edit_patrimonio, edit_local, edit_soft, edit_hard,
			abrir_os, fechar_os, edit_os, relat_os) values 
("Desenvolvedor", true, true, true, true, true, true, true, true, true, true, true, 
				true, true, true, true, true, true, true, true, true, true, true);

insert into tipousuario (
tipousuario, 
cad_user, 
cad_grupo, 
cad_patrimonio, 
cad_local, 
cad_soft, 
cad_hard,

cons_user, 
cons_grupo, 
cons_patrimonio, 
cons_local, 
cons_soft, 
cons_hard,

edit_user, 
edit_grupo, 
edit_patrimonio, 
edit_local, 
edit_soft, 
edit_hard,

abrir_os, 

fechar_os,
 
edit_os, 

relat_os
) values 
("Professor", 
false, 
false, 
false, 
false, 
false, 
false,
 
false, 
false, 
false, 
false, 
false, 
false, 

true, 
true, 
true, 
true, 
true, 
true,
 
true,
 
false,
 
false,
 
true);

insert into tipousuario (
tipousuario, 
cad_user, 
cad_grupo, 
cad_patrimonio, 
cad_local, 
cad_soft, 
cad_hard,

cons_user, 
cons_grupo, 
cons_patrimonio, 
cons_local, 
cons_soft, 
cons_hard,

edit_user, 
edit_grupo, 
edit_patrimonio, 
edit_local, 
edit_soft, 
edit_hard,

abrir_os, 

fechar_os,
 
edit_os, 

relat_os
) values 
("Estagiário", 
false, 
false, 
false, 
true, 
true, 
true,
 
false, 
false, 
false, 
true, 
true, 
true, 

false, 
false, 
true, 
true, 
true, 
true,
 
true,
 
true,
 
true,
 
true);

insert into tipousuario (
tipousuario, 
cad_user, 
cad_grupo, 
cad_patrimonio, 
cad_local, 
cad_soft, 
cad_hard,

cons_user, 
cons_grupo, 
cons_patrimonio, 
cons_local, 
cons_soft, 
cons_hard,

edit_user, 
edit_grupo, 
edit_patrimonio, 
edit_local, 
edit_soft, 
edit_hard,

abrir_os, 

fechar_os,
 
edit_os, 

relat_os
) values 
("Administrativo", 
false, 
false, 
true, 
true, 
false, 
false,
 
false, 
false, 
true, 
true, 
false, 
false, 

false, 
false, 
true, 
true, 
true, 
true,
 
true,
 
false,
 
false,
 
true);

insert into tipousuario (
tipousuario, 
cad_user, 
cad_grupo, 
cad_patrimonio, 
cad_local, 
cad_soft, 
cad_hard,

cons_user, 
cons_grupo, 
cons_patrimonio, 
cons_local, 
cons_soft, 
cons_hard,

edit_user, 
edit_grupo, 
edit_patrimonio, 
edit_local, 
edit_soft, 
edit_hard,

abrir_os, 

fechar_os,
 
edit_os, 

relat_os
) values 
("Apenas visualizar", 
false, 
false, 
false, 
false, 
false, 
false,
 
false, 
false, 
false, 
false, 
false, 
false, 

false, 
false, 
true, 
true, 
true, 
true,
 
true,
 
false,
 
false,
 
true);

/*insert into tipousuario (tipousuario, cad_user, cad_grupo, cad_patrimonio, cad_local, cad_soft, cad_hard,
	cons_user, cons_grupo, cons_patrimonio, cons_local, cons_soft, cons_hard,
		edit_user, edit_grupo, edit_patrimonio, edit_local, edit_soft, edit_hard,
			abrir_os, fechar_os, edit_os, relat_os) values ("Professor/Estagiário", false, false, false, false, false, false, true, true, true,
				true, true, true, false, false, false, false, false, false, true, true, true, true);
*/

/*
insert into tipousuario (tipousuario, cad_user, cad_grupo, cad_patrimonio, cad_local, cad_soft, cad_hard,
	cons_user, cons_grupo, cons_patrimonio, cons_local, cons_soft, cons_hard,
		edit_user, edit_grupo, edit_patrimonio, edit_local, edit_soft, edit_hard,
			abrir_os, fechar_os, edit_os, relat_os) values ("Aluno", false, false, false, false, false, false, false, false, false, false, false, 
				false, false, false, false, false, false, false, true, false, false, false);

insert into tipousuario2 (tipousuario, cad_user, cad_grupo, cad_patrimonio, cad_local, cad_soft, cad_hard,
	cons_user, cons_grupo, cons_patrimonio, cons_local, cons_soft, cons_hard,
		edit_user, edit_grupo, edit_patrimonio, edit_local, edit_soft, edit_hard,
			abrir_os, fechar_os, edit_os, relat_os) values ("Professor", 0, 0, 0, 0, 0, 0, 1, 1, 1,
				1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1);


insert into tipousuario2 (tipousuario, cad_user, cad_grupo, cad_patrimonio, cad_local, cad_soft, cad_hard,
	cons_user, cons_grupo, cons_patrimonio, cons_local, cons_soft, cons_hard,
		edit_user, edit_grupo, edit_patrimonio, edit_local, edit_soft, edit_hard,
			abrir_os, fechar_os, edit_os, relat_os) values ("Estagiário", 0, 0, 0, 0, 0, 0, 1, 1, 1,
				1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1);*/

INSERT INTO tipopatrimonio 
 (tipo) VALUES ('Centro Paula Souza');

/*select tipousuario.idtipousuario, tipousuario.tipousuario, COUNT(*) AS 'Qtd de Usuários' FROM usuario inner join tipousuario on tipousuario.idtipousuario = usuario.fkidtipousuario where tipousuario.idtipousuario like usuario.fkidtipousuario;*/

/*select * from ordemservico;*/

/*SELECT COUNT(*) AS 'Qtd de Usuários' FROM usuario INNER JOIN tipousuario ON tipousuario.idtipousuario = usuario.fkidtipousuario;*/


INSERT INTO patrimonio 
 (fkidtipopatrimonio, numero) 
  VALUES 
   (1,1),
   (1,2),
   (1,3),
   (1,4),
   (1,5),
   (1,6),
   (1,7),
   (1,8),
   (1,9),
   (1,10),
   (1,11),
   (1,12),
   (1,13),
   (1,14),
   (1,15),
   (1,16),
   (1,17),
   (1,18),
   (1,19),
   (1,20),
   (1,21),
   (1,22),
   (1,23),
   (1,24),
   (1,25),
   (1,26),
   (1,27),
   (1,28),
   (1,29),
   (1,30),
   (1,31),
   (1,32),
   (1,33),
   (1,34),
   (1,35),
   (1,36),
   (1,37),
   (1,38),
   (1,39),
   (1,40),
   (1,41),
   (1,42),
   (1,43),
   (1,44),
   (1,45),
   (1,46),
   (1,47),
   (1,48),
   (1,49),
   (1,50),
   (1,51),
   (1,52),
   (1,53),
   (1,54),
   (1,55),
   (1,56),
   (1,57),
   (1,58),
   (1,59),
   (1,60);
  

INSERT INTO memoria 
 (frequencia, tamanho) 
  VALUES 
   ('400MHz','2GB'),
   ('400MHz','4GB');

INSERT INTO hd 
 (marca, capacidade, rpm) 
  VALUES 
   ('Western Digital', '320GB','7200rpm'),
   ('Western Digital','500GB','7200rpm');

INSERT INTO processador 
 (marca, nome) 
  VALUES
   ('Intel','Core 2 Duo E7400 2,80GHz');

INSERT INTO gabinete 
 (nome,fkidhd,fkidmemoria,fkidprocessador) 
  VALUES 
   ('Itautec',1,2,1),
   ('Itautec',1,1,1);

INSERT INTO nseriegabinete
 (fkidpatrimonio, nseriefabricante,fkidgabinete,fkidlocal_2,fkidstatus_2,nomesystem)
  VALUES
   (1,'M420444004928G',1,1,3,'LAB1-PC1'),
   (2,'M749358347359G',2,1,1,'LAB1-PC2'),
   (3,'M430555034843G',1,4,2,'LABGESTAO-PC1'),
   (4,'M43938752343UG',1,2,1,'LAB2-PC1'),
   (5,'M434565430324G',1,3,1,'LAB3-PC1'),
   (6,'M23I34O34RN434',2,4,1,'LABGESTAO-PC2'),
   (7,'M439533210324G',2,1,1,'LAB1-PC4'),
   (8,'M539539230324G',1,3,2,'LAB3-PC2'),
   (9,'M449123230324G',1,3,3,'LAB3-PC3'),
   (10,'M434339230324G',1,4,1,'LABGESTAO-PC3'),
   (11,'M449539230324G',1,3,2,'LAB3-PC4'),
   (12,'M549539230324G',1,2,1,'LAB2-PC2'),
   (13,'M44123232024G',1,2,2,'LAB2-PC3'),
   (14,'M55321130324G',2,3,1,'LAB3-PC5'),
   (15,'M44123230324G',1,3,1,'LAB3-PC6');
   

INSERT INTO placasadicionais 
 (fkidnseriegabinete, nome, descricao) 
  VALUES 
   (1,'Placa Wiriless', '802.1nbg'),
   (2,'Placa de rede', 'Atheros Gyga');

INSERT INTO software 
 (nome,descricao) 
  VALUES 
   ('Google Chrome','Navegador de internet'),
   ('MS Office 2007','Pacote Office'),
   ('MS Visual Studio 2013 Ultimate', 'Programação'),
   ('MS SQLServer 2012 Express','Programação'),
   ('NetBeans IDE 8.0','Programação'),
   ('Oracle VM Virtual Box','Virtualização'),
   ('Adobe Reader XI','Leitor PDF'),
   ('Adobe Master Collection','Editor Multimídia'),
   ('Notepad++','Programação'),
   ('WinRAR','Gerenciador de Arquivos');

INSERT INTO softwaresinstalados 
 (fkidsoftware,fkidnseriegabinete,observacao) 
  VALUES 
   (1,1,'Navegador mais utilizado'),
   (1,2,'Navegador mais utilizado'),
   (1,3,'Navegador mais utilizado'),
   (1,4,'Navegador mais utilizado'),
   (1,5,'Navegador mais utilizado'),
   (2,1,'Necessário para trabalhos'),
   (2,2,'Necessário para trabalhos'),
   (2,3,'Necessário para trabalhos'),
   (2,4,'Necessário para trabalhos'),
   (2,5,'Necessário para trabalhos'),
   (3,6,'Necessário para programação web'),
   (3,7,'Necessário para programação web'),
   (3,8,'Necessário para programação web'),
   (3,9,'Necessário para programação web'),
   (3,10,'Necessário para programação web'),
   (5,6,'Necessário para programação web'),
   (5,7,'Necessário para programação web'),
   (5,8,'Necessário para programação web'),
   (5,9,'Necessário para programação web'),
   (5,10,'Necessário para programação web');

INSERT INTO monitor 
(modelo) 
 VALUES 
  ('Itautec L1742TT 17"');

INSERT INTO nseriemonitor
 (fkidpatrimonio,nseriefabricante,fkidmonitor,fkidlocal_2,fkidstatus_2)
  VALUES
   (16,'LG00032232453G',1,1,1),
   (17,'LG00654456215G',1,1,1),
   (18,'LG31329245453G',1,1,2),   
   (19,'LG00032245453G',1,1,1),
   (20,'LG12SA5245453G',1,1,1),
   (21,'LG12552478453G',1,2,1),
   (22,'LG12552D98453G',1,2,1),
   (23,'LG1255G245783G',1,2,1),
   (24,'LG12455245983G',1,2,1),
   (25,'LG12455245653G',1,2,1),
   (26,'LG13255655453G',1,3,1),
   (27,'LG12556456453G',1,3,1),
   (28,'LG12525245453G',1,3,1),
   (29,'LG12575265453G',1,3,1),
   (30,'LG12855295453G',1,3,1);

INSERT INTO estabilizador 
 (modelo) 
  VALUES 
   ('Enermax EXS II POWER 500 PRETO');

INSERT INTO nserieestabilizador
 (fkidpatrimonio,nseriefabricante,fkidestabilizador,fkidlocal_2,fkidstatus_2)
  VALUES
   (31,'123654SM654',1,1,1),
   (32,'123632S3654',1,1,1),
   (33,'1236512S654',1,4,2),
   (34,'123214SM654',1,2,1),
   (35,'123S987M654',1,4,1),
   (36,'123S986M654',1,4,1),
   (37,'123S985M654',1,4,1),
   (38,'123S984M654',1,4,1),
   (39,'123S983M654',1,4,1),
   (40,'123S982M654',1,4,1),
   (41,'123S981M654',1,4,1),
   (42,'123S977M654',1,4,1),
   (43,'123S967M654',1,4,1),
   (44,'123S957M654',1,4,1),
   (45,'123S947M654',1,4,1);
   
   select * from usuario;

INSERT INTO teclado 
 (contemteclado) 
  VALUES 
   ('Sim'),
   ('Não');

INSERT INTO mouse 
 (contemmouse) 
  VALUES 
   ('Sim'),
   ('Não');

INSERT INTO local_2
 (local_2, desc_local) 
  VALUES 
   ('LABORATÓRIO 1', '21 computadores'),
   ('LABORATÓRIO 2', '21 computadores'),
   ('LABORATÓRIO 3', '21 computadores'),
   ('LABORATÓRIO DE GESTÃO', '20 computadores');

INSERT INTO ip 
 (ip) 
  VALUES 
   ('10.67.168.11'),
   ('10.67.168.12'),
   ('10.67.168.13'),
   ('10.67.168.14'),
   ('10.67.168.15'),
   ('10.67.168.16'),
   ('10.67.168.17'),
   ('10.67.168.18'),
   ('10.67.168.19'),
   ('10.67.168.20'),
   ('10.67.168.21'),
   ('10.67.168.22'),
   ('10.67.168.23'),
   ('10.67.168.24'),
   ('10.67.168.25');

INSERT INTO status_2 
 (status_2) 
  VALUES 
   ('Funcionando'),
   ('Com problemas'),
   ('Não funcionando');

INSERT INTO pc 
 (fkidmouse, fkidteclado,fkidnseriemonitor,fkidnserieestabilizador,
   fkidlocal_2,fkidstatus_2,fkidnseriegabinete,nomepc)
  VALUES 
   (1,1,1,1,1,1,1,'LAB1-PC1'),
   (1,1,2,2,1,1,2,'LAB1-PC1'),
   (1,1,3,3,1,1,3,'LAB1-PC1'),
   (1,1,4,4,1,3,4,'LAB1-PC1'),
   (1,1,5,5,1,1,5,'LAB1-PC1'),
   (1,1,6,6,2,1,6,'LAB1-PC2'),
   (1,1,7,7,2,2,7,'LAB1-PC2'),
   (1,1,8,8,2,1,8,'LAB1-PC2'),
   (1,1,9,9,3,1,9,'LAB1-PC3'),
   (1,1,10,10,3,1,10,'LAB1-PC3'),
   (1,1,11,11,3,1,11,'LAB1-PC3'),
   (1,1,12,12,3,1,12,'LAB1-PC3'),
   (1,1,13,13,4,2,13,'LABGESTAO-PC1'),
   (1,1,14,14,4,1,14,'LABGESTAO-PC1'),
   (1,1,15,15,4,2,15,'LABGESTAO-PC1');
   
INSERT INTO lan 
 (fkidip,fkidpc) 
  VALUES 
   (1,1),
   (2,2),
   (3,3),
   (4,4),
   (5,5),
   (6,6),
   (7,7),
   (8,8),
   (9,9),
   (10,10),
   (11,11),
   (12,12),
   (13,13),
   (14,14),
   (15,15);

INSERT INTO ddd 
 (ddd) 
  VALUES 
   (11),
	(12),
	 (13),
	  (14),
	   (15),
		(16),
		 (17),
	      (18),
		   (19);

INSERT INTO tipoproblema
 (tipoproblema)
  VALUES
   ('Configurar de programa'),
   ('Instalar de programa'),
   ('Reparo'),
   ('Não liga'),
   ('Beeps'),
   ('Falta peças'),
   ('Sem internet'),
   ('Outros');

/*select * from tipousuario;*/

/*INSERT INTO problema
  (problema, fkidtipoproblema)
    VALUES
      ('Não liga a tela',1),
      ('Mouse ou teclado não funciona',1),
      ('Desliga sozinho',1),
      ('Falta software',3);*/

INSERT INTO usuario
  (fkidtipousuario, nome, sobrenome, cpf, telefone, email, login, senha, fkddd)
   VALUES
    (1, 'HENRIQUE', 'CECILIO', '654.586.586-54', '(11)5465-4544', 'HENRIQUE_CECILIO12@HOTMAIL.COM', 'henrique', '123456', 1);
INSERT INTO usuario
  (fkidtipousuario, nome, sobrenome, cpf, telefone, email, login, senha, fkddd)
   VALUES
    (2, 'GUILHERME', 'PINHEIRO', '410.460.128-43', '(11)4159-2444', 'GUILHERME.A01@HOTMAIL.COM', 'guilherme', '123456', 1);

INSERT INTO usuario
  (
fkidtipousuario, 
nome, 
sobrenome, 
cpf, 
telefone, 
email, 
login, 
senha, 
fkddd)
   VALUES
    (
2, 
'LUCAS', 
'SIMAS', 
'000.000.000-00', 
'(11)2222-2444', 
'LUCAS.SIMAS@HOTMAIL.COM', 
'lucas', '123456', 
1
);

INSERT INTO usuario
  (
fkidtipousuario, 
nome, 
sobrenome, 
cpf, 
telefone, 
email, 
login, 
senha, 
fkddd)
   VALUES
    (
6, 
'THIAGO', 
'COELHO', 
'111.222.333-00', 
'(11)2232-3444', 
'THIAGO.COELHO@HOTMAIL.COM', 
'thiago', '123456', 
1
);

INSERT INTO usuario
  (
fkidtipousuario, 
nome, 
sobrenome, 
cpf, 
telefone, 
email, 
login, 
senha, 
fkddd)
   VALUES
    (
4, 
'PAULA', 
'AMIA', 
'232.121.321-00', 
'(11)2432-2421', 
'PAULA.AMIA@HOTMAIL.COM', 
'paula', '123456', 
1
);



INSERT INTO usuario
  (
fkidtipousuario, 
nome, 
sobrenome, 
cpf, 
telefone, 
email, 
login, 
senha, 
fkddd)
   VALUES
    (
3, 
'ALEXANDRE', 
'PERES', 
'222.111.121-00', 
'(11)2232-2421', 
'ALEXANDRE.PERES@HOTMAIL.COM', 
'alexandre', '123456', 
1
);

INSERT INTO usuario
  (
fkidtipousuario, 
nome, 
sobrenome, 
cpf, 
telefone, 
email, 
login, 
senha, 
fkddd)
   VALUES
    (
5, 
'MARIA', 
'DA SILVA', 
'232.122.333-00', 
'(11)2432-2455', 
'MARIA.DASILVA@HOTMAIL.COM', 
'maria', '123456', 
1
);


select * from ordemservico;
INSERT INTO statusos
  (situacao)
   VALUES
    ('Aberta'),
    ('Em andamento'),
    ('Fechada');




INSERT INTO ordemservico
 (fkidpc,fkidusuario,fkidtipoproblema, fkidstatusos, tituloproblema, detalhesproblema, data_fechamento, comentariosfechamento)
  VALUES
   (2,4,3,3,'Problema de desligamento','Fica ligado uns 5 minutos depois de iniciar o Windows', '24/11/2014', 'Feita a troca de Fonte'),
   (2,3,3,3,'Problema de desligamento','Fica ligado uns 5 minutos depois de iniciar o Windows', '24/11/2014', 'Feita a troca de Cooler'),
   (5,3,3,3,'Problema de desligamento','Fica ligado uns 5 minutos depois de iniciar o Windows', '24/11/2014', 'Feita a troca de Cooler'),
   (9,4,3,3,'Problema de desligamento','Fica ligado uns 5 minutos depois de iniciar o Windows', '24/11/2014', 'Feita a troca de Cooler'),
   (13,3,3,1,'Problema de desligamento','Fica ligado uns 5 minutos depois de iniciar o Windows', '',''),
   (1,6,2,3, 'Necessidade de instalar uma IDE','Instalar Visual Studio 2013 Ultimate', '24/11/2014', 'Visual Studio Ultimate instalado'),
   (2,6,2,1, 'Necessidade de instalar uma IDE','Instalar Visual Studio 2013 Ultimate', '',''),
   (3,6,2,1, 'Necessidade de instalar uma IDE','Instalar Visual Studio 2013 Ultimate', '',''),
   (4,6,2,1, 'Necessidade de instalar uma IDE','Instalar Visual Studio 2013 Ultimate', '',''),
   (5,6,2,1, 'Necessidade de instalar uma IDE','Instalar Visual Studio 2013 Ultimate', '',''),
   (6,6,2,1, 'Necessidade de instalar uma IDE','Instalar Visual Studio 2013 Ultimate', '',''),
   (7,6,2,1, 'Necessidade de instalar uma IDE','Instalar Visual Studio 2013 Ultimate', '','');

SELECT * FROM ordemservico;
/*INSERT INTO ordemservico
 (fkidpc,fkidusuario,fkidtipoproblema, fkidstatusos, tituloproblema, detalhesproblema)
  VALUES
   (1,1,4,1, 'Necessidade de instalar uma IDE','Instalar Visual Studio 2013 Ultimate');*/

select idordemservico AS 'Código',
		local_2.local_2 AS 'Local', 
		pc.nomepc AS 'Computador',
		usuario.login AS 'User',
		tipoproblema.tipoproblema AS 'Serviço',
		tituloproblema AS 'Título',
		detalhesproblema AS 'Descrição',
		DATE_FORMAT(ordemservico.systemdate, '%d/%m/%Y') AS 'Data de Entrada',
		statusos.situacao AS 'Status'
		FROM ordemservico
		INNER JOIN local_2 INNER JOIN pc
		ON ordemservico.fkidpc=pc.idpc AND local_2.idlocal_2=pc.fkidlocal_2
		INNER JOIN usuario
		ON usuario.idusuario = ordemservico.fkidusuario
		INNER JOIN tipoproblema
		ON tipoproblema.idtipoproblema = ordemservico.fkidtipoproblema
		INNER JOIN statusos
		ON statusos.idstatusos = ordemservico.fkidstatusos
		WHERE ordemservico.idordemservico = 2 and statusos.situacao like 'Em aberto' or statusos.situacao like 'Em andamento';

select idusuario, tipousuario.tipousuario, nome, sobrenome, cpf, telefone, email, DATE_FORMAT(systemdate, '%d/%m/%Y'), login, senha, ddd.ddd
	FROM usuario
		INNER JOIN tipousuario ON usuario.fkidtipousuario=tipousuario.idtipousuario
		INNER JOIN ddd ON usuario.fkddd=ddd.idddd
			WHERE usuario.login like 'henrique';

select idusuario, tipousuario.tipousuario, nome, sobrenome, cpf, telefone, email, systemdate, login, senha
	FROM usuario
		INNER JOIN tipousuario ON usuario.fkidtipousuario=tipousuario.idtipousuario
			WHERE usuario.login like 'henrique';

/*INSERT INTO ordemok
 (fkidordemservico,fkidusuario)
  VALUES
   (1,1);*/

/*INSERT INTO log
 (fkidusuario,alteracao)
   VALUES
    (1,'Entrou no sistema às ')*/


/*select idusuario, tipousuario.tipousuario, nome, sobrenome, cpf, telefone, email, date_format(systemdate, '%d-%m-%Y'), login, senha
 FROM usuario INNER JOIN tipousuario ON usuario.fkidtipousuario=tipousuario.idtipousuario where tipousuario.tipousuario like 'Administrador';
*/

/*select * from pc;
select * from pc inner join local_2 on fkidlocal_2 = idlocal_2 where fkidlocal_2 like 1;

SELECT pc.idpc, mouse.contemmouse, teclado.contemteclado, nseriemonitor.nseriefabricante AS 'nseriemonitor', nserieestabilizador.nseriefabricante AS 'nserieestabilizador',
	nseriegabinete.nseriefabricante AS 'nseriegabinete', local_2.local_2, status_2.status_2, pc.nomepc FROM pc
		INNER JOIN mouse ON pc.fkidmouse = mouse.idmouse
		INNER JOIN teclado ON pc.fkidteclado = teclado.idteclado
		INNER JOIN nseriemonitor ON pc.fkidnseriemonitor = nseriemonitor.idnseriemonitor
		INNER JOIN nserieestabilizador ON pc.fkidnserieestabilizador = nserieestabilizador.idnserieestabilizador
		INNER JOIN nseriegabinete ON pc.fkidnseriegabinete = nseriegabinete.idnseriegabinete
		INNER JOIN local_2 ON pc.fkidlocal_2 = local_2.idlocal_2
		INNER JOIN status_2 ON pc.fkidstatus_2 = status_2.idstatus_2
			WHERE pc.fkidlocal_2 = 1;*/


select idordemservico AS 'Código',
		local_2.local_2 AS 'Local',
		pc.nomepc AS 'Computador',
		usuario.login AS 'User',
		tipoproblema.tipoproblema AS 'Serviço',
		tituloproblema AS 'Título',
		detalhesproblema AS 'Descrição',
		DATE_FORMAT(ordemservico.systemdate, '%d/%m/%Y') AS 'Data de Entrada',
		statusos.situacao AS 'Status',
		data_fechamento AS 'Data de Fechamento',
		ordemservico.comentariosfechamento AS 'Comentário'                      
		FROM ordemservico
		INNER JOIN local_2 INNER JOIN pc
		ON ordemservico.fkidpc=pc.idpc AND local_2.idlocal_2=pc.fkidlocal_2
		INNER JOIN usuario
		ON usuario.idusuario = ordemservico.fkidusuario
		INNER JOIN tipoproblema
		ON tipoproblema.idtipoproblema = ordemservico.fkidtipoproblema
		INNER JOIN statusos
		ON statusos.idstatusos = ordemservico.fkidstatusos
		ORDER BY idordemservico;
