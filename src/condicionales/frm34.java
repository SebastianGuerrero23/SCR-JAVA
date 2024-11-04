package condicionales;

import javax.swing.JOptionPane;

public class frm34 {
    public static void main(String[] args) {

        double peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese su peso en kg:"));
        double estatura = Double.parseDouble(JOptionPane.showInputDialog("Ingrese su estatura en metros:"));
        double imc = peso / (estatura * estatura);
        String gradoObesidad;


        if (imc < 20) {
            gradoObesidad = "Delgado";
        } else if (imc <= 25) {
            gradoObesidad = "Normal";
        } else if (imc <= 27) {
            gradoObesidad = "Sobrepeso";
        } else {
            gradoObesidad = "Obesidad";
        }


        // Resultado
        JOptionPane.showMessageDialog(null, "IMC: " + imc + "\nGrado de Obesidad: " + gradoObesidad);
    }
}

