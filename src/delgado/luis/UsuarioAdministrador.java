package delgado.luis;

import java.util.ArrayList;
import java.util.Scanner;

public class UsuarioAdministrador {

    private static Scanner scanner = new Scanner(System.in);
    private static UsuarioAdministrador usuarioAdm = new UsuarioAdministrador("1");

    private String id;

    /*
    Arreglo de datos de la clase de usuario
     */
    static ArrayList<Usuario> usuarios;

    /*
    Contructor de la clase del usuario de administrador
     */
    public UsuarioAdministrador(String id){
        this.id = id;
        this.usuarios = new ArrayList<Usuario>();
    }

    /*
    funcion para crear un usuario, esta clase se va a conectar con el constructor de crear usuario en la clase
    luego anade la informacion al arreglo
     */
    public static void NuevoUsuario(){
        System.out.println("Ingrese el id del usuario");
        String id = scanner.nextLine();
        System.out.println("Ingrese el nombre del usuario");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el primer apellido del usuario");
        String pApellido = scanner.nextLine();;
        System.out.println("Ingrese el segundo apellido del usuario");
        String sApellido = scanner.nextLine();
        System.out.println("Ingrese el telefono de contacto del usuario");
        String telefonoContacto = scanner.nextLine();
        Usuario newUsuario = Usuario.crearUsuario(id, nombre, pApellido, sApellido, telefonoContacto);


        if(usuarioAdm.crearUsuario(newUsuario)){
            System.out.println("Nuevo autor id: " + id + " Con el nombre " + nombre+" primer apellido " + pApellido+ " segundo apellido " +sApellido+ " Fue agregado con exito" );
        }else {
            System.out.println("El autor ya se encuentra en el archivo");
        }
    }

    /*
    esta funcion valida si ya existe un usuario con el mismo id en el arreglo
     */
    public boolean crearUsuario(Usuario usuario){
        if (encontrarUsuario(usuario.getId())>=0){
            System.out.println("Usuario ya existe");
            return false;
        }
        usuarios.add(usuario);
        return true;
    }

    /*
    esta funcion va a validar la cantidad de datos guardados en el arreglo
     */
    public int encontrarUsuario(Usuario usuario){
        return this.usuarios.indexOf(usuario);
    }

    /*
    esta funcion va a validar y devolver la ubicacion del id de un usuario dentro de la lista de arreglos
     */
    private int encontrarUsuario(String id){
        for (int i=0; i<this.usuarios.size(); i++){
            Usuario usuario = this.usuarios.get(i);
            if (usuario.getId().equals(id)){
                return i;
            }
        }
        return -1;
    }

    public String queryUsuario(Usuario usuario){
        if (encontrarUsuario(usuario)>=0){
            return usuario.getNombre();
        }
        return null;
    }

    /*
    esta funcion va a devolver la ubicacion exacta del id de un usuario dentro de un arreglo
     */
    public Usuario queryUsuario(String id){
        int position = encontrarUsuario(id);
        if(position>=0){
            return this.usuarios.get(position);
        }
        return null;
    }

    /*
    con esta funcion se puede verificar toda la informacion de un usuario tomando como referencia el id que se incluya en el programa
     */
    public  void ConsultarDatosUsuario(){

        System.out.println("Ingrese el id del usuario que desea consultar");
        String id = scanner.nextLine();
        Usuario usuarioExistente = usuarioAdm.queryUsuario(id);
        if (usuarioExistente != null){
            System.out.println(usuarioExistente);
            return;
        }
    }

    /*
    con esta funcion se puede actualizar toda la informacion de un usuario
    se busca con el id y luego de incluir la data, se agrega al arreglo de datos
     */
    public static void ActualizarUsuario(){
        System.out.println("Ingrese el id de un usuario existente");
        String id = scanner.nextLine();
        Usuario usuarioExistente = usuarioAdm.queryUsuario(id);
        if (usuarioExistente == null){
            System.out.println("Usuario no encontrado.");
            return;
        }
        System.out.println("Ingrese el nuevo id del Usuario");
        String nuevoID = scanner.nextLine();
        System.out.println("Ingrese el nuevo nombre del Usuario");
        String nuevoNombre = scanner.nextLine();
        System.out.println("Ingrese el nuevo primer apellido del Usuario");
        String nuevopApellido = scanner.nextLine();;
        System.out.println("Ingrese el nuevo segundo apellido del Usuario");
        String nuevosApellido = scanner.nextLine();
        System.out.println("Actualice telefono de contacto");
        String nuevoTelefonoContacto = scanner.nextLine();
        Usuario newUsuario = Usuario.crearUsuario(nuevoID, nuevoNombre, nuevopApellido, nuevosApellido, nuevoTelefonoContacto);

        if(usuarioAdm.updateUsuario(usuarioExistente, newUsuario)){
            System.out.println("Actualizacion exitosa");
        }else {
            System.out.println("Error al momento de actualizar");
        }
    }

    /*
    esta funcion se aplica en el arreglo de actualizar, verifica si el nuevo id ya existe, y sino, lo agrega en el arreglo
     */
    public boolean updateUsuario(Usuario oldUsuario, Usuario newUsuario){
        int foundPosition = encontrarUsuario(oldUsuario);
        if(foundPosition<0){
            System.out.println(oldUsuario.getId()+ " no fue encontrado");
            return false;
        }else if(encontrarUsuario(newUsuario.getId()) != -1){
            System.out.println("Usuario con el id " + newUsuario.getId() +
                    "Ya existe, la actualizacion no se pudo efectuar");
            return false;
        }
        this.usuarios.set(foundPosition, newUsuario);
        System.out.println("El antiguo id "+ oldUsuario.getId() + " fue cambiado por" +
                newUsuario.getId());
        return true;
    }

    /*
    funcion para eliminar los datos de un arreglo, mediante un id
     */
    public static void EliminarUsuario(){
        System.out.println("Ingrese el id del usuario que desea eliminar");
        String id = scanner.nextLine();
        Usuario usuarioExistente = usuarioAdm.queryUsuario(id);

        if (usuarioExistente == null){
            System.out.println("Usuario no encontrado");
            return;
        }
        if (usuarioAdm.removerUsuario(usuarioExistente)){
            System.out.println("Exitosamente eliminado");
        }else {
            System.out.println("Error al momento de eliminar el usuario");
        }
    }

    /*
    funcion utilizada en el eliminar usuario, validando si el usuario existe dentro del arreglo o no
     */
    public boolean removerUsuario(Usuario usuario){
        int posicion = encontrarUsuario(usuario);
        if (posicion<0){
            System.out.println(usuario.getId() + " no fue encontrado");
            return false;
        }
        this.usuarios.remove(posicion);
        System.out.println(usuario.getId() + " fue eliminado");
        return true;
    }

    /*
    funcion que entrega toda la lista de informacion dentro del arreglo de usuarios
     */
    public static void listarUsuarios(){

        System.out.println("Lista de usuarios:");
        for(int i=0; i< usuarios.size(); i++){
            System.out.println((i+1)+"."
                    + "-> "+
                    usuarios.get(i).getNombre());
        }
    }

    /*
    funcion utilizada en la clase de prestamo para asignar usuarios mediante una lista
     */
    public Usuario ListaUsuario (int id){
        boolean existe = false;
        Usuario usuario = null;
        int iterador = 0;

        while (!existe && iterador < usuarios.size()){
            if (usuarios.get(iterador).getId().equals(id)){
                existe = true;
                usuario = usuarios.get(iterador);
            }
            iterador++;
        }
        return usuario;
    }

}
