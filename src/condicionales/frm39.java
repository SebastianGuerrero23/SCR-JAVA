package condicionales;

import javax.swing.JOptionPane;

public class frm39 {
    public static void main(String[] args) {
        double horasAusencia = Double.parseDouble(JOptionPane.showInputDialog("Ingrese las horas de ausencia del operario:"));
        int tornillosDefectuosos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de tornillos defectuosos producidos:"));
        int tornillosNoDefectuosos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de tornillos no defectuosos producidos:"));
        
        int gradoEficiencia;

        boolean cumplePrimera = horasAusencia <= 1.5;
        boolean cumpleSegunda = tornillosDefectuosos < 300;
        boolean cumpleTercera = tornillosNoDefectuosos > 10000;

        if (cumplePrimera && cumpleSegunda && cumpleTercera) {
            gradoEficiencia = 20;
        } else if (cumplePrimera && cumpleSegunda) {
            gradoEficiencia = 12;
        } else if (cumplePrimera && cumpleTercera) {
            gradoEficiencia = 13;
        } else if (cumpleSegunda && cumpleTercera) {
            gradoEficiencia = 15;
        } else if (cumplePrimera) {
            gradoEficiencia = 7;
        } else if (cumpleSegunda) {
            gradoEficiencia = 8;
        } else if (cumpleTercera) {
            gradoEficiencia = 9;
        } else {
            gradoEficiencia = 5;
        }

        JOptionPane.showMessageDialog(null, "El grado de eficiencia del operario es: " + gradoEficiencia);
    }
}



