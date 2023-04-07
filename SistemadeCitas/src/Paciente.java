public class Paciente extends Persona{

    private String motivo;


    public Paciente(String nombre, int id, String motivo) {
        this.motivo = motivo;


    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }


}
