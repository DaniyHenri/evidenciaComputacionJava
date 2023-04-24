public class Doctor extends Persona {

    private int idDoctor;
    private String especialidad;

    // Constructor

    public Doctor(String nombre, int edad, int idDoctor, String especialidad) {
        super(nombre, edad);
        this.idDoctor = idDoctor;
        this.especialidad = especialidad;
    }

    // métodos getters y setters


    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}



