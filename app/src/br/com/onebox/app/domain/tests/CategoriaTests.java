package br.com.onebox.app.domain.tests;

import br.com.onebox.app.domain.Categoria;

public class CategoriaTests {
	
	public static void main(String[] args) {
		testaCategoria();
	}

	private static void testaCategoria() {
		Categoria primeiraCategoria = new Categoria("Informática");
		Categoria segundaCategoria = new Categoria("Livros");
		Categoria terceiraCategoria = new Categoria("Móveis");
		
		mostraCategoria(primeiraCategoria);
		mostraCategoria(segundaCategoria);
		mostraCategoria(terceiraCategoria);
	}

	private static void mostraCategoria(Categoria categoria) {

		if (categoria == null) {
			System.out.println("Categoria nula");
		}

		System.out.println("## Categoria: " + categoria.getNome() + " ##");
		System.out.println(categoria.toString());
	}

}
