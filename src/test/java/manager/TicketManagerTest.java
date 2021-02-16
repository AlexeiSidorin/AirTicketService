package manager;

import domain.Ticket;
import domain.TicketByTimeComparator;
import exception.TicketsNotFound;
import org.junit.jupiter.api.Test;
import repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TicketManagerTest {




    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);

    @Test
    void shouldFindAllTicket() throws TicketsNotFound {

        Ticket[] expect = {
                new Ticket(2, 2000, "DME", "ZKD", 200),
                new Ticket(7, 2000, "DME", "ZKD", 230),
                new Ticket(1, 3000, "DME", "ZKD", 130)
        };

        Ticket[] actual = manager.findAll("BOS", "IST");


        assertArrayEquals(expect, actual);

    }


    @Test
    void shouldFindAllJustOneTicket() throws TicketsNotFound {

        Ticket[] expect = { new Ticket(9, 4000, "INV", "LED", 230) };

        Ticket[] actual = manager.findAll("INV", "LED");


        assertArrayEquals(expect, actual);

    }

    @Test
    void shouldFindAllTicketComp() throws TicketsNotFound {

        TicketByTimeComparator comp = new TicketByTimeComparator();

        Ticket[] expect = {
                new Ticket(2, 2000, "DME", "ZKD", 200),
                new Ticket(7, 2000, "DME", "ZKD", 230),
                new Ticket(1, 3000, "DME", "ZKD", 130)
        };

        Ticket[] actual = manager.findAll("BOS", "IST", comp);


        assertArrayEquals(expect, actual);

    }
}