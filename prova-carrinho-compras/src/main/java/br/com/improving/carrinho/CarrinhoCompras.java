package br.com.improving.carrinho;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe que representa o carrinho de compras de um cliente.
 */
public class CarrinhoCompras {

	public List<Item> itens;
	
	public CarrinhoCompras() {
		super();
		itens = new ArrayList<Item>();
	}

	/**
     * Permite a adição de um novo item no carrinho de compras.
     *
     * Caso o item já exista no carrinho para este mesmo produto, as seguintes regras deverão ser seguidas:
     * - A quantidade do item deverá ser a soma da quantidade atual com a quantidade passada como parâmetro.
     * - Se o valor unitário informado for diferente do valor unitário atual do item, o novo valor unitário do item deverá ser
     * o passado como parâmetro.
     *
     * Devem ser lançadas subclasses de RuntimeException caso não seja possível adicionar o item ao carrinho de compras.
     *
     * @param newProduto
     * @param newValorUnitario
     * @param newQuantidade
     */
	public void adicionarItem(Produto newProduto, BigDecimal newValorUnitario, int newQuantidade) {

		validaItem(newProduto, newValorUnitario, newQuantidade);
		
		
		Item newItem = new Item(newProduto, newValorUnitario, newQuantidade);
		
		if(itens.contains(newItem)) {
			
			itens =  itens.stream().map(old -> {

				if (old.getProduto().equals(newProduto)) {
					old.addQuantidade(newQuantidade);
					if (!old.getValorUnitario().equals(newValorUnitario)) {
						old.setValorUnitario(newValorUnitario);
					}
				} 			
				return old;
				
			}).collect(Collectors.toList());
			
		}else {
			itens.add( new Item(newProduto, newValorUnitario, newQuantidade));
		}
		
		




	}

	private void validaItem(Produto produto, BigDecimal valorUnitario, int quantidade) {
		if(produto==null || produto.getCodigo() == null  ) {
    		throw new ValidacaoException("valor invalido para o parametro produto");
    	}
    	
    	if( valorUnitario==null  ) {
    		throw new ValidacaoException("valor invalido para o campo parametro valorunitario");
    	}
    	
    	if( quantidade <= 0 ) {
    		throw new ValidacaoException("valor invalido para o parametro quantidade");
    	}
	}

	/**
	 * Permite a remoção do item que representa este produto do carrinho de compras.
	 *
	 * @param produto
	 * @return Retorna um boolean, tendo o valor true caso o produto exista no carrinho de compras e
	 *         false caso o produto não exista no carrinho.
	 */
	public boolean removerItem(Produto produto) {
		
		
		return itens.removeIf(old-> old.getProduto().equals(produto));

	}
	


	/**
	 * Permite a remoção do item de acordo com a posição. Essa posição deve ser determinada pela
	 * ordem de inclusão do produto na coleção, em que zero representa o primeiro item.
	 *
	 * @param posicaoItem
	 * @return Retorna um boolean, tendo o valor true caso o produto exista no carrinho de compras e
	 *         false caso o produto não exista no carrinho.
	 */
	public boolean removerItem(int posicaoItem) {
		
		try {
			Item item = itens.get(posicaoItem);
			itens.remove(item);
			return true;
		}catch (IndexOutOfBoundsException e) {
			return false;
		}
		
		
		
		
	}

	/**
	 * Retorna o valor total do carrinho de compras, que deve ser a soma dos valores totais de todos
	 * os itens que compõem o carrinho.
	 *
	 * @return BigDecimal
	 */
	public BigDecimal getValorTotal() {

		double sum = itens.stream().map(i -> {

			return i.getValorTotal();
			
		}).collect(Collectors.summingDouble(BigDecimal::doubleValue));
						
		return new BigDecimal(sum);

	}

	/**
	 * Retorna a lista de itens do carrinho de compras.
	 *
	 * @return itens
	 */
	public Collection<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	
	
}