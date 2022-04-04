package Manager;

import Repository.TicketRepository;
import domain.TicketInfo;

import java.util.Arrays;

public class TicketManager {
    private final TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }


    public void add(TicketInfo item) {
        repository.add(item);
    }

    public TicketInfo[] findAll(String from, String to) {
        TicketInfo[] result = new TicketInfo[0];
        for (TicketInfo ticket : repository.findAll()) {
            if (ticket.getAirportIn().equals(from) && ticket.getAirportOut().equals(to)) {
                TicketInfo[] tmp = new TicketInfo[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public TicketInfo[] getAll() {
        TicketInfo[] items = repository.findAll();
        TicketInfo[] result = new TicketInfo[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

//    public int sum() {
//        int result = 0;
//        for (TicketInfo item : repository.findAll()) {
//            result = result + item.getCost() * item.getTime();
//        }
//        return result;
//    }
}
