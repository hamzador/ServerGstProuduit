package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Comment;
import com.example.demo.repository.CommentRepository;
import com.example.demo.service.ICrudService;

@Service
@Primary
public class CommentService implements ICrudService<Comment, Long>{

	@Autowired
	private CommentRepository commentRepository;
	
	@Override
	public List<Comment> getAll() {
		return commentRepository.findAll();
	}

	@Override
	public void add(Comment comment) {
		commentRepository.save(comment);
	}

	@Override
	public void update(Comment comment) {
		commentRepository.save(comment);
	}


	@Override
	public void saveAll(Iterable<Comment> iterable) {
		commentRepository.saveAll(iterable);
	}

	@Override
	public void delet(Long id) {
		Comment comment = new Comment();
		comment.setId(id);
		commentRepository.delete(comment);
		
	}


}
