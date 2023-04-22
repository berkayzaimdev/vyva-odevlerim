package odev04;
import java.util.Arrays;

public class RadixSort
{
    // Radix sort, diziyi sıralarken dizi elemanlarının basamaklarını baz alan sıralama algoritmasıdır
    // LSD ve MSD radix sort olmak üzere iki farklı şekilde gerçekleştirilebilir. Biz LSD yani birler basamağı metodunu kullanacağız
    public static void sirala(int[] arr)
    {
        final int BASE=10; // kullanacağımız sayı sistemi
        int max = Integer.MIN_VALUE,c=0;
        for(int i:arr) if(i>max) max=i;
        final int BASAMAK=String.valueOf(max).length(); // dizideki en büyük elemanın basamak sayısı
        for(int i=0;i<BASAMAK;i++)
        {
            int[] basamaksayisi = new int[BASE];
            int[] temp = new int[arr.length];

            for (int j = 0; j < arr.length; j++)
            {
                int digit = basamakDegeri(arr[j], i);
                basamaksayisi[digit]++;
            }

            for (int j = 1; j < BASE; j++) basamaksayisi[j] += basamaksayisi[j - 1];

            for (int j = arr.length - 1; j >= 0; j--)
            {
                int digit = basamakDegeri(arr[j], i);
                temp[--basamaksayisi[digit]] = arr[j];
            }

            for (int j = 0; j < arr.length; j++) arr[j] = temp[j];

            System.out.println((i+1)+".adım sonucu oluşan dizi: "+Arrays.toString(arr));
        }
    }

    public static int basamakDegeri(int num, int place)
    {
        return (int) (num / Math.pow(10, place)) % 10;
    }

    public static void main(String[] args)
    {
        int[] arr = { 170, 45, 75, 90, 802, 24, 2, 66 };
        System.out.println("Sıralamadan önce dizi: "+Arrays.toString(arr));
        sirala(arr);
    }
}
