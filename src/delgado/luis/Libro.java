package delgado.luis;

public class Libro {

    /*
    variables presentes en la clase de libro
     */
    public String id;
    public Autor autor;
    private String fechaPublicacion;
    private String edicion;
    private String titulo;
    public Editorial editorial;
    private int copias;

    /*
    contructor por defecto de la clase libro, esta asigna todas las variables presentes en la clase
     */

    public Libro(String id, Autor autor, String fechaPublicacion, String edicion, String titulo, Editorial editorial, int copias) {
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

    public Integer getCopias() {
        return copias;
    }

    /*
    constructor utilizado para crear un libro, esta clase utiliza todas las variables presentes en la clase
     */
    public static Libro crearLibro(String id, Autor autor, String fechaPublicacion, String edicion, String titulo, Editorial editorial, int copias){
        return new Libro(id, autor, fechaPublicacion, edicion, titulo, editorial, copias);
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id='" + id + '\'' +
                ", autor=" + autor +
                ", fechaPublicacion='" + fechaPublicacion + '\'' +
                ", edicion='" + edicion + '\'' +
                ", titulo='" + titulo + '\'' +
                ", editorial=" + editorial +
                ", copias='" + copias + '\'' +
                '}';
    }
}
