
package DTO;

import java.time.LocalDate;

public class Persona {
    private String nombre1, nombre2, apellido1, apellido2, mensajeCumpleaños;
    private LocalDate fecha;
    private int edad;

    public Persona() {
    }

    public Persona(String nombre1, String nombre2, String apellido1, String apellido2, LocalDate fecha, int edad, String mensajeCumpleaños) {
        setNombre1(nombre1);
        setNombre2(nombre2);
        setApellido1(apellido1);
        setApellido2(apellido2);
        setFecha(fecha);
        setEdad(edad);
        setMensajeCumpleaños(mensajeCumpleaños);
    }
    
    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getMensajeCumpleaños() {
        return mensajeCumpleaños;
    }

    public void setMensajeCumpleaños(String mensajeCumpleaños) {
        this.mensajeCumpleaños = mensajeCumpleaños;
    }
    
    
}
