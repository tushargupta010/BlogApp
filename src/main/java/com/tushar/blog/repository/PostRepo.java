package com.tushar.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tushar.blog.entities.Category;
import com.tushar.blog.entities.Post;
import com.tushar.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {
	
	// findBy_ methods in JPA
	List<Post> findByUser(User user);
	
	List<Post> findByCategory(Category category);
	
	//List<Post> findByTitleContaining(String title);
	//OR
	@Query("select p from Post p where p.title like :key")
	List<Post> searchByTitle(@Param("key") String title);
	
}
