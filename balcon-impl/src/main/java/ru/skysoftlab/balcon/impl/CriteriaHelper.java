package ru.skysoftlab.balcon.impl;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ru.skysoftlab.balcon.persistence.Person;

public class CriteriaHelper {

	@PersistenceContext(unitName = "balcon")
	private EntityManager em;
	
	public Person getPersonByGlobalIdentifier(UUID globalIdentifier) {
		CriteriaBuilder cBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Person> cQuery = cBuilder.createQuery(Person.class);
		Root<Person> cRoot = cQuery.from(Person.class);
		Predicate p = cBuilder.equal(cRoot.<String>get("globalIdentifier"), globalIdentifier);
		cQuery.where(p);
		try {			
			return em.createQuery(cQuery).getSingleResult();	
		} catch(NoResultException e) {
			return null;
		}		
	}
	
}
