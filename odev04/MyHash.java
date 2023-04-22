package odev04;
import java.util.Scanner;

/*
1. Hashing ile 20 kişilik bir telefon rehberi oluşturunuz. Aşağıdaki gibi isim ve telefon
        numarası içermelidir.
        Ayşe, 559 443 55 34
        Anahtar olarak ismin ilk karakterinden indis üretilmelidir.
        Yazılacak Fonksiyonlar
        - Ekleme
        - Arama
        - Silme

        2. Radix sort sıralama algoritmasını kodlayınız.
*/

public class MyHash
{
    public LinkedList[] rehber;
    public final static int LENGTH=20;

    MyHash()
    {
        this.rehber=new LinkedList[LENGTH];
        for(int i=0; i<LENGTH; i++) rehber[i] = new LinkedList();
    }

    public void ekle(Kisi kisi)
    {
        rehber[hash(kisi.getIsim().charAt(0))].add(new Node(kisi));
    }

    public boolean sil(String telefon)
    {
        for(int i=0;i<LENGTH;i++)
        {
            Node curr = rehber[i].head;
            Node prev = null;
            while (curr != null)
            {
                if (curr.kisi.getTelefon().equals(telefon))
                {
                    if (prev == null) rehber[i].head = curr.next;
                    else prev.next = curr.next;
                    return true;
                }
                prev = curr;
                curr = curr.next;
            }
        }
        return false;
    }

    public Kisi ara(String telefon)
    {
        Node curr;
        for(int i=0;i<LENGTH;i++)
        {
            curr=rehber[i].head;
            while(curr!=null)
            {
                if(curr.kisi.getTelefon().equals(telefon)) return curr.kisi;
                curr=curr.next;
            }
        }
        return null;
    }

    public int hash(int i)
    {
        return i%LENGTH;
    }

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        MyHash hash = new MyHash();
        hash.ekle(new Kisi("Emirhan", "3469852741"));
        hash.ekle(new Kisi("Mehmet Ali", "7584310965"));
        hash.ekle(new Kisi("Recep", "4290831576"));
        hash.ekle(new Kisi("Mustafa", "5019724683"));
        hash.ekle(new Kisi("Enes", "8341592076"));
        hash.ekle(new Kisi("Hazar", "6120983457"));
        hash.ekle(new Kisi("Emir", "9358127406"));
        hash.ekle(new Kisi("Yasin", "2876194350"));
        hash.ekle(new Kisi("Abdurrahman", "7249061385"));
        hash.ekle(new Kisi("Yunus", "8371064925"));
        hash.ekle(new Kisi("Hasan", "5937820416"));
        hash.ekle(new Kisi("Mert", "2698735104"));
        hash.ekle(new Kisi("Ahmet", "4089251637"));
        hash.ekle(new Kisi("Erdem", "1758942630"));
        hash.ekle(new Kisi("Melih", "6309718245"));
        hash.ekle(new Kisi("Ersin", "9273156840"));
        hash.ekle(new Kisi("Emre", "5210493768"));
        hash.ekle(new Kisi("Muhammed", "3864079251"));
        hash.ekle(new Kisi("Eren", "7902615348"));
        hash.ekle(new Kisi("Fatih", "1647583920"));
        int secim;
        System.out.println("     BERKAY TELEKOMÜNİKASYON");
        do
        {
            System.out.println("=================================");
            System.out.println("Yapmak istediğiniz işlemi seçiniz:");
            System.out.println("1- Rehberi görüntüle");
            System.out.println("2- Kişi ekle");
            System.out.println("3- Kişi ara");
            System.out.println("4- Kişi sil");
            System.out.println("5- Çıkış yap");
            System.out.println("=================================");
            secim=s.nextInt();
            String numara;
            switch(secim)
            {
                case 1:
                    for(int i=0;i<LENGTH;i++)
                    {
                        Node curr=hash.rehber[i].head;
                        if(curr==null) continue;
                        System.out.println("**********************");
                        System.out.println(i+".indise ait numaralar");
                        while(curr!=null)
                        {
                            System.out.println("----------------------");
                            System.out.println("İsim: "+curr.kisi.getIsim());
                            System.out.println("Numara: "+curr.kisi.getTelefon().substring(0,3)+" "+curr.kisi.getTelefon().substring(3,6)+" "+curr.kisi.getTelefon().substring(6,8)+" "+curr.kisi.getTelefon().substring(8,10));
                            System.out.println("----------------------");
                            curr=curr.next;
                        }
                        System.out.println("**********************\n\n");
                    }
                    break;
                case 2:
                    String isim;
                    System.out.println("Eklemek istediğiniz kişinin adı:");
                    isim=s.next();
                    System.out.println("Numarası:");
                    numara=s.next();
                    hash.ekle(new Kisi(isim,numara));
                    System.out.println("İşlem başarılı!");
                    break;
                case 3:
                    System.out.println("Aramak istediğiniz kişinin numarası:");
                    numara=s.next();
                    Kisi sonuc = hash.ara(numara);
                    System.out.println(sonuc!=null?"Numaranın kayıtlı olduğu kişi:"+sonuc.getIsim():"Girdiğiniz numara rehberde kayıtlı değil!");
                    break;
                case 4:
                    System.out.println("Silmek istediğiniz kişinin numarası:");
                    numara=s.next();
                    System.out.println(hash.sil(numara)?"İşlem başarılı!":"Girdiğiniz numara rehberde kayıtlı değil!");
                    break;
            }
        }
        while(secim!=5);
        System.out.println("Görüşmek üzere!");
    }
}

class LinkedList
{
    public Node head;

    LinkedList()
    {
        head=null;
    }

    public void add(Node node)
    {
        if(head==null) head=node;
        else
        {
            Node temp = head;
            while (temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = node;
        }
    }
}

class Node
{
    public Kisi kisi;
    public Node next;

    Node(Kisi kisi)
    {
        this.kisi=kisi;
        this.next=null;
    }
}

class Kisi
{
    private String isim,telefon;

    Kisi(String isim,String telefon)
    {
        this.isim=isim;
        this.telefon=telefon;
    }

    public String getIsim() {
        return isim;
    }

    public String getTelefon() {
        return telefon;
    }
}
