package com.epic.epictenet.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epic.epictenet.exception.DataNotFoundException;
import com.epic.epictenet.model.Post;
import com.epic.epictenet.repo.CommentRepository;
import com.epic.epictenet.repo.LikeRepository;
import com.epic.epictenet.repo.PostRepository;

@RestController

public class PostController {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private LikeRepository likeRepository;
	
	@GetMapping("/post")
	public List<Post> getAllPost(){
		
		return postRepository.findAll();
		
	 }
	
	@PostMapping("/post")
	public Post createPost(@Valid @RequestBody Post post)
	{
		return postRepository.save(post);
		
	}
	
	@GetMapping("/post/{postId}/count")
	public Post getCounts(@PathVariable Long postId){
		if(postRepository.existsById(postId)) {
		Post post  = postRepository.findById(postId).get();
		post.setCommentCounts(commentRepository.countByPostId(postId));
		post.setLikeCounts(likeRepository.countByPostId(postId));
		return post;
		}else {
			throw new DataNotFoundException();
		}
		
	 }
	
	@PutMapping("/post/{postid}")
	public Post updatePost(@PathVariable int postId, @Valid @RequestBody Post postReq) {
		
	Post post = postRepository.getUndoData(postId);
	post.setTitle(postReq.getTitle());
	post.setContent(postReq.getContent());
	post.setDescription(postReq.getDescription());
	post.setActive(postReq.getActive());
	return postRepository.save(post);
		
	}
	
	
	
	
	

}
