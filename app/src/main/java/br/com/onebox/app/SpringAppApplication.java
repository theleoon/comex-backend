package br.com.onebox.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import br.com.onebox.app.repository.CategoriaRepository;
import br.com.onebox.app.repository.ClienteRepository;

@SpringBootApplication
@EnableSpringDataWebSupport
public class SpringAppApplication implements CommandLineRunner {
	
	private final CategoriaRepository categoriaRepository;
	
	private final ClienteRepository clienteRepository;
	
	public SpringAppApplication(CategoriaRepository categoriaRepository, ClienteRepository clienteRepository) {
		this.categoriaRepository = categoriaRepository;
		this.clienteRepository = clienteRepository;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		new TestePersistenciaCategoriaSpringData(categoriaRepository).valida();

//		List<RelatorioClientePedidosVo> listaPorMaisPedidos = clienteRepository.listaPorMaisPedidos();
//		listaPorMaisPedidos.forEach(p -> System.out.println(p.getNomeDoCliente()));
		
//		 List<RelatorioClientePorMontanteVo> listaPorMaiorValorGasto = clienteRepository.listaPorMaiorValorGasto();
//		 listaPorMaiorValorGasto.forEach(p -> System.out.println(p.getMontanteGasto()));
		
	}
	
}
