package br.com.kiman.kiprev.ki.xp.dominio.batch;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.com.kiman.kiprev.ki.xp.dominio.anotation.Batch;
import br.com.kiman.kiprev.ki.xp.dominio.constants.BatchResult;
import br.com.kiman.kiprev.ki.xp.dominio.dao.GenericDAO;
import br.com.kiman.kiprev.ki.xp.dominio.exception.BatchException;

@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
@Batch(name = "example")
public class ExampleBatch implements BatchInterface {

	@Inject
	private GenericDAO dao;

	@Override
	public BatchResult execute() {
		try {


			//CLIENT GET REST
			//String urlCotas = "http://50.16.90.236:17022/mockxpserver/kiprev/boletoitau";
			//Client client = ClientBuilder.newClient();
			//String cotasFundo = client.target(urlCotas).request(MediaType.APPLICATION_JSON).get(String.class);

			
			
			
			

			return BatchResult.SUCESSO;

		} catch (Exception e) {
			throw new BatchException("Erro ao executar o batch de de atualização de cotas", e);
		}

		
	}
//	
//	private Customer[] buscaAtualizacaoPessoasXP(List<String> listaPessoasKiprev, Map<String, String> mapDocToCodPessoa) throws IOException, JsonParseException, JsonMappingException {
//
//
//		mapDocToCodPessoa.clear();
//		
//		Client client = ClientBuilder.newClient();
//		
//		List<Long> listDocsPessoasKiprev = Lists.newArrayList();
//		
//		
//		List<Long> listDocsPessoasKiprev= listaPessoasKiprev.stream().filter(e -> StringUtils.isNumeric(e.getDocumentoPrincipal().getNumero())) .map(
//				e-> {	
//					
//						mapDocToCodPessoa.put(e.getDocumentoPrincipal().getNumero(), e.getCodPessoa());
//						return Long.parseLong(e.getDocumentoPrincipal().getNumero());
//
//						
//				}
//				).collect(Collectors.toList());
//		
//		ClientesRequestDTO requestDTO = new ClientesRequestDTO();
//		requestDTO.setBody(listDocsPessoasKiprev);
//		
//		Response jsonResponse = client.target("URL").request().post(Entity.json(requestDTO));
//		
//		return jsonResponse.readEntity(Customer[].class);
//		
//	}
//
//	private List<Cota> buscaCotasPorFundo(FundoInvestimentoDTO fundo) throws IOException, JsonParseException, JsonMappingException {
//
//		String urlCotas = "http://..";
//		Client client = ClientBuilder.newClient();
//		ListaCotas cotasFundo = client.target(String.format(urlCotas,fundo.getId())).request(MediaType.APPLICATION_JSON).get(ListaCotas.class);
//
//		return cotasFundo.getInvestmentFundsShares();
//	}

}
