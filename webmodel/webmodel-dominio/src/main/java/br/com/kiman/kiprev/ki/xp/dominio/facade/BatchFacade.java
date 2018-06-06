package br.com.kiman.kiprev.ki.xp.dominio.facade;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

import br.com.kiman.kiprev.ki.xp.dominio.batch.BatchInterface;
import br.com.kiman.kiprev.ki.xp.dominio.batch.BatchLiteral;
import br.com.kiman.kiprev.ki.xp.dominio.constants.BatchResult;
import br.com.kiman.kiprev.ki.xp.dominio.interceptor.SetaAmbienteInterceptor;

@Stateless(name = BatchFacade.NAME_EJB)

@Interceptors(value = { SetaAmbienteInterceptor.class })
public class BatchFacade {

	public static final String NAME_EJB = "BatchFacade";

	@Inject
	@Any
	private Instance<BatchInterface> batchSelector;

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public BatchResult executeBatchByName(String batchName) {

		BatchLiteral qualifier = new BatchLiteral(batchName);
		BatchInterface batch = batchSelector.select(qualifier).get();

		return batch.execute();

	}


}
