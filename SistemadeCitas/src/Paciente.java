public class Paciente extends Persona{

    private int idPaciente;


    //Constructor
    public Paciente(String nombre, int edad, int idPaciente) {
        super(nombre, edad);
        this.idPaciente = idPaciente;
    }
    //Getter y setter
    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }
}
