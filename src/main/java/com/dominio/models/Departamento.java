package com.dominio.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String nombre;

    @OneToMany(mappedBy = "departamento")
    private List<Estudiante> estudianteList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Estudiante> getEstudianteList() {
        return estudianteList;
    }

    public void setEstudianteList(List<Estudiante> estudianteList) {
        this.estudianteList = estudianteList;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", estudianteList=" + estudianteList +
                '}';
    }
}
