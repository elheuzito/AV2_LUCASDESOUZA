package q5_LucasRangel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class dadoEmCasa extends JFrame implements ActionListener {
    JButton um, dois, tres, quatro, cinco, seis, sete, oito, nove, dez, onze, doze, treze, quatorze, quinze, dezesseis, dezessete, dezoito, dezenova, vinte;
    private int numeroAleatorio;
    private int tentativasRestantes = 5;
    private final JTextField tentativasTextField;

    public dadoEmCasa() {
        super("Jogo de Adivinhação");
        this.setLayout(new FlowLayout());

        tentativasTextField = new JTextField("Tentativas Restantes: " + tentativasRestantes, 20);
        tentativasTextField.setEditable(false);

        um = new JButton("1");
        dois = new JButton("2");
        tres = new JButton("3");
        quatro = new JButton("4");
        cinco = new JButton("5");
        seis = new JButton("6");
        sete = new JButton("7");
        oito = new JButton("8");
        nove = new JButton("9");
        dez = new JButton("10");
        onze = new JButton("11");
        doze = new JButton("12");
        treze = new JButton("13");
        quatorze = new JButton("14");
        quinze = new JButton("15");
        dezesseis = new JButton("16");
        dezessete = new JButton("17");
        dezoito = new JButton("18");
        dezenova = new JButton("19");
        vinte = new JButton("20");

        um.addActionListener(this);
        dois.addActionListener(this);
        tres.addActionListener(this);
        quatro.addActionListener(this);
        cinco.addActionListener(this);
        seis.addActionListener(this);
        sete.addActionListener(this);
        oito.addActionListener(this);
        nove.addActionListener(this);
        dez.addActionListener(this);
        onze.addActionListener(this);
        doze.addActionListener(this);
        treze.addActionListener(this);
        quatorze.addActionListener(this);
        quinze.addActionListener(this);
        dezesseis.addActionListener(this);
        dezessete.addActionListener(this);
        dezoito.addActionListener(this);
        dezenova.addActionListener(this);
        vinte.addActionListener(this);

        add(tentativasTextField);
        add(um);
        add(dois);
        add(tres);
        add(quatro);
        add(cinco);
        add(seis);
        add(sete);
        add(oito);
        add(nove);
        add(dez);
        add(onze);
        add(doze);
        add(treze);
        add(quatorze);
        add(quinze);
        add(dezesseis);
        add(dezessete);
        add(dezoito);
        add(dezenova);
        add(vinte);

        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        gerarNumero();
    }

    private void gerarNumero() {
        Random random = new Random();
        numeroAleatorio = random.nextInt(20) + 1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        int numeroEscolhido = Integer.parseInt(button.getText());

        if (numeroEscolhido == numeroAleatorio) {
            JOptionPane.showMessageDialog(this, "Parabéns! Você acertou o número " + numeroAleatorio);
        } else {
            tentativasRestantes--;
            tentativasTextField.setText("Tentativas Restantes: " + tentativasRestantes);
            if (tentativasRestantes == 0) {
                JOptionPane.showMessageDialog(this, "Fim das tentativas. O número era: " + numeroAleatorio);
                reiniciarJogo();
            } else {
                JOptionPane.showMessageDialog(this, "Tente novamente. O número era: " + numeroAleatorio);
            }
        }
        gerarNumero();
    }

    private void reiniciarJogo() {
        tentativasRestantes = 5;
        tentativasTextField.setText("Tentativas Restantes: " + tentativasRestantes);
        gerarNumero();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(dadoEmCasa::new);
    }
}




