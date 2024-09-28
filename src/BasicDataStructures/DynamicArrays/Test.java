package BasicDataStructures.DynamicArrays;

public class Test {
    public static void main(String[] args) {
        DynamicArrays da = new DynamicArrays();
        da.add(3);
        System.out.println(da.toString());
        da.add(9);
        System.out.println(da.toString());
        da.add(11);
        System.out.println(da.toString());
        da.add(1,7);
        System.out.println(da.toString());

        da.foreach((integer -> {
            System.out.print(integer + " ");
        }));
        System.out.println("");

        for (Integer i : da) {
            System.out.print(i + " ");
        }
        System.out.println("");

        da.stream().forEach((element) -> System.out.print(element + " "));
        System.out.println("");

        da.remove(3);
        System.out.println(da.toString());
        da.remove(1);
        System.out.println(da.toString());

        da.add(17);
        System.out.println(da.toString());
        da.add(32);
        System.out.println(da.toString());
        da.add(91);
        System.out.println(da.toString());
        da.add(4,7);
        System.out.println(da.toString());

        da.add(12);
        System.out.println(da.toString());
        da.add(6);
        System.out.println(da.toString());
        da.add(66);
        System.out.println(da.toString());
        da.add(8,666);
        System.out.println(da.toString());

        da.remove(7);
        System.out.println(da.toString());
        da.remove(4);
        System.out.println(da.toString());
        for (int i = 0; i < 20; i++) {
            da.add(12);
        }

        System.out.println(da.toString());
    }
}
