package com.gildedrose;

public class ConjuredUpdater implements ItemUpdater {
    @Override
    public void update(Item i) {
        i.sellIn--;
        int dropRate = (i.sellIn < 0) ? 4 : 2;
        if(i.quality > 0){
            i.quality -= 1 * dropRate;
            // No negative quality
            if(i.quality < 0) i.quality = 0;
        }
    }
}
