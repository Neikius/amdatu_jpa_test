package org.neikius.test.repo.api;

import java.util.List;

import org.neikius.test.repo.model.Entry;

public interface Repo {

	public List<? extends IEntry> getEntries();
	public void store(String title, String text);
}
