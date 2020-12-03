import java.util.Scanner;
public class Main {
    public static int ortHesapla(int kriterSayisi,int [] notlarDizi,int [] kriterEtki)   //ortalama hesaplama metodu oluşturdum.
    {
        int toplam=0;
        for (int i =0; i<kriterSayisi; i++)
        {
            int carpim = notlarDizi[i]*kriterEtki[i];
            toplam = toplam + carpim;
        }

        return (toplam/100);
    }

    public static void main(String[] args) {
        System.out.println("**********Nilay Okulları Bilgi Sistemine Hoşgeldiniz!**********");

        System.out.print("Dersin adını giriniz: ");
        Scanner scan = new Scanner(System.in);
        String dersAdi = scan.nextLine();

        int kriterSayisi;
        System.out.print("Derse ait kaç değerlendirme kriteri var?: ");
        kriterSayisi = scan.nextInt();

        String [] kriterler = new String[kriterSayisi];
        int [] kriterEtki = new int[kriterSayisi];

        for (int i=0; i<kriterSayisi; i++)
        {
            scan.nextLine();// Bu satırdaki kodu ekleme sebebim aynı scan nesnesini kullanarak döngüde nextLine metodunu çağırdığımda 1. kriter yazıp klavyeden giriş almayıp 1 alt satıra geçiyordu. Bu sorunun sebebi üstte scan ile nextInt'in kullanılması ve bu metodun da sadece int değerler okuması.Bundan sonra nextLine kullandığımda direk \n alıyor program. Bunu çözmek içinse nextInt'den sonra birkez scan.nextLine(); eklemek.
            // Eklemek içinse en stratejik yer burasıdır. Çünkü 13. satırdaki nextInt'in etkisini döngüdeki ilk nextLine için kırıyor ve döngünün ilerisinde nextInt olduğu için döngü her dönüşünde başta bu işleme ihtiyaç duyuyoruz.
            System.out.print(i+1 +". Kriterin adı nedir?: ");
            kriterler[i] = scan.nextLine();
            System.out.print(i+1 +". Kriterin etkisi nedir?: ");
            kriterEtki[i] = scan.nextInt();

        }
        int topla=0;
        for (int i=0; i<kriterSayisi; i++)
        {
            topla += kriterEtki[i];
        }
        if(topla<0 || topla!=100)
        {
            System.out.println("Ders kriterlerini yanlış girdiniz! Ders kriterleri toplamı yalnızca 100 etmelidir. Çünkü notlandırma sistemi 100 üzerindendir.");
            System.exit(0);
        }
        //ders kriterleri toplamı 100'ü geçince yanlış olduğunu söyleyip programdan çıkış yapar.
        

        System.out.println();
        System.out.print("Öğrencinin Adı Soyadı: ");
        scan.nextLine();
        String adSoyad = scan.nextLine();

        int [] notlarDizi = new int[kriterSayisi];

        for (int i =0; i<kriterSayisi; i++)
        {
            System.out.print("Öğrencinin "+kriterler[i]+" notu: ");
            notlarDizi[i] = scan.nextInt();

        }
        System.out.println();
        System.out.print("Adı Soyadı     ");
        for (int i =0; i<kriterSayisi; i++)
        {
            System.out.print(kriterler[i]+"     ");
        }
        System.out.println("Ortalama");
        //yukarıdaki 6 satır Ad soyad Vize Final Ortalama gibi başlıkları yazdırdı.
        System.out.print(adSoyad);
        for (int a=0; a<(15-adSoyad.length()); a++) //adSoyad'dan sonra yeterince boşluk bırakılmasını sağlar. 15 "Adı Soyadı     " deki karakter sayısından gelmektedir.
        {
            System.out.print(" ");
        }
        for (int i =0; i<kriterSayisi; i++)
        {
            System.out.print(notlarDizi[i]+"        ");
        }
        System.out.print(ortHesapla(kriterSayisi,notlarDizi,kriterEtki));   //ortHesapla metodunu çağırdık

    }
}
