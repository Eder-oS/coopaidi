package com.dominio.models;

import com.dominio.utils.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.*;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String celular;

    @ManyToMany(mappedBy = "autors")
    private List<Libro> libros = new ArrayList<>();

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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public Autor save(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(this);
        session.getTransaction().commit();
        session.close();
        HibernateUtil.shutdown();
        return this;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", celular='" + celular + '\'' +
                ", libros=" + libros +
                '}';
    }
    public static class Query{
        public static Autor getAutor(Long id) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Autor autor = session.get(Autor.class, id);
            session.getTransaction().commit();
            session.close();
            HibernateUtil.shutdown();
            return autor;
        }
    }
}
