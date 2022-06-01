package gifts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class GiftFactoryTests {
    public GiftFactory giftFactory;
    public Collection<Gift> data;

    @Before
    public void createCollectionToList() {
        data = new ArrayList<>();
    }

    @Test
    public void testConstructorHasCreateValidObjects() {
        Gift gift = new Gift("Miro", 12.0);
        Assert.assertEquals(gift.getType(),"Miro");
        Assert.assertEquals(gift.getMagic(),12.0, 12.0);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateMethodWithSameTypesShouldThrowException() {
        GiftFactory giftFactory = new GiftFactory();
        Gift gift1 = new Gift("Miro", 12.0);
        Gift gift2 = new Gift("Miro", 12.0);
        giftFactory.createGift(gift1);
        giftFactory.createGift(gift2);


    }

    @Test(expected = NullPointerException.class)
    public void testRemoveMethodIfNameNullShouldThrow() {
        GiftFactory giftFactory = new GiftFactory();
        giftFactory.removeGift(null);
    }

    @Test
    public void testRemoveWithValidGift(){
        GiftFactory giftFactory = new GiftFactory();
        Gift gift1 = new Gift("Miro", 12.0);
        giftFactory.createGift(gift1);
        Assert.assertTrue(giftFactory.removeGift("Miro"));
    }

    @Test
    public void testGetPresentWithLeastMagic() {
        GiftFactory giftFactory = new GiftFactory();
        Gift gift1 = new Gift("Miro", 12.0);
        Gift gift2 = new Gift("Test2", 4);
        giftFactory.createGift(gift1);
        giftFactory.createGift(gift2);
        double magic = giftFactory.getPresentWithLeastMagic().getMagic();
        double expectedMagic = 4.0;
        Assert.assertEquals(expectedMagic, magic, magic);
    }

    @Test
    public void testGetPresentWithHisName() {
        GiftFactory giftFactory = new GiftFactory();
        Gift gift1 = new Gift("Miro", 12.0);
        Gift gift2 = new Gift("Test2", 4);
        giftFactory.createGift(gift1);
        giftFactory.createGift(gift2);
       Assert.assertEquals("Test2",giftFactory.getPresent("Test2").getType());
    }

    @Test
    public void testGetPresentsUnmodified() {
        GiftFactory giftFactory = new GiftFactory();
        Gift gift1 = new Gift("Miro", 12.0);
        Gift gift2 = new Gift("Test2", 4);
        giftFactory.createGift(gift1);
        giftFactory.createGift(gift2);
        giftFactory.getPresents();
        Assert.assertEquals(2,giftFactory.getCount());
    }
}
