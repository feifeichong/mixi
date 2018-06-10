package com.lecotec.mixi.controller;

import com.lecotec.mixi.model.entity.Menu;
import com.lecotec.mixi.model.response.BootstrapTableResult;
import com.lecotec.mixi.model.response.ResponseObject;
import com.lecotec.mixi.model.response.SuccessResponse;
import com.lecotec.mixi.service.MenuService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/merchant/menu")
@Api(tags = "菜单数据接口")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("all")
    public BootstrapTableResult<Menu> getMenus(int pageNumber, int pageSize) {
        Page<Menu> menus = menuService.getMenus(pageNumber, pageSize);
        return new BootstrapTableResult<>(menus.getTotalElements(), menus.getContent());
    }

    @PostMapping
    public ResponseObject saveOrUpdateMenu(@Valid @RequestBody Menu menu) {
        /*Menu menu = new Menu();
        BeanUtils.copyProperties(menuParam, menu);
        menu.setModifyTime(new Date());*/
        return new SuccessResponse(menuService.saveMenu(menu));
    }

    @PutMapping("changeActiveStatus")
    public ResponseObject changeActiveStatus(long id, boolean isActive) {
        return new SuccessResponse(menuService.changeActiveStatus(id, isActive));
    }

    @DeleteMapping("/{id}")
    public ResponseObject deleteMenu(@PathVariable("id") long id) {
        return new SuccessResponse(menuService.deleteMenu(id));
    }
}
