package manager;

import domain.Ticket;
import exception.TicketsNotFound;
import repository.TicketRepository;

import java.util.Arrays;
import java.util.Comparator;

public class TicketManager {

    TicketRepository repository = new TicketRepository();

    public TicketManager(TicketRepository repository){
        this.repository=repository;
    }

    public Ticket[] findAll(String from, String to) throws TicketsNotFound {

        Ticket[] result = new Ticket[0];

        for (Ticket ticket : repository.findAll()) {
            if (ticket.getFrom().equals(from) && ticket.getTo().equals(to)) {

                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;

                result = tmp;
            } //else {
              //  throw new TicketsNotFound("not found");
            //}
        }


        Arrays.sort(result);
        System.out.println(Arrays.toString(result));

        return result;
    }

    public Ticket[] findAll(String from, String to, Comparator<Ticket> comparator) throws TicketsNotFound {

        Ticket[] result = new Ticket[0];

        for (Ticket ticket : repository.findAll()) {
            if (ticket.getFrom().equals(from) && ticket.getTo().equals(to)) {

                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;

                result = tmp;
            }
        }


        Arrays.sort(result, comparator);
        System.out.println(Arrays.toString(result));

        return result;
    }



}
