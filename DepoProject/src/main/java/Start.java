import java.util.Scanner;

public class Start {

    public static void start(Depo depo) {
        Scanner scanner = new Scanner(System.in);
        int secim;

        do {
            System.out.println("1- Ürün Tanımlama\n2- Ürün Listeleme\n3- Ürün Girişi\n4- Ürünü Rafa Koy\n5- Ürün Çıkışı\n6- Id çağır\n7- Ürün silme\n0- Çıkış");
            System.out.print("Seçiminizi yapın: ");
            secim = scanner.nextInt();

            switch (secim) {
                case 1://ürün tanımlama

                    String urunIsmi;
                    String uretici;
                    String birim;
                    System.out.println("ürün bilgilerini giriniz");
                    scanner.nextLine();
                    System.out.print("Ürün ismi :");
                    urunIsmi = Kontrol.isEmptyIsBlank(scanner,"Ürün ismi :");
                    System.out.print("Üretici :");
                    uretici= Kontrol.isEmptyIsBlank(scanner,"Üretici :");
                    System.out.print("Birim :");
                     birim= Kontrol.isEmptyIsBlank(scanner,"Birim :");

                    depo.urunTanimlama(urunIsmi, uretici, birim);
                    depo.urunListele();
                    break;


                case 2://ürün listeleme
                    depo.urunListele();
                    break;

                case 3: //ürün ekleme
                    System.out.print("Ürün ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Miktar: ");
                    double miktar = scanner.nextDouble();

                    if (miktar<0){
                       miktar= Kontrol.miktarSifirdanKucukOlamaz(scanner,id,miktar);
                    }
                    depo.urunGirisi(id, (int) miktar);
                    depo.urunListele();
                    break;

                case 4://ürünü rafa koyma
                    System.out.print("Ürün ID: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Raf: ");
                    String raf = scanner.nextLine();
                    depo.urunuRafaKoy(id, raf);
                    depo.urunListele();
                    break;

                case 5://ürün çıkarma
                    System.out.print("Ürün ID: ");
                    id = scanner.nextInt();
                    System.out.print("Miktar: ");
                    miktar = scanner.nextDouble();
                    if (miktar<0){
                        miktar= Kontrol.miktarSifirdanKucukOlamaz(scanner,id,miktar);
                    }
                    depo.urunCikisi(id, (int) miktar);
                    depo.urunListele();
                    break;
                case 6://Id çağırma
                    System.out.print("ürün ismi : ");
                    scanner.nextLine();
                    urunIsmi=scanner.nextLine();
                    depo.urunIdGetir(urunIsmi);
                    break;
                case 7://Ürün silme
                    System.out.print("ürün id : ");
                    id= scanner.nextInt();
                    depo.urunSilme(id);
                    depo.urunListele();
                    break;

                case 0:
                    System.out.println("Çıkış yapılıyor...\nGüncel Ürün Listesi :");
                    depo.urunListele();
                    break;

                default:
                    System.out.println("Geçersiz seçim!");
            }
        } while (secim != 0);

        scanner.close();
    }

}
