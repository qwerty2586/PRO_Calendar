package cz.zcu.qwerty2.calendar;

public class GregorianCalendar extends SunCalendar {


    public GregorianCalendar(int year, int month, int day) {
        super(year, month, day);
    }

    private static final int NORMAL_YEAR = 365;
    private static final int LEAP_YEAR = 366;

    public boolean is_leap_year(int year) {
        /*
        Simplified:
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        return year % 4 == 0;*/
        return year % 400 == 0 || year % 100 != 0 && year % 4 == 0;
    }

    private int year_to_days(int year) {
        return ((is_leap_year(year)) ? LEAP_YEAR : NORMAL_YEAR);
    }

    private static final int[] MONTH_DAYS_NORMAL = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] MONTH_DAYS_LEAP = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    protected int get_epoch_year() {return EPOCH_YEAR;}
    protected int get_epoch_month() {return EPOCH_MONTH;}
    protected int get_epoch_day() {return EPOCH_DAY;}


    @Override
    public int to_days_from_epoch() {
        int r = 0; //day 0
        int temp_year = get_epoch_year();
        int temp_month = get_epoch_month();
        int temp_day = get_epoch_day();

        int year = getYear();
        int month = getMonth() - 1;
        int day = getDay() - 1;

        // year
        if (year >= temp_year) {
            // we are adding
            while (temp_year != year) {
                r += year_to_days(temp_year);
                temp_year++;
            }
        } else {
            // we are decrementing
            while (temp_year != year) {
                temp_year--;
                r -= year_to_days(temp_year);
            }
        }

        // month
        while (temp_month != month) {
            r += (is_leap_year(year)) ? MONTH_DAYS_NORMAL[temp_month] : MONTH_DAYS_LEAP[temp_month];
            temp_month++;
        }

        // day
        r += day-temp_day;

        // temp_day = day;
        
        return r;
    }

    @Override
    public void from_days_from_epoch(int days) {
        year = get_epoch_year();
        month = get_epoch_month();
        day = get_epoch_day();

        while (days<0 || days>= year_to_days(year)) {
            if (days<0) {
                // decreasing
                year--;
                days+=year_to_days(year);
            } else {
                // adding
                days-=year_to_days(year);
                year++;
            }
        }

        while (days>= ((is_leap_year(year)) ? MONTH_DAYS_NORMAL[month] : MONTH_DAYS_LEAP[month])) {
            days-= (is_leap_year(year)) ? MONTH_DAYS_NORMAL[month] : MONTH_DAYS_LEAP[month];
            month++;
        }

        day =days;
    }

    @Override
    public int get_day_in_week() {
        int day_from_epoch = to_days_from_epoch();
        if (day_from_epoch < 0) {
            day_from_epoch += (-day_from_epoch / 7 + 1) * 7;
        }
        return (day_from_epoch + EPOCH_WDAY) % 7;
    }


}
