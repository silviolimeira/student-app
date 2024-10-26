package com.sl.app.rest.data;

/**
 * DTO class for example 1, fetching using a DTO.
 */
public class StatusDTO {

	private int id;
	private String name;
	private String title;

	public StatusDTO() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "StatusDTO{" +
				"id=" + id +
				", name='" + name + '\'' +
				", title='" + title + '\'' +
				'}';
	}
}
