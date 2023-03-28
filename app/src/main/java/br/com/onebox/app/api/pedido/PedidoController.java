package br.com.onebox.app.api.pedido;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.onebox.app.domain.pedido.Pedido;
import br.com.onebox.app.repository.ClienteRepository;
import br.com.onebox.app.repository.ProdutoRepository;
import br.com.onebox.app.service.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
	
	private static final Logger logger = LoggerFactory.getLogger(PedidoController.class);
	
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping("/{id}")
	@ResponseBody
	public PedidoDto get(@PathVariable("id") Long id) {
		return pedidoService.get(id);
	}
	
	@GetMapping
	@ResponseBody
	public List<PedidoDto> lista() {
		return pedidoService.getAll();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<PedidoDto> cadastro(@RequestBody @Valid PedidoForm form, BindingResult result, 
			UriComponentsBuilder uriBuilder) {
		
		logger.info(form.toString());

		if (result.hasFieldErrors()) {
			logger.info("Erro no formulário");
		}
		
		Pedido obj = form.toEntity(clienteRepository, produtoRepository);
		pedidoService.cadastrar(obj);
		
		URI uri = uriBuilder.path("/pedidos/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(new PedidoDto(obj));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@GetMapping
//	public Page<PedidoDto> lista(@PageableDefault(size = 2, page = 0, sort = "data", direction = Direction.DESC) Pageable paginacao) {
//		// /api/pedidos?page=0&size=2&sort=totalPedido,asc
//		return pedidoService.get(paginacao);
//	}


}
