import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Usuario {

    private String us;
    private String password;

    public Usuario(String nom, String pass) {
        us = nom;
        password = pass;
    }

    @Override
    public boolean equals(Object objeto) {
        if (objeto instanceof Usuario) {
            Usuario newAdmin = (Usuario) objeto;
            if (us.equals(newAdmin.us) && password.equals(newAdmin.password))
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
        String us = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.println("--------------------------------------------------------");

        Usuario admin = new Usuario(us, password);

        return administradores.contains(admin);

    }

    public static void crearAdministradores() {
        administradores.add(new Usuario("Daniel", "000"));
        administradores.add(new Usuario("Luis", "111"));
    }

    //Metodo para agregar usuario

}