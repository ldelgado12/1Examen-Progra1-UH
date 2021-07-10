package delgado.luis;

import java.util.ArrayList;
import java.util.Scanner;

public class LibroAdministrador {

    private static Scanner scanner = new Scanner(System.in);
    private static LibroAdministrador libroAdm = new LibroAdministrador("12");
    private static AutorAdministrador autorAdm = new AutorAdministrador("1");
    private static EditorialAdministrador editorialAdm = new EditorialAdministrador("1");

    private String id;
    static ArrayList<Libro> libros;

    public LibroAdministrador(String id){
        this.id = id;
        this.libros = new ArrayList<Libro>();
    }

    /*
    Funcion en la que se incluye un nuevo libro, esta va a solicitar los datos necesarios para el libro

     */

    public static void NuevoLibro(){
        System.out.println("Ingrese el id del Libro");
        String id = scanner.nextLine();
        System.out.println("Ingrese la fecha de publicacion");
        String fechaPublicacion = scanner.nextLine();
        System.out.println("Ingrese la cantidad de copias del libro");
        int copias = scanner.nextInt();
        System.out.println("Ingrese la edicion del libro");
        String edicion = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Ingrese el titulo del libro");
        String titulo = scanner.nextLine();
        System.out.print(" ");

        /*
        para ingresar nuevos autores, va a imprimir una lista actual de autores para luego asignar el valor necesario
         */

        scanner.nextLine();
        System.out.println("Ingrese el autor del libro");
        autorAdm.listarAutores();
        //System.out.println(autorAdm.mostrarAutores());
        System.out.println("ingrese el id correspondiente al autor del libro");
        int IdAutor = scanner.nextInt();
        Autor posibleAutor = autorAdm.ListaAutor(IdAutor);

        System.out.print("");

        scanner.nextLine();
        System.out.println("Ingrese la editrial del libro");
        System.out.println(editorialAdm.mostrarEditoriales());
        System.out.println("ingrese el id correspondiente a la editorial del libro");
        int IdEditorial = scanner.nextInt();
        Editorial posibleEditorial = editorialAdm.ListaEditorial(IdEditorial);

        System.out.print("");


        Libro newLibro = Libro.crearLibro(id, posibleAutor, fechaPublicacion, edicion, titulo, posibleEditorial, copias);

        if(libroAdm.crearLibro(newLibro)){
            System.out.println("Nuevo libro id: " + id+ " fue agregado con exito");
        }else {
            System.out.println("El libro ya existe");
        }



    }


    /*
    funcion para actualizar el arreglo de datos del libro, esta funcion se efectua automaticamente al momento de generar un prestamo
     */

    public static void ActualizarLibro(int id){
        for(int i =0; i<libros.size();i++){
            Libro libro = libros.get(i);
            if(libro.getId().equals(id)){
                String Actid = libro.getId();
                String ActFechaPublicacion = libro.getFechaPublicacion();
                int Actcopias = libroAdm.actCopias(id);
                String ActEdicion = libro.getEdicion();
                String Acttitulo = libro.getTitulo();
                Autor ActAutor = libro.getAutor();
                Editorial ActEditorial = libro.getEditorial();

                Libro ActLibro = Libro.crearLibro(Actid, ActAutor, ActFechaPublicacion, ActEdicion, Acttitulo, ActEditorial, Actcopias);
                libros.add(ActLibro);

            }
        }


    }

    /*
    esta funcion actualiza la cantidad de copias que pertenece a un libro al momento del prestamo, funcion necesaria para efectual la funcion ActualizarLibro()
     */

    public int actCopias(int id){
        for(int i =0; i<this.libros.size();i++){
            Libro libro = this.libros.get(i);
            if(libro.getId().equals(id)){
                int copiasActual = (libro.getCopias()-1);
                return copiasActual;
            }
        }
        return 0;
    }

    public int devolverCopias(int id){
        for(int i =0; i<this.libros.size();i++){
            Libro libro = this.libros.get(i);
            if(libro.getId().equals(id)){
                int copiasActual = (libro.getCopias()-1);
                return copiasActual;
            }
        }
        return 0;
    }

    /*
    funcion que devuelve la ubicacion correcta para encontrar un libro en el arreglo de libros
     */

    public Libro queryLibro(String id){
        int position = encontrarLibro(id);
        if(position>=0){
            return this.libros.get(position);
        }
        return null;
    }

    /*
    funcion para verificar si el id del libro creado ya existe, en caso positivo retorna un msj indicandolo
     */
    public boolean crearLibro(Libro libro){
        if(encontrarLibro(libro.getId())>=0){
            System.out.println("Libro ya existe");
            return false;
        }
        libros.add(libro);
        return true;
    }

    /*
    funcion con el indexOf este retornada un valor mayor a 0, indicando si encontro un libro en el arreglo, funcion necesaria para la funcion de remover
     */
    public int encontrarLibro(Libro libro){
        return this.libros.indexOf(libro);
    }

    public int encontrarLibro(String id){
        for(int i =0; i<this.libros.size();i++){
            Libro libro = this.libros.get(i);
            if(libro.getId().equals(id)){
                return i;
            }
        }
        return -1;
    }


    /*
    funcion de consultar los datos de un libro, esta funcion retornada los datos asociados a un id de libro en especifico
     */

    public void ConsultarDatosLibro(){

        System.out.println("Ingrese el id de un libro que desea consultar");
        String id = scanner.nextLine();
        Libro libroExistente = libroAdm.queryLibro(id);
        if (libroExistente != null){
            System.out.println(libroExistente);
            return;
        }
    }

    /*
    funcion para eliminar un libro, consultando el del libro y en caso positivo de que exista,
    el libro sera eliminado o mostrara un msj indicando que no se encontro el libro
     */

    public static void EliminarLibro(){
        System.out.println("Ingrese el id del libro que desea eliminar");
        String id = scanner.nextLine();
        Libro libroExistente = libroAdm.queryLibro(id);

        if (libroExistente == null) {
            System.out.println("Libro no encontrado.");
            return;
        }
        if (libroAdm.removerLibro(libroExistente)){
            System.out.println("Exitosamente eliminado");
        }else {
            System.out.println("Error al momento de eliminar el contact");
        }

    }

    public boolean existenLibros(Libro libro) {
        int posicion = encontrarLibro(libro);
        if (posicion < 0) {
            System.out.println(libro.getId() + "para crear prestamos debe de existir libros previos");
            return false;
        }
        return true;
    }

    /*
    funcion necesaria para efectual la eliminacion de un libro, esta funcion es llamada en la funcion EliminarLibro()
     */
    public boolean removerLibro(Libro libro){
        int posicion = encontrarLibro(libro);
        if(posicion < 0){
            System.out.println(libro.getId() + "no fue encontrado");
            return false;
        }
        this.libros.remove(posicion);
        System.out.println(libro.getId() + ", fue eliminado");
        return true;

    }

    /*
    esta funcion entrega el titulo del libro y la cantidad de copias asociadas, esta funcion es necesaria para efectuar los prestamos
     */

    public static void listarLibros(){
        System.out.println("Lista de libros:");
        for(int i=0; i< libros.size(); i++){
            System.out.println((i+1)+"."
                    + "-> "+
                    libros.get(i).getTitulo() + " copias " +
                    libros.get(i).getCopias());
        }
    }

    /*
    Funcion para listar libros, esta funcion es necesaria para efectuar los prestamos
     */

    public Libro ListaLibro (int id){
        boolean existe = false;
        Libro libro = null;
        int iterador = 0;

        while (!existe && iterador < libros.size()){
            if (libros.get(iterador).getId().equals(id)){
                existe = true;
                libro = libros.get(iterador);
            }
            iterador++;
        }
        return libro;
    }
}
