package com.gildedrose;

public class BackstageUpdater implements ItemUpdater {
    @Override
    public void update(Item i) {
        i.sellIn--;
        if(i.sellIn < 0) {
            i.quality = 0;
        }
        else if(i.quality < 50){
            i.quality += 1;
            if(i .sellIn <= 10) i.quality += 1;
            if(i.sellIn <= 5) i.quality += 1;
            // No overflowing quality
            if(i.quality > 50) i.quality = 50;
        }
    }
}
