import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Usuario {

    private String nombre;
    private String password;

    public Usuario(String nom, String pass) {
        nombre = nom;
        password = pass;
    }

    @Override
    public boolean equals(Object objeto) {
        if (objeto instanceof Usuario) {
            Usuario otroAdmin = (Usuario) objeto;
            if (nombre.equals(otroAdmin.nombre) && password.equals(otroAdmin.password))
                return true;
            else
                return false;
        }
        else
            return false;
    }
    private static ArrayList<Usuario> administradores = new ArrayList<Usuario>();
    public static Scanner scanner = new Scanner(System.in);//


    public static boolean validarAcceso( ) {
        System.out.println("Accediendo al Programa");
        System.out.print("Usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.println("--------------------------------------------------------");

        Usuario admin = new Usuario(nombre, password);

        return administradores.contains(admin);

    }

    public static void crearAdmins() {
        administradores.add(new Usuario("Admin", "007"));
        administradores.add(new Usuario("SuperAdmin", "ajit0oCt5!"));
    }
}