package cz.zcu.qwerty2;

import cz.zcu.qwerty2.calendar.GregorianCalendar;
import cz.zcu.qwerty2.calendar.JulianCalendar;
import cz.zcu.qwerty2.calendar.MayanLongCountCalendar;
import cz.zcu.qwerty2.calendar.SunCalendar;

public class Main {

    public static void main(String[] args) {
        System.out.println("Před zavedením Gregoriánského kalendáře se Juliánský opožďoval o 10 dní");
        GregorianCalendar g = new GregorianCalendar(1582, 10, 15);
        JulianCalendar j = new JulianCalendar();
        j.from_days_from_epoch(g.to_days_from_epoch());
        System.out.println("G " + g);
        System.out.println("J " + j);
        System.out.println("\r\nV roce 453 by měl být rozdíl jeden den");
        g.setYear(453);
        j.from_days_from_epoch(g.to_days_from_epoch());
        System.out.println("G " + g);
        System.out.println("J " + j);
        System.out.println("\r\nMnozí lidé očekávali 21.12.2012 konec světa, kdy nastane nový baktun v majském kalendáři");
        g = new GregorianCalendar(2012, 12, 21);
        MayanLongCountCalendar m = new MayanLongCountCalendar();
        m.from_days_from_epoch(g.to_days_from_epoch());
        System.out.println("G " + g);
        System.out.println("M " + m);
        System.out.println("\r\nNejobvyklejší systém počítání času v počítačích předtavuje unix timestamp, počet vteřin od 1.1.1970");
        g.from_days_from_epoch(0);
        j.from_days_from_epoch(0);
        m.from_days_from_epoch(0);
        System.out.println("G " + g);
        System.out.println("J " + j);
        System.out.println("M " + m);
        System.out.println("Tento den byl: " + SunCalendar.to_czech_day_name(g.get_day_in_week()));
        System.out.println("\r\nTato semestrální práce se odevzdává  30.11.2017 do půlnoci");
        g = new GregorianCalendar(2017, 11, 30);
        j.from_days_from_epoch(g.to_days_from_epoch());
        m.from_days_from_epoch(g.to_days_from_epoch());
        System.out.println("G " + g);
        System.out.println("J " + j);
        System.out.println("M " + m);
        System.out.println("Tento den byl taky: " + SunCalendar.to_czech_day_name(g.get_day_in_week()));
    }
}
