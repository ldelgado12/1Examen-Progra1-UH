package delgado.luis;

public class Usuario {

    private String id;
    private String Nombre;
    private String pApellido;
    private String sApellido;
    private String TelefonoContacto;

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

    public static Usuario crearUsuario(String id, String nombre, String pApellido, String sApellido, String telefonoContacto){
        return new Usuario(id, nombre, pApellido, sApellido, telefonoContacto);
    }

}
