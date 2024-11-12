import java.util.Scanner;

public class Kontrol {


   public static String isEmptyIsBlank(Scanner scanner, String mesaj) {

       String reset = "\u001B[0m";
       String kırmızı= "\u001B[31m";
       String girdi;
       do {
            girdi=scanner.nextLine();
               if (girdi.isBlank() || girdi.isEmpty()) {
                   System.out.print(kırmızı+"Bu alan boş bırakılamaz. lütfen geçrli bir değer giriniz+\n"+reset+mesaj);
               } else {
                   break;
               }

       }while (true) ;
       return girdi;
   }

   public static Double miktarSifirdanKucukOlamaz(Scanner scanner, int id, double miktar){
       String sarı="\u001B[33m";
       String mavi= "\u001B[34m";
       String reset = "\u001B[0m";
       String kırmızı= "\u001B[31m";

       int secenek;
           do {
               System.out.println(kırmızı+"Girilecek  miktar 0 dan küçük olamaz."+reset);
               System.out.println(mavi+"İşlemi tekrarlamak için : "+reset+ sarı+1 +reset+mavi+" (bir)\nAnamenüye dönmek için   : "+reset+sarı+9+reset+mavi+" (dokuz) a basınız"+reset);
                secenek=scanner.nextInt();
               if (secenek==1){

                   System.out.print("Miktar: ");
                   miktar = scanner.nextDouble();
                   return miktar ;
               } else if (secenek==9) {
                   return miktar=0;
               }
           }while (miktar<=0);
        return miktar ;

   }


}