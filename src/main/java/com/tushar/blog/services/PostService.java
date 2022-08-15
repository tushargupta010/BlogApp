package com.tushar.blog.services;

import java.util.List;

import com.tushar.blog.entities.Post;
import com.tushar.blog.payloads.PostDto;

public interface PostService {
	
	// create
	PostDto createPost(PostDto postDto, Integer postId, Integer categoryId);
	
	// update
	PostDto updatePost(PostDto postDto, Integer postId);
	
	// delete
	void deletePost(Integer postId);
	
	// get All posts
	List<PostDto> getAllPost();
	
	// get Single post
	PostDto getPostById(Integer postId);
	
	// get all posts by Category Id
	List<PostDto> getPostsByCategory(Integer categoryId);

	// get all posts by User Id
	List<PostDto> getPostsByUser(Integer userId);

	// search posts
	List<Post> searchPosts(String keyword);
	
}
