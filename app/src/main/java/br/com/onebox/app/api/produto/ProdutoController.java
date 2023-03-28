package br.com.onebox.app.api.produto;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.onebox.app.service.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;
    
    @GetMapping
	@ResponseBody
	public List<ProdutoDto> lista() {
		return produtoService.getAll();
	}

    @PostMapping
    public ResponseEntity<ProdutoDto> cria(@RequestBody @Valid NovoProdutoForm request, UriComponentsBuilder uriBuilder) {
        try {

            ProdutoDto obj = produtoService.cria(request);
            
            URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(obj.getId()).toUri();
    		return ResponseEntity.created(uri).body(obj);

        } catch (RuntimeException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Produto invalido para criação.", e
            );
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDto> edita(@RequestBody @Valid EditaProdutoForm request, UriComponentsBuilder uriBuilder) {
        try {
            ProdutoDto obj = produtoService.edita(request);

            URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(obj.getId()).toUri();
    		return ResponseEntity.created(uri).body(obj);
    
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Invalid Produto to edit", e
            );
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDto> getProdutoById(@PathVariable Long id) {
        try {
            ProdutoDto obj = produtoService.buscaPorId(id);
            
            return new ResponseEntity<>(obj, HttpStatus.OK);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(
                    HttpStatus.NO_CONTENT, "Não encontrado.", e
            );
        }
    }

}
