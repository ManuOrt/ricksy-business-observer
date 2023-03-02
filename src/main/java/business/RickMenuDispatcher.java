package business;

import java.util.ArrayList;
import java.util.List;

public class RickMenuDispatcher implements guestDispatcher
{
    private int stock = 100;
    private double precio = 10d;

    public RickMenuDispatcher(int stock, double precio)
    {
        this.stock = stock;
        this.precio = precio;
    }

    private List<String> lCompraMenu = new ArrayList<>();

    public List<String> getlCompraMenu()
    {
        return lCompraMenu;
    }

    public int getStock()
    {
        return stock;
    }

    public double getPrecio()
    {
        return precio;
    }

    public RickMenuDispatcher()
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
