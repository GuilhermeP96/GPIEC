
/*-------------------------------------------------------------------------------------------------------------------*/

/*Seleções*/


/*Números de patrimônios */
SELECT 
 tipo AS 'Tipo', 
 numero AS 'Número de patrimônio' 
  FROM patrimonio 
   INNER JOIN tipopatrimonio ON Tipopatrimonio.idtipopatrimonio=patrimonio.fkidtipopatrimonio;

/* Gabinetes */
SELECT
 nomesystem AS 'Nome no sistema',
 nseriegabinete.nseriefabricante AS 'Número de série', 
 patrimonio.numero AS 'Número de patrimônio', 
 hd.capacidade AS 'HD',
 memoria.tamanho AS 'Memória', 
 processador.nome AS 'Processador',
 local_2.local_2 AS 'Localização'
  FROM nseriegabinete 
   INNER JOIN gabinete ON nseriegabinete.fkidgabinete=gabinete.idgabinete
   INNER JOIN patrimonio ON patrimonio.idpatrimonio=nseriegabinete.fkidpatrimonio 
   INNER JOIN hd ON hd.idhd=gabinete.fkidhd 
   INNER JOIN memoria ON memoria.idmemoria=gabinete.fkidmemoria 
   INNER JOIN processador ON processador.idprocessador=gabinete.fkidprocessador
   INNER JOIN pc ON pc.fkidnseriegabinete=nseriegabinete.idnseriegabinete
   INNER JOIN local_2 ON local_2.idlocal_2=pc.fkidlocal_2;
/* gabinete com memória de 2GB */
SELECT 
 nseriefabricante AS 'Número de série', 
 patrimonio.numero AS 'Número de patrimônio', 
 hd.capacidade AS 'HD',
 memoria.tamanho AS 'Memória', 
 processador.nome AS 'Processador',
 local_2.local_2 AS 'Localização'
  FROM nseriegabinete 
   INNER JOIN gabinete ON nseriegabinete.fkidgabinete=gabinete.idgabinete
   INNER JOIN patrimonio ON patrimonio.idpatrimonio=nseriegabinete.fkidpatrimonio 
   INNER JOIN hd ON hd.idhd=gabinete.fkidhd 
   INNER JOIN memoria ON memoria.idmemoria=gabinete.fkidmemoria 
   INNER JOIN processador ON processador.idprocessador=gabinete.fkidprocessador
   INNER JOIN pc ON pc.fkidnseriegabinete=nseriegabinete.idnseriegabinete
   INNER JOIN local_2 ON local_2.idlocal_2=pc.fkidlocal_2 
    WHERE memoria.tamanho='2GB';

/* Softwares instalados */

SELECT
 nomesystem AS 'Nome do gabinete',
 software.nome AS 'Software instalado',
 DATE_FORMAT(softwaresinstalados.systemdate, '%d-%m-%Y às %H:%i:%s') AS 'Data de instalação'
  FROM nseriegabinete
   INNER JOIN softwaresinstalados 
    ON softwaresinstalados.fkidnseriegabinete=nseriegabinete.idnseriegabinete
   INNER JOIN software ON software.idsoftware=softwaresinstalados.idsoftwaresinstalados;   

/* Computadores */
SELECT 
 nomepc AS 'Nome PC', 
 local_2.local_2 AS 'Localização', 
 mouse.contemmouse AS 'Mouse', 
 teclado.contemteclado AS 'Teclado', 
 memoria.tamanho AS 'Memória', 
 hd.capacidade AS 'HD',
 processador.nome AS 'Processador', 
 monitor.descricao AS 'Monitor', 
 estabilizador.descricao AS 'Estabilizador',
 status_2.status_2 AS 'Status'
  FROM pc 
   INNER JOIN local_2 ON local_2.idlocal_2=pc.fkidlocal_2 
   INNER JOIN mouse ON mouse.idmouse=pc.fkidmouse 
   INNER JOIN teclado ON teclado.idteclado=pc.fkidteclado 
   INNER JOIN nseriegabinete ON nseriegabinete.idnseriegabinete=pc.fkidnseriegabinete
   INNER JOIN gabinete ON gabinete.idgabinete=nseriegabinete.fkidgabinete
   INNER JOIN memoria ON memoria.idmemoria=gabinete.fkidmemoria 
   INNER JOIN hd ON hd.idhd=gabinete.fkidhd
   INNER JOIN processador ON processador.idprocessador=gabinete.fkidprocessador
   INNER JOIN nseriemonitor ON pc.fkidnseriemonitor=nseriemonitor.idnseriemonitor
   INNER JOIN monitor ON monitor.idmonitor=nseriemonitor.fkidmonitor
   INNER JOIN nserieestabilizador ON pc.fkidnserieestabilizador=nserieestabilizador.idnserieestabilizador 
   INNER JOIN estabilizador ON estabilizador.idestabilizador=nserieestabilizador.fkidestabilizador 
   INNER JOIN status_2 ON status_2.idstatus_2=pc.fkidstatus_2;

/*IPs*/
SELECT
  nomepc AS 'Nome PC',
  ip.ip AS 'IP'
   FROM pc
    INNER JOIN lan ON lan.fkidpc=pc.idpc
    INNER JOIN ip ON lan.fkidip=ip.idip;

/*USUÁRIO*/
SELECT
  nome AS 'Nome',
  sobrenome AS 'Sobrenome',
  cpf AS 'CPF',
  email AS 'E-mail',
  telefone.numero AS 'Telefone',
  funcao AS 'Função',
  tipousuario.tipousuario AS 'Tipo de usuário',
  login.login AS 'Login de acesso'
   FROM usuario
    INNER JOIN telefone ON telefone.fkidusuario=usuario.idusuario
    INNER JOIN tipousuario ON usuario.fkidtipousuario=tipousuario.idtipousuario
    INNER JOIN login ON usuario.idusuario=login.fkidusuario;

/*ESTABILIZADORES*/

SELECT 
  descricao AS 'Estabilizador',
  nserieestabilizador.nseriefabricante AS 'Número de série',
  nserieestabilizador.fkidpatrimonio AS 'Número de patrimônio'
    FROM estabilizador
      INNER JOIN nserieestabilizador 
       ON estabilizador.idestabilizador=nserieestabilizador.fkidestabilizador;

/*MONITORES*/

SELECT 
  descricao AS 'Monitor',
  nseriemonitor.nseriefabricante AS 'Número de série',
  nseriemonitor.fkidpatrimonio AS 'Número de patrimônio'
    FROM monitor
      INNER JOIN nseriemonitor 
       ON monitor.idmonitor=nseriemonitor.fkidmonitor;

SELECT
  detalhesproblema AS 'Detalhes',
  DATE_FORMAT(ordemservico.systemdate, '%d/%m/%Y às %H:%i:%s') AS 'Data de abertura',
  DATE_FORMAT(ordemok.systemdate, '%d/%m/%Y às %H:%i:%s') AS 'Data de resolução',
  usuario.nome AS 'Fechada por'
    FROM ordemservico
      INNER JOIN ordemok 
       ON ordemok.fkidordemservico=ordemservico.idordemservico
      INNER JOIN usuario
       ON usuario.idusuario=ordemok.fkidusuario;
