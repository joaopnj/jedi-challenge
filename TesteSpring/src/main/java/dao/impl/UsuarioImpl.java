/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.IUsuario;
import java.util.List;
import model.Usuario;
import org.hibernate.Session;
import org.springframework.ui.ModelMap;
import utils.HibernateUtil;

/**
 *
 * @author Joao_Jardim
 */
public class UsuarioImpl implements IUsuario{
    
    private Session session;
    
    @Override
    public void cadastrar(Usuario usuario) {
        session=HibernateUtil.getSessionFactory().openSession(); 

        session.beginTransaction().begin();
        session.save(usuario);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List listar(Usuario usuario) {
        session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction().begin();
        List usuarios = session.createQuery("from usuario").list(); 
        session.getTransaction().commit();
        session.close();
        return usuarios;
    }

    @Override
    public void atualizar(Usuario usuario) {
        session=HibernateUtil.getSessionFactory().openSession(); 

        session.beginTransaction().begin();
        session.update(usuario);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deletar(Long id) {
        session=HibernateUtil.getSessionFactory().openSession(); 
        
        session.beginTransaction().begin();
        Usuario usuario = (Usuario)session.load(Usuario.class, id);
        session.getTransaction().commit();
        session.close();
    }

    public Iterable<Usuario> listar(ModelMap model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
