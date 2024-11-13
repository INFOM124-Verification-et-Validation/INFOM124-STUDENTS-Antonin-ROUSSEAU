package com.gildedrose;

public class UpdateFactory {
    private UpdateFactory(){
        super();
    }

    public static ItemUpdater get(Item i) {
        switch (i.name){
            case "Aged Brie":
                return new AgingUpdater();
            case "Sulfuras, Hand of Ragnaros":
                return new LegendaryUpdater();
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstageUpdater();
            default:
                if(i.name.contains("Conjured")) return new ConjuredUpdater();
                else return new DefaultUpdater();
        }
    }
}
