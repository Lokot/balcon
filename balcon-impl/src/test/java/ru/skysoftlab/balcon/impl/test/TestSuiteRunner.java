package ru.skysoftlab.balcon.impl.test;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.logging.Logger;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import ru.skysoftlab.balcon.impl.CriteriaHelper;
import ru.skysoftlab.balcon.impl.person.PersonAction;
import ru.skysoftlab.balcon.impl.person.SharedConstants;
import ru.skysoftlab.balcon.persistence.Person;

public class TestSuiteRunner {
	
	private static final Logger log = Logger.getLogger(TestSuiteRunner.class);
	
	@BeforeSuite
	public void beforeSuite() {
		log.trace("call beforeSuite ...");		
	}

	@AfterSuite
	public void afterSuite() {
		log.trace("call afterSuite ...");
	}
	
	@Deployment
	public static WebArchive createWebDeployment() {
		return ShrinkWrap
				.create(WebArchive.class, "protonizer.war")
				.addClasses(Person.class, PersonAction.class, SharedConstants.class, CriteriaHelper.class)
				.addAsResource("test-persistence.xml", "META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	
}
