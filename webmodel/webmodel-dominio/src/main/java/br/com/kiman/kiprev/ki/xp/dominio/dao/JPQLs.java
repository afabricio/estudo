package br.com.kiman.kiprev.ki.xp.dominio.dao;

public interface JPQLs {

	String N_PESSOA_FISICA = "PessoaFisica";
	//String Q_PESSOA_FISICA = "SELECT p FROM Pessoa p join fetch p.documentos dc WHERE p.isPessoaFisica = 'S' AND EXISTS (SELECT 1 from p.documentos doc WHERE doc.codTipoDocumento = function('kiprev.pa_utl.f_obt_tipoid_principal','FISICA')) ";

	String Q_PESSOA_FISICA = "SELECT p FROM Pessoa p join fetch p.documentos dc "
			+ "WHERE p.isPessoaFisica = 'S' AND  dc.codTipoDocumento = function('kiprev.pa_utl.f_obt_tipoid_principal','FISICA') ";
	
	
	
	
}
