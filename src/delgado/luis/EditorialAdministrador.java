package delgado.luis;

import java.util.ArrayList;
import java.util.Scanner;

public class EditorialAdministrador {

    private static Scanner scanner = new Scanner(System.in);
    private static EditorialAdministrador ediAdm = new EditorialAdministrador("1");
    private String myID;

    /*
    Arreglo de datos de la clase editorial
     */
    static ArrayList<Editorial> editoriales;

    /*
    Contructor de la clase del editorial administrador
     */
    public EditorialAdministrador(String id){
        this.myID = id;
        this.editoriales = new ArrayList<>();
    }

    /*
    funcion para crear un nuevo editorial, esta clase se va a conectar con el constructor de crear editorial en la clase
    luego anade la informacion al arreglo
     */
    public static void NuevaEditorial(){
        System.out.println("Ingrese el id de la editorial");
        String id = scanner.nextLine();
        System.out.println("Ingrese el nombre de la editorial");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese la ubicacion de la editorial");
        String ubicacion = scanner.nextLine();;
        System.out.println("Ingrese el telefono de la editorial");
        String telefono = scanner.nextLine();
        Editorial newEditorial = Editorial.crearEditorial(id, nombre, ubicacion, telefono);

        if(ediAdm.crearEditorial(newEditorial)){
            System.out.println("Nueva editorial id: " + id + " fue agregada" );
        }else {
            System.out.println("El autor ya se encuentra en el archivo");
        }
    }

    /*
    esta funcion valida si ya existe una editorial con el mismo id en el arreglo
     */
    public boolean crearEditorial(Editorial editorial){
        if (encontrarEditorial(editorial.getId())>=0) {
            System.out.println("La editorial ya existe");
            return false;
        }
        this.editoriales.add(editorial);

        return true;
    }

    /*
    esta funcion va a validar la cantidad de datos guardados en el arreglo
     */
    public int encontrarEditorial(Editorial editorial){
        return this.editoriales.indexOf(editorial);
    }

    /*
    esta funcion va a validar y devolver la ubicacion del id de la editorial dentro de la lista de arreglos
     */
    private int encontrarEditorial(String id){
        for (int i=0; i<this.editoriales.size(); i++){
            Editorial editorial = this.editoriales.get(i);
            if (editorial.getId().equals(id)){
                return i;
            }
        }
        return -1;
    }

    /*
    esta funcion va a devolver la ubicacion exacta del id de una editorial dentro de un arreglo
     */
    public Editorial queryEditorial(String id){
        int position = encontrarEditorial(id);
        if(position>=0){
            return this.editoriales.get(position);
        }
        return null;
    }

    /*
    con esta funcion se puede verificar toda la informacion de una editorial tomando como referencia el id que se incluya en el programa
     */
    public void ConsultarDatosEditorial(){

        System.out.println("Ingrese el id de la editorial que desea consultar");
        String id = scanner.nextLine();
        Editorial editorialExistente = ediAdm.queryEditorial(id);
        if (editorialExistente != null){
            System.out.println(editorialExistente);
            return;
        }
    }

    /*
    funcion para eliminar los datos de un arreglo, mediante un id
     */
    public static void EliminarEditorial(){
        System.out.println("Ingrese el id de la editorial que desea eliminar");
        String id = scanner.nextLine();
        Editorial editorialExistente= ediAdm.queryEditorial(id);

        if (editorialExistente == null) {
            System.out.println("Contact not found.");
            return;
        }
        if (ediAdm.removerEditorial(editorialExistente)){
            System.out.println("Successfully deleted");
        }else {
            System.out.println("Error deleting contact");
        }
    }

    /*
    funcion utilizada en el eliminar una editorial, validando si el usuario existe dentro del arreglo o no
     */
    public boolean removerEditorial(Editorial editorial){
        int posicion = encontrarEditorial(editorial);
        if(posicion < 0){
            System.out.println(editorial.getId() + "no fue encontrado");
            return false;
        }
        this.editoriales.remove(posicion);
        System.out.println(editorial.getId() + ", fue eliminado");
        return true;
    }

    /*
    muestra en pantalla todas las editoriales junto con el id y nombre
     */
    public String mostrarEditoriales(){
        String lineaEditorial = "";
        int iterador= 0;

        while (iterador < editoriales.size()){
            lineaEditorial = lineaEditorial + editoriales.get(iterador).getId() + " - " + editoriales.get(iterador).getNombre();
            iterador++;
        }
        return lineaEditorial;
    }

    /*
    funcion utilizada en la clase de editorial para asignar editoriales mediante una lista
     */
    public Editorial ListaEditorial (int id){
        boolean existe = false;
        Editorial editorial = null;
        int iterador = 0;

        while (!existe && iterador < editoriales.size()){
            if (editoriales.get(iterador).getId().equals(id)){
                existe = true;
                editorial = editoriales.get(iterador)

                ;
            }
            iterador++;
        }
        return editorial;
    }



}
