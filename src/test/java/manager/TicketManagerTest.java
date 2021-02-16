package manager;

import domain.Ticket;
import org.junit.jupiter.api.Test;
import repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TicketManagerTest {



    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);

    @Test
    void shouldFindAllWithoutTicket(){
        Ticket[] expect= {};
        Ticket[] actual = manager.findAll("RNT", "GTJ");

        assertArrayEquals(expect, actual);

    }

    @Test
    void shouldFindAllTicket() {

        Ticket[] expect = {
                new Ticket(1, 1000, "DME", "ZKD", 230),
                new Ticket(2, 2000, "DME", "ZKD", 230),
                new Ticket(7, 2000, "DME", "ZKD", 230)
        };

        Ticket[] actual = manager.findAll("DME", "ZKD");


        assertArrayEquals(expect, actual);

    }


    @Test
    void shouldFindAllJustOneTicket() {

        Ticket[] expect = { new Ticket(9, 4000, "INV", "LED", 230) };

        Ticket[] actual = manager.findAll("INV", "LED");


        assertArrayEquals(expect, actual);

    }
}