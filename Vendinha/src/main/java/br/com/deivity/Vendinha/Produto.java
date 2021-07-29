package br.com.deivity.Vendinha;

import java.math.BigDecimal;
import java.util.SplittableRandom;

public class Produto {

	private Long id;
	private String nome;
	private BigDecimal valor;

	public Produto(String nome, BigDecimal valor) {
		this.id = new SplittableRandom().nextLong(1, Long.MAX_VALUE);
		this.nome = nome;
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public BigDecimal getValor() {
		return valor;
	}
}