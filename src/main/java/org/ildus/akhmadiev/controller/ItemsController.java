package org.ildus.akhmadiev.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.ildus.akhmadiev.dao.ItemsDAO;
import org.ildus.akhmadiev.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemsController {

    private ItemsDAO itemsDAO;

    @Autowired
    public ItemsController(ItemsDAO itemsDAO) {
        this.itemsDAO = itemsDAO;
    }

    @GetMapping("")
    public String getAll(Model model,@ModelAttribute("newItem") Item item) {
        List<Item> allItem = itemsDAO.getAllItem();
        model.addAttribute("allItems",allItem);
        return "/items/main";
    }

    @PostMapping
    public String getAllpost(Model model,@ModelAttribute("newItem") Item item) {
        item.increment();
        itemsDAO.updateItem(item);
        return "redirect:/items";
    }

}
