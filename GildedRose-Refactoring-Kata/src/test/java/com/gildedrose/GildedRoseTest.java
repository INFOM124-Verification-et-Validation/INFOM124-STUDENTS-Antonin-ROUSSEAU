package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void BrieBeforeDate() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void BrieAfterDate() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 40) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(42, app.items[0].quality);
    }

    @Test
    void ItemBeforeDate() {
        Item[] items = new Item[] { new Item("Copper dagger", 14, 12) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void ItemAfterDate() {
        Item[] items = new Item[] { new Item("Copper dagger", -2, 8) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, app.items[0].quality);
    }

    @Test
    void SulfurasBeforeDate() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 1, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void SulfurasAfterDate() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -1, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void BackstageEarly() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 12, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(21, app.items[0].quality);
    }

    @Test
    void BackstageMid() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 8, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(32, app.items[0].quality);
    }

    @Test
    void BackstageLate() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 3, 40) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(43, app.items[0].quality);
    }

    @Test
    void BackstageLateMaxxed() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 8, 48) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void BackstageExpired() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void ConjuredBeforeDate() {
        Item[] items = new Item[] { new Item("Conjured arrow bundle", 10, 22) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(20, app.items[0].quality);
    }

    @Test
    void ConjuredAfterDate() {
        Item[] items = new Item[] { new Item("Conjured arrow bundle", -3, 12) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

}
