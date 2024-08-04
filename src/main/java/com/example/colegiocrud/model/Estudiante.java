package com.example.colegiocrud.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String genero;
    private String direccion;
    private String telefono;
    private String correoElectronico;
    private String grado;
    private LocalDate fechaInscripcion;


    public Estudiante() {}

    public Estudiante(String nombre, String apellido, LocalDate fechaNacimiento, String genero, String direccion, 
                      String telefono, String correoElectronico, String grado, LocalDate fechaInscripcion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.grado = grado;
        this.fechaInscripcion = fechaInscripcion;
    }

}
