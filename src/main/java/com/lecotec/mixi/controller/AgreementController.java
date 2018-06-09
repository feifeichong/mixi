package com.lecotec.mixi.controller;

import com.lecotec.mixi.model.entity.Agreement;
import com.lecotec.mixi.model.parameter.AgreementSearchParam;
import com.lecotec.mixi.model.response.BootstrapTableResult;
import com.lecotec.mixi.model.response.ResponseObject;
import com.lecotec.mixi.model.response.SuccessResponse;
import com.lecotec.mixi.service.AgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/merchant/agreement")
public class AgreementController {
    @Autowired
    private AgreementService agreementService;

    @GetMapping("search")
    public BootstrapTableResult<Agreement> search(AgreementSearchParam agreementSearchParam) {
        Page<Agreement> result = agreementService.search(agreementSearchParam);
        return new BootstrapTableResult<>(result.getTotalElements(), result.getContent());
    }

    @PostMapping
    public ResponseObject saveOrUpdate(@Valid @RequestBody Agreement agreement) {
        return new SuccessResponse(agreementService.saveOrUpdate(agreement));
    }

    @PutMapping("changeActiveStatus")
    public ResponseObject changeActiveStatus(long id, boolean isActive) {
        return new SuccessResponse(agreementService.changeActiveStatus(id, isActive));
    }

    @DeleteMapping("{id}")
    public ResponseObject deleteById(@PathVariable("id") long id) {
        return new SuccessResponse(agreementService.deleteById(id));
    }

    @PostMapping("deleteBatch")
    public ResponseObject deleteBatch(@RequestBody long[] ids) {
        return new SuccessResponse(agreementService.deleteBatch(ids));
    }
}
