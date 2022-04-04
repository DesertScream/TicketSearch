package RepositoryTest;

import Manager.TicketManager;
import Repository.TicketRepository;
import domain.TicketInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepositoryTest {
    private final TicketRepository repository = new TicketRepository();

    private final TicketInfo first = new TicketInfo(1, 1000, "SVO", "KZN", 3);
    private final TicketInfo second = new TicketInfo(2, 2000, "VKO", "KZN", 4);
    private final TicketInfo third = new TicketInfo(3, 3000, "VKO", "PEE", 5);
    private final TicketInfo fourth = new TicketInfo(4, 4000, "VKO", "SVX", 6);

    @Test
    void addTickets() {
        repository.add(first);
        repository.add(second);
        repository.add(third);
        repository.add(fourth);
    }

    @Test
    void shouldFindAll() {
        repository.add(first);
        repository.add(second);
        repository.add(third);
        repository.add(fourth);
        repository.findAll();

        TicketInfo[] expected = {first, second, third, fourth};
        TicketInfo[] actual = repository.findAll();
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldFindById() {
        repository.add(first);
        repository.add(second);
        repository.add(third);
        repository.add(fourth);
        int expected = 3;
        TicketInfo actual = repository.findById(3);
        assertEquals(expected, actual.getId());
    }

    @Test
    void shouldRemoveById() {
        repository.add(first);
        repository.add(second);
        repository.add(third);
        repository.add(fourth);
        TicketInfo[] expected = new TicketInfo[]{first, third, fourth};
        repository.removeById(2);
        TicketInfo[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }


}
