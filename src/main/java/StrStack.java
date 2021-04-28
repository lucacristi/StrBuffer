public class StrStack extends StrBuffer {

    public StrStack(){

    }

    public StrStack(String[] strings){
        int receivedStringsLength = strings.length;

        if(receivedStringsLength > capacity){
            capacity = receivedStringsLength + receivedStringsLength/2;
        }
        size = receivedStringsLength;
        super.strings = strings;
    }

    public String top(){
        return strings[size-1];
    }

    public void push(String string){
        super.addString(string);
    }

    public String pop(){
        int lastIndex = size-1;
        String result = strings[lastIndex];
        super.removeString(lastIndex);

        return result;
    }

    public boolean isEmpty(){
        return size==0;
    }
}
