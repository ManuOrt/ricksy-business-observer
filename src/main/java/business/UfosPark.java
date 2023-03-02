package business;

import java.util.*;

public class UfosPark implements guestDispatcher
{
    private double fee = 500d;
    public double getFee()
    {
        return fee;
    }

    private Map<String,String> mFlota = new HashMap<>();

    public UfosPark()
    {}

    public Map<String, String> getmFlota()
    {
        return mFlota;
    }


    void add(String ufoName){
        mFlota.putIfAbsent(ufoName, null);
    }

    @Override
    public void dispatch(CreditCard card)
    {
        // 1 -- Mirar si esta en el mapa el credit number
        // 2 -- Miarar si hay sitio
        // 3 -- Si hay sitio, tenemos que descontar el dinero
        // 4 -- Meterlo en la lista
        String keyUfo = null;

        if (!mFlota.containsValue(card.getNumber())){
            for (Map.Entry<String,String> checkUfo : mFlota.entrySet()){
                if (checkUfo.getValue() == null){
                    keyUfo = checkUfo.getKey();
                    break;
                }
            }
            if (keyUfo != null && card.pay(fee)){
                mFlota.put(keyUfo, card.getNumber());
            }
        }
    }

    String getUfoOf(String idCard){
        /*
        *  Mirar si ya esta el identificador de la tarjeta y con eso nos dice que ufo tenemos asignado
        * 1.Mirar si existe la tarjeta en el mapa
        * 2.Sacar el id del ufo
        *
        * */
        if (mFlota.containsValue(idCard)){
            for (Map.Entry<String,String> ufoName : mFlota.entrySet()){
                if (ufoName.getValue() == idCard){
                    return ufoName.getKey();
                }
            }
        }
        return " Este credit number no tiene ningun UFO asignado";
    }

    boolean containsCard(String numeroCard){
        return mFlota.containsValue(numeroCard);
    }

    Collection<String> cardNumbers(){
        List<String> getNumbers = new ArrayList<>();

        for (Map.Entry<String,String> checkCardNumbers : mFlota.entrySet()){
            if (checkCardNumbers.getValue() != null)
            {
                getNumbers.add(checkCardNumbers.getValue());
            }
        }
        return getNumbers;
    }
}
