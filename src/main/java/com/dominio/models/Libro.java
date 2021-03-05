package com.dominio.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToMany
    @JoinTable(name = "libro_autor",
            joinColumns = {@JoinColumn(name = "fk_book")},
            inverseJoinColumns = {@JoinColumn(name = "fk_autor")})
    private List<Autor> autors = new ArrayList<>();

    @Column
    private String titulo;

    @Column
    private int paginas;

    @Column
    private String ano;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Autor> getAutors() {
        return autors;
    }

    public void setAutors(List<Autor> autors) {
        this.autors = autors;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
}
