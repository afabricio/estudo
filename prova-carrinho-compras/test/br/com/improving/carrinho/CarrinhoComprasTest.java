package br.com.improving.carrinho;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class CarrinhoComprasTest {

	@Test
	void test() {

		CarrinhoComprasFactory factory = new CarrinhoComprasFactory();

		CarrinhoCompras carrinhoCompras = factory.criar("A");

		carrinhoCompras.adicionarItem(new Produto(1L, "produto um"), new BigDecimal(1000), 1);
		carrinhoCompras.adicionarItem(new Produto(2L, "produto dois"), new BigDecimal(1000), 2);

		CarrinhoCompras carrinhoComprasB = factory.criar("B");

		carrinhoComprasB.adicionarItem(new Produto(1L, "produto um"), new BigDecimal(500), 1);
		carrinhoComprasB.adicionarItem(new Produto(2L, "produto dois"), new BigDecimal(500), 2);

		assert (factory.getValorTicketMedio().doubleValue() == 2250.0);

	}

}
