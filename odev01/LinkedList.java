package odev02;

public class LinkedList
{
    Node head;

    public LinkedList()
    {
        head=null;
    }

    public void add(Ders ders)
    {
        Node yeniDers = new Node(ders,null);
        if(head==null) head=yeniDers;
        else
        {
            Node temp = head;
            while (temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = yeniDers;
        }
    }

    public void remove(int id)
    {
        if (head == null) return;

        if (head.ders.getId() == id)
        {
            head = head.next;
            return;
        }

        Node prev = head;
        Node curr = head.next;
        while (curr != null)
        {
            if (curr.ders.getId() == id)
            {
                prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }


    public void next(int id)
    {
        Node temp = head;
        while(temp!=null)
        {
            if(!temp.ders.isDisabled()&&temp.ders.getId()>id)
            {
                print(temp.ders);
                break;
            }
            temp=temp.next;
        }
    }

    public void nextInSemester(int id)
    {
        Node nd = head,found=null;
        int semester=0;
        while(nd!=null)
        {
            if(!nd.ders.isDisabled()&&nd.ders.getId()==id)
            {
                semester = nd.ders.getSomestr();
                found = nd;
            }
            if(!nd.ders.isDisabled()&&nd.ders.getId()>id&&nd.ders.getSomestr()==semester)
            {
                print(nd.ders);
                return;
            }
            nd=nd.next;
        }
        nd=head;
        while(nd!=found)
        {
            if(!nd.ders.isDisabled()&&nd.ders.getSomestr()==semester)
            {
                print(nd.ders);
                return;
            }
            nd=nd.next;
        }
    }

    public int size()
    {
        int c=0;
        Node nd = head;
        while(nd!=null)
        {
            if(!nd.ders.isDisabled()) c++;
            nd=nd.next;
        }
        return c;
    }

    public void goster()
    {
        Node nd = head;
        while(nd!=null)
        {
            if(!nd.ders.isDisabled()) print(nd.ders);
            nd=nd.next;
        }
    }

    public void getByCode(String code)
    {
        Node temp = head;
        while(temp!=null)
        {
            if(temp.ders.getDersKodu().equals(code))
            {
                print(temp.ders);
                System.out.println("Ders durumu:"+(temp.ders.isDisabled()?"deaktif":"aktif"));
            }
            temp=temp.next;
        }
    }

    public void listSemesterCourses(int semester)
    {
        Node nd = head;
        while(nd!=null)
        {
            if(nd.ders.getSomestr()==semester&&!nd.ders.isDisabled()) print(nd.ders);
            nd=nd.next;
        }
    }

    public void getByRange(int start_index,int last_index)
    {
        Node nd = head;
        while(nd!=null)
        {
            if(nd.ders.getId()-1<=last_index&&nd.ders.getId()-1>=start_index&&!nd.ders.isDisabled()) print(nd.ders);
            nd=nd.next;
        }
    }

    public void disable(int id)
    {
        Node nd = head;
        while(nd!=null)
        {
            if(nd.ders.getId()==id)
            {
                nd.ders.setDisabled(true);
                break;
            }
            nd=nd.next;
        }
    }

    public void enable(int id)
    {
        Node nd = head;
        while(nd!=null)
        {
            if(nd.ders.getId()==id)
            {
                nd.ders.setDisabled(false);
                break;
            }
            nd=nd.next;
        }
    }

    public void showDisabled()
    {
        Node nd = head;
        while(nd!=null)
        {
            if(nd.ders.isDisabled()) print(nd.ders);
            nd=nd.next;
        }
    }

    public void print(Ders ders)
    {
        System.out.println("\n\n");
        System.out.println("====================================");
        System.out.println("ID:"+ders.getId());
        System.out.println("Ders Adı:"+ders.getDersAdi());
        System.out.println("Ders Kodu:"+ders.getDersKodu());
        System.out.println("Sömestr Bilgisi:"+ders.getSomestr());
        System.out.println("====================================");
    }
}

class Node
{
    Ders ders;
    Node next;

    public Node(Ders ders, Node next){
        this.ders=ders;
        this.next=next;
    }
}
