import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Depo {

    private Map<Integer, Urun> urunDepo = new HashMap<>();
    private int idSayaci = 1000; // Başlangıç ID değeri (1000'den başlayabilir)


    // Ürün Tanımlama Metodu
    public void urunTanimlama(String urunIsmi, String urqetici, String birim) {
        String mavi= "\u001B[34m";
        String reset = "\u001B[0m";
        String sarı="\u001B[33m";
        boolean ayniUrunVarMi = urunDepo.values().stream()
                .anyMatch(t -> t.getUrunIsmi().equalsIgnoreCase(urunIsmi) && t.getUretici().equalsIgnoreCase(uretici));

        if (ayniUrunVarMi) {
            System.out.println(mavi+"Bu ürün zaten tanımlanmış: "+reset + urunIsmi + " - " + uretici);
        } else {
            Urun yeniUrun = new Urun(idSayaci++, urunIsmi, uretici, birim);
            urunDepo.put(yeniUrun.getId(), yeniUrun);

            System.out.println(sarı+"Yeni ürün tanımlandı: " +reset+ yeniUrun);
        }
    }

    // Ürün listeleme
    public void urunListele() {
        String green ="\u001B[32m";
        String mavi= "\u001B[34m";
        String reset = "\u001B[0m";
        String kırmızı= "\u001B[31m";
        System.out.printf(green+"%-10s %-10s %-10s %-10s %-10s %-10s%n", "ID", "İsim", "Üretici", "Miktar", "Birim", "Raf"+reset);
        System.out.println(kırmızı+"-------------------------------------------------------------"+reset);
        for (Urun urun : urunDepo.values()) {
            System.out.printf(mavi+"%-10d %-10s %-10s %-10.2f %-10s %-10s%n",
                    urun.getId(), urun.getUrunIsmi(), urun.getUretici(),
                    urun.getMiktar(), urun.getBirim(), urun.getRaf()+reset);
        }
    }

    // Ürün Girişi
    public void urunGirisi(int id, double miktar) {
        String kırmızı= "\u001B[31m";
        String reset = "\u001B[0m";
        Urun urun = urunDepo.get(id);
        if (urun != null) {
            urun.setMiktar(urun.getMiktar() + miktar);
        } else {
            System.out.println(kırmızı+"Girilen Id de bir ürün bulunamadı."+reset);
        }
    }


    // Ürünü rafa koyma
    public void urunuRafaKoy(int id, String raf) {
        String kırmızı= "\u001B[31m";
        String reset = "\u001B[0m";
        Urun urun = urunDepo.get(id);
        if (urun != null) {
            boolean ayniRafKullanimdaMi = urunDepo.values().stream()
                    .anyMatch(u -> raf.equals(u.getRaf()) && u.getId() != id);

            if (!ayniRafKullanimdaMi) {
                urun.setRaf(raf);
                System.out.println("Ürün rafa yerleştirildi: " + raf);
            } else {
                System.out.println(kırmızı+"Bu raf dolu ve aynı ID'ye sahip olmayan başka bir ürün var."+reset);
            }
        } else {
            System.out.println(kırmızı+"Ürün bulunamadı."+reset);
        }
    }



    // Ürün çıkışı
    public void urunCikisi(int id, double miktar) {
        String kırmızı= "\u001B[31m";
        String reset = "\u001B[0m";
        Urun urun = urunDepo.get(id);
        if (urun != null) {
            if (urun.getMiktar() >= miktar) {
                urun.setMiktar(urun.getMiktar() - miktar);
                System.out.println(miktar+ " " + urun.getBirim() + " " +urun.getUrunIsmi()+  " çıkarıldı.");
            } else {
                System.out.println(kırmızı+"Stoktaki "+ urun.getUrunIsmi()+" miktarından fazla ürün çıkışı yapılamaz.\n" +
                        "Stokta "+reset + urun.getMiktar()+ " "+ urun.getBirim()+" "+ urun.getUrunIsmi() + kırmızı+" vardır."+reset);
            }
        } else {
            System.out.println(kırmızı+"Girilen Id de bir ürün bulunamadı."+reset);
        }
    }

    public void urunIdGetir(String urunIsmi) {
        String kırmızı= "\u001B[31m";
        String reset = "\u001B[0m";
        String sarı="\u001B[33m";
        int urunId=0;
        for (Urun urun : urunDepo.values()) {
            if (urun.getUrunIsmi().equalsIgnoreCase(urunIsmi)) {
                System.out.println(sarı+urunIsmi+" ürününün Id si: "+reset+ urun.getId()+ " (üreticisi : " +urun.getUretici()+ " )");
                urunId=urun.getId();
            }
        }
        if (urunId==0){
            System.out.println(kırmızı+urunIsmi+" listede bulunamadı"+reset);
        }
    }
    public void urunSilme(Integer id){
        String kırmızı= "\u001B[31m";
        String reset = "\u001B[0m";
        String green ="\u001B[32m";
        Urun urun=urunDepo.get(id);
        if (urun !=null){
            System.out.println(kırmızı+ urun.getUrunIsmi()+reset+ " isimli ürün siliniyor.");
            System.out.println("silme işlemini onaylamak için :" + kırmızı+"d"+reset );
            System.out.println("işlemi iptal etmek için :" + green+  " c " +reset+ " tuşuna basınız" );
            Scanner input=new Scanner(System.in);
            String cıkıs=input.next();
           if (cıkıs.equalsIgnoreCase("d")){
                urunDepo.remove(id);
               System.out.println(urun.getUrunIsmi()+ kırmızı+" isimli ürününüz listeden silinmiştir"+reset);
           }else if (cıkıs.equalsIgnoreCase("c")){
               System.out.println(green+"silme işleminiz iptal edildi"+reset);
           }
        }else {
            System.out.println(kırmızı+"Girilen Id de bir ürün bulunamadı."+reset);

        }

    }


}



