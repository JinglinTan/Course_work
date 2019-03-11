import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;


public class PriorityQueueBasics {
  private static Random rng = new Random();
  private static int id = 0;
  private static LinkedList<Integer> seats = new LinkedList<Integer>();

  public static void main(String[] args) {
    PriorityQueue<Passenger> queue = new PriorityQueue<Passenger>(new PassengerComparator());
    makeSeats();
    enqueue(queue, 5);
    assignSeat(queue);
  }

  private static void makeSeats() {
    for(int i = 0; i < 50; i++) {
      seats.add(i);
    }
  }

  private static void assignSeat(Queue<Passenger> queue) {
    while(!queue.isEmpty()) {
      int seatNumber = rng.nextInt(seats.size());
      Passenger p = queue.poll();
      p.assignSeat(seatNumber);
      seats.remove(seatNumber);
      System.out.println(p);
    }
  }

  private static void enqueue(Queue<Passenger> queue, int maxPassengers) {
    for (int i=0; i<maxPassengers; i++) {
      Passenger p = makeRandomPassenger();
      queue.add(p);
    }
  }

  private static Passenger makeRandomPassenger() {
    String[] names = {"John", "Tom", "Ben", "Arthur",
      "Emma", "Erica", "Sally", "Rose", "Uma", "Anthony", "Jerry", "Sasha", "Wendy"};
    int[] seatClasses = {1, 2};

    String name = names[rng.nextInt(names.length)];
    int seatClass = seatClasses[rng.nextInt(seatClasses.length)];
    id ++;
    return new Passenger(id, name, seatClass);
  }
}
