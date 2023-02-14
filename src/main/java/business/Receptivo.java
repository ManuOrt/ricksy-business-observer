package business;

import java.util.*;

public class Receptivo
{
    Set<guestDispatcher> lDispatch = new HashSet<>(); //El set para que no se repitan
 
    Receptivo()
    {}

    void registra(guestDispatcher guest){
        lDispatch.add(guest);
    }

    void dispatch(CreditCard credit)
    {
        for (guestDispatcher guestD : lDispatch){
            guestD.dispatch(credit);
        }
    }
}
