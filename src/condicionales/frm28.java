package condicionales;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm28 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtHora24, txtHora12;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm28 frame = new frm28();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm28() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 300, 200);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblHora24 = new JLabel("Hora (24 horas): ");
        lblHora24.setBounds(20, 30, 150, 30);
        getContentPane().add(lblHora24);

        txtHora24 = new JTextField();
        txtHora24.setBounds(150, 30, 100, 30);
        getContentPane().add(txtHora24);

        JLabel lblHora12 = new JLabel("Hora (12 horas): ");
        lblHora12.setBounds(20, 80, 150, 30);
        getContentPane().add(lblHora12);

        txtHora12 = new JTextField();
        txtHora12.setBounds(150, 80, 100, 30);
        txtHora12.setEditable(false);
        getContentPane().add(txtHora12);

        JButton btnConvertir = new JButton("Convertir");
        btnConvertir.setBounds(80, 130, 130, 30);
        getContentPane().add(btnConvertir);

        btnConvertir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertirHora();
            }
        });
    }

    private void convertirHora() {
        String[] partesHora = txtHora24.getText().split(":");
        if (partesHora.length != 2) {
            txtHora12.setText("Hora inválida");
            return;
        }

        try {
            int horas = Integer.parseInt(partesHora[0]);
            int minutos = Integer.parseInt(partesHora[1]);

            if (horas < 0 || horas > 23 || minutos < 0 || minutos > 59) {
                txtHora12.setText("Hora inválida");
                return;
            }

            String periodo = (horas < 12) ? "AM" : "PM";
            if (horas == 0) {
                horas = 12; // 12 AM
            } else if (horas > 12) {
                horas -= 12; // Convertir a formato 12 horas
            }

            txtHora12.setText(String.format("%02d:%02d %s", horas, minutos, periodo));
        } catch (NumberFormatException e) {
            txtHora12.setText("Hora inválida");
        }
    }
}
