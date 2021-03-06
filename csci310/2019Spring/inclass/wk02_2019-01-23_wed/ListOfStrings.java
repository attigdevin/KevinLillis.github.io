
import java.util.Arrays;

/**
 *
 * @author Dr. Lillis
 */
public class ListOfStrings  implements ListOfStringInterface {
    // Class and Instance variables
    public static final int DEFAULT_CAPACITY = 4;
    private String[] array;
    private int size = 0;
    
    // Constructors
    public ListOfStrings(int initialCapacity){
        array = new String[initialCapacity];
    }
    
    public ListOfStrings(){
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void add(String str) {
        add(this.size(), str);
    }

    @Override
    public void add(int i, String str) throws IndexOutOfBoundsException {
        if(i < 0 || i > size){ // note, i can equal size
            String message = "Cannot add element " + i;
            throw new IndexOutOfBoundsException(message);
        }
        
        if(size == this.getCapacity()){
            // double the size of the array
            this.ensureCapacity(this.getCapacity() * 2);
        }
        
        // Shift items to the right to make a "hole" at index i
        System.arraycopy(array, i, array, i+1, size - i);
        array[i] = str;
        
        size++;
    }

    @Override
    public void addFirst(String str) {
        this.add(0, str);
    }

    @Override
    public void addLast(String str) {
        this.add(this.size(), str);
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void compress() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(String str) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ensureCapacity(int minCapacity) {
        if(this.getCapacity() < minCapacity){
            // Need to increase the capacity
            String[] temp = new String[minCapacity];
            System.arraycopy(array, 0, temp, 0, this.size());
            array = temp;
        }
    }

    @Override
    public int firstIndexOf(String str) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String get(int i) throws IndexOutOfBoundsException {
        if(i < 0 || i > this.size() - 1){
            String message = "index " + i + " is not valid";
            throw new IndexOutOfBoundsException(message);
            
        }
        
        return array[i];
    }

    @Override
    public int getCapacity() {
        return array.length;
    }

    @Override
    public String getFirst() throws IllegalStateException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getLast() throws IllegalStateException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int lastIndexOf(String str) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String remove(String str) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String remove(int i) throws IndexOutOfBoundsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String removeFirst() throws IllegalStateException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String removeLast() throws IllegalStateException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String set(int i, String str) throws IndexOutOfBoundsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String setFirst(String str) throws IllegalStateException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String setLast(String str) throws IllegalStateException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        return size;
    }
    
    @Override
    public String toString(){
        String s = "";
        
        s += "[";
        
        boolean firstItem = true;
        for(int i = 0; i < this.size(); i++){
            if(firstItem){
                s += array[i];
                firstItem = false;
            } else {
                s += ", ";
                s += array[i];
            }
        }
        
        s += "]";
        
        s += " (" + this.size() + "/" + this.getCapacity() + ")";
        return s;
    }

}
