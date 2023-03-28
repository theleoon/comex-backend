package br.com.onebox.app.api.pedido;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.onebox.app.domain.cliente.Cliente;
import br.com.onebox.app.domain.pedido.ItemDePedido;
import br.com.onebox.app.domain.pedido.Pedido;
import br.com.onebox.app.domain.pedido.TipoDescontoPedidoEnum;
import br.com.onebox.app.domain.produto.Produto;
import br.com.onebox.app.domain.produto.TipoDescontoProdutoEnum;
import br.com.onebox.app.repository.ClienteRepository;
import br.com.onebox.app.repository.ProdutoRepository;

public class PedidoForm {

	private Long clienteId;

	private TipoDescontoPedidoEnum tipoDesconto;

	private BigDecimal totalPedido;

	private List<PedidoProdutoForm> produtos;

	public Pedido toEntity(ClienteRepository clienteRepository, ProdutoRepository produtoRepository) {

		Optional<Cliente> cliente = clienteRepository.findById(clienteId);

		List<ItemDePedido> itemDePedido = new ArrayList<>();

		produtos.forEach(produtoForm -> {
			Produto produto = produtoRepository.findById(produtoForm.getId()).get();
			itemDePedido.add(new ItemDePedido(produto, produtoForm.getQuantidade(), BigDecimal.ZERO,
					TipoDescontoProdutoEnum.NENHUM));
		});

		return new Pedido(itemDePedido, cliente.get(), totalPedido, tipoDesconto);
	}

	@Override
	public String toString() {
		return "PedidoForm [clienteId=" + clienteId + ", tipoDesconto=" + tipoDesconto + ", totalPedido=" + totalPedido
				+ ", itens=" + produtos + "]";
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
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

	public List<PedidoProdutoForm> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<PedidoProdutoForm> produtos) {
		this.produtos = produtos;
	}
}
