package com.gildedrose;

import java.util.ArrayList;
import java.util.List;

public class NonPerishables {
    public static boolean isIn(Item item){
        List<String> allowed = new ArrayList<String>();
        allowed.add("Aged Brie");
        allowed.add("Sulfuras, Hand of Ragnaros");
        allowed.add("Backstage passes to a TAFKAL80ETC concert");
        return allowed.contains(item.name);
    }
}
