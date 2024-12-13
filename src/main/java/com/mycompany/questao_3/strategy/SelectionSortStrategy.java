package com.mycompany.questao_3.strategy;

import com.mycompany.questao_3.model.ConteudoArquivo;

public class SelectionSortStrategy implements IMetodoOrdenacaoStrategy {
    private long tempoExecucao;

    @Override
    public void ordenarArquivo(ConteudoArquivo conteudo) {
        long tempoInicial = System.currentTimeMillis();
        conteudo.getRegistros().sort(String::compareTo);
        long tempoFinal = System.currentTimeMillis();
        this.tempoExecucao = tempoFinal - tempoInicial;
    }

    public long getTempoExecucao() {
        return tempoExecucao;
    }
}
