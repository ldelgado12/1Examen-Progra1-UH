package delgado.luis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AutorAdministrador {


    private static Scanner scanner = new Scanner(System.in);
    private String myID;
    private static AutorAdministrador autorAdm = new AutorAdministrador("12");

    public ArrayList<Autor> autores;

    public AutorAdministrador(String id) {
        this.myID = id;
        this.autores = new ArrayList<Autor>();
    }

    public static void NuevoAutor() throws IOException {
        System.out.println("Ingrese el id del autor");
        String id = scanner.nextLine();
        System.out.println("Ingrese el nombre del autor");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el primer apellido del autor");
        String pApellido = scanner.nextLine();;
        System.out.println("Ingrese el segundo apellido del autor");
        String sApellido = scanner.nextLine();
        System.out.println("Ingrese la fecha de nacimiento del autor");
        String fechaNacimiento = scanner.nextLine();
        Autor newAutor = Autor.crearAutor(id, nombre, pApellido, sApellido, fechaNacimiento);


        if(autorAdm.crearAutor(newAutor)){
            System.out.println("Nuevo autor id: " + id + " Con el nombre " + nombre+" primer apellido " + pApellido+ " segundo apellido " +sApellido+ " nacido en "+ fechaNacimiento+" Fue agregado con exito" );
        }else {
            System.out.println("El autor ya se encuentra en el archivo");
        }

    }


    public boolean crearAutor(Autor autor){
        if (encontrarAutor(autor.getId())>=0) {
            System.out.println("Autor ya existe");
            return false;
        }
        this.autores.add(autor);

        return true;
    }

    public int encontrarAutor(Autor autor){
        return this.autores.indexOf(autor);
    }

    private int encontrarAutor(String id){
        for (int i=0; i<this.autores.size(); i++){
            Autor autor = this.autores.get(i);
            if (autor.getId().equals(id)){
                return i;
            }
        }
        return -1;
    }

    public String queryAutor(Autor autor){
        if (encontrarAutor(autor)>=0){
            return autor.getNombre();
        }
        return null;
    }

    public Autor queryAutor(String id){
        int position = encontrarAutor(id);
        if(position>=0){
            return this.autores.get(position);
        }
        return null;
    }


    public void ConsultarDatosAutor(){
        System.out.println("Lista de datos de los autores");

        for(int i=0; i<autores.size(); i++){
            System.out.println((i+1)+"."
                    + this.autores.get(i).getId() + "-> "+
                    this.autores.get(i).getNombre() + "-> "+
                    this.autores.get(i).getpApellido() + "-> "+
                    this.autores.get(i).getsApellido() + "-> "+
                    this.autores.get(i).getFechaNacimiento());
        }
    }

    public static void ActualizarAutor(){
        System.out.println("Ingrese el id de un contacto existente");
        String id = scanner.nextLine();
        Autor autorExistente = autorAdm.queryAutor(id);
        if (autorExistente == null){
            System.out.println("Autor no encontrado.");
            return;
        }

        System.out.println("Ingrese el nuevo id de un contacto existente");
        String nuevoId = scanner.nextLine();
        System.out.println("Ingrese el nuevo nombre del autor");
        String nuevoNombre = scanner.nextLine();
        System.out.println("Ingrese el nuevo primer apellido del autor");
        String nuevopApellido = scanner.nextLine();;
        System.out.println("Ingrese el nuevo segundo apellido del autor");
        String nuevosApellido = scanner.nextLine();
        System.out.println("Actualice la fecha de nacimiento");
        String nuevoFechaNacimiento = scanner.nextLine();
        Autor newAutor = Autor.crearAutor(nuevoId,nuevoNombre,nuevopApellido,nuevosApellido,nuevoFechaNacimiento );

        if(autorAdm.updateAutor(autorExistente, newAutor)){
            System.out.println("Actualizacion exitosa");
        }else {
            System.out.println("Error al momento de actualizar");
        }
    }


    public boolean updateAutor(Autor oldAutor, Autor newAutor){
        int foundPosition = encontrarAutor(oldAutor);
        if(foundPosition<0){
            System.out.println(oldAutor.getId() + ", no fue encontrado");
            return false;
        }else if (encontrarAutor(newAutor.getId()) != -1){
            System.out.println("Autor con el nuevo id" + newAutor.getId()+
                    "Ya existe, la actualizacion no se pudo efectuar");
            return false;
        }
        this.autores.set(foundPosition, newAutor);
        System.out.println("El antiguo id "+ oldAutor.getId() + ", fue cambiado por " + newAutor.getId());
        return true;
    }



    public static void EliminarAutor(){
        System.out.println("Ingrese el id del Autor que desea eliminar");
        String id = scanner.nextLine();
        Autor autorExistente = autorAdm.queryAutor(id);

        if (autorExistente == null) {
            System.out.println("Contact not found.");
            return;
        }
        if (autorAdm.removerAutor(autorExistente)){
            System.out.println("Successfully deleted");
        }else {
            System.out.println("Error deleting contact");
        }

    }

    public boolean removerAutor(Autor autor){
        int posicion = encontrarAutor(autor);
        if(posicion < 0){
            System.out.println(autor.getId() + "no fue encontrado");
            return false;
        }
        this.autores.remove(posicion);
        System.out.println(autor.getId() + ", fue eliminado");
        return true;

    }



}
