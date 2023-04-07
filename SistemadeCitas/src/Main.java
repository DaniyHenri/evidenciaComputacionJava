import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

    private static final String USUARIODOCTOR = "Doctor";
    private static final String USUARIOPACIENTE = "Paciente";
    private static final String USUARIOCITAS = "Cita";
    private ArrayList<Doctor> doctores;
    private ArrayList<Paciente> pacientes;
    private ArrayList<Cita> citas;

    public Main() {


        doctores = new ArrayList<>();
        citas = new ArrayList<>();
        pacientes = new ArrayList<>();
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);

        while (true) {


            System.out.println("Bienvenido");
            System.out.println("Selecciona una opcion para iniciar.");
            System.out.println("1. Registrar nuevo doctor");
            System.out.println("2. Registrar nuevo paciente");
            System.out.println("3. Crear una nueva cita");
            System.out.println("--------------------------------------------------------");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese usuario: ");
                    String usuario = scanner.nextLine();
                    if (!usuario.equals(USUARIODOCTOR)) {
                        System.out.println("Usuario o contraseña incorrectos");
                        return;
                    }
                    System.out.println("Ingrese el nombre del nuevo doctor:");
                    String nombrePersona = scanner.nextLine();
                    System.out.println("Ingrese la especialidad::");
                    String especialidadDoctor = scanner.nextLine();
                    System.out.println("Ingrese el numero identificador del doctor:");
                    int idPersona = scanner.nextInt();

                    Doctor doctor = new Doctor(nombrePersona, especialidadDoctor, idPersona);
                    main.doctores.add(doctor);
                    System.out.println("El nuevo Doctor a sido registrado exitosamente.");

                    System.out.println("--------------------------------------------------------");
                    System.out.println("Datos del doctor guardados.");
                    System.out.println("Nombre del Doctor: " + nombrePersona + "\nEspecialidad::  " + especialidadDoctor + "\nNumero identificador del doctor:  " + idPersona);
                    System.out.println("--------------------------------------------------------");

                    break;
                case 2:
                    System.out.print("Ingrese usuario: ");
                    String usuario1 = scanner.nextLine();
                    if (!usuario1.equals(USUARIOPACIENTE)) {
                        System.out.println("Usuario o contraseña incorrectos");
                        return;
                    }
                        System.out.println("Ingresar el nombre del paciente:");
                        String nombrePersonaPaciente = scanner.nextLine();
                        System.out.println("Ingrese el numero el numero identificador del paciente:");
                        int idPersonaPaciente = scanner.nextInt();
                        scanner.nextLine(); // para consumir el salto de línea después del número
                        System.out.println("Ingrese el motivo por el que esta aqui:");
                        String motivoPaciente = scanner.nextLine();

                        Paciente paciente = new Paciente(nombrePersonaPaciente, idPersonaPaciente, motivoPaciente);
                        main.pacientes.add(paciente);
                        System.out.println("Paciente registrado exitosamente");

                        System.out.println("--------------------------------------------------------");
                        System.out.println("Datos del Paciente guardados.");
                        System.out.println("Nombre del Paciente: " + nombrePersonaPaciente + "\nNumero identificador del paciente:  " + idPersonaPaciente + "\nMotivo:  " + motivoPaciente);

                        System.out.println("--------------------------------------------------------");
                        break;
                        case 3:
                            System.out.print("Ingrese usuario: ");
                            String usuario2 = scanner.nextLine();
                            if (!usuario2.equals(USUARIOCITAS)) {
                                System.out.println("Usuario o contraseña incorrectos");
                                return;
                            }
                            System.out.print("Ingresar nombre de la persona: ");
                            String nombrePersonaCita = scanner.nextLine();
                            System.out.print("Ingresar el motivo de la cita: ");
                            String motivoCita = scanner.nextLine();
                            System.out.print("Ingresar el nombre del doctor: ");
                            String doctorDoctor = scanner.nextLine();
                            System.out.print("Por favor, ingrese una fecha (dd/mm/aaaa): ");
                            String fechaCita = scanner.nextLine();
                            System.out.print("Por favor, ingrese la hora de la cita (en formato hh:mm:ss): ");
                            String horaCita = scanner.nextLine();
                            System.out.print("Ingresar codigo de identificación: ");
                            String idPersonaCita = scanner.nextLine();


                            Cita cita = new Cita(nombrePersonaCita, motivoCita, doctorDoctor, fechaCita, horaCita, idPersonaCita);
                            main.citas.add(cita);
                            System.out.println("La nueva cita a sido registrada exitosamente.");

                            System.out.println("--------------------------------------------------------");
                            System.out.println("Cita agregada con éxito.");
                            System.out.println("Nombre del Paciente: " + nombrePersonaCita + "\nMotivo de la visita:  " + motivoCita + "\nDoctor asignado:  " + doctorDoctor + "\nFecha de la cita: " + fechaCita + "\nHora de la cita: " + horaCita
                                    + "\nNumero identificador del paciente: " + idPersonaCita);
                            System.out.println("--------------------------------------------------------");
                            break;
                        default:
                            break;

                    }


            }
        }
    }

