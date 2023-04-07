public class Doctor extends Persona {

    private String especialidad;

    // otros atributos y métodos

    public Doctor(String nombre, String especialidad, int id) {
        this.especialidad = especialidad;

    }

    // métodos getters y setters

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }


}



