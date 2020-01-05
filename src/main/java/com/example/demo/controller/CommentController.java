package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Comment;
import com.example.demo.repository.CommentRepository;



@RestController
@RequestMapping("/api/comments")
@CrossOrigin("*")
public class CommentController extends CrudController<Comment, Long>{
	
	//@Autowired
	//private CommentRepository repository;
	
	//@GetMapping                         
	public  List<Comment> getAll(){
		List <Comment> comments =super.getAll();
		return comments;
	}
	
	


}
