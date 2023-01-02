package org.ildus.akhmadiev.dao;


import org.ildus.akhmadiev.models.Item;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemsDAO {

    private List<Item> items;

    {
        items = new ArrayList<>();
        items.add(new Item("Sword",3.0,"weapon"));
        items.add(new Item("Foundament",10.0,"build"));
        items.add(new Item("Turrel",7.0,"defense"));
    }

    public Item getItem(Long id) {
        return null;
    }

    public List<Item> getAllItem() {
        return items;
    }

    public void updateItem(Item oldItem) {
        items.add(oldItem);
    }

    public void deleteItem(Long id) {

    }

}
