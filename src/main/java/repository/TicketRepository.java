package repository;

import domain.Ticket;
import exception.TicketsNotFound;

public class TicketRepository {

    private Ticket[] items = {
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

    public void save(Ticket item){
        int length = items.length + 1;
        Ticket[] tmp = new Ticket[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }



    public Ticket[] findAll() {
        return items;
    }



    public void removeById(int id) {
        int length = items.length - 1;
        Ticket[] tmp = new Ticket[length];
        int index = 0;
        for (Ticket item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

}
