package delgado.luis;

import java.util.ArrayList;
import java.util.Scanner;

public class LibroAdministrador {

    private static Scanner scanner = new Scanner(System.in);
    private static LibroAdministrador libroAdm = new LibroAdministrador("12");
    private static AutorAdministrador autorAdm = new AutorAdministrador("1");
    private static EditorialAdministrador editorialAdm = new EditorialAdministrador("1");

    private String id;
    private ArrayList<Libro> libros;

    public LibroAdministrador(String id){
        this.id = id;
        this.libros = new ArrayList<Libro>();
    }

    public static void NuevoLibro(){
        System.out.println("Ingrese el id del Libro");
        String id = scanner.nextLine();


        System.out.println("Ingrese el autor del libro");
        System.out.println(autorAdm.mostrarAutores());
        System.out.println("ingrese el id correspondiente al autor del libro");
        int IdAutor = scanner.nextInt();
        Autor posibleAutor = autorAdm.ListaAutor(IdAutor);

        System.out.println("Ingrese la fecha de publicacion");
        String fechaPublicacion = scanner.nextLine();
        System.out.println("Ingrese la edicion del libro");
        String edicion = scanner.nextLine();
        System.out.println("Ingrese el titulo del libro");
        String titulo = scanner.nextLine();


        System.out.println("Ingrese la editrial del libro");
        System.out.println(editorialAdm.mostrarEditoriales());
        System.out.println("ingrese el id correspondiente a la editorial del libro");
        int IdEditorial = scanner.nextInt();
        Editorial posibleEditorial = editorialAdm.ListaEditorial(IdEditorial);


        System.out.println("Ingrese la cantidad de copias del libro");
        String copias = scanner.nextLine();

        Libro newLibro = Libro.crearLibro(id, posibleAutor, fechaPublicacion, edicion, titulo, posibleEditorial, copias);

        if(libroAdm.crearLibro(newLibro)){
            System.out.println("Nuevo libro id: " + id+ " fue agregado con exito");
        }else {
            System.out.println("El libro ya existe");
        }

    }

    public boolean crearLibro(Libro libro){
        if(encontrarLibro(libro.getId())>=0){
            System.out.println("Libro ya existe");
            return false;
        }
        libros.add(libro);
        return true;
    }

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

    public Libro queryLibro(String id){
        int position = encontrarLibro(id);
        if(position>=0){
            return this.libros.get(position);
        }
        return null;
    }


    public void ConsultarDatosLibro(){

        System.out.println("Ingrese el id de un libro que desea consultar");
        String id = scanner.nextLine();
        Libro libroExistente = libroAdm.queryLibro(id);
        if (libroExistente != null){
            System.out.println(libroExistente);
            return;
        }
    }

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
}