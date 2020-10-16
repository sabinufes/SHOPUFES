package com.ufes;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ufes.domain.User;
import com.ufes.domain.security.Role;
import com.ufes.domain.security.UserRole;
import com.ufes.service.UserService;
import com.ufes.utility.SecurityUtility;

@SpringBootApplication
public class ShopUfesApplication implements CommandLineRunner {
	
	
	@Autowired
	
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ShopUfesApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		User user1= new User();
		user1.setFirstName("Sabin");
		user1.setLastName("Dumitrache");
		user1.setUsername("sabinufes");
		user1.setPassword(SecurityUtility.passowrdEncoder()
				.encode("p"));
		user1.setEmail("dumitrachesabin@gmail.com");
		Set<UserRole> userRoles = new HashSet<>();
		Role role1 = new Role();
		role1.setRoleId(1);
		role1.setName("ROLE_USER");
		userRoles.add(new UserRole(user1, role1));
		
		userService.createUser(user1, userRoles);
	}

}
