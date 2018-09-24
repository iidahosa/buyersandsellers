package com.bns;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bns.models.UserAcc;
import com.bns.models.security.Role;
import com.bns.models.security.UserRole;
import com.bns.service.UserService;
import com.bns.utility.SecurityUtility;


@SpringBootApplication
public class BuyersAndSellersApplication implements CommandLineRunner{
	@Autowired
	private UserService userService;
	public static void main(String[] args) {
		
		SpringApplication.run(BuyersAndSellersApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
	
		   UserAcc user1 = new  UserAcc();
					user1.setFirstName("Johnnny");
					user1.setLastName("Ada");
					user1.setUsername("jo");
					user1.setPhone("3476836902");
					user1.setPassword(SecurityUtility.passwordEncoder().encode("p"));
					user1.setEmail("JAjohnns@gmail.com");
					Set<UserRole> userRoles = new HashSet<>();
					Role role1= new Role();
					role1.setRoleId(1);
					role1.setName("ROLE_USER");
					userRoles.add(new UserRole(user1, role1));
					
					userService.createUser(user1, userRoles);
	
	
	
	}
}
