package Repository;

import domain.TicketInfo;

public class TicketRepository {
    private TicketInfo[] items = new TicketInfo[0];

    public void add(TicketInfo item) {
        int length = items.length + 1;
        TicketInfo[] tmp = new TicketInfo[length];
        System.arraycopy(items, 0, tmp, 0, items.length);

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public TicketInfo[] findAll() {
        return items;
    }

    public TicketInfo findById(int id) {
        for (TicketInfo item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
        int length = items.length - 1; // Вычисляем длину старого массива
        TicketInfo[] tmp = new TicketInfo[length]; //Создаем новый массив
        int index = 0; // Создаем переменную, которая указывает на номер ячейки куда будем копировать
        for (TicketInfo item : items) { //Перебираем элементы
            if (item.getId() != id) { //Сравнивает даваемый Id с тем который надо удалить
                tmp[index] = item; //Если равно - скопируй, если не равно, то не копируй
                index++;
            }
        }
        items = tmp; // Получаем новый массив, без элемента, который удалили
    }
}
