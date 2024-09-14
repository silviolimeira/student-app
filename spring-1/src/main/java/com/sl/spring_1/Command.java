package com.sl.spring_1;

public interface Command {

	public <T> void execute(T param);
}
