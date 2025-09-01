package com.school.sptech;

import java.util.Scanner;

public class Biblioteca {
    private String nome;
    private Double multaDiaria;
    private Integer qtdLivros;
    private Boolean ativa;

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Construtor - Serve para definir os valores padrões dos atributos
    public Biblioteca(String nome, Double multaDiaria) {
        setNome(nome);
        this.multaDiaria = multaDiaria;
        qtdLivros = 0;
        ativa = true;
    }

    // Fazendo os getters
    public String getNome() {
        return this.nome;
    }
    public Double getMultaDiaria() {
        return this.multaDiaria;
    }
    public Integer getQtdLivros() {
        return this.qtdLivros;
    }
    public Boolean getAtiva() {
        return this.ativa;
    }

    public void registrarLivro (Integer quantidade) {
        if (quantidade != null && quantidade > 0 && ativa) {
            this.qtdLivros += quantidade;
        }
    }

    public Integer emprestar (Integer quantidade) {
        if (this.ativa && quantidade != null && quantidade > 0 && quantidade <= this.qtdLivros) {
            this.qtdLivros -= quantidade;
            return quantidade;

        }
        return null;
    }

    public Integer devolver (Integer quantidade) {
        if (ativa && quantidade != null && quantidade > 0) {
            this.qtdLivros += quantidade;
            return quantidade;
        }
        return null;
    }

    public Integer desativar() {
        if (!this.ativa) {
            return null;
        }
        Integer anterior = this.qtdLivros;
        this.ativa = false;
        this.qtdLivros = 0;
        return anterior;
    }

    public void transferir (Biblioteca destino, Integer quantidade) {
        if (this.ativa && destino != null && destino.getAtiva()
        && quantidade != null && quantidade > 0
        && quantidade <= this.qtdLivros) {
            this.qtdLivros -= quantidade;
            destino.qtdLivros += quantidade;
        }
    }

    public boolean reajustarMulta (Double percentual) {
        if (percentual != null && percentual > 0) {
            this.multaDiaria += this.multaDiaria * percentual;
            return true;
        }
        return false;
    }
}
