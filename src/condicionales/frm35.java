package condicionales;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm35 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtCodigo, txtTipoEmpleado;

    public frm35() {
        setTitle("Determinación de Tipo de Empleado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 350, 200);
        setLayout(null);

        JLabel lblCodigo = new JLabel("Código de Empleado:");
        lblCodigo.setBounds(10, 20, 150, 25);
        add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(150, 20, 100, 25);
        add(txtCodigo);

        JLabel lblTipoEmpleado = new JLabel("Tipo de Empleado:");
        lblTipoEmpleado.setBounds(10, 60, 150, 25);
        add(lblTipoEmpleado);

        txtTipoEmpleado = new JTextField();
        txtTipoEmpleado.setBounds(150, 60, 150, 25);
        txtTipoEmpleado.setEditable(false);
        add(txtTipoEmpleado);

        JButton btnDeterminar = new JButton("Determinar");
        btnDeterminar.setBounds(10, 100, 100, 25);
        btnDeterminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                determinarTipoEmpleado();
            }
        });
        add(btnDeterminar);
    }

    private void determinarTipoEmpleado() {
        int codigo = Integer.parseInt(txtCodigo.getText());
        String tipoEmpleado;

        if (codigo % 2 == 0 && codigo % 3 == 0 && codigo % 5 == 0) {
            tipoEmpleado = "Administrativo";
        } else if (codigo % 3 == 0 && codigo % 5 == 0 && codigo % 2 != 0) {
            tipoEmpleado = "Directivo";
        } else if (codigo % 2 == 0 && codigo % 3 != 0 && codigo % 5 != 0) {
            tipoEmpleado = "Vendedor";
        } else if (codigo % 2 != 0 && codigo % 3 != 0 && codigo % 5 != 0) {
            tipoEmpleado = "Seguridad";
        } else {
            tipoEmpleado = "Tipo no determinado";
        }

        txtTipoEmpleado.setText(tipoEmpleado);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm35 frame = new frm35();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
