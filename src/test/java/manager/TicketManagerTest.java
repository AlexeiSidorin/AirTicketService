package manager;

import domain.Ticket;
import exception.TicketsNotFound;
import org.junit.jupiter.api.Test;
import repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TicketManagerTest {

    Ticket[] items = {
            new Ticket(1, 1000, "DME", "ZKD", 230),
            new Ticket(2, 2000, "DME", "ZKD", 230),
            new Ticket(3, 4000, "OGZ", "FRU", 120),
            new Ticket(4, 6000, "GOJ", "LED", 360),
            new Ticket(5, 5000, "RVH", "FRU", 230),
            new Ticket(6, 7000, "BOS", "IST", 200),
            new Ticket(7, 2000, "DME", "ZKD", 230),
            new Ticket(8, 9000, "BOS", "IST", 250),
            new Ticket(9, 4000, "INV", "LED", 230),
            new Ticket(10, 2000, "BOS", "IST", 130),
            new Ticket(11, 4000, "BOS", "IST", 330)


    };


    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);

    @Test
    void shouldFindAllTicket() throws TicketsNotFound {

        Ticket[] expect = {
                new Ticket(1, 1000, "DME", "ZKD", 230),
                new Ticket(2, 2000, "DME", "ZKD", 230),
                new Ticket(7, 2000, "DME", "ZKD", 230)
        };

        Ticket[] actual = manager.findAll("DME", "ZKD");


        assertArrayEquals(expect, actual);

    }


    @Test
    void shouldFindAllJustOneTicket() throws TicketsNotFound {

        Ticket[] expect = { new Ticket(9, 4000, "INV", "LED", 230) };

        Ticket[] actual = manager.findAll("INV", "LED");


        assertArrayEquals(expect, actual);

    }
}