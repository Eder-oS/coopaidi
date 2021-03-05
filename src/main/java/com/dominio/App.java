package com.dominio;

import com.dominio.models.Autor;
import com.dominio.utils.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class App {
    public static void main( String[] args )
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();


        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Autor> cq = criteriaBuilder.createQuery(Autor.class);
        Root<Autor> root = cq.from(Autor.class);

        List<Autor> autors = session.createQuery(cq).list();



//        CriteriaBuilder builder = session.getCriteriaBuilder();
//
//        CriteriaQuery<Departamento> cq = builder.createQuery(Departamento.class);
////        Root<Departamento> root = cq.from(Departamento.class);
//
//        List<Departamento> list = session.createQuery(cq).list();
        session.getTransaction().commit();
        session.close();
        HibernateUtil.shutdown();
    }
}
