package business;

public class CrystalExpender implements guestDispatcher
{
    private int stock;
    private double itemCost = 50d;

    public CrystalExpender(int stock, double itemCost)
    {
        this.stock = stock;
        this.itemCost = itemCost;
    }

    @Override
    public void dispatch(CreditCard card)
    {
        if (stock > 0 && card.pay(itemCost)){
            stock -= 1;
            //stock--;
        }
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Stock: ").append(stock).append("\nItem cost: ").append(itemCost);

        return sb.toString();
    }

    int getStock()
    {
        return this.stock;
    }
}
