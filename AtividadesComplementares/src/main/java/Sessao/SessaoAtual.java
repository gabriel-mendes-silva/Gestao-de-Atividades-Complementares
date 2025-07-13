package Sessao;

import Model.Requerimento;

public class SessaoAtual {
    private Requerimento requerimentoAtual;

    public void requerimentoAtual(Requerimento requerimento) {
        this.requerimentoAtual = requerimento;
    }

    public Requerimento requerimentoAtual() {
        return this.requerimentoAtual;
    }

}

