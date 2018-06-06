package br.com.kiman.kiprev.ki.xp.rest.resource;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import br.com.kiman.kiprev.ki.xp.dominio.constants.BatchResult;
import br.com.kiman.kiprev.ki.xp.dominio.facade.BatchFacade;

@Path("/batch")
public class BatchResource {
	
	private static final Logger logger = Logger.getLogger(BatchResource.class);
	
	@EJB(beanName = BatchFacade.NAME_EJB)
	private BatchFacade facade;

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)  
	public String executeBatch(@QueryParam("name")  String batchName) {

		BatchResult result=null;
		try {
			result  = facade.executeBatchByName(batchName);
			return result.getValue();
			
		} catch (Exception e) {

			logger.error("Erro ao tentar executar o batch "+batchName, e);
			return BatchResult.ERRO.getValue();
		}

	}

	
	
}
