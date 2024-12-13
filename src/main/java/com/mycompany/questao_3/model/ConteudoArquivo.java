package com.mycompany.questao_3.model;

import java.util.ArrayList;
import java.util.List;

public class ConteudoArquivo {
    private List<String> registros;

    public ConteudoArquivo() {
        registros = new ArrayList<>();
    }

    public void setRegistros(String linha) {
        registros.add(linha);
    }

    public List<String> getRegistros() {
        return registros;
    }
}
