
CREATE VIEW v_relatorio_pc
  AS 
	SELECT 
 nomepc AS 'Nome PC', 
 local_2.local_2 AS 'Localização', 
 mouse.contemmouse AS 'Mouse', 
 teclado.contemteclado AS 'Teclado', 
 memoria.tamanho AS 'Memória', 
 hd.capacidade AS 'HD',
 processador.nome AS 'Processador', 
 monitor.modelo AS 'Monitor', 
 estabilizador.modelo AS 'Estabilizador',
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


CREATE VIEW v_relatorio_nseriegabinete
  AS
	 SELECT 
		nomesystem AS 'Gabinete(Nome no SO)',
        patrimonio.numero AS 'Patrimônio',
        nseriefabricante AS 'Número de série',
        local_2.local_2 AS 'Localização',
        status_2.status_2 AS 'Status'
        
		  FROM nseriegabinete
          INNER JOIN patrimonio ON patrimonio.idpatrimonio=nseriegabinete.fkidpatrimonio
          INNER JOIN local_2 ON local_2.idlocal_2=nseriegabinete.fkidlocal_2
          INNER JOIN status_2 ON status_2.idstatus_2=nseriegabinete.fkidstatus_2
		  INNER JOIN pc ON pc.fkidnseriegabinete=nseriegabinete.idnseriegabinete;

CREATE VIEW v_relatorio_nseriemonitor
  AS
	SELECT 
		monitor.modelo AS 'Monitor',
        patrimonio.numero AS 'Patrimônio',
        nseriefabricante AS 'Número de série',
        local_2.local_2 AS 'Localização',
        status_2.status_2 AS 'Status'
        
		  FROM nseriemonitor
		  INNER JOIN monitor ON monitor.idmonitor=nseriemonitor.fkidmonitor
          INNER JOIN patrimonio ON patrimonio.idpatrimonio=nseriemonitor.fkidpatrimonio
          INNER JOIN local_2 ON local_2.idlocal_2=nseriemonitor.fkidlocal_2
          INNER JOIN status_2 ON status_2.idstatus_2=nseriemonitor.fkidstatus_2;

CREATE VIEW v_relatorio_nserieestabilizador
  AS
	SELECT 
		estabilizador.modelo AS 'Estabilizador',
        patrimonio.numero AS 'Patrimônio',
        nseriefabricante AS 'Número de série',
        local_2.local_2 AS 'Localização',
        status_2.status_2 AS 'Status'
        
		  FROM nserieestabilizador
		  INNER JOIN estabilizador ON estabilizador.idestabilizador=nserieestabilizador.fkidestabilizador
          INNER JOIN patrimonio ON patrimonio.idpatrimonio=nserieestabilizador.fkidpatrimonio
          INNER JOIN local_2 ON local_2.idlocal_2=nserieestabilizador.fkidlocal_2
          INNER JOIN status_2 ON status_2.idstatus_2=nserieestabilizador.fkidstatus_2;  
DESCRIBE ordemservico;
CREATE VIEW v_rel_OS
  AS
	SELECT
		idordemservico AS 'Número',
		statusos.situacao AS 'Status',
		pc.nomepc AS 'PC',
		usuario.nome AS 'Aberta por',
		tipoproblema.tipoproblema AS 'Assunto',
		DATE_FORMAT(ordemservico.systemdate, '%d/%m/%Y') AS 'Aberta em',
		DATE_FORMAT(data_fechamento, '%d/%m/%Y') AS 'Fechada em',
		comentariosfechamento AS 'Observações'
		  FROM ordemservico
			INNER JOIN statusos ON statusos.idstatusos=ordemservico.fkidstatusos
			INNER JOIN pc ON pc.idpc=ordemservico.fkidpc
			INNER JOIN tipoproblema ON tipoproblema.idtipoproblema=ordemservico.fkidtipoproblema
			INNER JOIN usuario ON usuario.idusuario=ordemservico.fkidusuario
			  ORDER BY idordemservico;
DESCRIBE software;
DESCRIBE patrimonio;
DESCRIBE nseriegabinete;
DESCRIBE pc;
DESCRIbE softwaresinstalados;


CREATE VIEW v_rel_softwareinstalado	
  AS
	SELECT
		patrimonio.numero AS 'Patrimônio',
		software.nome AS 'Software',
		pc.nomepc AS 'Computador',
		local_2.local_2 AS 'Local',
		DATE_FORMAT(softwaresinstalados.systemdate, '%d/%m/%Y') AS 'Data'
		  FROM softwaresinstalados
			INNER JOIN software ON softwaresinstalados.fkidsoftware=software.idsoftware
			INNER JOIN nseriegabinete ON nseriegabinete.idnseriegabinete=softwaresinstalados.fkidnseriegabinete
			INNER JOIN pc ON nseriegabinete.idnseriegabinete=pc.fkidnseriegabinete
			INNER JOIN patrimonio ON nseriegabinete.fkidpatrimonio=patrimonio.idpatrimonio
			INNER JOIN local_2 ON local_2.idlocal_2=nseriegabinete.fkidlocal_2
			  ORDER BY software.nome;

SELECT * FROM v_rel_softwareinstalado;