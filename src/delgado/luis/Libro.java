package delgado.luis;

public class Libro {

    private String id;
    private Autor autor;
    private String fechaPublicacion;
    private String edicion;
    private String titulo;
    private Editorial editorial;
    private String copias;

    public Libro(String id, Autor autor, String fechaPublicacion, String edicion, String titulo, Editorial editorial, String copias) {
        this.id = id;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.edicion = edicion;
        this.titulo = titulo;
        this.editorial = editorial;
        this.copias = copias;
    }

    public String getId() {
        return id;
    }

    public Autor getAutor() {
        return autor;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public String getEdicion() {
        return edicion;
    }

    public String getTitulo() {
        return titulo;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public String getCopias() {
        return copias;
    }

    public static Libro crearLibro(String id, Autor autor, String fechaPublicacion, String edicion, String titulo, Editorial editorial, String copias){
        return new Libro(id, autor, fechaPublicacion, edicion, titulo, editorial, copias);
    }

}
