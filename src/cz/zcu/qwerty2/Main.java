package cz.zcu.qwerty2;

import cz.zcu.qwerty2.calendar.GregorianCalendar;
import cz.zcu.qwerty2.calendar.JulianCalendar;
import cz.zcu.qwerty2.calendar.MayanLongCountCalendar;
import cz.zcu.qwerty2.calendar.SunCalendar;

import java.util.Calendar;

public class Main {

    public static void main(String[] args) {
        JulianCalendar j = new JulianCalendar(1969, 12, 19);
        System.out.println(j + " " + SunCalendar.to_czech_day_name(j.get_day_in_week()));
        System.out.println(j.to_days_from_epoch());
        GregorianCalendar c = new GregorianCalendar(1969, 12, 31);
        System.out.println(c + " " + SunCalendar.to_czech_day_name(c.get_day_in_week()));
        c = new GregorianCalendar(2030, 6, 13);
        System.out.println(c + " " + SunCalendar.to_czech_day_name(c.get_day_in_week()));
        c = new GregorianCalendar(200, 2, 5);
        System.out.println(c + " " + SunCalendar.to_czech_day_name(c.get_day_in_week()));
        c = new GregorianCalendar(2017, 11, 29);
        System.out.println(c + " " + SunCalendar.to_czech_day_name(c.get_day_in_week()));
        c = new GregorianCalendar(1970, 1, 1);
        System.out.println(c + " " + SunCalendar.to_czech_day_name(c.get_day_in_week()));
        c = new GregorianCalendar(1999, 1, 1);
        System.out.println(c + " " + SunCalendar.to_czech_day_name(c.get_day_in_week()));
        c = new GregorianCalendar(1970, 12, 1);
        System.out.println(c + " " + SunCalendar.to_czech_day_name(c.get_day_in_week()));

        MayanLongCountCalendar m = new MayanLongCountCalendar(13,0,0,0,0);
        c.from_days_from_epoch(m.to_days_from_epoch());
        System.out.println("Mayan 13.0.0.0.0 "+ c);



    }
}
