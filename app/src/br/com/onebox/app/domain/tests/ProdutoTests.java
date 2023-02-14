package br.com.onebox.app.domain.tests;

import java.math.BigDecimal;

import br.com.onebox.app.domain.Categoria;
import br.com.onebox.app.domain.Produto;

public class ProdutoTests {
	
	public static void main(String[] args) {
		testa();
	}

	private static void testa() {
		Categoria celular = new Categoria("Celular");
		Produto samsung = new Produto("Samsung A31", "Celular da Samsung", new BigDecimal("1300"), 10, celular);
		Produto motorola = new Produto("Motorola G31", "Celular da Motorola", new BigDecimal("1100"), 8, celular);
		Produto lg = new Produto("LG G31", "Celular da LG", new BigDecimal("1190"), 4, celular);
		
		mostra(samsung);
		mostra(motorola);
		mostra(lg);
		
		validaCalculoTotalEmEstoque(samsung);
		validaCalculoDeImposto(lg);
		
	}

	private static void mostra(Produto obj) {
		if (obj == null) {
			System.out.println("Objeto nulo");
		}

		System.out.println("## Produto: " + obj.getNome() + " ##");
		System.out.println(obj.toString());
	}
	
	private static void validaCalculoDeImposto(Produto obj) {
		System.out.println("Produto: " + obj.getNome() + ", total com imposto: " + obj.getPrecoComImposto());
	}
	
	private static void validaCalculoTotalEmEstoque(Produto obj) {
		System.out.println("Produto: "+ obj.getNome() + ", total em estoque: " + obj.getTotalEmEstoque());
	}

}
