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
import com.epic.epictenet.model.Post;
import com.epic.epictenet.repo.CommentRepository;
import com.epic.epictenet.repo.PostRepository;


@RestController
public class CommentController {
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/post/{postId}/comments")
	public List<Comment> getAllComments(@PathVariable (value = "postId") Long postId){
		
		return commentRepository.findByPostId(postId);
		
	}
	@PostMapping("/post/{postId}/comments")
	public  Comment createComment(@PathVariable (value = "postId") Long postId,@Valid @RequestBody Comment comment){
		Post post = postRepository.findById(postId).get();
		comment.setPost(post);
		return commentRepository.save(comment);
	}
	
	@PutMapping("/post/{postId}/comments/{commentId}")
	public Comment updateComment(@PathVariable (value = "postId") Long postId,
            @PathVariable (value = "commentId") Long commentId,
            @Valid @RequestBody Comment reqComment) {
		
		if(postRepository.existsById(postId)) {
			
			Comment comment = commentRepository.findById(commentId).get();
			comment.setText(reqComment.getText());
			comment.setActive(reqComment.getActive());
			return commentRepository.save(comment);
			
           
        }else {
        	 throw new DataNotFoundException();
        }
		
	
		
	}
	
	
	
	@PutMapping("/comments/undo/{commentId}")
	public  Comment undoComment(@PathVariable (value = "commentId") int commentId){
		 Comment comment = commentRepository.getUndoData(commentId);
		 comment.setActive(true);
		return commentRepository.save(comment);
	}

}
