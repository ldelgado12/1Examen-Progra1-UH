package delgado.luis;

import java.util.ArrayList;
import java.util.Scanner;

public class PrestamoAdministrador {

    private static Scanner scanner = new Scanner(System.in);
    private static PrestamoAdministrador prestaAdm = new PrestamoAdministrador("1");
    private static UsuarioAdministrador usuarioAdm = new UsuarioAdministrador("1");
    private static LibroAdministrador libroAdm = new LibroAdministrador("1");


    private String id;
    static ArrayList<Prestamo> prestamos;

    public PrestamoAdministrador(String id){
        this.id = id;
        this.prestamos = new ArrayList<Prestamo>();
    }

    public static void NuevoPrestamo(){
        System.out.println("Ingrese el id del nuevo prestamo");
        String id =  scanner.nextLine();

        Prestamo nuevoID = Prestamo.crearID(id);
        if(prestaAdm.crearID(nuevoID)){
            scanner.nextLine();
            System.out.println("Revise la siguiente lista de usuarios");
            usuarioAdm.listarUsuarios();
            System.out.println("Ingrese el id correspondiente a algun usuario");
            int idUsuario = scanner.nextInt();
            Usuario posibleUsuario = usuarioAdm.ListaUsuario(idUsuario);

            scanner.nextLine();
            System.out.println("Revise la siguiente lista de libros");
            //libroAdm.existenLibros()
            libroAdm.listarLibros();
            System.out.println("Ingrese el id correspondiente al libro");
            int idLibro = scanner.nextInt();
            Libro posibleLibro = libroAdm.ListaLibro(idLibro);

            scanner.nextLine();
            System.out.println(" ");
            System.out.println("Ingrese fecha de inicio del prestamo");
            String fechaInicio = scanner.nextLine();
            System.out.println("Ingrese fecha final del prestamo (Debe de ser mayor a la fecha de inicio)");
            String fechaFinal = scanner.nextLine();

            Prestamo newPrestamo = Prestamo.crearPrestamo(id, posibleUsuario, posibleLibro, fechaInicio, fechaFinal);

            if (prestaAdm.crearPrestamo(newPrestamo)){
                libroAdm.ActualizarLibro(idLibro);
                System.out.println("Nuevo prestamo generado con exito");
            }else {
                System.out.println("prestamo no se pudo efectuar");
            }

        }else {
            System.out.println("El id del prestamo ya existe");
        }

    }

    public static void FinalizarPrestamo(){
        System.out.println("A continuacion se le mostraran los usuarios con prestamo :");
        listarPrestamo();
        System.out.println("Ingrese el id del prestamo que desea finalizar");
        int IdDevolver = scanner.nextInt();
        ActualizarLibro(prestaAdm.actPrestamo(IdDevolver));
//        Prestamo devolverPrestamo = prestaAdm.ListaPrestamo(IdDevolver);




    }

    public static void ConsultarPrestamosUsuario(){
        System.out.println("Contact list:");
        for(int i=0; i< prestamos.size(); i++){
            System.out.println((i+1)+"."
                    + "-> "+
                    prestamos.get(i).getUsuarioSolicitante() + " Prestamo-> "+
                    prestamos.get(i).getId());
        }
    }

    public static void ConsultarPrestamosLibro(){
        System.out.println("Contact list:");
        for(int i=0; i< prestamos.size(); i++){
            System.out.println((i+1)+"."
                    + "-> "+
                    prestamos.get(i).getLibroSolicitado() + " Prestamo-> "+
                    prestamos.get(i).getId());
        }
    }

    public static void ActualizarLibro(int id){
        for(int i =0; i<libroAdm.libros.size();i++){
            Libro libro = libroAdm.libros.get(i);
            if(libro.getId().equals(id)){
                String Actid = libro.getId();
                String ActFechaPublicacion = libro.getFechaPublicacion();
                int Actcopias = libroAdm.actCopias(id);
                String ActEdicion = libro.getEdicion();
                String Acttitulo = libro.getTitulo();
                Autor ActAutor = libro.getAutor();
                Editorial ActEditorial = libro.getEditorial();

                Libro ActLibro = Libro.crearLibro(Actid, ActAutor, ActFechaPublicacion, ActEdicion, Acttitulo, ActEditorial, Actcopias);
                libroAdm.libros.add(ActLibro);

            }
        }


    }

    public int actPrestamo(int id){
        for(int i =0; i< libroAdm.libros.size();i++){
            Libro libro = libroAdm.libros.get(i);
            if(libro.getId().equals(id)){
                int copiasActual = (libro.getCopias()+1);
                return copiasActual;
            }

        }
        return 0;
    }

//    public Prestamo ListaPrestamo (int id){
//        boolean existe = false;
//        Prestamo prestamo = null;
//        int iterador = 0;
//
//        while (!existe && iterador < prestamos.size()){
//            if (prestamos.get(iterador).getId().equals(id)){
//                existe = true;
//                prestamo = prestamos.get(iterador);
//            }
//            iterador++;
//        }
//        return prestamo;
//    }

    public static void listarPrestamo(){

        System.out.println("Lista de prestamos:");
        for(int i=0; i< prestamos.size(); i++){
            System.out.println((i+1)+"."
                    + "-> "+
                    prestamos.get(i).getId());
                    prestamos.get(i).getUsuarioSolicitante();
        }
    }

    public boolean crearPrestamo(Prestamo prestamo){
        if (encontrarPrestamo(prestamo.getId())>=0){
            System.out.println("Prestamo no se puede generar");
            return false;
        }
        prestamos.add(prestamo);
        return true;
    }

    public int encontrarPrestamo(Prestamo prestamo){
        return prestamos.indexOf(prestamo);
    }

    public int encontrarPrestamo(String id){
        for(int i =0; i<this.prestamos.size();i++){
            Prestamo prestamo = this.prestamos.get(i);
            if(prestamo.getId().equals(id)){
                return i;
            }
        }
        return -1;
    }

    public boolean crearID(Prestamo prestamo){
        if (encontrarPrestamo(prestamo.getId())>=0){
            System.out.println("Prestamo ya existe");
            return false;
        }
        return true;
    }

//    private int encontrarID(String id){
//        for (int i=0; i<this.prestamos.size(); i++){
//            Prestamo prestamo = this.prestamos.get(i);
//            if (prestamo.getId().equals(id)){
//                return i;
//            }
//        }
//        return -1;
//    }



}
