import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Menu {

    public  void mostrarMenu() throws ParseException, CitaExistenteException {
        Usuario.crearAdministradores();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        do {
            if (Usuario.validarAcceso()) {
                System.out.println("\nUsuario autorizado\n");
                System.out.println("Sistema de citas medicas");
                System.out.println("1. Agregar un nuevo doctor.");
                System.out.println("2. Agregar un nuevo paciente.");
                System.out.println("3. Agregar una nueva cita.");
                System.out.println("4. Buscar Doctor.");
                System.out.println("5. Buscar Paciente.");
                System.out.println("6. Buscar Citas de un Doctor.");
                System.out.println("0. Salir del Programa.");
                System.out.println("-----------------------------------------------------------");
                opcion = scanner.nextInt();

                switch (opcion) {

                    case 1:
                        //Iniciamos solicitando los datos del doctor.
                        scanner.nextLine();
                        System.out.println("Ingresar nombre del doctor: ");
                        String nombreDoctor = scanner.nextLine();
                        System.out.println("Ingresar especialidad del doctor: ");
                        String especialidad = scanner.nextLine();
                        System.out.println("Ingrese el numero identificador del doctor: ");
                        int idDoctor = scanner.nextInt();
                        scanner.nextLine();
                        Doctor doctores = new Doctor(nombreDoctor, especialidad, idDoctor);
                        Doctor.agregarDoctor(doctores);
                        Doctor.saveRecord(doctores.getNombre(), doctores.getIdDoctor(), doctores.getEspecialidad(), "doctores.csv");
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("Doctor registrado exitosamente: ");
                        System.out.println(doctores.mostrar());
                        System.out.println("-----------------------------------------------------------");
                        break;
                    case 2:
                        //Iniciamos solicitando los datos del Paciente.
                        scanner.nextLine();
                        System.out.println("Ingresar nombre del paciente: ");
                        String nombrePaciente = scanner.nextLine();
                        System.out.println("Ingrese el numero identificador del paciente: ");
                        int idPaciente = scanner.nextInt();
                        Paciente pacientes = new Paciente(nombrePaciente,  idPaciente);
                        Paciente.agregarPaciente(pacientes);
                        Paciente.saveRecord(pacientes.getNombre(), pacientes.getIdPaciente(), "pacientes.csv");
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("Paciente registrado exitosamente: ");
                        System.out.println(pacientes.mostrar());
                        System.out.println("-----------------------------------------------------------");
                        break;
                    case 3:
                        System.out.print("Ingresar el numero identificador de doctor: ");
                        int idDoctorCita = scanner.nextInt();
                        Doctor doctorCita = Doctor.buscarDoctor(idDoctorCita);
                        if (doctorCita == null) {
                            System.out.println("Doctor no encontrado.");
                            break;
                        }
                        System.out.print("Ingrese el numero identificador del paciente: ");
                        int idPacienteCita = scanner.nextInt();
                        Paciente pacienteCita = Paciente.buscarPaciente(idPacienteCita);
                        if (pacienteCita == null) {
                            System.out.println("Paciente no encontrado.");
                            break;
                        }
                        System.out.print("Ingresar la fecha de la cita dd/MM/yyyy: ");
                        String fechaCitaStr = scanner.next();
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        Date fechaCita = sdf.parse(fechaCitaStr);
                        System.out.print("Ingresar la hora de la cita HH:mm: ");
                        String horaCita = scanner.next();
                        System.out.print("Ingrese el motivo de la consulta: ");
                        String motivoCita = scanner.next();
                        System.out.print("Ingrese el numero identificador de la cita: ");
                        int idCita = scanner.nextInt();
                        Cita citas = new Cita( doctorCita, pacienteCita, fechaCita, horaCita, motivoCita, idCita);
                        Cita.agregarCita(citas);
                        Cita.saveRecord(citas.getDoctor(), citas.getPaciente(), citas.getIdCita(), citas.getFecha(), citas.getHora(), citas.getMotivo(), "Citas.csv");
                        System.out.println("Cita agregada exitosamente.");
                        break;
                    case 4:
                        // Solicitar id del doctor y llamar a buscarDoctor
                        System.out.print("Ingrese el numero identificador del doctor a buscar: ");
                        int idDoctorBuscar = scanner.nextInt();
                        scanner.nextLine();
                        Doctor doctorEncontrado = Doctor.buscarDoctor(idDoctorBuscar);
                        if (doctorEncontrado != null) {
                            System.out.println("-----------------------------------------------------------");
                            System.out.println("Datos del doctor:");
                            System.out.println("Nombre: " + doctorEncontrado.getNombre());
                            System.out.println("Especialidad: " + doctorEncontrado.getEspecialidad());
                            System.out.println("Numero de identificacion: " + doctorEncontrado.getIdDoctor());
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
                        Paciente pacienteEncontrado = Paciente.buscarPaciente(idPacienteBuscar);
                        if (pacienteEncontrado != null) {
                            System.out.println("-----------------------------------------------------------");
                            System.out.println("Datos del paciente.");
                            System.out.println("Nombre: " + pacienteEncontrado.getNombre());
                            System.out.println("Numero de identificación: " + pacienteEncontrado.getIdPaciente());
                            System.out.println("-----------------------------------------------------------");
                        } else {
                            System.out.println("Paciente no encontrado");
                        }
                        break;
                    case 6:
                        System.out.println("--------------------------------------------------------");
                        System.out.print("Ingrese el ID del doctor para buscar sus citas: ");
                        int idDoctorCitas = scanner.nextInt();
                        scanner.nextLine(); // Consumir el salto de línea restante
                        ArrayList<Cita> citasDoctor = Cita.buscarCitasPorDoctor(idDoctorCitas);
                        if (!citasDoctor.isEmpty()) {
                            System.out.println("-----------------------------------------------------------");
                            System.out.println("Citas del doctor con ID " + idDoctorCitas + ":");
                            for (Cita cita : citasDoctor) {
                                System.out.println("Doctor: " + cita.getDoctor().getNombre() );
                                System.out.println("Paciente: " + cita.getPaciente().getNombre() );
                                System.out.println("Fecha: " + cita.getFecha());
                                System.out.println("Hora: " + cita.getHora());

                                System.out.println("--------------------------------------------------------");
                            }
                        } else {
                            System.out.println("No se encontraron citas para el doctor con ID " + idDoctorCitas);
                        }
                        break;
                }
            }
            else {
                System.out.println("\nUsuario no autorizado.");

                System.out.println("\n Fin del Programa");
            }
        }
        while (opcion != 0) ;
        scanner.close();
    }
}

