package odev02;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        LinkedList dersler = new LinkedList();
        Scanner s = new Scanner(System.in);
        dersler.add(new Ders("Veri Yapıları ve Algoritmalar","BLM2002",3));
        dersler.add(new Ders("Bilgisayar Ağlarına Giriş","BLM2001",3));
        dersler.add(new Ders("Mikroişlemciler","BLM2008",3));
        dersler.add(new Ders("Matematik I","MAT1001",1));
        dersler.add(new Ders("Fizik I","FZK1001",1));
        dersler.add(new Ders("TEST I","TEST1001",2));
        dersler.add(new Ders("TEST II","TEST1002",2));
        dersler.add(new Ders("Fizik II","FZK1002",2));
        dersler.add(new Ders("TEST III","TEST1003",2));
        dersler.add(new Ders("Matematik II","MAT1002",2));

        int secim1,secim2;
        do
        {
            System.out.println("\n\n\n\n1-Ders İşlemleri");
            System.out.println("2-Arama İşlemleri");
            System.out.println("3-Dersleri Yazdır");
            System.out.println("4-Çıkış");
            System.out.println("\nSeçiminiz:");
            secim1=s.nextInt();
            switch(secim1)
            {
                case 1:
                    System.out.println("1-Ders Ekle");
                    System.out.println("2-Ders Sil");
                    System.out.println("3-Ders Deaktive Et");
                    System.out.println("4-Ders Aktive Et");
                    secim2=s.nextInt();
                    int id;
                    switch(secim2)
                    {
                        case 1:
                            String dersadi,derskodu;
                            int semester;
                            System.out.print("Ders Adı:");
                            dersadi=s.next();
                            System.out.print("Ders Kodu:");
                            derskodu=s.next();
                            System.out.print("Sömestr Verisi:");
                            semester=s.nextInt();
                            dersler.add(new Ders(dersadi,derskodu,semester));
                            break;
                        case 2:
                            System.out.println("Ders ID'sini giriniz:");
                            id = s.nextInt();
                            dersler.remove(id);
                            break;
                        case 3:
                            System.out.println("Ders ID'sini giriniz:");
                            id = s.nextInt();
                            dersler.disable(id);
                            break;
                        case 4:
                            System.out.println("Ders ID'sini giriniz:");
                            id = s.nextInt();
                            dersler.enable(id);
                            break;
                    }
                    break;
                case 2:
                    System.out.println("1-Ders Kodu ile Ders Bul");
                    System.out.println("2-Sömestr Verisi ile Ders Bul");
                    System.out.println("3-İndis Aralığı ile Ders Bul");
                    System.out.println("4-Tüm Deaktive Dersleri Bul");
                    System.out.println("5-Seçilen Dersten Sonraki Dersi Bul");
                    System.out.println("6-Seçilen Dersten Sonraki Aynı Sömestra Ait Dersi Bul (Circular şekilde)");
                    System.out.println("\nSeçiminiz:");
                    secim2=s.nextInt();
                    int semester;
                    switch(secim2)
                    {
                        case 1:
                            String kod;
                            System.out.print("Ders kodunu giriniz:");
                            kod = s.next();
                            dersler.getByCode(kod);
                            break;
                        case 2:
                            System.out.println("Sömestr verisini giriniz:");
                            semester = s.nextInt();
                            dersler.listSemesterCourses(semester);
                            break;
                        case 3:
                            int indis1,indis2;
                            System.out.println("Başlangıç indisini giriniz:");
                            indis1 = s.nextInt();
                            System.out.println("Bitiş indisini giriniz:");
                            indis2 = s.nextInt();
                            dersler.getByRange(indis1,indis2);
                            break;
                        case 4:
                            dersler.showDisabled();
                            break;
                        case 5:
                            int id2;
                            System.out.println("Ders ID'sini giriniz:");
                            id2 = s.nextInt();
                            dersler.next(id2);
                            break;
                        case 6:
                            System.out.println("Ders ID'sini giriniz:");
                            semester = s.nextInt();
                            dersler.nextInSemester(semester);
                            break;
                    }
                    break;
                case 3:
                    dersler.goster();
                    System.out.println("Toplam ders sayısı:"+dersler.size());
                    break;
            }
        }
        while(secim1!=4);
    }
}

class Ders
{
    private String dersAdi;
    private String dersKodu;
    private int id,somestr;
    private static int c=1;
    private boolean disabled=false;

    public Ders(String dersAdi, String dersKodu, int somestr)
    {
        this.dersAdi = dersAdi;
        this.dersKodu = dersKodu;
        this.somestr = somestr;
        this.id=c++;
    }

    public String getDersAdi() { return dersAdi; }

    public String getDersKodu() {
        return dersKodu;
    }

    public int getSomestr() {
        return somestr;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public int getId()
    {
        return id;
    }
}
