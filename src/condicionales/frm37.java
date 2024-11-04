package condicionales;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm37 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtPamela, txtCarol, txtFanny, txtResultado;

    public frm37() {
        setTitle("Resultado de Elección");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 250);
        setLayout(null);

        JLabel lblPamela = new JLabel("Votos para Pamela:");
        lblPamela.setBounds(10, 20, 150, 25);
        add(lblPamela);

        txtPamela = new JTextField();
        txtPamela.setBounds(160, 20, 100, 25);
        add(txtPamela);

        JLabel lblCarol = new JLabel("Votos para Carol:");
        lblCarol.setBounds(10, 60, 150, 25);
        add(lblCarol);

        txtCarol = new JTextField();
        txtCarol.setBounds(160, 60, 100, 25);
        add(txtCarol);

        JLabel lblFanny = new JLabel("Votos para Fanny:");
        lblFanny.setBounds(10, 100, 150, 25);
        add(lblFanny);

        txtFanny = new JTextField();
        txtFanny.setBounds(160, 100, 100, 25);
        add(txtFanny);

        JLabel lblResultado = new JLabel("Resultado:");
        lblResultado.setBounds(10, 140, 150, 25);
        add(lblResultado);

        txtResultado = new JTextField();
        txtResultado.setBounds(160, 140, 200, 25);
        txtResultado.setEditable(false);
        add(txtResultado);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(10, 180, 100, 25);
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularResultado();
            }
        });
        add(btnCalcular);
    }

    private void calcularResultado() {
        int votosPamela = Integer.parseInt(txtPamela.getText());
        int votosCarol = Integer.parseInt(txtCarol.getText());
        int votosFanny = Integer.parseInt(txtFanny.getText());

        int totalVotos = votosPamela + votosCarol + votosFanny;
        int votosNecesarios = (totalVotos / 2) + 1;
        String resultado;


        if (votosPamela >= votosNecesarios) {
            resultado = "Ganadora: Pamela";
        } else if (votosCarol >= votosNecesarios) {
            resultado = "Ganadora: Carol";
        } else if (votosFanny >= votosNecesarios) {
            resultado = "Ganadora: Fanny";
        } else {
            
            // Ordenar votos para determinar segundo puesto
            if (votosPamela == votosCarol && votosCarol == votosFanny) {
                resultado = "Elección anulada por triple empate.";
            } else if (votosPamela == votosCarol || votosCarol == votosFanny || votosPamela == votosFanny) {
                resultado = "Elección anulada por empate en el segundo puesto.";
            } else {

            // Determinar los dos primeros para segunda vuelta
             if (votosPamela > votosCarol && votosPamela > votosFanny) {
                    resultado = votosCarol > votosFanny ? "Segunda vuelta: Pamela y Carol" : "Segunda vuelta: Pamela y Fanny";
            } else if (votosCarol > votosPamela && votosCarol > votosFanny) {
                    resultado = votosPamela > votosFanny ? "Segunda vuelta: Carol y Pamela" : "Segunda vuelta: Carol y Fanny";
            } else {
                    resultado = votosPamela > votosCarol ? "Segunda vuelta: Fanny y Pamela" : "Segunda vuelta: Fanny y Carol";
                }
            }
        }
        txtResultado.setText(resultado);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm37 frame = new frm37();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
