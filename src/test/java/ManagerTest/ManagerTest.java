package ManagerTest;

import Manager.TicketManager;
import Repository.TicketRepository;
import domain.TicketInfo;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ManagerTest {
    private final TicketRepository repository = new TicketRepository();
    private final TicketManager manager = new TicketManager(repository);

    private final TicketInfo first = new TicketInfo(1, 1000, "SVO", "KZN", 3);
    private final TicketInfo second = new TicketInfo(2, 2000, "VKO", "KZN", 4);
    private final TicketInfo third = new TicketInfo(3, 3000, "VKO", "PEE", 5);
    private final TicketInfo fourth = new TicketInfo(4, 4000, "VKO", "SVX", 6);

    @Test
    void shouldAdd() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
    }


    @Test
    void shouldGetAll() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        TicketInfo[] tickets = new TicketInfo[]{first, second,third,fourth};
        TicketInfo[] result = manager.findAll("VKO", "PEE");
        assertNotEquals(tickets, result);
    }
    @Test
    void shouldSortByTwoParameters() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        TicketInfo[] tickets = new TicketInfo[]{third};
        TicketInfo[] result = manager.findAll("VKO", "PEE");
        Arrays.sort(tickets);
        assertArrayEquals(tickets, result);
    }
}



