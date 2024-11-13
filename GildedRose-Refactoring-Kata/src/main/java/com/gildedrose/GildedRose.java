package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private void updateRotting(Item item){
        item.sellIn--;
        int dropRate = (item.sellIn < 0) ? 2 : 1;
        if(item.name.contains("Conjured")) dropRate = dropRate * 2;
        if(item.quality > 0){
            item.quality -= 1 * dropRate;
            if(item.quality < 0) item.quality = 0;
        }
    }

    private void updateBackstage(Item item){
        if(item.sellIn < 0) {
            item.quality = 0;
        } else {
            item.quality += 1;
            if(item .sellIn <= 10) item.quality += 1;
            if(item.sellIn <= 5) item.quality += 1;
        }
    }

    private void updateSpecialCase(Item item){
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

    public void updateQuality() {
        for (Item item : items) {
            if(NonPerishables.isIn(item)) updateSpecialCase(item);
            else updateRotting(item);
        }
    }
}
