package org.example.TelaDoUsuario;

import org.example.Sistemas.Configuracoes;
import org.example.Sistemas.Data;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class Tela {
    static Configuracoes configuracoes = new Configuracoes();
    static JLabel mensagemExibicao;
    private static JComboBox<String> mesesComboBox;
    private static JComboBox<String> diasUteisComboBox;

    public static void telaDeBoasVindas() {


        JFrame frame = new JFrame(configuracoes.getNOME());
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Criar um painel
        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);
        placeComponents(panel);

        // Centralizar a janela na tela
        frame.setLocationRelativeTo(null);

        // Tornar a janela visível
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        // Adicionar um rótulo de boas-vindas
        mensagemExibicao = new JLabel("Bem-Vindo à Clinica!");
        mensagemExibicao.setBounds(10, 20, 300, 25);
        panel.add(mensagemExibicao);

        // Adicionar um botão para iniciar
        JButton iniciarButton = new JButton("Iniciar");
        iniciarButton.setBounds(150, 80, 80, 25);
        iniciarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ocultarComponentes(panel, iniciarButton, mensagemExibicao);
                exibirMensagem(panel);
            }
        });
        panel.add(iniciarButton);
    }


    private static void ocultarComponentes(JPanel panel, JButton button, JLabel texto) {
        button.setVisible(false);
        texto.setVisible(false);
    }

    private static void ocultarComponentes(JButton button, JComboBox jComboBoxm, JComboBox comboBox, JComboBox jComboBox, JLabel texto) {
        button.setVisible(false);
        jComboBoxm.setVisible(false);
        comboBox.setVisible(false);
        jComboBox.setVisible(false);
        texto.setVisible(false);
    }

    private static void ocultarComponentes(JLabel panel) {
        panel.setVisible(false);
    }


    // Método para exibir uma mensagem quando o botão é clicado
    private static void exibirMensagem(JPanel panel) {

        mensagemExibicao = new JLabel("Escolha o dia e o mes para seu agendamento.");
        mensagemExibicao.setBounds(10, 20, 300, 25);
        panel.add(mensagemExibicao);

        String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        mesesComboBox = new JComboBox<>(meses);
        mesesComboBox.setBounds(10, 60, 100, 25);


        mesesComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vereficadorDeDiasUteis();
            }
        });
        panel.add(mesesComboBox);

        diasUteisComboBox = new JComboBox<>();
        diasUteisComboBox.setBounds(130, 60, 90, 25);
        panel.add(diasUteisComboBox);

        String[] horas = {"8:00", "10:00", "12:00", "13:30", "15:30", "17:30", "19:30"};
        JComboBox<String> horasComboBox = new JComboBox<>(horas);
        horasComboBox.setBounds(240, 60, 60, 25);
        panel.add(horasComboBox);

        // Adicionar botão para iniciar o agendamento
        JButton button = new JButton("Iniciar Agendamento");
        button.setBounds(10, 100, 200, 25);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para o que acontece quando o botão é clicado
                String diaSelecionado = (String) diasUteisComboBox.getSelectedItem();
                String mesSelecionado = (String) mesesComboBox.getSelectedItem();
                System.out.println("Consulta agendada para " + diaSelecionado + " de " + mesSelecionado);
                ocultarComponentes(button, mesesComboBox, diasUteisComboBox, horasComboBox, mensagemExibicao);
            }
        });
        panel.add(button);
    }

    private static void vereficadorDeDiasUteis() {
        String mesSelecionado = (String) mesesComboBox.getSelectedItem();
        int anoAtual = LocalDate.now().getYear(); // Pode ser ajustado conforme necessário
        Data dataq = new Data();


        if (mesSelecionado != null) {

            dataq.converterMesDoAnoEmIngles(mesSelecionado);
            Month month = Month.valueOf(dataq.getMesSelecionado().toUpperCase());
            YearMonth yearMonth = YearMonth.of(anoAtual, month);
            int ultimoDia = yearMonth.lengthOfMonth();

            LocalDate dataAtual = LocalDate.now();

            List<String> dias = new ArrayList<>();
            for (int i = 1; i <= ultimoDia; i++) {
                LocalDate data = LocalDate.of(anoAtual, month, i);
                if(data.isEqual(dataAtual)|| data.isAfter(dataAtual)) {
                    if (ehDiaUtil(data)) {
                        dias.add(Integer.toString(i));
                    }
                }else {
                    dias.add("indisponivel");
                }
            }

            // Atualizar o modelo do JComboBox de dias
            DefaultComboBoxModel<String> diasModel = new DefaultComboBoxModel<>(dias.toArray(new String[0]));
            diasUteisComboBox.setModel(diasModel);
        }
    }

    private static boolean ehDiaUtil(LocalDate data) {
        DayOfWeek diaDaSemana = data.getDayOfWeek();
        return diaDaSemana != DayOfWeek.SATURDAY && diaDaSemana != DayOfWeek.SUNDAY;
    }
}

