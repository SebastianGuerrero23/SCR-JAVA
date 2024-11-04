package condicionales;

import javax.swing.JOptionPane;

public class frm40 {
    public static void main(String[] args) {
        // Selección del curso
        String curso = JOptionPane.showInputDialog("Ingrese el curso Matematica, Fisica o Quimica:").toLowerCase();
        
        // Ingreso de notas
        double pc1 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota de PC1:"));
        double pc2 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota de PC2:"));
        double pc3 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota de PC3:"));
        double ep = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota del EP:"));
        double ef = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota del EF:"));
        
        double promedioFinal = 0;
        
        // Calculo del promedio final según el curso
        switch (curso) {
            case "Matematica":
                promedioFinal = pc1 * 0.10 + pc2 * 0.20 + pc3 * 0.10 + ep * 0.30 + ef * 0.30;
                break;
            case "Fisica":
                promedioFinal = pc1 * 0.20 + pc2 * 0.20 + pc3 * 0.20 + ep * 0.20 + ef * 0.20;
                break;
            case "Quimica":
                promedioFinal = pc1 * 0.10 + pc2 * 0.30 + pc3 * 0.10 + ep * 0.25 + ef * 0.25;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Curso inválido.");
                System.exit(0);
        }
        
        // Determinar la condición del estudiante
        String condicion = (promedioFinal >= 13) ? "Aprobado" : "Desaprobado";
        
        // Mostrar el resultado
        JOptionPane.showMessageDialog(null, "Promedio Final: " + promedioFinal + "\nCondición: " + condicion);
    }
}

