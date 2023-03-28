package br.com.onebox.app.domain;

import java.math.BigDecimal;

import br.com.onebox.app.domain.produto.Produto;

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

    }

    public void registraSaida(Produto produto){
        
    }

    @Override
    public String toString() {
        return "Relatório de Estoque: " +
                "Capacidade: " + capacidade +
                ", Ocupacao: " + ocupacao +
                ", Montante: R$" + montante;
    }
}
