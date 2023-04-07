import java.util.Date;
public class Cita extends Persona{

    private Date fecha;
    private Date hora;
    private Doctor doctor;


    // otros atributos y métodos



    public Cita(Date fecha, Date hora, Doctor doctor, int id, String nombre) {
        this.fecha = fecha;
        this.hora = hora;
        this.doctor = doctor;


    }

    public Cita(String nombreCita, String motivoCita, String doctorCita, String fechaCita, String horaCita, String idCita) {
    }

    // métodos getters y setters

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }



}
