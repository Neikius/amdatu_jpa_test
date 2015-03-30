package org.neikius.test.tester;

import org.apache.felix.dm.annotation.api.Component;
import org.apache.felix.dm.annotation.api.Property;
import org.apache.felix.dm.annotation.api.ServiceDependency;
import org.apache.felix.service.command.CommandProcessor;
import org.neikius.test.repo.api.Repo;

@Component(properties = {
		@Property(name = CommandProcessor.COMMAND_SCOPE, value = "test"),
		@Property(name = CommandProcessor.COMMAND_FUNCTION, values = {"store", "show"})
	}, provides=Object.class)
public class TestRepo {
	 
	@ServiceDependency
	private Repo repo;
	
	public void store(String title, String text) {
		repo.store(title, text);
	}
	
	public void show() {
		repo.getEntries().forEach(System.out::println);
	}
}
