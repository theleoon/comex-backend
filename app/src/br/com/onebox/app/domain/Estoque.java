package br.com.onebox.app.domain;

import java.math.BigDecimal;

public class Estoque {

    private int capacidade = 1000;
    private int ocupacao;
    private BigDecimal montante = BigDecimal.ZERO;

    public int getCapacidade() {
        return capacidade;
    }

    public int getOcupacao() {
        return ocupacao;
    }

    public BigDecimal getMontante() {
        return montante;
    }

    public void registraEntrada(Produto produto){
        this.capacidade -= produto.getQuantidadeEmEstoque();
        this.ocupacao += produto.getQuantidadeEmEstoque();
        montante = this.montante.add(produto.getValorTotalEmEstoque());
    }

    public void registraSaida(Produto produto){
        this.capacidade += produto.getQuantidadeEmEstoque();
        this.ocupacao -= produto.getQuantidadeEmEstoque();
        montante = this.montante.subtract(produto.getValorTotalEmEstoque());
    }

    @Override
    public String toString() {
        return "Relatório de Estoque: " +
                "Capacidade: " + capacidade +
                ", Ocupacao: " + ocupacao +
                ", Montante: R$" + montante;
    }
}
