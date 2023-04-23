
public class Test {
    public static void main(String[] args){
        MyArrayList<Object> arrayList= new MyArrayList<>();
        arrayList.add("5");
        arrayList.add("4");
        arrayList.add("1");

        for(int i = 0;i<3;i++){
            System.out.print(arrayList.get(i)+" ");
        }
        System.out.print("\n");
        System.out.println("Removing element on index 1");

        arrayList.remove(1);
        for(int i = 0;i<2;i++){
            System.out.print(arrayList.get(i)+" ");
        }
        System.out.print("\n");

        System.out.println("size: "+arrayList.size());
        System.out.print("\n");

        System.out.println("2 in list: "+arrayList.contains(2));
        System.out.print("\n");

        System.out.println("Adding 2 at index 1");
        arrayList.add("2",1);
        for(int i = 0;i<3;i++){
            System.out.print(arrayList.get(i)+" ");
        }
        System.out.print("\n");

        System.out.println("Removing element 2");
        arrayList.remove("2");
        for(int i = 0;i<arrayList.size();i++){
            System.out.print(arrayList.get(i)+" ");
        }
        System.out.print("\n");

        System.out.println("clear list");
        arrayList.clear();
        for(int i = 0;i<arrayList.size();i++){
            System.out.print(arrayList.get(i)+" ");
        }
        System.out.print("\n");

        System.out.println("Creating list: 6 5 2");
        arrayList.add(6);
        arrayList.add(5);
        arrayList.add(2);
        for(int i = 0;i<arrayList.size();i++){
            System.out.print(arrayList.get(i)+" ");
        }
        System.out.print("\n");

        System.out.println("Sort list");
        arrayList.sort();
        for(int i = 0;i<arrayList.size();i++){
            System.out.print(arrayList.get(i)+" ");
        }
        System.out.print("\n");

        System.out.println("Check index of 5: "+arrayList.indexOf(5));
        System.out.println("Adding 5");
        arrayList.add(5);
        for(int i = 0;i<arrayList.size();i++){
            System.out.print(arrayList.get(i)+" ");
        }
        System.out.print("\n");
        System.out.println("Check last index of 5: "+arrayList.lastIndexOf(5));


    }
}
