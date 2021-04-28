public class StrBuffer {
    protected String[] strings;
    protected int size = 0;
    protected int capacity = 10;

    public StrBuffer() {
        strings = new String[capacity];
    }

    public StrBuffer(int size){
        if(size < 0){
            this.size = 0;
            strings = new String[capacity];
            return;
        }
        if(size > capacity) {
            capacity += size;
        }
        this.size = size;
        strings = new String[capacity];
    }

    protected void addString(String string) {
        if (size == capacity) {
            capacity += capacity / 2;
        }
        strings[size++] = string;
    }

    protected String elementAt(int index){
        if(index > size || index < 0){
            return null;
        }
        else {
            return strings[index];
        }
    }

    protected String removeString(int index){
        String result = null;
        if(index < 0 || index > size){
            return null;
        }
        else{
            result = strings[index];
            swapStrings(index);
            if(--size<0){
                size=0;
            };
        }
        return result;
    }

    public int size(){
        return size;
    }

    public void listAll(){
        for(int i = 0; i < size; i++){
            System.out.println(strings[i]);
        }
    }

    public String[] getAll(){
        String[] result = new String[size];
        for(int i = 0; i < size; i++){
            result[i] = strings[i];
        }
        return result;
    }

    private void swapStrings(int deletedIndex) {
        for(int i = deletedIndex; i < size; i++){
            strings[i] = strings[i+1];
        }
    }
}
