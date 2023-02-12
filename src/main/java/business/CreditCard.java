package business;
/**
 * Ricksy Business
 * ===============
 * Rick se queda a cargo Morty y Summer,
 * y celebra una pedazo de fiesta.
 * Entre los invitados hay adolescentes, aliens,
 * Gearhead, Squanchy, Birdpearson y
 * Abradolph Lincler (una combinación de DNA
 * de Adolf Hitler y Abraham Lincoln).
 *
 * Cuando un invitado/a llega a la fiesta,
 * se le da de alta en el receptivo del sistema
 * mediante su tarjeta de crédito.
 *
 * El receptivo carga en el crédito de la tarjeta:
 * - El coste del UberOvni de vuelta a casa Ufospark -> Ovni
 * - El coste del pack de bienvenida (Collaxion crystals).
 *
 * El componente de reserva de Ovnis y el componente
 * de entrega del pack de bienvenida observan al
 * componente receptivo, de modo que cuando el receptivo
 * da de alta a un invitado/a automáticamente cargan
 * en la tarjeta del invitado/a el coste de ambos servicios.
 */

/* Crea una tarjeta de crédito para Abradolph.
        * Como es una AndromedanExpress
        * el crédito inicial es de 3000 EZIS
        */
    /*

        CreditCard abradolph = new CreditCard("Abradolph Lincler", "4916119711304546");

        System.out.println("\n" + "Tarjeta de Abradolph" + "\n" +
                "===================="        );
        System.out.println(abradolph);

        */

public class CreditCard
{
    private final String OWNER;
    private final String NUMBER;
    private double credit = 0d;
    private String SYMBOL;

    public CreditCard(String OWNER, String NUMBER)
    {
        this.OWNER = OWNER;
        this.NUMBER = NUMBER;
    }

    boolean pay(double pago){//todo mirar si es lo correcto
        //si el dinero que tienes en credit es mayor o igual que lo que te cuesta, devuelves true, sinó false

        //forma 1
        if (credit >= pago){
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
        sb.append("Nombre: ").append(OWNER).append("\nCredit card number: ").append(NUMBER).append("\nTotal credit: ").append(credit);
        return sb.toString();
    }
}
