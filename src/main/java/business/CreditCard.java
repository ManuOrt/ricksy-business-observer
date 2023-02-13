package business;
public class CreditCard
{
    private final String OWNER;
    private final String NUMBER;
    private double credit = 3000d;
    private final String SYMBOL = "EZIS";

    public CreditCard(String OWNER, String NUMBER)
    {
        this.OWNER = OWNER;
        this.NUMBER = NUMBER;
    }

    boolean pay(double pago){
        //si el dinero que tienes en credit es mayor o igual que lo que te cuesta, devuelves true, sinó false
        //forma 1
        if (credit >= pago){
            credit -= pago;
            return true;
        }
        return false;

        //forma dos
        //return credit >= pago;
    }

    String getNumber(){
        return this.NUMBER;
    }

    String getCardOwner(){
        return this.OWNER;
    }

    double getCredit(){
        return this.credit;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(OWNER).append("\nCredit card number: ").append(NUMBER).append("\nTotal credit: ").append(credit).append(SYMBOL);
        return sb.toString();
    }
}
