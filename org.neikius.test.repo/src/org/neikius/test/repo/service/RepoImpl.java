package org.neikius.test.repo.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.sql.DataSource;

import org.amdatu.jta.ManagedTransactional;
import org.amdatu.jta.Transactional;
import org.apache.felix.dm.annotation.api.Component;
import org.apache.felix.dm.annotation.api.ServiceDependency;
import org.neikius.test.repo.api.Repo;
import org.neikius.test.repo.api.IEntry;
import org.neikius.test.repo.model.Entry;

@Component(provides = {ManagedTransactional.class})
public class RepoImpl implements Repo, ManagedTransactional {

	@ServiceDependency
	private volatile EntityManager em;
	
	@ServiceDependency(filter="(name=ManagedDS)")
	private volatile DataSource ds;
	
	@Override
	@Transactional
	public void store(String title, String text) {
		Entry post = new Entry();
		post.setTitle(title);
		post.setText(text);
		em.persist(post);
	}
	
	@Override
	public List<? extends IEntry> getEntries() {
		TypedQuery<Entry> query = em.createQuery("SELECT e FROM Entry e", Entry.class);
		
		return query.getResultList();
	}

	@Override
	public Class<?>[] getManagedInterfaces() {
		return new Class[]{Repo.class};
	}

}
