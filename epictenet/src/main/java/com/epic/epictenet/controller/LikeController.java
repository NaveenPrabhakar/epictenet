package com.epic.epictenet.controller;

import java.util.List;

import javax.persistence.PostRemove;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epic.epictenet.exception.DataNotFoundException;
import com.epic.epictenet.model.Comment;
import com.epic.epictenet.model.Lyke;
import com.epic.epictenet.model.Post;
import com.epic.epictenet.repo.CommentRepository;
import com.epic.epictenet.repo.LikeRepository;
import com.epic.epictenet.repo.PostRepository;


@RestController
public class LikeController {
	
	@Autowired
	private LikeRepository likeRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/post/{postId}/like")
	public List<Lyke> getAllComments(@PathVariable (value = "postId") Long postId){
		
		return likeRepository.findByPostId(postId);
	}
	
	@PostMapping("/post/{postId}/like")
	public  Lyke createComment(@PathVariable (value = "postId") Long postId,@Valid @RequestBody Lyke like){
		Post post = postRepository.findById(postId).get();
		like.setPost(post);
		return likeRepository.save(like);
	}
	
	@PutMapping("/like/del/{likeId}")
	public Lyke deleteLike(@PathVariable (value = "likeId") int likeId) {
		
		Lyke like  = likeRepository.findById(likeId).get();
		like.setActive(false);
		return likeRepository.save(like);
	}
	
	@PutMapping("/like/undo/{likeId}")
	public Lyke undoLike(@PathVariable (value = "likeId") int likeId) {
		
		Lyke like  = likeRepository.getUndoData(likeId);
		like.setActive(true);
		return likeRepository.save(like);
	}
	
	
	
	

}
