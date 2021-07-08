package delgado.luis;

public class Prestamo {

    private String id;
    private Usuario usuarioSolicitante;
    private Libro libroSolicitado;
    private String fechaSolicitada;
    private String fechaDevolucion;

    public Prestamo(String id, Usuario usuarioSolicitante, Libro libroSolicitado, String fechaSolicitada, String fechaDevolucion) {
        this.id = id;
        this.usuarioSolicitante = usuarioSolicitante;
        this.libroSolicitado = libroSolicitado;
        this.fechaSolicitada = fechaSolicitada;
        this.fechaDevolucion = fechaDevolucion;
    }

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

    public static Prestamo crearPrestamo(String id, Usuario usuarioSolicitante, Libro libroSolicitado, String fechaSolicitada, String fechaDevolucion){
        return new Prestamo(id, usuarioSolicitante, libroSolicitado, fechaSolicitada, fechaDevolucion);
    }

    public static Prestamo crearID(String id){
        return new Prestamo(id);
    }

}
