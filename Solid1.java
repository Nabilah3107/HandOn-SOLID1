// 1. Membuat Interface spesifik (Menerapkan ISP)
interface Notifier {
    void send(String message);}

// 2. Implementasi masing-masing platform secara terpisah (Menerapkan SRP & OCP)
class EmailNotifier implements Notifier {
    public void send(String message) { //override
        System.out.println("Email: " + message);}}

class SMSNotifier implements Notifier {
    public void send(String message) { //override
        System.out.println("SMS: " + message);}}

class WhatsAppNotifier implements Notifier {
    public void send(String message) { //override
        System.out.println("WhatsApp: " + message);}}

// Contoh penambahan fitur baru (Telegram) TANPA mengubah kode lama (Bukti OCP berhasil)
class TelegramNotifier implements Notifier {
    public void send(String message) { //override
        System.out.println("Telegram: " + message);}}

// 3. Kelas Service yang bergantung pada abstraksi interface Notifier (Menerapkan DIP)
class NotificationService {
    private Notifier notifier;
    // Constructor menerima abstraksi Notifier
    public NotificationService(Notifier notifier) {
        this.notifier = notifier;}

    public void notifyUser(String message) {
        notifier.send(message);}}

public class Solid1 {
    public static void main(String[] args) {
        // Mengirim via Email
        NotificationService emailService = new NotificationService(new EmailNotifier());
        emailService.notifyUser("Halo, ini email test!");

        // Mengirim via SMS
        NotificationService smsService = new NotificationService(new SMSNotifier());
        smsService.notifyUser("Haii, Ini SMS test!");

        // Mengirim via WhatsApp
        NotificationService waService = new NotificationService(new WhatsAppNotifier());
        waService.notifyUser("Haloww, Ini pesan WhatsApp test!");

        // Mengirim via Telegram (Platform baru)
        NotificationService telegramService = new NotificationService(new TelegramNotifier());
        telegramService.notifyUser("HII, Ini pesan Telegram baru!");
    }
}