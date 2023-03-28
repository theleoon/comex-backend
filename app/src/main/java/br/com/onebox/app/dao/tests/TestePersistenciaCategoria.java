package br.com.onebox.app.dao.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.onebox.app.dao.CategoriaDao;
import br.com.onebox.app.domain.produto.Categoria;

public class TestePersistenciaCategoria {
	
	private static final Logger logger = LoggerFactory.getLogger(TestePersistenciaCategoria.class);
	
	public static void main(String[] args) {
		
		Categoria categoriaCelular = new Categoria("CELULARES");
		Categoria categoriaInformatica = new Categoria("INFORMÁTICA");
		Categoria categoriaMoveis = new Categoria("MÓVEIS");
		Categoria categoriaLivros = new Categoria("LIVROS");
		Categoria categoriaAutomotiva = new Categoria("AUTOMOTIVA");
		
		CategoriaDao categoriaDao = new CategoriaDao();
		categoriaDao.cadastra(categoriaCelular);
		categoriaDao.cadastra(categoriaInformatica);
		categoriaDao.cadastra(categoriaMoveis);
		categoriaDao.cadastra(categoriaLivros);
		categoriaDao.cadastra(categoriaAutomotiva);
		
		logger.info("Categoria cadastrada com sucesso!");
		
		// BUSCAR
		Categoria nome = categoriaDao.buscaPorId(categoriaCelular.getId());
		

	}

}
