package delgado.luis;

import java.util.ArrayList;
import java.util.Scanner;

public class EditorialAdministrador {

    private static Scanner scanner = new Scanner(System.in);
    private static EditorialAdministrador ediAdm = new EditorialAdministrador("1");
    private String myID;

    static ArrayList<Editorial> editoriales;

    public EditorialAdministrador(String id){
        this.myID = id;
        this.editoriales = new ArrayList<>();
    }

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

    public boolean crearEditorial(Editorial editorial){
        if (encontrarEditorial(editorial.getId())>=0) {
            System.out.println("La editorial ya existe");
            return false;
        }
        this.editoriales.add(editorial);

        return true;
    }

    public int encontrarEditorial(Editorial editorial){
        return this.editoriales.indexOf(editorial);
    }

    private int encontrarEditorial(String id){
        for (int i=0; i<this.editoriales.size(); i++){
            Editorial editorial = this.editoriales.get(i);
            if (editorial.getId().equals(id)){
                return i;
            }
        }
        return -1;
    }

    public Editorial queryEditorial(String id){
        int position = encontrarEditorial(id);
        if(position>=0){
            return this.editoriales.get(position);
        }
        return null;
    }

    public void ConsultarDatosEditorial(){

        System.out.println("Ingrese el id de la editorial que desea consultar");
        String id = scanner.nextLine();
        Editorial editorialExistente = ediAdm.queryEditorial(id);
        if (editorialExistente != null){
            System.out.println(editorialExistente);
            return;
        }
    }

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

    public String mostrarEditoriales(){
        String lineaEditorial = "";
        int iterador= 0;

        while (iterador < editoriales.size()){
            lineaEditorial = lineaEditorial + editoriales.get(iterador).getId() + " - " + editoriales.get(iterador).getNombre();
            iterador++;
        }
        return lineaEditorial;
    }

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
