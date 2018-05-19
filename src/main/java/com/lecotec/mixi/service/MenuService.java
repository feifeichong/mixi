package com.lecotec.mixi.service;

import com.lecotec.mixi.model.entity.Menu;
import com.lecotec.mixi.model.entity.Station;
import com.lecotec.mixi.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public Page<Menu> getMenus(int pageNumber, int pageSize) {
        return menuRepository.findAll(PageRequest.of(pageNumber, pageSize));
    }

    public Menu saveMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    public boolean changeActiveStatus(long id, boolean isActive) {
        return menuRepository.changeActiveStatus(id, isActive, new Date()) > 0;
    }

    public boolean deleteMenu(long id) {
        menuRepository.deleteById(id);
        return true;
    }
}
