package business;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCreditCard
{
    CreditCard card;

    @Before
    public void setUp(){
       card = new CreditCard("Andreas", "12345");
    }

    @Test
    public void testCreditCardToString(){
        Assert.assertEquals(this.card.toString(), "Nombre: Andreas\n" +
                "Credit card number: 12345\n" +
                "Total credit: 3000.0EZIS");
    }

    @Test
    public void testCreditCardPaySuccess(){
        Assert.assertTrue(this.card.pay(500d));
        Assert.assertEquals(2500d, this.card.getCredit(), 0);
    }

    @Test
    public void testCreditCardPayFail(){
        Assert.assertFalse(this.card.pay(4000d));
        Assert.assertEquals(3000, this.card.getCredit(),0);
    }
}
