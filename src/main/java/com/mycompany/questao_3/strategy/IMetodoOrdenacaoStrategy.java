package com.mycompany.questao_3.strategy;

import com.mycompany.questao_3.model.ConteudoArquivo;

public interface IMetodoOrdenacaoStrategy {
    public void ordenarArquivo(ConteudoArquivo conteudo);
    public long getTempoExecucao();
}
