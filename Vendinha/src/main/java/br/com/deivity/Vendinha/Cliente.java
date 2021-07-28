package br.com.deivity.Vendinha;

import java.math.BigDecimal;
import java.util.SplittableRandom;

public class Cliente {

	// Long id
		private String nome;
	private long id;

		public Cliente(String nome) {
			this.id = new SplittableRandom().nextLong(1,Long.MAX_VALUE);
			this.nome = nome;
		}

		public Compra comprar(Produto p, Integer qtd) {
			return new Compra(this, p, qtd);
		}
		
		public String getNome() {
			return nome;
		}
	}