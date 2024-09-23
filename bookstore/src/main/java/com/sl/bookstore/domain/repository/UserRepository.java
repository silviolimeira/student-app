package com.sl.bookstore.domain.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.sl.bookstore.domain.entity.User;
import com.sl.bookstore.domain.entity.UserId;

public class UserRepository {

	static List<User> users;
	
	public UserRepository() {
		users = new ArrayList<>();
	}
	
	public static void initialize() {
		users.add(new User(new UserId(1),"Silvio", "silvio@gmail.com"));
		users.add(new User(new UserId(2),"Marqui", "marqui@gmail.com"));
		users.add(new User(new UserId(3),"MarCesar", "cesar@gmail.com"));
		users.add(new User(new UserId(4),"Limeira", "limeira@www.com"));
	}
	
	public static List<String> filter() {
		UserRepository ur = new UserRepository();
		ur.initialize();
		String[] names = { "Lim", "Mar" };
		List<String> filters = ur.users.stream()
				.map(u -> u)
				.filter(u -> {
					return u.getId().getInteger() > 2;
				})
				.filter(u -> {
					return Arrays.stream(names)
						.anyMatch(u.getName()::contains);
				})
//				.filter(u -> {
//					return u.getName().startsWith("Lim");
//				})
				.map(u -> u.getId().getValue())
				.collect(Collectors.toList());
		return filters;
		
	}
}
