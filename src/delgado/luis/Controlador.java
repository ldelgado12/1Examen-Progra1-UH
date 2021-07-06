package delgado.luis;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import static delgado.luis.Autor.*;
import static delgado.luis.AutorAdministrador.*;
import static delgado.luis.Editorial.*;
import static delgado.luis.EditorialAdministrador.*;
import static delgado.luis.Libro.*;
import static delgado.luis.Usuario.*;
import static delgado.luis.UsuarioAdministrador.*;

public class Controlador {

    int answer;
    int SubAnswer1;
    int amount;

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    private static EditorialAdministrador ediAdm = new EditorialAdministrador("12");
    private static AutorAdministrador autorAdm = new AutorAdministrador("12");
    private static UsuarioAdministrador usuarioAdm = new UsuarioAdministrador("12");

    public static PrintStream out = System.out;

    public void imprimirMensaje(String msj){
        out.println(msj);
    }

    public String leerTexto() throws IOException {
       return in.readLine();
    }

    public void start() throws IOException {
        int opcion;
        do {
            ShowMenu();
            opcion = answer;
            procesarOpcion(opcion);
        } while (opcion != 5);

    }

    public void ShowMenu() throws java.io.IOException {

        imprimirMensaje("Por favor seleccione alguna de las siguientes opciones:");
        imprimirMensaje("1. Administrar catalogos de datos");
        imprimirMensaje("2. Solicitar nuevo prestamo");
        imprimirMensaje("3. Consultar prestamos");
        imprimirMensaje("4. Consultar todos los prestamos realizados por un usuario");
        imprimirMensaje("4. Consultar todos los prestamos realizados de un libro");
        imprimirMensaje("5. Salir");
        imprimirMensaje("Ingrese el numero de la operacion que desea");
        answer = Integer.parseInt(in.readLine());

    }


    public void procesarOpcion(int pOpcion) throws IOException {
        switch (pOpcion) {
            case 1:
                int sub1;
                do {
                    AdmCatalogoDatos();
                    sub1 = SubAnswer1;
                    SubCatalogo(sub1);
                } while (sub1 != 15);
                break;
            case 2:
                //NuevoPrestamo();
                break;
            case 3:
                //ConsultarPrestamos();
                break;
            case 4:
                //ConsultarPrestamosUsuario();
                break;
            case 5:
                //ConsultarPrestamosLibro();
                break;
            case 6:
                System.out.println("Gracias");
                break;
            default:
                System.out.println("Opcion Invalida");
        }
    }

    public void AdmCatalogoDatos() throws IOException {
        imprimirMensaje("Catalogo de autor");
        imprimirMensaje("1. Ingresar un nuevo autor");
        imprimirMensaje("2. Consultar datos de un autor.");
        imprimirMensaje("3. Actualizar datos de un autor");
        imprimirMensaje("4. Eliminar un autor");
        imprimirMensaje("Catalogo de editorial");
        imprimirMensaje("5. Ingresar una nueva editorial.");
        imprimirMensaje("6. Consultar datos de una editorial.");
        imprimirMensaje("7. Eliminar una editorial.");
        imprimirMensaje("Catalogo de libro");
        imprimirMensaje("8. Ingresar un nuevo libro.");
        imprimirMensaje("9. Consultar datos de un libro.");
        imprimirMensaje("10. Eliminar un libro.");
        imprimirMensaje("Catalogo de usuario");
        imprimirMensaje("11. Ingresar un nuevo usuario.");
        imprimirMensaje("12. Consultar datos de un usuario.");
        imprimirMensaje("13. Actualizar datos de un usuario.");
        imprimirMensaje("14. Eliminar un usuario.");
        imprimirMensaje("Salir del submenu y volver al menu");
        imprimirMensaje("15. Salir del administrador de catálogos.");
        imprimirMensaje("Ingrese el numero de la operacion que desea");
        SubAnswer1 = Integer.parseInt(in.readLine());
    }

    public void SubCatalogo(int SubOpcion) throws IOException {
        switch (SubOpcion) {
            case 1:
                NuevoAutor();
                break;
            case 2:
                autorAdm.ConsultarDatosAutor();
                break;
            case 3:
                ActualizarAutor();
                break;
            case 4:
                EliminarAutor();
                break;
            case 5:
                NuevaEditorial();
                break;
            case 6:
                ediAdm.ConsultarDatosEditorial();
                break;
            case 7:
                EliminarEditorial();
                break;
            case 8:
                NuevoLibro();
                break;
            case 9:
                ConsultarDatosLibro();
                break;
            case 10:
                EliminarLibro();
                break;
            case 11:
                NuevoUsuario();
                break;
            case 12:
                usuarioAdm.ConsultarDatosUsuario();
                break;
            case 13:
                ActualizarUsuario();
                break;
            case 14:
                EliminarUsuario();
                break;
            case 15:
                System.out.println("Gracias");
                break;
            default:
                System.out.println("Opcion Invalida");

        }
    }
}
