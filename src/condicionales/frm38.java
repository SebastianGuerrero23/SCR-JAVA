package condicionales;

import javax.swing.JOptionPane;

public class frm38 {
    public static void main(String[] args) {
        int mes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número del mes (1-12):"));
        int año = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año:"));
        
        String nombreMes;
        int diasMes;
        
        switch (mes) {
            case 1:
                nombreMes = "Enero";
                diasMes = 31;
                break;
            case 2:
                nombreMes = "Febrero";
                if ((año % 4 == 0 && año % 100 != 0) || (año % 400 == 0)) {
                    diasMes = 29;
                } else {
                    diasMes = 28;
                }
                break;
            case 3:
                nombreMes = "Marzo";
                diasMes = 31;
                break;
            case 4:
                nombreMes = "Abril";
                diasMes = 30;
                break;
            case 5:
                nombreMes = "Mayo";
                diasMes = 31;
                break;
            case 6:
                nombreMes = "Junio";
                diasMes = 30;
                break;
            case 7:
                nombreMes = "Julio";
                diasMes = 31;
                break;
            case 8:
                nombreMes = "Agosto";
                diasMes = 31;
                break;
            case 9:
                nombreMes = "Septiembre";
                diasMes = 30;
                break;
            case 10:
                nombreMes = "Octubre";
                diasMes = 31;
                break;
            case 11:
                nombreMes = "Noviembre";
                diasMes = 30;
                break;
            case 12:
                nombreMes = "Diciembre";
                diasMes = 31;
                break;
            default:
                nombreMes = "Mes inválido";
                diasMes = 0;
                break;
        }
        
        if (diasMes > 0) {
            JOptionPane.showMessageDialog(null, "Mes: " + nombreMes + "\nDías: " + diasMes);
        } else {
            JOptionPane.showMessageDialog(null, "Mes ingresado no es válido.");
        }
    }
}
