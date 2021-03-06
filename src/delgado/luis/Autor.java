package delgado.luis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Autor {

    /*
    variables de la clase autor
     */
    public String id;
    public String nombre;
    private String pApellido;
    private String sApellido;
    private String fechaNacimiento;

    /*
    Constructor de la variable autor
     */
    public Autor(String id, String nombre, String pApellido, String sApellido, String fechaNacimiento){
        this.id = id;
        this.nombre = nombre;
        this.pApellido = pApellido;
        this.sApellido = sApellido;
        this.fechaNacimiento = fechaNacimiento;

    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getpApellido() {
        return pApellido;
    }

    public String getsApellido() {
        return sApellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /*
    Constructor para crear un autor en el arreglo de datos
     */
    public static Autor crearAutor(String id, String nombre, String pApellido, String sApellido, String fechaNacimiento){
        return new Autor(id, nombre, pApellido, sApellido, fechaNacimiento);
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", pApellido='" + pApellido + '\'' +
                ", sApellido='" + sApellido + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                '}';
    }
}
