/*
A class that can copy and paste arrays between classes
 */
public class ArrayTransfer<T> {

    private MyArrayList<T> storedList;


    public ArrayTransfer(){
        this.storedList = storedList;
    }

    public void copyArray(MyArrayList<T> copy){
        for(T e : copy){
            storedList.add(e);
        }
    }
    public MyArrayList<T> pasteArray(){
        return storedList;
    }


}
