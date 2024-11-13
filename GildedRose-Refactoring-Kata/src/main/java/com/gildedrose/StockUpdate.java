package com.gildedrose;

public class StockUpdate {
    public static void updateRotting(Item item){
        item.sellIn--;
        int dropRate = (item.sellIn < 0) ? 2 : 1;
        if(item.name.contains("Conjured")) dropRate = dropRate * 2;
        if(item.quality > 0){
            item.quality -= 1 * dropRate;
            if(item.quality < 0) item.quality = 0;
        }
    }

    public static void updateBackstage(Item item){
        if(item.sellIn < 0) {
            item.quality = 0;
        } else {
            item.quality += 1;
            if(item .sellIn <= 10) item.quality += 1;
            if(item.sellIn <= 5) item.quality += 1;
        }
    }

    public static void updateSpecialCase(Item item){
        item.sellIn--;
        // Cancel if Sulfuras
        if(item.quality > 50) return;
        int dropRate = (item.sellIn < 0) ? 2 : 1;
        if(item.name.equals("Backstage passes to a TAFKAL80ETC concert")){
            updateBackstage(item);
        } else {
            item.quality += 1 * dropRate;
        }
        // No overflowing quality
        if(item.quality > 50) item.quality = 50;
    }
}
