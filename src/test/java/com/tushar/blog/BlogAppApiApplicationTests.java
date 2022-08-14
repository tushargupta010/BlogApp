package com.tushar.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tushar.blog.repository.UserRepo;

@SpringBootTest
class BlogAppApiApplicationTests {

	@Autowired
	private UserRepo userRepo;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void userRepoTest() {
		String userRepoImplementedClassName = this.userRepo.getClass().getName();
		String userRepoImplementedClassPackageName = this.userRepo.getClass().getPackageName();
		System.out.println("userRepoImplementedClassName : " + userRepoImplementedClassName);
		System.out.println("userRepoImplementedClassPackageName : " + userRepoImplementedClassPackageName);
		
		// classes built at runtime for Repositories and we generally lnown as Proxy classes
		// userRepoImplementedClassName : jdk.proxy2.$Proxy101
		// userRepoImplementedClassPackageName : jdk.proxy2
	}

}
