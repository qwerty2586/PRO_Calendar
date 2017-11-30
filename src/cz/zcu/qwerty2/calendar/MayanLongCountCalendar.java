package cz.zcu.qwerty2.calendar;

public class MayanLongCountCalendar extends AbstractCalendar {

    private int kin; //day
    private int uinal; // 20 kin
    private int tun; // 18 uinal
    private int katun; // 20 tun
    private int baktun; //20 katun
    /// and so on....

    public int getKin() {
        return kin;
    }

    public void setKin(int kin) {
        this.kin = kin;
    }

    public int getUinal() {
        return uinal;
    }

    public void setUinal(int uinal) {
        this.uinal = uinal;
    }

    public int getTun() {
        return tun;
    }

    public void setTun(int tun) {
        this.tun = tun;
    }

    public int getKatun() {
        return katun;
    }

    public void setKatun(int katun) {
        this.katun = katun;
    }

    public int getBaktun() {
        return baktun;
    }

    public void setBaktun(int baktun) {
        this.baktun = baktun;
    }

    public MayanLongCountCalendar(int baktun, int katun, int tun, int uinal ,int kin) {
        this.kin = kin;
        this.uinal = uinal;
        this.tun = tun;
        this.katun = katun;
        this.baktun = baktun;
    }
    public MayanLongCountCalendar() {
        from_days_from_epoch(EPOCH_DAY);
    }

    private static final int _KIN = 1;
    private static final int _UINAL = 20 * _KIN; // 20 kin
    private static final int _TUN = 18 * _UINAL; // 18 uinal
    private static final int _KATUN = 20 * _TUN; // 20 tun
    private static final int _BAKTUN = 20 * _KATUN; //20 katun

    // 1.1.1970 is 12.17.16.7.5 in long count
    private static final int EPOCH_DAY = 12 * _BAKTUN + 17 * _KATUN + 16 * _TUN + 7 * _UINAL + 5 * _KIN;

    @Override
    public int to_days_from_epoch() {
        return
                _KIN * kin +
                _UINAL * uinal +
                _TUN * tun +
                _KATUN * katun +
                _BAKTUN * baktun -
                EPOCH_DAY;
    }

    @Override
    public void from_days_from_epoch(int days) {
        days+=EPOCH_DAY;
        baktun = days / _BAKTUN;
        days -= _BAKTUN*baktun;
        katun = days / _KATUN;
        days -= _KATUN*katun;
        tun = days / _TUN;
        days -= _TUN*tun;
        uinal = days / _UINAL;
        days -= _UINAL*uinal;
        kin = days;
    }

    @Override
    public String toString() {
        return "" + baktun + "." + katun + "." + tun + "." + uinal + "." + kin;
    }
}
