package br.com.onebox.app.dao.tests;

import java.math.BigDecimal;

import br.com.onebox.app.dao.ClienteDao;
import br.com.onebox.app.dao.PedidoDao;
import br.com.onebox.app.dao.ProdutoDao;
import br.com.onebox.app.domain.cliente.Cliente;
import br.com.onebox.app.domain.pedido.ItemDePedido;
import br.com.onebox.app.domain.pedido.Pedido;
import br.com.onebox.app.domain.pedido.TipoDescontoPedidoEnum;
import br.com.onebox.app.domain.produto.Produto;
import br.com.onebox.app.domain.produto.TipoDescontoProdutoEnum;

public class TestePersistenciaPedido {
	
	public static void main(String[] args) {
		
		ProdutoDao produtoDao = new ProdutoDao();
		Produto novoProduto1 = produtoDao.buscaPorId(1l);
		Produto novoProduto2 = produtoDao.buscaPorId(2l);
		
		ClienteDao clienteDao = new ClienteDao();
		Cliente clienteJoao =  clienteDao.buscaPorId(1l);
		Cliente cliente2 =  clienteDao.buscaPorId(2l);
		Cliente cliente3 =  clienteDao.buscaPorId(3l);
		
		PedidoDao pedidoDao = new PedidoDao();
		Pedido novoPedidoJoao = new Pedido(null, clienteJoao, BigDecimal.ZERO, TipoDescontoPedidoEnum.NENHUM);
		ItemDePedido ItemDePedido1 = new ItemDePedido(novoProduto1, novoPedidoJoao, 2, BigDecimal.valueOf(200), TipoDescontoProdutoEnum.PROMOCAO);
		ItemDePedido ItemDePedido2 = new ItemDePedido(novoProduto2, novoPedidoJoao, 2, BigDecimal.valueOf(200), TipoDescontoProdutoEnum.PROMOCAO);
		novoPedidoJoao.adicionaItem(ItemDePedido1);
		novoPedidoJoao.adicionaItem(ItemDePedido2);
		pedidoDao.cadastra(novoPedidoJoao);
		
		Pedido novoPedido2 = new Pedido(null, cliente2, BigDecimal.TEN, TipoDescontoPedidoEnum.FIDELIDADE);
		ItemDePedido ItemDePedido3 = new ItemDePedido(novoProduto1, novoPedido2, 2, BigDecimal.valueOf(200), TipoDescontoProdutoEnum.PROMOCAO);
		ItemDePedido ItemDePedido4 = new ItemDePedido(novoProduto2, novoPedido2, 2, BigDecimal.valueOf(200), TipoDescontoProdutoEnum.PROMOCAO);
		novoPedido2.adicionaItem(ItemDePedido3);
		novoPedido2.adicionaItem(ItemDePedido4);
		pedidoDao.cadastra(novoPedido2);
		
		Pedido novoPedido3 = new Pedido(null, cliente3, BigDecimal.ZERO, TipoDescontoPedidoEnum.NENHUM);
		ItemDePedido ItemDePedido5 = new ItemDePedido(novoProduto1, novoPedido3, 2, BigDecimal.valueOf(200), TipoDescontoProdutoEnum.PROMOCAO);
		ItemDePedido ItemDePedido6 = new ItemDePedido(novoProduto2, novoPedido3, 2, BigDecimal.valueOf(200), TipoDescontoProdutoEnum.PROMOCAO);
		novoPedido3.adicionaItem(ItemDePedido5);
		novoPedido3.adicionaItem(ItemDePedido6);
		pedidoDao.cadastra(novoPedido3);
		
	}

}
