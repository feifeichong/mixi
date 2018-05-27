package com.lecotec.mixi.controller;

import com.lecotec.mixi.model.entity.Comment;
import com.lecotec.mixi.model.parameter.CommentParam;
import com.lecotec.mixi.model.parameter.PageParam;
import com.lecotec.mixi.model.response.BootstrapTableResult;
import com.lecotec.mixi.model.response.ResponseObject;
import com.lecotec.mixi.model.response.SuccessResponse;
import com.lecotec.mixi.service.CommentService;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api(tags = "评论接口")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/api/customer/comment")
    public ResponseObject saveOrUpdate(@Valid @RequestBody CommentParam commentParam) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentParam, comment);
        return new SuccessResponse(commentService.saveOrUpdate(comment));
    }

    @GetMapping("/api/merchant/comment/searchByParam")
    public BootstrapTableResult<Comment> searchByParam(PageParam pageParam) {
        Page<Comment> pageResult = commentService.searchByParam(pageParam);
        return new BootstrapTableResult<>(pageResult.getTotalElements(), pageResult.getContent());
    }

    @PutMapping("/api/merchant/comment/changeActiveStatus")
    public ResponseObject changeActiveStatus(long id, boolean isShow) {
        return new SuccessResponse(commentService.changeActiveStatus(id, isShow));
    }

    @DeleteMapping("/api/merchant/comment/{id}")
    public ResponseObject deleteComment(@PathVariable("id") long id) {
        return new SuccessResponse(commentService.deleteComment(id));
    }
}
