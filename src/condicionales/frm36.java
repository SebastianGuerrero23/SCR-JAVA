package condicionales;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm36 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtCuadernos, txtLucas, txtFaber, txtPilot;

    public frm36() {
        setTitle("Obsequio de Lapiceros");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 250);
        setLayout(null);

        JLabel lblCuadernos = new JLabel("Número de Cuadernos:");
        lblCuadernos.setBounds(10, 20, 150, 25);
        add(lblCuadernos);

        txtCuadernos = new JTextField();
        txtCuadernos.setBounds(160, 20, 100, 25);
        add(txtCuadernos);

        JLabel lblLucas = new JLabel("Lapiceros Lucas:");
        lblLucas.setBounds(10, 60, 150, 25);
        add(lblLucas);

        txtLucas = new JTextField();
        txtLucas.setBounds(160, 60, 100, 25);
        txtLucas.setEditable(false);
        add(txtLucas);

        JLabel lblFaber = new JLabel("Lapiceros Faber:");
        lblFaber.setBounds(10, 100, 150, 25);
        add(lblFaber);

        txtFaber = new JTextField();
        txtFaber.setBounds(160, 100, 100, 25);
        txtFaber.setEditable(false);
        add(txtFaber);

        JLabel lblPilot = new JLabel("Lapiceros Pilot:");
        lblPilot.setBounds(10, 140, 150, 25);
        add(lblPilot);

        txtPilot = new JTextField();
        txtPilot.setBounds(160, 140, 100, 25);
        txtPilot.setEditable(false);
        add(txtPilot);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(10, 180, 100, 25);
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularLapiceros();
            }
        });
        add(btnCalcular);
    }

    private void calcularLapiceros() {
        int cuadernos = Integer.parseInt(txtCuadernos.getText());
        int lucas = 0, faber = 0, pilot = 0;

        if (cuadernos >= 36) {
            pilot = (cuadernos / 4) * 2;
            faber = (cuadernos / 6);
            lucas = (cuadernos / 12);
        } else if (cuadernos >= 24) {
            faber = (cuadernos / 4) * 2;
        } else if (cuadernos >= 12) {
            lucas = (cuadernos / 4);
        }

        txtLucas.setText(String.valueOf(lucas));
        txtFaber.setText(String.valueOf(faber));
        txtPilot.setText(String.valueOf(pilot));
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm36 frame = new frm36();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
