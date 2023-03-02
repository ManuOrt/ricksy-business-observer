package business;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestUfosPark
{
    UfosPark ufos = null;
    String[] ovnis = { "unx", "dox", "trex" };

    @Before
    public void setUp() {
        ufos = new UfosPark();
        Assert.assertNotNull("Parque de UFOS creados", ufos);
        for (String ovni : ovnis) {
            ufos.add(ovni);
        }
    }

    @Test
    public void addUfoTest() {
        Arrays.sort(ovnis);
        Assert.assertEquals(ufos.toString(), ufos.toString());
    }


    @Test
    public void dispatchTest() {
        CreditCard card = new CreditCard("Abradolf Lincler", "4916119711304546");
        ufos.dispatch(card);
        Assert.assertTrue(ufos.containsCard(card.getNumber()));
        List<String> cards = ufos.cardNumbers()
                .stream()
                .filter(n -> n == card.getNumber())
                .collect(Collectors.toList());

        Assert.assertEquals(1, cards.size(), 0);
        Assert.assertEquals(2500, card.getCredit(), 0);
    }

    @Test
    public void dispatchNoCreditTest() {
        CreditCard card = new CreditCard("Abradolf Lincler", "4916119711304546");
        card.pay(3000);
        Assert.assertEquals(0, card.getCredit(), 0);
        ufos.dispatch(card);
        Assert.assertFalse(ufos.containsCard(card.getNumber()));
        Assert.assertEquals(0, card.getCredit(), 0);
    }

    @Test
    public void dispatchUfoAlreadyReservedTest() {
        CreditCard card = new CreditCard("Abradolf Lincler", "4916119711304546");
        ufos.dispatch(card);
        ufos.dispatch(card);
        List<String> cards = ufos.cardNumbers()
                .stream()
                .filter(n -> n == card.getNumber())
                .collect(Collectors.toList());

        Assert.assertEquals(1, cards.size(), 0);
        Assert.assertEquals(2500, card.getCredit(), 0);
    }

    @Test
    public void dispatchNoUfoAvaliableTest() {
        CreditCard abradolph = new CreditCard("Abradolf Lincler", "4916119711304546");
        ufos.dispatch(abradolph);
        CreditCard squanchy = new CreditCard("Squanchy", "4444444444444444");
        ufos.dispatch(squanchy);
        CreditCard birdpearson = new CreditCard("Birdpearson", "1111111111111111");
        ufos.dispatch(birdpearson);
        CreditCard morty = new CreditCard("Morty", "0000000000000000");
        ufos.dispatch(morty);

        List<String> cards = ufos.cardNumbers()
                .stream()
                .filter(n -> n == morty.getNumber())
                .collect(Collectors.toList());

        Assert.assertEquals(0, cards.size(), 0);
        Assert.assertEquals(3000, morty.getCredit(), 0);
    }

    @Test
    public void getUfoOfTest() {
        CreditCard card = new CreditCard("Abradolf Lincler", "4916119711304546");
        ufos.dispatch(card);
        Assert.assertFalse(ufos.toString().contains(ufos.getUfoOf(card.getNumber())));
        Assert.assertEquals(2500, card.getCredit(), 0);
    }

}
