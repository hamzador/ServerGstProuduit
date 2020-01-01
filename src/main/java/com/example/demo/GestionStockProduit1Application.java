package com.example.demo;


import java.util.Arrays;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.entity.Produit;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.ProduitRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.util.RoleEnum;

@SpringBootApplication//(exclude = { DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class, JdbcTemplateAutoConfiguration.class })
public class GestionStockProduit1Application {//extends SpringBootServletInitializer

	public static void main(String[] args) {
		ConfigurableApplicationContext cxt = SpringApplication.run(GestionStockProduit1Application.class, args);
		
		ProduitRepository produitRepository = cxt.getBean(ProduitRepository.class);
		
		/*produitRepository.save(new Produit("Livre", 50, 20)); 
		produitRepository.save(new Produit("Cahier", 200, 5.25f)); 
		produitRepository.save(new Produit("Stylo", 500, 2.10f)); */
		
		
		RoleRepository roleRepository = cxt.getBean(RoleRepository.class);
		Role roleUser = new Role(RoleEnum.ROLE_USER);
		Role roleAdmin = new Role(RoleEnum.ROLE_ADMIN);
		
		//roleRepository.save(roleUser);
		//roleRepository.save(roleAdmin);
		
		UserRepository userRepository = cxt.getBean(UserRepository.class);
		
		User user = new User("user", "password", true);	
		user.setRoles(Arrays.asList(roleUser));
		
		//userRepository.save(user);
		
		
		User admin = new User("admin", "password1", true);	
		admin.setRoles(Arrays.asList(roleUser, roleAdmin));
		
		//userRepository.save(admin);
	}

} 
