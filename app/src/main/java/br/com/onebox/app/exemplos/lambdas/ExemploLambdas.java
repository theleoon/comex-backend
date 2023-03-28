package br.com.onebox.app.exemplos.lambdas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.com.onebox.app.domain.produto.Categoria;

public class ExemploLambdas {
	
	public static void main(String[] args) {
		
		//ordenandoComLambda();
		exemploAcumulandoQuantidades();
		
	}
	
	public static void ordenandoComLambda() {
		
		List<Categoria> categorias = new ArrayList<>();
		categorias.add(new Categoria("Informática 3"));
		categorias.add(new Categoria("Informática 1"));
		categorias.add(new Categoria("Informática 4"));
		categorias.add(new Categoria("Informática 2"));
		
		categorias.stream()
					.map(c -> {
						return true;
					})
					.collect(Collectors.toList())
					.forEach(System.out::println);
		
		categorias.stream().map(c -> {
						c.setId(10L);
						c.setNome(c.getNome().toUpperCase());
						return c;
					}).collect(Collectors.toList());
		
		categorias.forEach(c -> {
			c.setId(10L);
			c.setNome(c.getNome().toUpperCase());
		});
		
		categorias.sort(Comparator.comparing(Categoria::getNome)); // c -> categoria.getNome()
		categorias.forEach(c -> System.out.println(c));
	}
	
	
	public static void exemploAcumulandoQuantidades() {
//		Categoria celular = new Categoria("Celular");
//		Produto samsung = new Produto("Samsung A31", "Celular da Samsung", new BigDecimal("1300"), 10, celular);
//		Produto motorola = new Produto("Motorola G31", "Celular da Motorola", new BigDecimal("1100"), 8, celular);
//		Produto lg = new Produto("LG G31", "Celular da LG", new BigDecimal("5000"), 4, celular);
//		
//		List<Produto> produtos = new ArrayList<>();
//		produtos.add(samsung);
//		produtos.add(motorola);
//		produtos.add(lg);
//		
//		BigDecimal totalEmProdutos = produtos
//										.stream()
//										.map(p -> p.getPrecoComImposto())
//										.reduce(BigDecimal.ZERO, BigDecimal::add);
//		
//		System.out.println(totalEmProdutos);
	}
	
	
	public static void exemploPopulandoListas() {
		
		List<Categoria> categorias = new ArrayList<>();
		categorias.add(new Categoria("Informática 1"));
		categorias.add(new Categoria("Informática 2"));
		categorias.add(new Categoria("Informática 3"));
		categorias.add(new Categoria("Informática 4"));
		
		List<Categoria> validas = new ArrayList<>();
		
		categorias.forEach(validas::add);
		categorias.forEach(c -> validas.add(c));
		
		validas.forEach(c -> System.out.println(c));
	}
	
	
	
	
	

}
