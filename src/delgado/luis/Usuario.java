package delgado.luis;

public class Usuario {

    /*
    variables de la clase usuario
     */
    public String id;
    public String Nombre;
    private String pApellido;
    private String sApellido;
    private String TelefonoContacto;

    /*
    constructor de la clase usuario
     */
    public Usuario(String id, String nombre, String pApellido, String sApellido, String telefonoContacto) {
        this.id = id;
        this.Nombre = nombre;
        this.pApellido = pApellido;
        this.sApellido = sApellido;
        this.TelefonoContacto = telefonoContacto;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getpApellido() {
        return pApellido;
    }

    public String getsApellido() {
        return sApellido;
    }

    public String getTelefonoContacto() {
        return TelefonoContacto;
    }

    /*
    constructor para crear un usuario en la el arreglo de los usuarios
     */
    public static Usuario crearUsuario(String id, String nombre, String pApellido, String sApellido, String telefonoContacto){
        return new Usuario(id, nombre, pApellido, sApellido, telefonoContacto);
    }

}
