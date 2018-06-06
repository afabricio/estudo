package br.com.kiman.kiprev.ki.xp.dominio.interceptor;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import br.com.kiman.kiprev.ki.xp.dominio.dao.GenericDAO;

public class SetaAmbienteInterceptor {

	
	@Inject
	private GenericDAO dao;

	@AroundInvoke
	public Object intercept(InvocationContext context) throws Exception {
		
		System.out.println("INTERCEPTOR");
		
		return context.proceed();
	}
}




