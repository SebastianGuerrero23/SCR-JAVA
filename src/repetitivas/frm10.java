package repetitivas;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm10 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtResultado, txtCantidad;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm10 frame = new frm10();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm10() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 350, 250);
        setLayout(null);  // Activación
        setLocationRelativeTo(null); 

        JLabel lblResultado = new JLabel("Números encontrados:");
        lblResultado.setBounds(20, 30, 200, 30);
        getContentPane().add(lblResultado);

        txtResultado = new JTextField();
        txtResultado.setBounds(20, 60, 300, 80);
        txtResultado.setFocusable(false);
        txtResultado.setHorizontalAlignment(SwingConstants.LEFT);
        getContentPane().add(txtResultado);

        JLabel lblCantidad = new JLabel("Cantidad de números:");
        lblCantidad.setBounds(20, 150, 150, 30);
        getContentPane().add(lblCantidad);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(170, 150, 150, 30);
        txtCantidad.setFocusable(false);
        txtCantidad.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtCantidad);

        JButton btnBuscar = new JButton("Buscar Números");
        btnBuscar.setBounds(100, 200, 150, 30);
        getContentPane().add(btnBuscar);

        btnBuscar.addActionListener(e -> btnBuscar_actionPerformed());
    }

    protected void btnBuscar_actionPerformed() {
        StringBuilder resultado = new StringBuilder();
        int cantidad = 0;

        for (int i = 1000; i < 10000; i++) {
            int num = i;
            int sumaPares = 0;
            int sumaImpares = 0;

            for (int j = 0; j < 4; j++) {
                int digito = num % 10; 
                if (digito % 2 == 0) {  
                    sumaPares += digito;
                } else {  
                    sumaImpares += digito;
                }
                num /= 10;  
            }

            if (sumaPares == sumaImpares) {
                resultado.append(i).append("\n");
                cantidad++;
            }
        }

        txtResultado.setText(resultado.toString());
        txtCantidad.setText(String.valueOf(cantidad));
    }
}
