package br.net.mirantecnology.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.net.mirantecnology.model.Fisica;
import br.net.mirantecnology.model.Pessoa;

public class PessoaDAO {
		
		private static PessoaDAO instance = null;
		
		protected EntityManager entityManager = null;
		
		private PessoaDAO() {
			entityManager = getEntityManager();
		}
		
		public static synchronized  PessoaDAO getInstance() {
			if (instance == null) {
				instance = new PessoaDAO();
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
		
		public Pessoa getById(final int id) {
	        return entityManager.find(Pessoa.class, id);
	      }

	      @SuppressWarnings("unchecked")
	      public List<Pessoa> findAll() {
	        return entityManager.createQuery("FROM " + Pessoa.class.getName()).getResultList();
	      }

	      public void persist(Pessoa pessoa) {
	        try {
	           entityManager.getTransaction().begin();
	           entityManager.persist(pessoa);
	           entityManager.getTransaction().commit();
	        } catch (Exception ex) {
	           ex.printStackTrace();
	           entityManager.getTransaction().rollback();
	        }
	      }

	      public void merge(Pessoa pessoa) {
	        try {
	           entityManager.getTransaction().begin();
	           entityManager.merge(pessoa);
	           entityManager.getTransaction().commit();
	        } catch (Exception ex) {
	           ex.printStackTrace();
	           entityManager.getTransaction().rollback();
	        }
	      }

	      public void remove(Pessoa pessoa) {
	        try {
	           entityManager.getTransaction().begin();
	           pessoa = entityManager.find(Pessoa.class, ((Fisica) pessoa).getId());
	           entityManager.remove(pessoa);
	           entityManager.getTransaction().commit();
	        } catch (Exception ex) {
	           ex.printStackTrace();
	           entityManager.getTransaction().rollback();
	        }
	      }

	      public void removeById(final int id) {
	        try {
	           Pessoa pessoa = getById(id);
	           remove(pessoa);
	        } catch (Exception ex) {
	           ex.printStackTrace();
	        }
	      }
	


}
