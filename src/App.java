
import java.util.Scanner;
import java.util.ArrayList;

public class App {

    ArrayList<Kitap> kitaplar = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        while (true) {
        System.out.println("===== Kütüphane =====");
        System.out.println("1- Kitap Listele");
        System.out.println("2- Kitap Ekle");
        System.out.println("3- Kitap Ödünç Al");
        System.out.println("4- Kitap İade Et");
        System.out.println("5- Kitap Ara");
        System.out.println("0- Çıkış\n");
        System.out.print("Seçiminiz: ");
        int secim = scanner.nextInt();
        scanner.nextLine(); 

        switch (secim) {
            case 1:
                System.out.println("Kitaplar listeleniyor...");
                if(kitaplar.isEmpty()) {
                    System.out.println("Kayıtlı kitap bulunmamaktadır.");
                } else {
                    for (Kitap kitap : kitaplar) {
                        System.out.println("Kitap Adı: " + kitap.kitapAdi);
                        System.out.println("Yazar: " + kitap.yazar);
                        System.out.println("ID: " + kitap.ID);
                        System.out.println("Durum: " + kitap.durum);
                        System.out.println("-------------------------");
                    }
                }
                break;
                    
            case 2:
                System.out.println("Kitap ekleme işlemi başlatılıyor...");
                System.out.print("Kitap Adı: ");
                String kitapAdi = scanner.nextLine();
                System.out.print("Yazar: ");
                String yazar = scanner.nextLine();
                System.out.print("ID: ");
                String ID = scanner.nextLine();
                boolean idVarMi = false;
                for (Kitap kitap : kitaplar) {
                    if (kitap.ID.equals(ID)) {
                        idVarMi = true;
                        break;
                    }
                }
                if (idVarMi) {
                    System.out.println("Bu ID ile bir kitap zaten mevcut!");
                } else {
                    kitaplar.add(new Kitap(kitapAdi, yazar, ID));
                    System.out.println("Kitap başarıyla eklendi!");
                }
                break;
            case 3:
                System.out.println("Kitap ödünç alma işlemi başlatılıyor...");
                System.out.println("Ödünç almak istediğiniz kitabın ID'sini giriniz: ");
                String oduncID = scanner.nextLine();

                Kitap oduncKitap = null;
                for (Kitap kitap : kitaplar) {
                    if (kitap.ID.equals(oduncID)) {
                        oduncKitap = kitap;
                        break;
                    }
                }
                if (oduncKitap == null) {
                    System.out.println("Kitap bulunamadı!");
                } else if (oduncKitap.durum.equals("Ödünç Alındı")) {
                    System.out.println("Kitap zaten ödünç alınmış!");
                } else {
                    oduncKitap.durum = "Ödünç Alındı";
                    System.out.println("Kitap başarıyla ödünç alındı!");
                }
                break;
            case 4:
                System.out.println("Kitap iade etme işlemi başlatılıyor...");
                System.out.println("İade etmek istediğiniz kitabın ID'sini giriniz: ");
                String iadeID = scanner.nextLine();
                Kitap iadeKitap = null;
                for (Kitap kitap : kitaplar) {
                    if (kitap.ID.equals(iadeID)) {
                        iadeKitap = kitap;
                        break;
                    }
                }
                if (iadeKitap == null) {
                    System.out.println("Kitap bulunamadı!");
                } else if (iadeKitap.durum.equals("Mevcut")) {
                    System.out.println("Kitap zaten iade edilmiş!");
                } else {
                    iadeKitap.durum = "Mevcut";
                    System.out.println("Kitap başarıyla iade edildi!");
                }
                break;
            case 5:
                System.out.println("Kitap arama işlemi başlatılıyor...");
                System.out.println("Aramak istediğiniz kitabın adını veya yazarını giriniz : ");
                String arananKitapAdi = scanner.nextLine().toLowerCase();
                boolean kitapBulundu = false;
                for (Kitap kitap : kitaplar) {
                    if (kitap.kitapAdi.toLowerCase().contains(arananKitapAdi) 
                        || kitap.yazar.toLowerCase().contains(arananKitapAdi)) {
                        System.out.println("Kitap Adı: " + kitap.kitapAdi);
                        System.out.println("Yazar: " + kitap.yazar);
                        System.out.println("ID: " + kitap.ID);
                        System.out.println("Durum: " + kitap.durum);
                        System.out.println("-------------------------");
                        kitapBulundu = true;
                    }
                }
                if (!kitapBulundu) {
                    System.out.println("Kitap bulunamadı!");
                }
                break;
            case 0:
                System.out.println("Çıkış yapılıyor...");
                scanner.close();
                return;
            default:
                System.out.println("Geçersiz seçim! Lütfen tekrar deneyin.");
        }

    }

    }

}
