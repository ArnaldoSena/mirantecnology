package br.net.mirantecnology.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.net.mirantecnology.model.Telefone;

public class TelefoneDao {
	
	private static TelefoneDao instance = null;
	
	protected EntityManager entityManager = null;
	
	private TelefoneDao() {
		entityManager = getEntityManager();
	}
	
	public static synchronized  TelefoneDao getInstance() {
		if (instance == null) {
			instance = new TelefoneDao();
		}
		return instance;
	}
	
	private EntityManager getEntityManager() {
		if(entityManager == null) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("mirantecnology");
			entityManager = emf.createEntityManager();
		}
		return entityManager;
	}
	
	public Telefone getById(final int id) {
        return entityManager.find(Telefone.class, id);
      }

      @SuppressWarnings("unchecked")
      public List<Telefone> findAll() {
        return entityManager.createQuery("FROM " + 
        Telefone.class.getName()).getResultList();
      }

      public void persist(Telefone telefone) {
        try {
           entityManager.getTransaction().begin();
           entityManager.persist(telefone);
           entityManager.getTransaction().commit();
        } catch (Exception ex) {
           ex.printStackTrace();
           entityManager.getTransaction().rollback();
        }
      }

      public void merge(Telefone telefone) {
        try {
           entityManager.getTransaction().begin();
           entityManager.merge(telefone);
           entityManager.getTransaction().commit();
        } catch (Exception ex) {
           ex.printStackTrace();
           entityManager.getTransaction().rollback();
        }
      }

      public void remove(Telefone telefone) {
        try {
           entityManager.getTransaction().begin();
           telefone = entityManager.find(Telefone.class, telefone.getId());
           entityManager.remove(telefone);
           entityManager.getTransaction().commit();
        } catch (Exception ex) {
           ex.printStackTrace();
           entityManager.getTransaction().rollback();
        }
      }

      public void removeById(final int id) {
        try {
           Telefone telefone = getById(id);
           remove(telefone);
        } catch (Exception ex) {
           ex.printStackTrace();
        }
      }
}
