package com.system.model.dao;

import com.system.model.dto.UsuarioDTO;
import com.system.model.entities.Usuario;
import com.system.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    public void crear(UsuarioDTO dto){
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = sesion.getTransaction();
        try{
            transaction.begin();
            sesion.save(dto.getEntidad());
            transaction.commit();
        }catch (HibernateException he){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
        }

    }
    public void update(UsuarioDTO dto){
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = sesion.getTransaction();
        try{
            transaction.begin();
            sesion.update(dto.getEntidad());
            transaction.commit();
        }catch(HibernateException he){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
        }
    }
    public void delete(UsuarioDTO dto){
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = sesion.getTransaction();
        try{
            transaction.begin();
            sesion.delete(dto.getEntidad());
            transaction.commit();
        }catch(HibernateException he){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
        }
    }
    public UsuarioDTO read(UsuarioDTO dto){
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = sesion.getTransaction();
        try{
            transaction.begin();
            dto.setEntidad(sesion.get(dto.getEntidad().getClass(),dto.getEntidad().getIdUsuario()));
            transaction.commit();

        }catch(HibernateException he){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
        }
        return dto;
    }
    public List readAll(){
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = sesion.getTransaction();
        List lista = new ArrayList();
        try{
            transaction.begin();
            Query q = sesion.createQuery("from Usuario u order by u.idUsuario");
            for(Usuario u : (List<Usuario>) q.list()){
                UsuarioDTO dto = new UsuarioDTO();
                dto.setEntidad(u);
                lista.add(dto);
            }
            transaction.commit();

        }catch(HibernateException he){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
        }
        return lista;
    }
    public UsuarioDTO search(UsuarioDTO dto){
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = sesion.getTransaction();
        List lista = new ArrayList();
        try{
            transaction.begin();
            Query q = sesion.createQuery("from Usuario u where u.userName = :userName and u.pass = :pass ");
            q.setParameter("userName",dto.getEntidad().getUserName());
            q.setParameter("pass",dto.getEntidad().getPass());
            if(q.getResultList().isEmpty()){
                transaction.commit();
                return null;
            }
            dto.setEntidad((Usuario) q.getSingleResult());
            transaction.commit();
            return dto;

        }catch(HibernateException he){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
        }
        return null;
    }
}
