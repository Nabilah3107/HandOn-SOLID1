// 1. Buat Interface untuk Aturan Nilai
interface GradingStrategy {
    double hitungNilai(double tugas, double uts, double uas);}

// Implementasi aturan nilai standar (Bobot: 30%, 30%, 40%)
class StandardGrading implements GradingStrategy {
    public double hitungNilai(double tugas, double uts, double uas) { //overriding
        return (tugas * 0.3) + (uts * 0.3) + (uas * 0.4);}}

// 2. KELAS KALKULATOR (Menerapkan OCP & DIP)
class GradeCalculator {
    private GradingStrategy gradingStrategy;
    // Bergantung pada abstraksi (Interface), bukan angka/rumus kaku
    public GradeCalculator(GradingStrategy gradingStrategy) {
        this.gradingStrategy = gradingStrategy;}

    public double hitungNilaiAkhir(double tugas, double uts, double uas) {
        return gradingStrategy.hitungNilai(tugas, uts, uas);}
}

// 3. SOLUSI SRP: Pisahkan Tugas Cetak & Database
class ReportPrinter {
    public void cetakLaporan(String nama, double nilai) {
        System.out.println("Laporan Nilai Mahasiswa: " + nama + " = " + nilai);}}

class GradeRepository {
    public void simpanDatabase(String nama, double nilai) {
        System.out.println( nama + " = " + nilai + " Telah tersimpan ke database");}}

public class Solid2 {
    public static void main(String[] args) {
        // Tentukan strategi penilaian yang mau dipakai
        GradingStrategy strategy = new StandardGrading();

        // Inisialisasi objek sesuai tanggung jawabnya masing-masing
        GradeCalculator calculator = new GradeCalculator(strategy);
        ReportPrinter printer = new ReportPrinter();
        GradeRepository repository = new GradeRepository();

        // Eksekusi program
        double nilai = calculator.hitungNilaiAkhir(80, 85, 90);
        printer.cetakLaporan("Andi", nilai);
        repository.simpanDatabase("Andi", nilai);
    }}