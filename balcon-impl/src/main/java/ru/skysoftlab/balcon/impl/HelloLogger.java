package ru.skysoftlab.balcon.impl;

import org.jboss.logging.BasicLogger;
import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;
import org.jboss.logging.annotations.LogMessage;
import org.jboss.logging.annotations.Message;
import org.jboss.logging.annotations.MessageLogger;

@MessageLogger(projectCode = "PROTONIZER")
public interface HelloLogger extends BasicLogger {

	HelloLogger LOGGER = Logger.getMessageLogger(HelloLogger.class, HelloLogger.class.getPackage().getName());
	
	@LogMessage(level = Level.INFO)
	@Message(id = 1, value = "Hello World !!!")
	void sayHello();
	
	@LogMessage(level = Level.DEBUG)
	@Message(id = 2, value = "start new conversation with id = %s")
	void startConversation(Integer cid);	

	@LogMessage(level = Level.ERROR)
	@Message(id = 3, value = "Не задан обязательный параметр = %s !")
	void emptyRequiredParameter(String paramName);	

	@LogMessage(level = Level.ERROR)
	@Message(id = 4, value = "Очень очень длинное и невыносимое сообщение об ошибке, "
			+ "которое не влезает в одну строку кода и "
			+ "переносится на другие строки.")
	void veryLongMessage();
	
	@LogMessage(level = Level.INFO)
	@Message(id = 5, value = "Всего персон = %s")
	void printPersonsSize(Integer size);		

	@LogMessage(level = Level.INFO)
	@Message(id = 6, value = "�?мя = %s, Фамилия = %s")
	void printPerson(String firstName, String lastName);		
	
}
