import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Paciente extends Persona {

    private int idPaciente;


    private static ArrayList<Paciente> pacientes = new ArrayList<>();

    //Constructor


    public Paciente(String nombre, int idPaciente) {
        super(nombre);
        this.idPaciente = idPaciente;
    }

    //Metodo getter y setter


    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    //Metodos
    public static void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public static Paciente buscarPaciente(int idPaciente) {
        for (Paciente paciente : pacientes) {
            if (paciente.getIdPaciente() == idPaciente) {
                return paciente;
            }
        }
        return null;
    }

    public String mostrar() {
        return "ID: " + idPaciente + "\nNombre: " + getNombre();
    }

    public static void saveRecord(String nombre, int id, String filepath) {
        try {
            FileWriter fw = new FileWriter(filepath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println("\nNombre: " +nombre + "," + "\nNumero de identificacion: " + id);
            pw.flush();
            pw.close();

            JOptionPane.showMessageDialog(null, "Record Saved!");
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null, "Record Not Saved!");

        }


    }
}
