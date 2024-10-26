package com.sl.api.admin.service;

import java.util.List;

public interface AppService {

	public <T> T save(T t);
	public <T> List<T> findAll();
	
}
