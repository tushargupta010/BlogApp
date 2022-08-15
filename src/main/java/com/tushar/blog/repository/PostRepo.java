package com.tushar.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tushar.blog.entities.Category;
import com.tushar.blog.entities.Post;
import com.tushar.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {
	
	// findBy_ methods in JPA
	List<Post> findByUser(User user);
	
	List<Post> findByCategory(Category category);

}
