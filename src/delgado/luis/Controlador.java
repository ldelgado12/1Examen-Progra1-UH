package delgado.luis;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import static delgado.luis.Autor.*;
import static delgado.luis.Editorial.*;
import static delgado.luis.Libro.*;
import static delgado.luis.Usuario.*;

public class Controlador {

    int answer;
    int SubAnswer1;
    int amount;

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static PrintStream out = System.out;

    public void start() throws IOException {
        int opcion;
        do {
            ShowMenu();
            opcion = answer;
            procesarOpcion(opcion);
        } while (opcion != 5);

    }

    public void ShowMenu() throws java.io.IOException {

        System.out.println("Por favor seleccione alguna de las siguientes opciones:");
        System.out.println("1. Administrar catalogos de datos");
        System.out.println("2. Solicitar nuevo prestamo");
        System.out.println("3. Consultar prestamos");
        System.out.println("4. Consultar todos los prestamos realizados por un usuario");
        System.out.println("4. Consultar todos los prestamos realizados de un libro");
        System.out.println("5. Salir");
        System.out.println("Ingrese el numero de la operacion que desea");
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
        System.out.println("Catalogo de autor");
        System.out.println("1. Ingresar un nuevo autor");
        System.out.println("2. Consultar datos de un autor.");
        System.out.println("3. Actualizar datos de un autor");
        System.out.println("4. Eliminar un autor");
        System.out.println("Catalogo de editorial");
        System.out.println("5. Ingresar una nueva editorial.");
        System.out.println("6. Consultar datos de una editorial.");
        System.out.println("7. Eliminar una editorial.");
        System.out.println("Catalogo de libro");
        System.out.println("8. Ingresar un nuevo libro.");
        System.out.println("9. Consultar datos de un libro.");
        System.out.println("10. Eliminar un libro.");
        System.out.println("Catalogo de usuario");
        System.out.println("11. Ingresar un nuevo usuario.");
        System.out.println("12. Consultar datos de un usuario.");
        System.out.println("13. Actualizar datos de un usuario.");
        System.out.println("14. Eliminar un usuario.");
        System.out.println("Salir del submenu y volver al menu");
        System.out.println("15. Salir del administrador de catálogos.");
        System.out.println("Ingrese el numero de la operacion que desea");
        SubAnswer1 = Integer.parseInt(in.readLine());
    }

    public void SubCatalogo(int SubOpcion) throws IOException {
        switch (SubOpcion) {
            case 1:
                NuevoAutor();
                break;
            case 2:
                ConsultarDatosAutor();
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
                ConsultarDatosEditorial();
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
                ConsultarDatosUsuario();
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
