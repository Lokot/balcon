package ru.skysoftlab.balcon.impl.test;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.jboss.arquillian.testng.Arquillian;
import org.jboss.logging.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import ru.skysoftlab.balcon.impl.CriteriaHelper;
import ru.skysoftlab.balcon.impl.person.PersonAction;
import ru.skysoftlab.balcon.impl.person.SharedConstants;
import ru.skysoftlab.balcon.persistence.Person;

public class PersonActionUserTransactionTest extends Arquillian {

	private static final Logger log = Logger.getLogger(PersonActionUserTransactionTest.class);

	@PersistenceContext(unitName = "spo")
	private EntityManager em;
	
	@Inject
	private UserTransaction utx;
	
	@EJB
	private PersonAction personAction;
	
	@Inject
	private CriteriaHelper criteriaHelper;
	
	@Test	
	public void simpleTest() {						
		try {
			utx.begin();			
			
			personAction.createPerson();
			Person person = criteriaHelper.getPersonByGlobalIdentifier(SharedConstants.PERSON_UUID);		
			
			Assert.assertNotNull(person);
			Assert.assertEquals(person.getGlobalIdentifier(), SharedConstants.PERSON_UUID);
			
			utx.commit();
		} catch(SystemException | NotSupportedException | HeuristicRollbackException | 
				HeuristicMixedException | RollbackException e) {
			log.error(e.getMessage(), e);
		}		
	}
	
	
}
