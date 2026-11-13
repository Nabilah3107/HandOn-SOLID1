//1, Interface untuk kendaraan berbahan bakar
interface FuelVehicle {
    void startEngine();
    void isiBahanBakar();}
// 2. Interface khusus untuk kendaraan bertenaga listrik
interface ElectricVehicle {
    void isiBaterai();}

// 3. Implementasi untuk Mobil Bensin
class MobilBensin implements FuelVehicle {
    public void startEngine() { //overriding
        System.out.println("Menyalakan mesin bensin kendaraan...");}
    public void isiBahanBakar() { //overriding
        System.out.println("Mengisi bahan bakar bensin...");}}

class MobilListrik implements ElectricVehicle {
    public void isiBaterai() { //overriding
        System.out.println("Mengisi baterai kendaraan listrik...");}}

class Sepeda {
    public void gowes() {
        System.out.println("Sepeda dikayuh secara manual di jalan.");}}

public class Solid3 {
    public static void main(String[] args) {
        // Menguji Mobil Listrik
        ElectricVehicle mobilListrik = new MobilListrik();
        mobilListrik.isiBaterai();

        // Menguji Mobil Bensin
        FuelVehicle mobilBensin = new MobilBensin();
        mobilBensin.startEngine();
        mobilBensin.isiBahanBakar();

        // Menguji Sepeda (Aman, tidak ada paksaan method mesin)
        Sepeda sepeda = new Sepeda();
        sepeda.gowes();}}
