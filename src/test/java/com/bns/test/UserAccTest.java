package com.bns.test;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bns.models.UserAcc;
import com.bns.models.security.Role;
import com.bns.models.security.UserRole;
import com.bns.service.UserService;
import com.bns.utility.SecurityUtility;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserAccTest {


	 @Autowired
	 private UserService userService;
	@Test
 	 public void findByUserNameTest() {
		UserAcc user4 = userService.findByUsername("j");
        assertThat(user4.getUsername()).isEqualTo("j");
		
	}
	@Test
	 public void findByEmailTest() {
		UserAcc user3 = userService.findByUsername("JAdams@gmail.com");
       assertThat(user3.getEmail()).isEqualTo("JAdams@gmail.com");
		
	}
	@Test
	 public void createUserAccTest() throws Exception {
		         
		          UserAcc user5 = new  UserAcc();
					user5.setFirstName("honest");
					user5.setLastName("test");
					user5.setUsername("ki");
					user5.setPhone("3476666706");
					user5.setPassword(SecurityUtility.passwordEncoder().encode("b"));
					user5.setEmail("hon@gmail.com");
					Set<UserRole> userRoles = new HashSet<>();
					Role role1= new Role();
					role1.setRoleId(1);
					role1.setName("ROLE_USER");
					userRoles.add(new UserRole(user5, role1));
					
					userService.createUser(user5, userRoles);
					UserAcc user = userService.findByUsername("ki");
			        assertThat(user.getUsername()).isEqualTo("ki");
	 }  
	 @Test
	 public void saveTest()
	 {
	 
		 UserAcc user2 = new  UserAcc();
			user2.setFirstName("test");
			user2.setLastName("test1");
			user2.setUsername("t");
			user2.setPhone("3476666666");
			user2.setPassword(SecurityUtility.passwordEncoder().encode("b"));
			user2.setEmail("test@gmail.com");
			Set<UserRole> userRoles = new HashSet<>();
			Role role2= new Role();
			role2.setRoleId(1);
			role2.setName("ROLE_USER");
			userRoles.add(new UserRole(user2, role2));
			userService.save(user2);
			UserAcc user = userService.findByUsername("t");
	        assertThat(user.getUsername()).isEqualTo("t");

	 }
	 
	 @Test
	 public void createPasswordResetForUserTest()
	 {
			UserAcc user6 = new  UserAcc();
			user6.setFirstName("test6");
			user6.setLastName("test6");
			user6.setUsername("tt");
			user6.setPhone("3476666666");
			user6.setPassword(SecurityUtility.passwordEncoder().encode("g"));
			user6.setEmail("test6@gmail.com");
			Set<UserRole> userRoles = new HashSet<>();
			Role role2= new Role();
			role2.setRoleId(1);
			role2.setName("ROLE_USER");
			userRoles.add(new UserRole(user6, role2));
			userService.save(user6);

			UserAcc user = userService.findByUsername("tt");
	        assertThat(user.getPassword()).isEqualTo(SecurityUtility.passwordEncoder().encode("g"));
	 }
	
	 @Test
	 public void getPasswordResetTokenTest() throws Exception
	 {
		 
		 UserAcc user7 = new  UserAcc();
			user7.setFirstName("test7");
			user7.setLastName("test7");
			user7.setUsername("tt7");
			user7.setPhone("3479996666");
			user7.setPassword(SecurityUtility.passwordEncoder().encode("g"));
			user7.setEmail("test7@gmail.com");
		 Role role = new Role();
			role.setRoleId(1);
			role.setName("ROLE_USER");
			Set<UserRole> userRoles = new HashSet<>();
			userRoles.add(new UserRole(user7, role));
			userService.createUser(user7, userRoles);
			
			String token = UUID.randomUUID().toString();
			userService.createPasswordResetTokenForUser(user7, token);
			UserAcc user = userService.findByUsername("tt7");
	        assertThat(user.getPassword()).isEqualTo(SecurityUtility.passwordEncoder().encode("g"));
	 }
}
