package br.com.deivity.Vendinha;

import java.math.BigDecimal;
import java.util.List;
import java.util.SplittableRandom;

public class Compra {
	
	private long id;
	private Cliente cliente;
	private Produto produto;
	private Integer qtd;
	private BigDecimal total;
	private BigDecimal valorUnitario;
	

	private List<ItemCompra> itens;

	
	public Compra(Cliente c, Produto p, Integer qtd) {
		this.id = new SplittableRandom().nextLong(1,Long.MAX_VALUE);
		this.cliente = c;
		this.produto = p;
		this.qtd = qtd;
		this.total = p.getValor().multiply(BigDecimal.valueOf(qtd));
	}

	public Cliente getCliente() {
		return cliente;
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