package cz.zcu.qwerty2.calendar;

public class JulianCalendar extends GregorianCalendar {
    public JulianCalendar(int year, int month, int day) {
        super(year, month, day);
    }
    public JulianCalendar() { this(EPOCH_YEAR,EPOCH_MONTH+1,EPOCH_DAY+1);};

    private static final int EPOCH_YEAR = 1969;
    private static final int EPOCH_MONTH = 11;
    private static final int EPOCH_DAY = 18;

    @Override
    public boolean is_leap_year(int year) {
        return year % 4 == 0;
    }
    @Override
    protected int get_epoch_year() {return EPOCH_YEAR;}
    @Override
    protected int get_epoch_month() {return EPOCH_MONTH;}
    @Override
    protected int get_epoch_day() {return EPOCH_DAY;}
}
