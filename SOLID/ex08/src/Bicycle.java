public class Bicycle implements PedalVehicle {
    @Override
    public void pedal(int effort) {
        System.out.println("Pedal effort " + effort);
    }
}