package ru.skysoftlab.balcon.impl.person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

import ru.skysoftlab.balcon.persistence.Person;

@Stateless
public class PersonAction {
	
	private static final Logger log = Logger.getLogger(PersonAction.class);
	
	@PersistenceContext(unitName = "balcon")
	private EntityManager em;
	
	public void createPerson() {
		log.trace("call method createPerson() of PersonAction ...");
		
		Person person = new Person();
		//person.setGlobalIdentifier(SharedConstants.PERSON_UUID);
		person.setFirstName("Ivan");
		person.setLastName("Ivanov");
		person.setMiddleName("Ivanovich-1111");
		
		em.persist(person);
		
		log.debugf("person.globalIdentifier = %d", person.getGlobalIdentifier());
		
		log.debugf("person.id = %d", person.getId());
		log.trace("finish method createPerson()");
	}

}
