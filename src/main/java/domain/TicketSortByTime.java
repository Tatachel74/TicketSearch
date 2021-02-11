package domain;

import java.util.Comparator;

public class TicketSortByTime implements Comparator<Ticket> {
    public int compare(Ticket t1, Ticket t2) {
        return t1.getTime() - t2.getTime();
    }
}


