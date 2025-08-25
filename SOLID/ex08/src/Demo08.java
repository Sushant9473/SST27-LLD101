public class Demo08 {
    public static void main(String[] args) {
        PedalVehicle v = new Bicycle();
        v.pedal(10);
        // v.startEngine(); // compile-time error: PedalVehicle does not have startEngine
    }
}
