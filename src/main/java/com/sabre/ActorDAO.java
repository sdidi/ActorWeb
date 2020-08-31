package com.sabre;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class ActorDAO implements Dao<Actor> {
	private static ActorDAO instance;
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ActorWeb");

	private ActorDAO() {}
	
	public static ActorDAO getInstance() {
		if(instance == null) {
			instance = new ActorDAO();
		}
		return instance;
	}
	/*
	 * @PersistenceUnit(unitName="ActorsApp") EntityManager em;
	 */

	EntityManager em; //= emf.createEntityManager();

	public List<Actor> getActors() {
		em = emf.createEntityManager();
		String strQuery = "SELECT a FROM Actor a WHERE a.id IS NOT NULL";
		if (em == null) {
			List list = new ArrayList();
			list.add(new Actor(000, "Test", "Test"));
			return list;

		}
		TypedQuery<Actor> ta = em.createQuery(strQuery, Actor.class);
		List<Actor> actors;

		try {
			actors = ta.getResultList();
				return actors;
		} catch (NoResultException ex) {
			System.out.println("ex");
			return null;
		} finally {
			//em.close();

		}

	}

	/*
	 * public List getAll() { return em.createNamedQuery("Actor.findAll",
	 * Actor.class).getResultList(); }
	 */

	public Actor findById(int id) {
		em = emf.createEntityManager();
		return em.find(Actor.class, id);
	}

	public void update(Actor actor) {
		em = emf.createEntityManager();
		em.merge(actor);
	}

	public void create(Actor actor) {
		em = emf.createEntityManager();
		em.persist(actor);
	}

	public void delete(Actor actor) {
		em = emf.createEntityManager();
		if (!em.contains(actor)) {
			actor = em.merge(actor);
		}

		em.remove(actor);
	}

}