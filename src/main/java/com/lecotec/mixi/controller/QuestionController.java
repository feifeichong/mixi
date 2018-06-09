package com.lecotec.mixi.controller;

import com.lecotec.mixi.model.entity.Question;
import com.lecotec.mixi.model.parameter.QuestionSearchParam;
import com.lecotec.mixi.model.response.BootstrapTableResult;
import com.lecotec.mixi.model.response.ResponseObject;
import com.lecotec.mixi.model.response.SuccessResponse;
import com.lecotec.mixi.service.QuestionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api(tags = "培训考试接口")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping("/api/merchant/question")
    public ResponseObject saveOrUpdate(@Valid @RequestBody Question question) {
        return new SuccessResponse(questionService.saveOrUpdate(question));
    }

    @GetMapping("/api/merchant/question/searchForConsole")
    public BootstrapTableResult<Question> searchForConsole(QuestionSearchParam questionSearchParam) {
        Page<Question> result = questionService.searchForConsole(questionSearchParam);
        return new BootstrapTableResult<>(result.getTotalElements(), result.getContent());
    }

    @DeleteMapping("/api/merchant/question/{id}")
    public ResponseObject deleteById(@PathVariable("id") long id) {
        return new SuccessResponse(questionService.deleteById(id));
    }

    @PostMapping("/api/merchant/question/deleteBatch")
    public ResponseObject deleteBatch(@RequestBody long[] ids) {
        return new SuccessResponse(questionService.deleteBatch(ids));
    }
}
