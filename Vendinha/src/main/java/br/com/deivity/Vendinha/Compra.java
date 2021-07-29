package br.com.deivity.Vendinha;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.SplittableRandom;
import java.util.List;
import java.util.SplittableRandom;

public class Compra {


	private Long id;
	private Cliente cliente;
	private List<ItemCompra> itens;
	private LocalDateTime dataCompra;
	private LocalDateTime dataPagamento;
	private LocalDateTime dataCancelamento;
	private EnumStatusPagamento status;
	private BigDecimal valorPago;
	private BigDecimal estorno;

	public Compra(Cliente c, Produto p, Integer qtd) {
		this.itens = new ArrayList<>();
		this.dataCompra = LocalDateTime.now();
		this.status = EnumStatusPagamento.AGUARDANDO;
		this.id = new SplittableRandom().nextLong(1, Long.MAX_VALUE);
		this.cliente = c;
		this.addProduto(p, qtd);
	}

	public void addProduto(Produto p, Integer qtd) {
		this.itens.add(new ItemCompra(p, qtd));
	}

	public void cancelar() {
		this.status = EnumStatusPagamento.CANCELADO;
		this.dataCancelamento = LocalDateTime.now();
	}

	public BigDecimal pagar(BigDecimal dinheiro) {
		if (EnumStatusPagamento.PAGO.equals(this.status)) {
			throw new RuntimeException("Esse produto já foi pago");
		}
		if (Objects.isNull(dinheiro)) {
			throw new RuntimeException("Dinheiro inválido");
		}
		if (dinheiro.compareTo(this.getTotal()) < 0) {
			throw new RuntimeException("o dinheiro é insuficiente");
		}

		if (EnumStatusPagamento.CANCELADO.equals(this.status)) {
			this.dataCancelamento = null;
		}
		this.status = EnumStatusPagamento.PAGO;
		this.dataPagamento = LocalDateTime.now();
		this.valorPago = dinheiro;
		return dinheiro.subtract(this.getTotal());
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Long getId() {
		return id;
	}

	public List<ItemCompra> getItens() {
		return itens;
	}

	public BigDecimal getTotal() {
		BigDecimal soma = BigDecimal.ZERO;
		for (ItemCompra i : itens) {
			soma = soma.add(i.getTotal());
		}
		return soma;
	}

	public LocalDateTime getDataCompra() {
		return dataCompra;
	}

	public LocalDateTime getDataPagamento() {
		return dataPagamento;
	}

	public LocalDateTime getDataCancelamento() {
		return dataCancelamento;
	}

	public EnumStatusPagamento getStatus() {
		return status;
	}

	public BigDecimal getValorPago() {
		return valorPago;
	}
}