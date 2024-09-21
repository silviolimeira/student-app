package com.sl.spring_1.adm.view.menu;

public abstract class MenuComponent {

	protected String title;

	public abstract <T> T getOption();

	public abstract <T> boolean execute(T service);


}
