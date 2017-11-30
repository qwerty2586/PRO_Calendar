package cz.zcu.qwerty2.calendar;

import sun.security.provider.Sun;

public abstract class SunCalendar extends AbstractCalendar {

    protected int year;
    protected int month;
    protected int day;

    public SunCalendar(int year, int month, int day) {
        this.year = year;
        this.month = month-1;
        this.day = day-1;
    }

    public abstract int get_day_in_week();

    public SunCalendar() { this(EPOCH_YEAR,EPOCH_MONTH+1,EPOCH_DAY+1);};


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month+1;
    }

    public void setMonth(int month) {
        this.month = month-1;
    }

    public int getDay() {
        return day+1;
    }

    public void setDay(int day) {
        this.day = day-1;
    }

    // days in week
    public static final int MONDAY = 0;
    public static final int TUESDAY= 1;
    public static final int WEDNESDAY= 2;
    public static final int THURSDAY = 3;
    public static final int FRIDAY= 4;
    public static final int SATURDAY= 5;
    public static final int SUNDAY= 6;


    protected static final int EPOCH_YEAR = 1970;
    protected static final int EPOCH_MONTH = 0;
    protected static final int EPOCH_DAY = 0;
    protected static final int EPOCH_WDAY = THURSDAY;

    public static String to_english_day_name(int day) {
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        return days[day % days.length];
    }

    public static String to_czech_day_name(int day) {
        String[] days = {"Pondělí", "Úterý", "Středa", "Čtvrtek", "Pátek", "Sobota", "Neděle"};
        return days[day % days.length];
    }

    @Override
    public String toString() {
        return ""+getDay()+"."+getMonth()+"."+getYear();
    }
}
