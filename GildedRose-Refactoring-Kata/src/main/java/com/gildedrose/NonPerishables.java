package com.gildedrose;

import java.util.ArrayList;
import java.util.List;

public class NonPerishables {
    private NonPerishables() {
        super();
    }

    public static boolean isIn(Item item){
        List<String> allowed = new ArrayList<>();
        allowed.add("Aged Brie");
        allowed.add("Sulfuras, Hand of Ragnaros");
        allowed.add("Backstage passes to a TAFKAL80ETC concert");
        return allowed.contains(item.name);
    }
}
