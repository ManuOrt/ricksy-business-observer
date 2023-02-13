package business;

import java.util.*;

public class UfosPark implements guestDispatcher
{
    private double fee = 500d;
    private final Map<String,String> mFlota = new HashMap<>(); //todo lo que tenga Hash, significa que no se repiten los valores dentro de el mapa, el orden no esta definido

    UfosPark(){}

    void add(String nombreUber){
        mFlota.putIfAbsent(nombreUber, null);
    }

    @Override
    public void dispatch(CreditCard card)
    {//tenemos que mirar si tenemos algun ovni para asignarle, descontar el dinero
        //recorrer el mapa y mirar si tine null

        /*
        * for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println(String.format("Key (name) is: %s, Value (age) is : %s", pair.getKey(), pair.getValue()));
}
        *
        * */
        // 1 -- Mirar si esta en el mapa el credit number
        // 2 -- Miarar si hay sitio
        // 3 -- Si hay sitio, tenemos que descontar el dinero
        // 4 -- Meterlo en la lista

        String keyUfo = null;//si es null, significa que todos los taxis están ocupados y no recogeremos el id del ovni que vamos a asignarle en la línia 51.

        if (!mFlota.containsValue(card.getNumber())){ // paso 1

            for (Map.Entry<String, String> ufoReserv : mFlota.entrySet()){// miramos paso dos
                    if (ufoReserv.getValue() == null){
                        keyUfo = ufoReserv.getKey();
                        break;
                    }
            }
        }else{
            System.out.println("Ya tienes asignado un Ufo");
        }
        //comprobamos si tiene dinero, si tiene dinero, entonces si es true, metodo con la clave,


        if (keyUfo != null && card.pay(fee))//si la primera condicion no se cumple, no descontará el dinero de la segunda condición
        {
            mFlota.put(keyUfo, card.getNumber()); //meterlo aquí
        }
    }

    String getUfoOf(String creditNumber){
        //tenemos que mirar en el mapa, que ovni tiene asignado el creditNumber
        //
        if (mFlota.containsValue(creditNumber)){
            for (Map.Entry<String,String> nombreOvni : mFlota.entrySet()){
                if (nombreOvni.getValue().equals(creditNumber)){
                    return nombreOvni.getKey();
                }
            }
        }

        return " Este credit number no tiene ningún UFO asignado";
    }

    public String returnFreeOvnis()
    {
        //vamos a hacer un listado  de ellos
        final String noValue = "Tenemos todos los ovnis ocupados";
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String,String> freeOvnis : mFlota.entrySet()){
            if (freeOvnis.getValue() == null){
                sb.append(freeOvnis.getKey()).append("\n");
            }
        }
        return sb.toString() == null ? noValue : sb.toString();
    }
    public String returnBusyOvnis()
    {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String,String> busyOvnis : mFlota.entrySet()){
            if (busyOvnis.getValue() != null){
                sb.append(busyOvnis.getKey()).append("\n");
            }
        }
        return sb.toString();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("----------- UFO'S PARK -----------").append("\nCost Service: ").append(fee).append("\nFree ovnis: \n").append(returnFreeOvnis()).append("\nBusy ovnis: ").append(returnBusyOvnis());

        return sb.toString();
    }

    boolean containsCard(String card){
        if (mFlota.containsValue(card))
            return true;
        else
            return false;

        //return mFlota.containsValue(card);
    }

    Collection<String> cardNumbers()
    {
        List<String> lCardsNum = new ArrayList<>(); //Creamos una lista para guardar todos los card numbers

        for (Map.Entry<String,String> checkCardNum : mFlota.entrySet()){ //Hacemos la iteracion del mapa
            if (checkCardNum.getValue() != null){ //Comprobamos que en la iteracion del mapa el valor nor sea nullo
                lCardsNum.add(checkCardNum.getValue()); //Si no es nulo metemos el valor en la lista donde guardamos los card numbers
            }
        }
        
        return lCardsNum;
/*
        return mFlota.values();*///todo mirar si nos devuelve tmb los nulls
    }
}
