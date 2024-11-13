package com.gildedrose;

public class LegendaryUpdater implements ItemUpdater {
    @Override
    public void update(Item i) {
        i.sellIn--;
    }
}
