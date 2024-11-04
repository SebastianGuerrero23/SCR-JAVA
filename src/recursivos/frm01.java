package recursivos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm01 extends JFrame {
    private static final long serialVersionUID = 1L;
    
    private JTextField inputFactorial;
    private JTextArea outputArea;
    private JTextField inputFibonacci;
    private JTextField inputElementoBuscar;
    private JTextField inputLista;
    private JTextField inputCadena;

    public frm01() {
        setTitle("Operaciones Recursivas");
        setBounds(100, 100, 400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        inputFactorial = new JTextField();
        inputFibonacci = new JTextField();
        inputElementoBuscar = new JTextField();
        inputLista = new JTextField();
        inputCadena = new JTextField();

        panel.add(new JLabel("Número para Factorial:"));
        panel.add(inputFactorial);
        
        panel.add(new JLabel("Número para Fibonacci:"));
        panel.add(inputFibonacci);
        
        panel.add(new JLabel("Buscar Elemento en Lista:"));
        panel.add(inputElementoBuscar);
        
        panel.add(new JLabel("Lista (separados por espacios):"));
        panel.add(inputLista);
        
        panel.add(new JLabel("Cadena para Invertir:"));
        panel.add(inputCadena);

        JButton calcularButton = new JButton("Calcular");
        calcularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcular();
            }
        });
        
        panel.add(calcularButton);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);
    }

    private void calcular() {
        StringBuilder resultado = new StringBuilder();
        
        // Cálculo del factorial
        int numeroFactorial = Integer.parseInt(inputFactorial.getText());
        resultado.append("El factorial de ").append(numeroFactorial).append(" es: ").append(factorial(numeroFactorial)).append("\n");
        
        // Cálculo de Fibonacci
        int numeroFibonacci = Integer.parseInt(inputFibonacci.getText());
        resultado.append("Fibonacci de ").append(numeroFibonacci).append(": ");
        for (int i = 0; i <= numeroFibonacci; i++) {
            resultado.append(fibonacci(i)).append(" ");
        }
        resultado.append("\n");
        
        // Búsqueda en lista
        String[] elementosLista = inputLista.getText().split(" ");
        int[] lista = new int[elementosLista.length];
        for (int i = 0; i < elementosLista.length; i++) {
            lista[i] = Integer.parseInt(elementosLista[i]);
        }
        
        int elementoBuscar = Integer.parseInt(inputElementoBuscar.getText());
        int resultadoBusqueda = busquedaRecursiva(lista, elementoBuscar, 0);
        if (resultadoBusqueda != -1) {
            resultado.append("Elemento ").append(elementoBuscar).append(" encontrado en la posición: ").append(resultadoBusqueda).append("\n");
        } else {
            resultado.append("Elemento ").append(elementoBuscar).append(" no encontrado en la lista.\n");
        }
        
        // Inversión de cadena
        String cadena = inputCadena.getText();
        resultado.append("Cadena invertida: ").append(invertirCadena(cadena)).append("\n");
        
        outputArea.setText(resultado.toString());
    }

    // Método para calcular el factorial
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    // Método para calcular la serie de Fibonacci
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    // Método para buscar un elemento en una lista de manera recursiva
    public static int busquedaRecursiva(int[] lista, int elemento, int indice) {
        if (indice >= lista.length) {
            return -1; // No encontrado
        }
        if (lista[indice] == elemento) {
            return indice; // Encontrado
        }
        return busquedaRecursiva(lista, elemento, indice + 1); // Llamada recursiva
    }

    // Método para invertir una cadena
    public static String invertirCadena(String cadena) {
        if (cadena.isEmpty()) {
            return cadena; // Caso base
        }
        return cadena.charAt(cadena.length() - 1) + invertirCadena(cadena.substring(0, cadena.length() - 1));
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm01 frame = new frm01();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

