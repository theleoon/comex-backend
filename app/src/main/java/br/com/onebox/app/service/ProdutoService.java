package br.com.onebox.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.onebox.app.api.produto.EditaProdutoForm;
import br.com.onebox.app.api.produto.NovoProdutoForm;
import br.com.onebox.app.api.produto.ProdutoDto;
import br.com.onebox.app.domain.produto.Categoria;
import br.com.onebox.app.domain.produto.Produto;
import br.com.onebox.app.repository.CategoriaRepository;
import br.com.onebox.app.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional
    public ProdutoDto cria(NovoProdutoForm request) {
        
    	Optional<Categoria> categoria = categoriaRepository.findById(request.getCategoria().getId());

        if(categoria.isEmpty())
            throw new RuntimeException("Categoria não existe");

        if(!categoria.get().getAtiva())
            throw new RuntimeException("Categoria inativa");

        return new ProdutoDto(produtoRepository.save(request.toEntity()));
    }

    public ProdutoDto buscaPorId(Long id) {
        return new ProdutoDto(produtoRepository.findById(id).orElseThrow());
    }

    public ProdutoDto edita(EditaProdutoForm request) {
        Produto produto = produtoRepository.findById(request.getId()).orElseThrow();

        produto.setNome(request.getNome());
        produto.setPreco(request.getPreco());
        produto.setDescricao(request.getDescricao() != null ? request.getDescricao() : null);
        produto.setQuantidadeEstoque(request.getQuantidadeEstoque());

        return new ProdutoDto(produtoRepository.save(produto));
    }

	public List<ProdutoDto> getAll() {
		List<Produto> objs = new ArrayList<>();
		produtoRepository.findAll().forEach(objs::add);
		
		return ProdutoDto.converter(objs);
	}

}
