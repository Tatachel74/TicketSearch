package manager;

import domain.Ticket;
import repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public Ticket[] findTickets(String from, String to) {
        Ticket[] tickets = new Ticket[0];
        Ticket[] ticketsAll = repository.getAll();
        for (Ticket ticket : ticketsAll) {
            if (ticket.getFrom().equalsIgnoreCase(from) && ticket.getTo().equalsIgnoreCase(to)) {
                int length = tickets.length + 1;
                Ticket[] tmp = new Ticket[length];
                System.arraycopy(tickets, 0, tmp, 0, tickets.length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = ticket;
                tickets = tmp;
            }
        }
        Arrays.sort(tickets);
        return tickets;
    }

}
