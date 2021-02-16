package manager;

import domain.Ticket;
import domain.TicketByTimeComparator;
import org.junit.jupiter.api.Test;
import repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TicketManagerTest {

    TicketRepository repository = new TicketRepository();

    TicketManager manager = new TicketManager(repository);

    TicketByTimeComparator comparator = new TicketByTimeComparator();

    @Test
    void shouldFindAllSortedByTimeJustOneTicket()  {

        Ticket[] expect = { new Ticket(9, 4000, "INV", "LED", 230) };

        Ticket[] actual = manager.findAllSortedByTime("INV", "LED", comparator);

        assertArrayEquals(expect, actual);

    }

    @Test
    void shouldFindAllTicketComp()  {

        Ticket[] expect = {
                new Ticket(1, 3000, "DME", "ZKD", 130),
                new Ticket(2, 2000, "DME", "ZKD", 200),
                new Ticket(7, 2000, "DME", "ZKD", 230)

        };

        Ticket[] actual = manager.findAllSortedByTime("DME", "ZKD", comparator);

        assertArrayEquals(expect, actual);

    }

    @Test
    void shouldFindAllTicketWhenIsNoneTicket(){

        Ticket[] expect = {};
        Ticket[] actual = manager.findAllSortedByTime("RTB", "GTV", comparator);

        assertArrayEquals(expect, actual);
    }


}