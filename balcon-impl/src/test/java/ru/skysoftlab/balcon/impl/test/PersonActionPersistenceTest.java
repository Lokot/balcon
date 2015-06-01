package ru.skysoftlab.balcon.impl.test;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.persistence.PersistenceTest;
import org.jboss.arquillian.testng.Arquillian;
import org.jboss.logging.Logger;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.testng.Assert;
import org.testng.annotations.Test;

import ru.skysoftlab.balcon.impl.CriteriaHelper;
import ru.skysoftlab.balcon.impl.person.PersonAction;
import ru.skysoftlab.balcon.impl.person.SharedConstants;
import ru.skysoftlab.balcon.persistence.Person;

@PersistenceTest
public class PersonActionPersistenceTest extends Arquillian {

	private static final Logger log = Logger.getLogger(PersonActionPersistenceTest.class);

	@PersistenceContext(unitName = "spo")
	private EntityManager em;

	@EJB
	private PersonAction personAction;

	@Inject
	private CriteriaHelper criteriaHelper;
	
	@Test	
	public void simpleTest() {
		log.trace("call method simpleTest ...");
		Assert.assertTrue(true);
		
		personAction.createPerson();
		Person person = criteriaHelper.getPersonByGlobalIdentifier(SharedConstants.PERSON_UUID);
		
		Assert.assertNotNull(person);
		Assert.assertEquals(person.getGlobalIdentifier(), SharedConstants.PERSON_UUID);
								
	}
	
	@Deployment
	public static WebArchive createWebDeployment() {
		return ShrinkWrap
				.create(WebArchive.class, "protonizer.war")
				.addClasses(Person.class, PersonAction.class, SharedConstants.class, CriteriaHelper.class)
				.addAsResource("test-persistence.xml", "META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class, "protonizer.jar")
				.addClasses(Person.class, PersonAction.class, SharedConstants.class)
				.addAsManifestResource("test-persistence.xml", "META-INF/persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	// public static EnterpriseArchive createDeployment() {
	// return ShrinkWrap.create(EnterpriseArchive.class, "protonizer.ear")
	// .addAsModule(createJavaArchive())
	// .addAsModule(createPersistenceArchive())
	// .addAsApplicationResource("persistence.xml", "META-INF/persistence.xml")
	// .addAsApplicationResource("wildfly-ds.xml")
	// .addAsApplicationResource(EmptyAsset.INSTANCE, "beans.xml");
	// }


	public static JavaArchive createPersistenceArchive() {
		return ShrinkWrap.create(JavaArchive.class).addClass(Person.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	
}
