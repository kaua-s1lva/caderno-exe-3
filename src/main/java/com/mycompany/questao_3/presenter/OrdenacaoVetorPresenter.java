package com.mycompany.questao_3.presenter;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.mycompany.questao_3.LeituraArquivo;
import com.mycompany.questao_3.model.ConteudoArquivo;
import com.mycompany.questao_3.service.OrdenacaoService;
import com.mycompany.questao_3.strategy.BubbleSortStrategy;
import com.mycompany.questao_3.strategy.IMetodoOrdenacaoStrategy;
import com.mycompany.questao_3.strategy.SelectionSortStrategy;
import com.mycompany.questao_3.view.OrdenacaoVetorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class OrdenacaoVetorPresenter {
    private ConteudoArquivo conteudo;
    private OrdenacaoVetorView view;
    private LeituraArquivo leituraArquivo;

    public OrdenacaoVetorPresenter() {
        this.conteudo = new ConteudoArquivo();
        this.view = new OrdenacaoVetorView();
        this.view.setVisible(false);

        configuraView();
        view.setVisible(true);
    }

    private void configuraView() {
        this.view.getBtnCarregarArquivo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    carregar();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        this.view.getBtnOrdenar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ordenar();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    private void carregar() throws IOException {
        leituraArquivo = new LeituraArquivo();

        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();

        leituraArquivo.lerArquivo(f.toString(), conteudo);

        DefaultListModel<String> modeloSemOrdem = new DefaultListModel<>();
        view.getLstSemOrdem().setModel(modeloSemOrdem);

        for (String linha : conteudo.getRegistros()) {
            modeloSemOrdem.addElement(linha);
        }
    }

    private void ordenar() throws ClassNotFoundException {
        String metodo = view.getCmbMetodo().getSelectedItem().toString();
        OrdenacaoService ordenacaoService = new OrdenacaoService();
        IMetodoOrdenacaoStrategy metodoOrdenacao;
        if (metodo == "Bubble Sort") {
            metodoOrdenacao = new BubbleSortStrategy();
            ordenacaoService.ordenar(conteudo, metodoOrdenacao);
        } else if (metodo == "Selection Sort") {
            metodoOrdenacao = new SelectionSortStrategy();
            ordenacaoService.ordenar(conteudo, metodoOrdenacao);
        } else {
            throw new RuntimeException("nenhum método selecionado");
        }

        DefaultListModel<String> modeloSemOrdem = new DefaultListModel<>();
        view.getLstOrdenados().setModel(modeloSemOrdem);

        for (String linha : conteudo.getRegistros()) {
            modeloSemOrdem.addElement(linha);
        }

        view.getLblTempo().setText("Tempo: " + Long.toString(metodoOrdenacao.getTempoExecucao()) + "ms");
    }
}
