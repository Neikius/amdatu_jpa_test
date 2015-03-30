package org.neikius.test.repo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.neikius.test.repo.api.IEntry;

@Entity
@Table(name="\"ENTRY\"")
public class Entry implements IEntry {

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("{\"id\":");
		sb.append(id);
		sb.append(",\"title\":");
		sb.append(title);
		sb.append(",\"text\":");
		sb.append(text);
		sb.append("}");
		return sb.toString();
	};
	
	@Id
	@Column(name="\"ID\"")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="\"TITLE\"")
	private String title;
	
	@Lob
	@Column(name="\"TEXT\"")
	private String text;
	
	@Override
	public String getTitle() {
		return title;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
