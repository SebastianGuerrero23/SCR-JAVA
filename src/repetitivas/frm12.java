package repetitivas;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class frm12 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextArea txtArea;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frm12 frame = new frm12();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public frm12() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 350, 300);
        setLayout(null);  // Activación
        setLocationRelativeTo(null); 

        JLabel lblTitulo = new JLabel("Números del 1 al 100");
        lblTitulo.setBounds(100, 20, 200, 30);
        getContentPane().add(lblTitulo);

        txtArea = new JTextArea();
        txtArea.setBounds(20, 60, 300, 180);
        txtArea.setEditable(false);
        getContentPane().add(txtArea);

        JButton btnMostrar = new JButton("Mostrar Números");
        btnMostrar.setBounds(100, 240, 150, 30);
        getContentPane().add(btnMostrar);

        btnMostrar.addActionListener(e -> btnMostrar_actionPerformed());
    }

    protected void btnMostrar_actionPerformed() {
        StringBuilder numeros = new StringBuilder();
        
        for (int i = 1; i <= 100; i++) {
            numeros.append(i).append("\t");
            if (i % 10 == 0) {  
                numeros.append("\n");
            }
        }
        
        txtArea.setText(numeros.toString());
    }
}
