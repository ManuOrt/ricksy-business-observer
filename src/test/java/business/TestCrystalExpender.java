package business;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCrystalExpender
{
    CrystalExpender packExpender;

    @Before
    public void setUp(){
        this.packExpender = new CrystalExpender(3,50);
    }

    @Test
    public void testDispatchSuccess(){
        CreditCard card = new CreditCard("Andreas", "12345");

        this.packExpender.dispatch(card);

        Assert.assertEquals(2, packExpender.getStock());
        Assert.assertEquals(2950d, card.getCredit(),0);
    }

    @Test
    public void testDispatchNotSuficentCredits(){
        CreditCard card = new CreditCard("Andreas", "12345");
        CrystalExpender crystalExpender = new CrystalExpender(3,4000);

        crystalExpender.dispatch(card);

        Assert.assertEquals(3, packExpender.getStock());
        Assert.assertEquals(3000d, card.getCredit(),0);
    }

    @Test
    public void testToString(){
        Assert.assertEquals(this.packExpender.toString(), "Stock: 3\n" +
                "Item cost: 50.0");
    }
}
