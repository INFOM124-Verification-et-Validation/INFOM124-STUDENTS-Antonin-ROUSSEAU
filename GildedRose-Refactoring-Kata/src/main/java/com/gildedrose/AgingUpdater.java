package com.gildedrose;

public class AgingUpdater implements ItemUpdater {
    @Override
    public void update(Item i) {
        i.sellIn--;
        int agingRate = (i.sellIn < 0) ? 2 : 1;
        if(i.quality < 50) {
            i.quality += 1 * agingRate;
            // No overflowing quality
            if(i.quality > 50) i.quality = 50;
        }
    }
}
