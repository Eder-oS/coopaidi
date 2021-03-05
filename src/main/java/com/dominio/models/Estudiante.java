package com.dominio.models;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
public class Estudiante {
    @Id
    @Column(name = "estudiante_tbl")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fk_departamento", nullable = false)
    private Departamento departamento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
