package com.learn.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;


@Component
public class UserDaoService {
		
	private static List<User> users = new ArrayList<>();

	private static int userId = 0;

	static {
		users.add(new User(++userId, "Dat", LocalDate.now().minusYears(30)));
		users.add(new User(++userId, "Nam", LocalDate.now().minusYears(25)));
		users.add(new User(++userId, "Nam2", LocalDate.now().minusYears(65)));
	}

	public User save(User user){
		user.setId(++userId);
		users.add(user);
		return user;
	}

	public List<User> findAll() {
		return users;
	}

	public User findOne(int id){
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
	}

	public void deleteById(int id){
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
	}

}
