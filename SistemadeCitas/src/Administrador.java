import javax.print.Doc;
import java.util.ArrayList;
import java.util.Scanner;

public class Administrador {

    //Variables de instancia
    private ArrayList<Doctor> doctores;
    private ArrayList<Paciente> pacientes;
    private ArrayList<Cita> citas;

    //Arraylist (Dinamico)
    public Administrador() {
        doctores = new ArrayList<>();
        pacientes = new ArrayList<>();
        citas = new ArrayList<>();
    }

    //Metodo para agregar, doctor, pacinte y cita.
    public void agregarDoctor(Doctor doctor){
        doctores.add(doctor);
    }
    public void agregarPaciente(Paciente paciente){
        pacientes.add(paciente);
    }
    public void agregarCita(Cita cita){
        citas.add(cita);
    }
    //Metodo para buscar, doctor, pacinte y cita.
    public Doctor buscarDoctor(int idDoctor) {
        for (Doctor doctor : doctores) {
            if (doctor.getIdDoctor() == idDoctor) {
                return doctor;
            }
        }
        return null;
    }
    public Paciente buscarPaciente(int idPaciente) {
        for (Paciente paciente : pacientes) {
            if (paciente.getIdPaciente() == idPaciente) {
                return paciente;
            }
        }
        return null;
    }




    //Metodo de mostrarMenu, el cual se va a llamar desde la clase main.
    public  void mostrarMenu(){
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Sistema de citas medicas");
            System.out.println("1. Agregar un nuevo doctor.");
            System.out.println("2. Agregar un nuevo paciente.");
            System.out.println("3. Agregar una nueva cita.");
            System.out.println("4. Buscar Doctor.");
            System.out.println("4. Buscar Paciente.");
            opcion = scanner.nextInt();

            switch (opcion){

                case 1:
                    //Iniciamos solicitando los datos del doctor.
                    scanner.nextLine();
                    System.out.println("Ingresar nombre del doctor: ");
                    String nombreDoctor = scanner.nextLine();
                    System.out.println("Ingresar la edad doctor: ");
                    int edadDoctor = scanner.nextInt();
                    System.out.println("Ingrese el numero identificador del doctor: ");
                    int idDoctor = scanner.nextInt();
                    System.out.println("Ingresar especialidad del doctor: ");
                    String especialidadDoctor = scanner.nextLine();
                    scanner.nextLine();
                    Doctor doctor = new Doctor(nombreDoctor, edadDoctor, idDoctor, especialidadDoctor);
                    agregarDoctor(doctor);
                    System.out.println("Doctor registrado exitosamente: ");
                    System.out.println("-----------------------------------------------------------");
                    break;
                case 2:
                    //Iniciamos solicitando los datos del Paciente.
                    scanner.nextLine();
                    System.out.println("Ingresar nombre del paciente: ");
                    String nombrePaciente = scanner.nextLine();
                    System.out.println("Ingresar la edad paciente: ");
                    int edadPaciente = scanner.nextInt();
                    System.out.println("Ingrese el numero identificador del paciente: ");
                    int idPaciente = scanner.nextInt();
                    Paciente paciente = new Paciente(nombrePaciente, edadPaciente, idPaciente);
                    agregarPaciente(paciente);
                    System.out.println("Paciente registrado exitosamente: ");
                    System.out.println("-----------------------------------------------------------");
                    break;
                case 3:
                    break;
                case 4:
                    // Solicitar id del doctor y llamar a buscarDoctor
                    System.out.print("Ingrese el numero identificador del doctor a buscar: ");
                    int idDoctorBuscar = scanner.nextInt();
                    scanner.nextLine();
                    Doctor doctorEncontrado = buscarDoctor(idDoctorBuscar);
                    if (doctorEncontrado != null) {
                        System.out.println("El doctor se encuentra registrado:");
                        System.out.println("Nombre: " + doctorEncontrado.getNombre());
                        System.out.println("Edad: " + doctorEncontrado.getEdad());
                        System.out.println("-----------------------------------------------------------");
                    } else {
                        System.out.println("Doctor no encontrado.");
                    }
                    break;
                case 5:
                    // Solicitar id del paciente y llamar a buscarDoctor
                    System.out.print("Ingrese el numero identificador del paciente a buscar: ");
                    int idPacienteBuscar = scanner.nextInt();
                    scanner.nextLine();
                    Paciente pacienteEncontrado =buscarPaciente(idPacienteBuscar);
                    if (pacienteEncontrado !=null){
                        System.out.println("El paciente se encuentra registrado.");
                        System.out.println("Nombre: " +pacienteEncontrado.getNombre());
                        System.out.println("Edad: " +pacienteEncontrado.getEdad());
                        System.out.println("-----------------------------------------------------------");
                    }else {
                        System.out.println("Paciente no encontrado");
                    }
                    break;

            }

        }while (opcion !=0);
        scanner.close();
    }



}


