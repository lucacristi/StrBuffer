import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
        StrBuffer buffer = new StrBuffer();
        buffer.addString("Luca");
        buffer.addString("Flavius");
        buffer.addString("Cristian");
        System.out.println("Second string in buffer is: " + buffer.elementAt(1));

        buffer.removeString(1);
        System.out.println("New second string in buffer is: " + buffer.elementAt(1));

        buffer.listAll();

        System.out.println("Printing all elemnts: " + Arrays.toString(buffer.getAll()));


        //SET
        System.out.println("\n--------------SET------------------\n");

        StrSet set1 = new StrSet(new String[]{"1","2","3"});
        StrSet set2 = new StrSet(new String[]{"3","4","5"});

        System.out.println(Arrays.toString(set1.union(set2).getAll()));
        System.out.println(Arrays.toString(set1.difference(set2).getAll()));
        System.out.println("Set1 elements: " + Arrays.toString(set1.getAll()));
        System.out.println("Set1 contains 2?: " + set1.contains("2"));
        System.out.println("Set1 contains 4?: " + set1.contains("4"));

        //STACK
        System.out.println("\n--------------STACK------------------\n");

        StrStack stack = new StrStack();
        System.out.println("Is stack empty?: " + stack.isEmpty());
        stack.addString("floor");
        stack.addString("leve1");
        stack.addString("leve2");
        System.out.println("Is stack empty?: " + stack.isEmpty());

        System.out.println("\nTop element is: " + stack.top());
        System.out.println("Deleted element was: " + stack.pop());
        System.out.println("New top element is: " + stack.top());

        stack.push("Ceil");
        System.out.println("Top element is: " + stack.top());
    }
}
