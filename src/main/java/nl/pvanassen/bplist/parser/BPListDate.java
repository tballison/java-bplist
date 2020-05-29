package nl.pvanassen.bplist.parser;

import java.util.*;

class BPListDate implements BPListElement<Date> {

    private final static Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"),
            Locale.US);

    static {
        calendar.set(2001, 0, 1, 1, 0, 0);

    }
    /** Time interval based dates are measured in seconds from 2001-01-01. */
    private final static long TIMER_INTERVAL_TIMEBASE = calendar.getTimeInMillis();

    private final Date value;

    /**
     * Timer interval based dates are measured in seconds from 1/1/2001. Timer
     * intervals have no time zone.
     */
    BPListDate(double value) {
        this.value = new Date(TIMER_INTERVAL_TIMEBASE + ((long) value * 1000L));
    }

    @Override
    public BPListType getType() {
        return BPListType.DATE;
    }

    @Override
    public Date getValue() {
        return value;
    }
}
