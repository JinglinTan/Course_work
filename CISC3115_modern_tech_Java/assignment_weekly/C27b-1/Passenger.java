public class Passenger {
  private int id;
  private String name;
  private int seatClass;
  private int seatNumber;

  public Passenger(int id, String name, int seatClass) {
    this.id = id;
    this.name = name;
    this.seatClass = seatClass;
  }

  public String toString() {
    return "Passenger[id=" + id + ",name=" + name + ",seatClass=" + seatClass +
    ",assigned seatNumber=" + seatNumber + "]";
  }

  public int getSeatClass() {
    return this.seatClass;
  }

  public int getSeatNumber() {
    return this.seatNumber;
  }

  public void assignSeat(int seatNumber) {
    this.seatNumber = seatNumber;
  }
}
