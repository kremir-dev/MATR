public class Kitap {
    String kitapAdi;
    String yazar;
    String ID;
    String durum;

    

    public Kitap(String kitapAdi, String yazar, String ID) {
        this.kitapAdi = kitapAdi;
        this.yazar = yazar;
        this.ID = ID;
        this.durum = "Mevcut";
    }

}
