package com.mycompany.questao_3;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.mycompany.questao_3.model.ConteudoArquivo;

public class LeituraArquivo {

    public void lerArquivo(String caminho, ConteudoArquivo conteudo) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(caminho));
        String linha = "";
        while (true) {
            if (linha != null) {
                conteudo.setRegistros(linha);
            } else {
                break;
            }
            linha = buffRead.readLine();
        }
        buffRead.close();
    }
}
