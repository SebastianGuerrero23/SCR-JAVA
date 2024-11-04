package condicionales;

import javax.swing.JOptionPane;

public class frm33 {
    public static void main(String[] args) {

        int tardanza = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los minutos de tardanza:"));
        int observaciones = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de observaciones:"));
        
        int puntajePuntualidad = 0;
        int puntajeRendimiento = 0;
        double bonificacionPorPunto = 0;

        if (tardanza == 0) {
            puntajePuntualidad = 10;
            bonificacionPorPunto = 2.5;
        } else if (tardanza >= 1 && tardanza <= 2) {
            puntajePuntualidad = 8;
            bonificacionPorPunto = 5.0;
        } else if (tardanza >= 3 && tardanza <= 5) {
            puntajePuntualidad = 6;
            bonificacionPorPunto = 7.5;
        } else if (tardanza >= 6 && tardanza <= 9) {
            puntajePuntualidad = 4;
            bonificacionPorPunto = 10.0;
        } else if (tardanza >= 10 && tardanza <= 13) {
            puntajePuntualidad = 2;
            bonificacionPorPunto = 12.5;
        } else {
            puntajePuntualidad = 0;
            bonificacionPorPunto = 0;
        }

        if (observaciones == 0) {
            puntajeRendimiento = 10;
        } else if (observaciones == 1) {
            puntajeRendimiento = 8;
        } else if (observaciones == 2) {
            puntajeRendimiento = 5;
        } else if (observaciones >= 3 && observaciones <= 5) {
            puntajeRendimiento = 4;
        } else if (observaciones >= 6 && observaciones <= 9) {
            puntajeRendimiento = 1;
        } else {
            puntajeRendimiento = 0;
        }


        // Puntaje total y bonificación
        int puntajeTotal = puntajePuntualidad + puntajeRendimiento;
        double bonificacion = puntajeTotal * bonificacionPorPunto;

        // Resultado
        JOptionPane.showMessageDialog(null, "Puntaje de Puntualidad: " + puntajePuntualidad + 
                                      "\nPuntaje de Rendimiento: " + puntajeRendimiento +
                                      "\nPuntaje Total: " + puntajeTotal +
                                      "\nBonificación Anual: S/. " + bonificacion);
    }
}
