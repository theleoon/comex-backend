package br.com.onebox.app.api.pedido;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import br.com.onebox.app.api.cliente.ClienteDto;
import br.com.onebox.app.domain.pedido.Pedido;
import br.com.onebox.app.domain.pedido.TipoDescontoPedidoEnum;

public class PedidoDto {

	private Long id;
	private ClienteDto cliente;
	private BigDecimal desconto;
	private TipoDescontoPedidoEnum tipoDesconto;
	private BigDecimal totalPedido;
	private LocalDate data;
	private List<ItemDePedidoDto> itens = new ArrayList<>();

	public PedidoDto(Pedido pedido) {
		this.id = pedido.getId();
		this.cliente = new ClienteDto(pedido.getCliente());
		this.desconto = pedido.getDesconto();
		this.tipoDesconto = pedido.getTipoDesconto();
		this.totalPedido = pedido.getTotalPedido();
		this.data = pedido.getData();
		this.itens = ItemDePedidoDto.converter(pedido.getItens());// ajustar essa chamada
	}

	public static List<PedidoDto> converter(List<Pedido> objs) {
		List<PedidoDto> retorno = new ArrayList<>();
		objs.forEach(obj -> retorno.add(new PedidoDto(obj)));
		return retorno;
	}
	
	public static Page<PedidoDto> converter(Page<Pedido> objs) {
		return objs.map(PedidoDto::new);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ClienteDto getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDto cliente) {
		this.cliente = cliente;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public TipoDescontoPedidoEnum getTipoDesconto() {
		return tipoDesconto;
	}

	public void setTipoDesconto(TipoDescontoPedidoEnum tipoDesconto) {
		this.tipoDesconto = tipoDesconto;
	}

	public BigDecimal getTotalPedido() {
		return totalPedido;
	}

	public void setTotalPedido(BigDecimal totalPedido) {
		this.totalPedido = totalPedido;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public List<ItemDePedidoDto> getItens() {
		return itens;
	}

	public void setItens(List<ItemDePedidoDto> itens) {
		this.itens = itens;
	}

}
