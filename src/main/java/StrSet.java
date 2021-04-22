import java.util.*;

public class StrSet extends StrBuffer {
    public StrSet(){

    }

    public StrSet(String[] strings){
        int receivedStringsLength = strings.length;

        if(receivedStringsLength > capacity){
            capacity = receivedStringsLength + receivedStringsLength/2;
        }
        size = receivedStringsLength;
        super.strings = strings;
    }

    public StrSet union(StrSet anotherSet){
        String[] result = new String[size + anotherSet.size()];
        System.arraycopy(strings,0,result,0,size);
        System.arraycopy(anotherSet.strings,0,result,size,anotherSet.size);

        return new StrSet(result);
    }

    public StrSet difference(StrSet anotherSet){
        Set<String> result = new HashSet<>(Arrays.asList(strings));

        for(String string: anotherSet.strings){
            if(result.contains(string)){
                result.remove(string);
            }
        }

        return new StrSet(result.toArray(new String[result.size()]));
    }

    public boolean contains(String string){
        for(String str: strings){
            if(str.equals(string)){
                return true;
            }
        }
        return false;
    }
}
