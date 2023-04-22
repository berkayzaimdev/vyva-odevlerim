package odev03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Node {
    char data;
    Node next;

    public Node(char data) {
        this.data = data;
        this.next = null;
    }
}

public class MyStack
{
    Node last;

    public MyStack() {
        this.last = null;
    }

    public boolean bosMu()
    {
        return last == null;
    }

    public void push(char data)
    {
        Node newNode = new Node(data);
        newNode.next = last;
        last = newNode;
    }

    public char pop()
    {
        if (bosMu())
        {
            System.out.println("Stack boş!");
        }
        char data = last.data;
        last = last.next;
        return data;
    }

    public char peek()
    {
        return last.data;
    }

    public static boolean FindPalindromes(String str)
    {
        MyStack s = new MyStack();
        String s1 = "", s2 = "";
        str=str.toLowerCase();
        for (int i = 0; i < str.length(); i++)
        {
            if (Character.isLetter(str.charAt(i)))
            {
                s.push(str.charAt(i));
                s1 += str.charAt(i);
            }
        }
        while (!s.bosMu())
        {
            if (Character.isLetter(s.peek())) s2 += s.pop();
        }
        return s1.equals(s2);
    }


    public static void main(String[] args)
    {
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\ASUS\\Downloads\\DERS\\2.Sınıf\\2.Dönem\\Veri Yapıları\\odevler\\src\\odev3\\odev.txt.txt"));
            String str;
            while((str=reader.readLine())!=null) System.out.println("'"+str+"' -> bir palindrom"+(FindPalindromes(str)?"dur.":" değildir!"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
