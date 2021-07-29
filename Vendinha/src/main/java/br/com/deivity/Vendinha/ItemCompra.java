package br.com.deivity.Vendinha;

import java.math.BigDecimal;
import java.util.Random;
import java.util.SplittableRandom;


public class ItemCompra {

	private Long id;
	private Produto produto;
	private Integer qtd;
	private BigDecimal total;

	public ItemCompra(Produto p, Integer qtd) {
		this.id = new SplittableRandom().nextLong(1, Long.MAX_VALUE);
		this.produto = p;
		this.qtd = qtd;
		this.total = p.getValor().multiply(BigDecimal.valueOf(qtd));
	}

	public Long getId() {
		return id;
	}

	public Produto getProduto() {
		return produto;
	}

	public Integer getQtd() {
		return qtd;
	}

	public BigDecimal getTotal() {
		return total;
	}
}