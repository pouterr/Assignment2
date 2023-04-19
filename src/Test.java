
public class Test {
    public static void main(String[] args){
        MyLinkedList<Object> arrayList= new MyLinkedList<>();
        arrayList.add(5);
        arrayList.add(4);
        arrayList.add(1);

        for(int i = 0;i<3;i++){
            System.out.print(arrayList.get(i));
        }
        arrayList.remove(1);
        for(int i = 0;i<2;i++){
            System.out.print(arrayList.get(i));
        }
    }
}
