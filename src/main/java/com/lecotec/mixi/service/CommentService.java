package com.lecotec.mixi.service;

import com.lecotec.mixi.model.entity.Comment;
import com.lecotec.mixi.model.parameter.PageParam;
import com.lecotec.mixi.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Comment saveOrUpdate(Comment comment) {
        return commentRepository.save(comment);
    }

    public Page<Comment> searchByParam(PageParam pageParam) {
        return commentRepository.findAll(PageRequest.of(pageParam.getPageNumber(), pageParam.getPageSize()));
    }

    public boolean deleteComment(long id) {
        commentRepository.deleteById(id);
        return true;
    }

    public boolean changeActiveStatus(long id, boolean isShow) {
        return commentRepository.changeActiveStatus(id, isShow) > 0;
    }
}
