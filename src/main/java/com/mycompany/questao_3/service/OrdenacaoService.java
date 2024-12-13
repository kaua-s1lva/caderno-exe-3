package com.mycompany.questao_3.service;

import com.mycompany.questao_3.model.ConteudoArquivo;
import com.mycompany.questao_3.strategy.IMetodoOrdenacaoStrategy;

public class OrdenacaoService {

    public void ordenar(ConteudoArquivo conteudo, IMetodoOrdenacaoStrategy metodoOrdenacao) {
        if (metodoOrdenacao == null) {
            throw new IllegalArgumentException("Método de ordenação não informado");
        }
        metodoOrdenacao.ordenarArquivo(conteudo);
    }

}
