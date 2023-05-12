import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

public class Cita {
    private Doctor doctor;
    private Paciente paciente;
    private Date fecha;
    private String hora;
    private String motivo;

    private int idCita;

    //ArrayList
    private static ArrayList<Cita> citas = new ArrayList<>();

    //Constructor

    public Cita(Doctor doctor, Paciente paciente, Date fecha, String hora, String motivo, int idCita) {
        this.doctor = doctor;
        this.paciente = paciente;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.idCita = idCita;

    }

    //Getter y Setter
    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    //Metodo para agregar citas
    public static void agregarCita(Cita cita) throws CitaExistenteException {
        if (citas.contains(cita)) throw new CitaExistenteException("La cita ya existe en la agenda.");
        citas.add(cita);
    }
    //Metodo para buscar citas por doctor.
    public static ArrayList<Cita> buscarCitasPorDoctor(int idDoctor) {
        ArrayList<Cita> citasDoctor = new ArrayList<>();
        for (Cita cita : citas) {
            if (cita.getDoctor().getIdDoctor() == idDoctor) {
                citasDoctor.add(cita);
            }
        }
        return citasDoctor;
    }

    //metodos para mostrar datos en archivo CSV
    public String mostrar() {
        return "ID: " + idCita + "\nNombre: " + getDoctor()
                + "\nPaciente: " + getPaciente() + "\nFecha: " + getFecha() + "\nHora: " + getHora() + "\nMotivo: " + getMotivo();
    }

    //Metodo para guardar archivo CSV
    public static void saveRecord(Doctor Doctor, Paciente Paciente, int idCita, Date fecha, String Hora, String motivo, String filepath) {
        try {
            FileWriter fw = new FileWriter(filepath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println("\nDoctor: "+Doctor.getNombre() + "\nPaciente: " + Paciente.getNombre() + "\nNumero identificador de la cita: " + idCita + "\nFecha: " + fecha + "\nHora: " + Hora  + "\nMotivo de la cita: " + motivo);

            pw.flush();
            pw.close();

            JOptionPane.showMessageDialog(null, "Record Saved!");
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null, "Record Not Saved!");

        }


    }



}
