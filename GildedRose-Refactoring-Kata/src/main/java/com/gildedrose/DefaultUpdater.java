package com.gildedrose;

public class DefaultUpdater implements ItemUpdater{
    @Override
    public void update(Item i) {
        i.sellIn--;
        int dropRate = (i.sellIn < 0) ? 2 : 1;
        if(i.quality > 0){
            i.quality -= 1 * dropRate;
            // No negative quality
            if(i.quality < 0) i.quality = 0;
        }
    }
}
