package Manager;

import domain.Ticket;
import manager.TicketManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class TicketManagerTest {
    @Mock
    private TicketRepository repository;
    @InjectMocks
    private TicketManager manager;
    private Ticket route1 = new Ticket(33618, "VOZ", "FRA");
    private Ticket route2 = new Ticket(34130, "VOZ", "FRA");
    private Ticket route3 = new Ticket(92831, "VOZ", "CNX");
    private Ticket route4 = new Ticket(98642, "VOZ", "CNX");

    @Test
    void shouldFindTickets() {
        Ticket[] returned = new Ticket[]{route1, route2, route3, route4};
        doReturn(returned).when(repository).getAll();
        Ticket[] actual = manager.findTickets("VOZ", "CNX");
        Ticket[] expected = new Ticket[]{route3, route4};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldDidNotFindTickets() {
        Ticket[] returned = new Ticket[]{route1, route2, route3, route4};
        doReturn(returned).when(repository).getAll();
        Ticket[] actual = manager.findTickets("FRA", "CZ");
        Ticket[] expected = new Ticket[]{};

        assertArrayEquals(expected, actual);
    }
}
