package br.com.deivity.Vendinha;

import java.math.BigDecimal;
import java.util.SplittableRandom;

public class Produto {

	private String nome;
	private BigDecimal valor;
	private static long id = new SplittableRandom().nextLong(1, Long.MAX_VALUE);

	public Produto(String nome, BigDecimal valor) {
		this.nome = nome;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public long getId() {
		return id;
	}
}