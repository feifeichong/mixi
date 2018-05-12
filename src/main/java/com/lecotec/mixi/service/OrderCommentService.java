package com.lecotec.mixi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lecotec.mixi.model.entity.Comment;
import com.lecotec.mixi.repository.OrderCommentRepository;

@Service
public class OrderCommentService {

	@Autowired
	private OrderCommentRepository orderCommentRepository;
	
	public Comment saveComment(Comment comment) {
		return orderCommentRepository.save(comment);
	}
}
