package business;

import java.util.ArrayList;
import java.util.List;

public class RickManuDispatcher implements guestDispatcher
{
    private int stock = 100;
    private double precio = 10d;

    private List<String> lCompraMenu = new ArrayList<>();

    public RickManuDispatcher()
    {}

    @Override
    public void dispatch(CreditCard card)
    {
        if (stock > 0 && card.pay(precio)){
            stock--;
            lCompraMenu.add(card.getNumber());
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("El numero de pedidos es: ").append(lCompraMenu.size()).append("\nLista de invitados que han realizado un pedido: \n");
        for (String nTarjeta : lCompraMenu){
            sb.append(nTarjeta).append("\n");
        }
        return sb.toString();
    }
}
