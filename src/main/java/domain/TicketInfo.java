package domain;

public class TicketInfo implements Comparable<TicketInfo> {
    private int id;
    private int cost;
    private String airportIn;
    private String airportOut;
    private int time;

    public TicketInfo() {

    }

    public TicketInfo(int id, int cost, String airportIn, String airportOut, int time) {
        this.id = id;
        this.cost = cost;
        this.airportIn = airportIn;
        this.airportOut = airportOut;
        this.time = time;
    }

    @Override
    public int compareTo(TicketInfo o) {
        TicketInfo t = (TicketInfo) o; //Продукт, который передан на вход
        return this.cost - t.cost; //из одной цены будет вычитаться цена другого объекта
    }
    //Берем один продукт, вызываем у него метода compareTo,
    // как метод equals и передаем туда другой объект

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getAirportIn() {
        return airportIn;
    }

    public void setAirportIn(String airportIn) {
        this.airportIn = airportIn;
    }

    public String getAirportOut() {
        return airportOut;
    }

    public void setAirportOut(String airportOut) {
        this.airportOut = airportOut;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
