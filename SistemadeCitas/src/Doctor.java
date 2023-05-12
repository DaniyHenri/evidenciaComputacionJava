import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.UUID;

public class Doctor extends Persona {

    private String especialidad;
    private int idDoctor;

   //Arraylist
    private static ArrayList<Doctor> doctores = new ArrayList<>();


    // Constructor

    public Doctor(String nombre, String especialidad, int idDoctor) {
        super(nombre);
        this.especialidad = especialidad;
        this.idDoctor = idDoctor;
    }

    // métodos getters y setters
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    //Metodo para buscar Doctor
    public static Doctor buscarDoctor(int idDoctor) {
        for (Doctor doctor : doctores) {
            if (idDoctor == doctor.getIdDoctor()) {
                return doctor;
            }
        }
        return null;
    }

    //Metodo para guardar el nuevo doctor en el arreglo de doctores
    public static void agregarDoctor(Doctor doctor) {
        doctores.add(doctor);
    }

    //Metodo para mostrar la informacion en el archivo CSV
    public String mostrar() {
        return "ID: " + idDoctor + "\nNombre: " + getNombre()
                + "\nEspecialidad: " + especialidad;
    }

    //Metodo para guardar archivo CSV
    public static void saveRecord(String nombre, int id, String especialidad, String filepath) {
        try {
            FileWriter fw = new FileWriter(filepath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println("\nNombre: "+ nombre + "\nNumero de identificacion: " + id + "\nEspecialidad: " + especialidad);

            pw.flush();
            pw.close();

            JOptionPane.showMessageDialog(null, "Record Saved!");
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null, "Record Not Saved!");

        }


    }
}



