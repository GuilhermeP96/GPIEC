/*--------------------------------------------------------------------------------------------------------------------*/

/*INSERÇÕES DE TESTE*/
insert into tipousuario (tipousuario, cad_user, cad_grupo, cad_patrimonio, cad_local, cad_soft, cad_hard,
	cons_user, cons_grupo, cons_patrimonio, cons_local, cons_soft, cons_hard,
		edit_user, edit_grupo, edit_patrimonio, edit_local, edit_soft, edit_hard,
			abrir_os, fechar_os, edit_os, relat_os) values ("Administrador", true, true, true, true, true, true, true, true, true, true, true, 
				true, true, true, true, true, true, true, true, true, true, true);

insert into tipousuario (tipousuario, cad_user, cad_grupo, cad_patrimonio, cad_local, cad_soft, cad_hard,
	cons_user, cons_grupo, cons_patrimonio, cons_local, cons_soft, cons_hard,
		edit_user, edit_grupo, edit_patrimonio, edit_local, edit_soft, edit_hard,
			abrir_os, fechar_os, edit_os, relat_os) values ("Professor/Estagiário", false, false, false, false, false, false, true, true, true,
				true, true, true, false, false, false, false, false, false, true, true, true, true);

insert into tipousuario (tipousuario, cad_user, cad_grupo, cad_patrimonio, cad_local, cad_soft, cad_hard,
	cons_user, cons_grupo, cons_patrimonio, cons_local, cons_soft, cons_hard,
		edit_user, edit_grupo, edit_patrimonio, edit_local, edit_soft, edit_hard,
			abrir_os, fechar_os, edit_os, relat_os) values ("Aluno", false, false, false, false, false, false, false, false, false, false, false, 
				false, false, false, false, false, false, false, true, false, false, false);

insert into tipousuario2 (tipousuario, cad_user, cad_grupo, cad_patrimonio, cad_local, cad_soft, cad_hard,
	cons_user, cons_grupo, cons_patrimonio, cons_local, cons_soft, cons_hard,
		edit_user, edit_grupo, edit_patrimonio, edit_local, edit_soft, edit_hard,
			abrir_os, fechar_os, edit_os, relat_os) values ("Professor/Estagiário", 0, 0, 0, 0, 0, 0, 1, 1, 1,
				1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1);

INSERT INTO tipopatrimonio 
 (tipo) VALUES ('Centro Paula Souza');

select tipousuario.idtipousuario, tipousuario.tipousuario, COUNT(*) AS 'Qtd de Usuários' FROM usuario inner join tipousuario on tipousuario.idtipousuario = usuario.fkidtipousuario;

SELECT COUNT(*) AS 'Qtd de Usuários' FROM usuario INNER JOIN tipousuario ON tipousuario.idtipousuario = usuario.fkidtipousuario WHERE tipousuario.tipousuario LIKE 'Aluno';

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
   (1,15);
  

INSERT INTO memoria 
 (frequencia, tamanho) 
  VALUES 
   ('800MHz','2GB'),
   ('800MHz','4GB');

INSERT INTO hd 
 (marca, capacidade, rpm) 
  VALUES 
   ('Western Digital', '320GB','7200rpm'),
   ('Western Digital','500GB','7200rpm');

INSERT INTO processador 
 (marca, nome) 
  VALUES
   ('Intel','Core 2 Duo 2,93GHz');

INSERT INTO gabinete 
 (fkidhd,fkidmemoria,fkidprocessador) 
  VALUES 
   (1,2,1),
   (1,1,1);

INSERT INTO nseriegabinete
 (fkidpatrimonio, nseriefabricante,fkidgabinete,nomesystem)
  VALUES
   (1,'M420444004928G',1,'LAB1-PC1'),
   (2,'M749358347359G',2,'LAB1-PC2'),
   (3,'M430555034843G',1,'LABGESTAO-PC1'),
   (4,'M43938752343UG',1,'LAB2-PC1'),
   (5,'M439539230324G',1,'LAB3-PC1');
   

INSERT INTO placasadicionais 
 (fkidnseriegabinete, nome, descricao) 
  VALUES 
   (1,'Placa Wiriless', '802.1nbg'),
   (2,'Placa de rede', 'Atheros Gyga');

INSERT INTO software 
 (nome,descricao) 
  VALUES 
   ('Google Chrome','Navegador de internet'),
   ('Microsoft Office 2007','Pacote Office'),
   ('Microsoft Visual Studio 2013 Ultimate', 'Desenvolvimento'),
   ('MS SQLServer 2012 Express','Desenvolvimento'),
   ('NetBeans 8.0','Desenvolvimento');

INSERT INTO softwaresinstalados 
 (fkidsoftware,fkidnseriegabinete,observacao) 
  VALUES 
   (1,1,'O Internet Explorer é muito lento');

INSERT INTO softwaresinstalados 
 (fkidsoftware,fkidnseriegabinete) 
  VALUES 
   (3,1),
   (3,2),
   (3,3),
   (3,4),
   (3,5);

INSERT INTO monitor 
(descricao) 
 VALUES 
  ('InfoWay 14.1"');

INSERT INTO nseriemonitor
 (fkidpatrimonio,nseriefabricante,fkidmonitor)
  VALUES
   (6,'LG00032232453G',1),
   (7,'LG00654456215G',1),
   (8,'LG31322245453G',1),   
   (9,'LG00032245453G',1),
   (10,'LG1255245453G',1);

INSERT INTO estabilizador 
 (descricao) 
  VALUES 
   ('Estabilizador Enermax');

INSERT INTO nserieestabilizador
 (fkidpatrimonio,nseriefabricante,fkidestabilizador)
  VALUES
   (11,'123654SM654',1),
   (12,'123632S3654',1),
   (13,'1236512S654',1),
   (14,'123214SM654',1),
   (15,'123S987M654',1);
   
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
 (local_2) 
  VALUES 
   ('LABORATÓRIO 1'),
   ('LABORATÓRIO 2'),
   ('LABORATÓRIO 3'),
   ('LABORATÓRIO DE GESTÃO');

INSERT INTO ip 
 (ip) 
  VALUES 
   ('10.67.168.11'),
   ('10.67.168.12'),
   ('10.67.168.13'),
   ('10.67.168.14'),
   ('10.67.168.15'),
   ('10.67.168.16');

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
   (1,1,2,1,1,1,2,'LAB1-PC2'),
   (1,1,3,2,4,2,3,'LABGESTAO-PC1'),
   (1,1,4,3,2,1,4,'LAB2-PC1'),
   (1,1,5,4,3,1,5,'LAB3-PC1');
   
INSERT INTO lan 
 (fkidip,fkidpc) 
  VALUES 
   (1,1),
   (2,2),
   (3,2),
   (4,3),
   (5,4),
   (6,5);

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
   ('Configuração'),
   ('Instalação de programa'),
   ('Reparo'),
   ('Outros');

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

INSERT INTO statusos
  (situacao)
   VALUES
    ('Em aberto'),
    ('Em andamento'),
    ('Fechada');

INSERT INTO ordemservico
 (fkidpc,fkidusuario,fkidtipoproblema, fkidstatusos, tituloproblema, detalhesproblema, data_fechamento)
  VALUES
   (2,1,3,3,'Problema de desligamento','Fica ligado uns 5 minutos depois de iniciar o Windows', '2014-10-23');

INSERT INTO ordemservico
 (fkidpc,fkidusuario,fkidtipoproblema, fkidstatusos, tituloproblema, detalhesproblema)
  VALUES
   (1,1,4,1, 'Necessidade de instalar uma IDE','Instalar Visual Studio 2013 Ultimate');

select idordemservico AS 'Código',
		local_2.local_2 AS 'Local', 
		pc.nomepc AS 'Computador',
		usuario.login AS 'User',
		tipoproblema.tipoproblema AS 'Serviço',
		tituloproblema AS 'Título',
		detalhesproblema AS 'Descrição',
		ordemservico.systemdate AS 'Data de Entrada',
		statusos.situacao AS 'Status',
		data_fechamento AS 'Data de Fechamento'
		FROM ordemservico
		INNER JOIN local_2 INNER JOIN pc
		ON ordemservico.fkidpc=pc.idpc AND local_2.idlocal_2=pc.fkidlocal_2
		INNER JOIN usuario
		ON usuario.idusuario = ordemservico.fkidusuario
		INNER JOIN tipoproblema
		ON tipoproblema.idtipoproblema = ordemservico.fkidtipoproblema
		INNER JOIN statusos
		ON statusos.idstatusos = ordemservico.fkidstatusos
		WHERE statusos.situacao like 'Em aberto' or statusos.situacao like 'Em andamento';

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

select * from ordemservico;
/*INSERT INTO log
 (fkidusuario,alteracao)
   VALUES
    (1,'Entrou no sistema às ')*/
