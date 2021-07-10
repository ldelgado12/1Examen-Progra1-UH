package delgado.luis;

public class Prestamo {

    /*
    variables de la clase de prestamo
     */
    private String id;
    private Usuario usuarioSolicitante;
    private Libro libroSolicitado;
    private String fechaSolicitada;
    private String fechaDevolucion;

    /*
    constructor de la clase prestamo, asignando cada uno de los valores de la clase
     */
    public Prestamo(String id, Usuario usuarioSolicitante, Libro libroSolicitado, String fechaSolicitada, String fechaDevolucion) {
        this.id = id;
        this.usuarioSolicitante = usuarioSolicitante;
        this.libroSolicitado = libroSolicitado;
        this.fechaSolicitada = fechaSolicitada;
        this.fechaDevolucion = fechaDevolucion;
    }

    /*
    constructor por defecto para la variable del id
     */
    public Prestamo(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Usuario getUsuarioSolicitante() {
        return usuarioSolicitante;
    }

    public Libro getLibroSolicitado() {
        return libroSolicitado;
    }

    public String getFechaSolicitada() {
        return fechaSolicitada;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    /*
    contructor para crear un nuevo prestamo, este constructor utiliza todas las variables presentes en la clase
     */
    public static Prestamo crearPrestamo(String id, Usuario usuarioSolicitante, Libro libroSolicitado, String fechaSolicitada, String fechaDevolucion){
        return new Prestamo(id, usuarioSolicitante, libroSolicitado, fechaSolicitada, fechaDevolucion);
    }

    /*
    contructor para crear un nuevo id, este constructor utiliza solo la variable id del prestamo
     */
    public static Prestamo crearID(String id){
        return new Prestamo(id);
    }

}
