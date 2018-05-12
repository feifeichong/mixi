package com.lecotec.mixi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lecotec.mixi.model.entity.Comment;
import com.lecotec.mixi.model.response.ResponseObject;
import com.lecotec.mixi.model.response.SuccessResponse;
import com.lecotec.mixi.service.OrderCommentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/comment")
@Api(value = "/api/comment",tags = "订单评论")
public class OrderCommentController {
	
	@Autowired
	private OrderCommentService orderCommentService;

	@PostMapping
	@ApiOperation("订单评论接口")
	@ApiImplicitParam(name = "saveComment",value = "订单评论", required = true, dataType = "Comment")
	public ResponseObject saveComment(@RequestBody Comment comment) {
		return new SuccessResponse(orderCommentService.saveComment(comment));
	}
}
