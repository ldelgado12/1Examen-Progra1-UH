package delgado.luis;

public class Editorial {

    /*
    variables presentes en la clase editorial
     */

    public String id;
    public String nombre;
    private String ubicacion;
    private String telefonoContacto;

    /*
    Constructor de la clase editorial, asigna todas las variables presentes en la clase
     */

    public Editorial(String id, String nombre, String ubicacion, String telefonoContacto){
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.telefonoContacto = telefonoContacto;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    /*
    contructor para crear una editorial, utiliza todas las variables presentes en la clase editorial
     */
    public static Editorial crearEditorial(String id, String nombre, String ubicacion, String telefonoContacto){
        return new Editorial(id, nombre, ubicacion, telefonoContacto);
    }

}
