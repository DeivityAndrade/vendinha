package br.com.deivity.Vendinha;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.com.deivity.Vendinha.Cliente;
import br.com.deivity.Vendinha.Compra;
import br.com.deivity.Vendinha.Produto;
import br.com.deivity.Vendinha.ItemCompra;
import br.com.deivity.Vendinha.EnumStatusPagamento;

public class App {

	public static void main(String[] args) {

		Produto p1 = new Produto("Camisa Botafogo", BigDecimal.valueOf(125));
		Produto p2 = new Produto("Camisa Brasil", BigDecimal.valueOf(125));
		Produto p3 = new Produto("Calção de futebol", BigDecimal.valueOf(60));

		Cliente deivity = new Cliente("Deivity");

		Compra c = deivity.comprar(p1, 2);
		c.addProduto(p2, 2);
		c.addProduto(p3, 4);

		System.out.println("LISTA DE COMPRAS DO CLIENTE : " + c.getCliente().getNome() + " - " + c.getCliente().getId());
		for (ItemCompra i : c.getItens()) {
			System.out.println("");
			System.out.println("Produto....: " + i.getProduto().getNome());
			System.out.println("Qtd........: " + i.getQtd()+" peças");
			System.out.println("Valor UNT..: " + i.getProduto().getValor()+" reais");
			System.out.println("Total peça.: " + i.getTotal()+" reais");
		}

		System.out.println("Total gasto: " + c.getTotal()+" reais");
		System.out.println("Você deseja continuar com a compra? Caso não queira escreva cancelar");
		Scanner ler = new Scanner(System.in);
		String statusCompra = ler.next();

		if(!statusCompra.equals("cancelar")) {
			System.out.println("Deseja pagar no cartão ou em dinheiro?");
			String metodoPagamento = ler.next();
			if(metodoPagamento.equals("dinheiro")) {
				System.out.println("Quantos reais você irá dar?");
				String t = ler.next();
				Integer t1 = Integer.valueOf(t);
				BigDecimal troco = BigDecimal.valueOf(t1);

				System.out.println("Você deseja continuar com a compra? Caso não queira escreva cancelar");
				String statusCompraFinal = ler.next();
				if(!statusCompraFinal.equals("cancelar")) {
					BigDecimal trocoFinal = c.pagar(troco);
					System.out.println("");
					System.out.println(c.getStatus());
					System.out.println("Troco......: " + trocoFinal + " reais");
					System.out.println("Você comprou o pedido na data : "+c.getDataCompra().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
					System.out.println("Você finalizou o pagamento na data : "+c.getDataPagamento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
				}
				else { 
					System.out.println("");
					c.cancelar();
					System.out.println("O pedido foi "+c.getStatus());
					System.out.println("o estorno é de : " + t1 + " reais");
					System.out.println("Você cancelou o pedido na data : "+c.getDataCancelamento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
				}
			} else { 
				BigDecimal cartao = c.pagar(BigDecimal.valueOf(10000));
				System.out.println("");
				System.out.println(c.getStatus());
				System.out.println("Você comprou o pedido na data : "+c.getDataCompra().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
				System.out.println("Você finalizou o pagamento na data : "+c.getDataPagamento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
			}
		} else {
			System.out.println("");
			c.cancelar();
			System.out.println("O pedido foi "+c.getStatus());
			System.out.println("Você cancelou o pedido na data : "+c.getDataCancelamento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
		}
	}
}
