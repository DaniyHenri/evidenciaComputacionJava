import java.util.Date;
public class Cita {

    private Doctor doctor;
    private Paciente paciente;
    private Date fecha;
    private String hora;
    private String motivo;
    private int idCita;

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
}
