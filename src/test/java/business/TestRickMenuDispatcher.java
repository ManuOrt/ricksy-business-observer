package business;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestRickMenuDispatcher
{
    RickMenuDispatcher rickMenu;

    @Before
    public void setUp(){
        this.rickMenu = new RickMenuDispatcher(20,30d);
    }

    @Test
    public void testDispatch(){
        CreditCard card = new CreditCard("Andreas", "12345");
        this.rickMenu.dispatch(card);

        Assert.assertEquals(19,rickMenu.getStock());
        Assert.assertEquals(2970,card.getCredit(),0);
        Assert.assertEquals(rickMenu.getlCompraMenu().get(0), card.getNumber());

    }

    @Test
    public void testToString(){
        CreditCard card = new CreditCard("Andreas", "12345");
        this.rickMenu.dispatch(card);
        Assert.assertEquals(rickMenu.toString(), "El numero de pedidos es: 1\n" +
                "Lista de invitados que han realizado un pedido: \n" +
                "12345\n");
    }
}
