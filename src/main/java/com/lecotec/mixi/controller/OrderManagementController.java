package com.lecotec.mixi.controller;

import com.lecotec.mixi.model.parameter.OrderParam;
import com.lecotec.mixi.model.response.ResponseObject;
import com.lecotec.mixi.model.response.SuccessResponse;
import com.lecotec.mixi.service.OrderManagementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@Api(value = "/api/order", tags = "订单查询")
public class OrderManagementController {

    @Autowired
    private OrderManagementService orderManagementService;

    @GetMapping("/getPageOrdersForAll/{tag}/{pageNum}/{pageSize}")
    @ApiOperation("所有订单查询接口")
    public ResponseObject getPageOrdersForAll(@PathVariable("tag") String tag, @PathVariable("pageNum") Integer pageNum,
                                              @PathVariable("pageSize") Integer pageSize) {
        return new SuccessResponse(orderManagementService.getPageOrdersForAll(tag, pageNum, pageSize));
    }

    @GetMapping("/getOrdersByOrderState/{tag}/{orderState}/{pageNum}/{pageSize}")
    @ApiOperation("订单查询接口（按照订单状态查询）")
    public ResponseObject getOrdersByOrderState(@PathVariable("tag") String tag, 
    		@PathVariable("orderState")String orderState, 
    		@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        return new SuccessResponse(orderManagementService.getOrdersByOrderState(orderState, tag, pageNum, pageSize));
    }
    @GetMapping("/getOrdersByOrderState/{tag}/{repayState}/{pageNum}/{pageSize}")
    @ApiOperation("订单查询接口（按照还款状态查询）")
    public ResponseObject getOrdersByRepayState(@PathVariable("tag") String tag, 
    		@PathVariable("repayState") String repayState, 
    		@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
    	return new SuccessResponse(orderManagementService.getOrdersByRepayState(repayState, tag, pageNum, pageSize));
    }
    
    @DeleteMapping("/deleteOrderById/{id}")
    @ApiOperation("订单删除接口")
    @ApiImplicitParam(name = "id",value = "订单删除", required = true, dataType = "int")
    public ResponseObject deleteOrderById(@PathVariable("id") int id) {
    	return new SuccessResponse(orderManagementService.deleteOrderById(id));
    }
    
    @GetMapping("/countOrderStateByTag/{tag}")
    @ApiOperation("订单各个状态的统计接口")
    @ApiImplicitParam(name = "tag",value = "订单状态统计", required = true, dataType = "String")
    public ResponseObject countOrderStateByTag(@PathVariable("tag") String tag) {
    	return new SuccessResponse(orderManagementService.countOrderStateByTag(tag));
    }
    
    @PostMapping("/dispatchOrder")
    @ApiOperation("派单接口")
    @ApiImplicitParam(name = "dispatchOrder",value = "派单", required = true, dataType = "OrderParam")
    public ResponseObject dispatchOrder(@RequestBody OrderParam order){
    	Long riderId = order.getRiderId();
    	String riderName = order.getRiderName();
    	List<Long> orderIds = order.getOrderIds();
    	
    	return new SuccessResponse(orderManagementService.dispatchOrder(riderId, riderName, orderIds));
    }
}
