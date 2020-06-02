package com.codebind;

import java.util.Vector;

public class KolejkaKomunikatow {

    Vector kolejka = new Vector();

    public synchronized void wyslij(Object ob) {
        kolejka.addElement(ob);
    }

    public synchronized Object odbierz() {
        if (kolejka.size() == 0)
            return null;

        Object ob = kolejka.firstElement();
        kolejka.removeElementAt(0);
        return ob;
    }
}
