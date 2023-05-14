
import java.util.Arrays;

/*
This problem was asked by Amazon.
Implement a bit array.
A bit array is a space efficient array that holds a value of 1 or 0 at each index.
•	init(size): initialize the array with size
•	set(i, val): updates index at i with val where val is either 1 or 0.
•	get(i): gets the value at index i.

 */
public class EfficientBitArray {
    int offsize = Integer.SIZE - 1;
    int[] arr;
    int maxSize = 0;

    class Addr {
        public int seg;
        public int offs;
    }

    public static void main(String[] args) {
        EfficientBitArray app = new EfficientBitArray();
        app.init(50);
        app.printSlots();
        app.set(5, (byte) 1);
        app.set(20, (byte) 1);
        app.set(31, (byte) 1);
        System.out.println();
        app.printSlots();
        app.set(5, (byte) 0);
        app.set(20, (byte) 0);
        app.set(31, (byte) 1);
        System.out.println();
        app.printSlots();

    }

    public void init(int size) {
        maxSize = size;
        int ns = size > offsize ?  (int) Math.ceil((double) size / offsize) : 1;
        arr = new int[ns];
        Arrays.fill(arr, 0);
    }

    public Addr calcAddr(int index) {
        Addr addr = new Addr();
        addr.seg = (int) Math.floor((double) index / offsize);
        addr.offs = (index % offsize);
        return  addr;
    }

    public byte get(int index) {
        if (index >= maxSize)
            throw new IndexOutOfBoundsException("index must be smaller than array size!");
        Addr addr = calcAddr(index);
        return (byte) ((arr[addr.seg] & (int) Math.pow(2, addr.offs)) == 0 ? 0 : 1);
    }

    public void set(int index, byte val) {
        if (!((val==0)||(val==1)))
            throw new IllegalArgumentException("Val must be 0 or 1!");
        if (get(index) != val  ) {
            Addr addr = calcAddr(index);
            arr[addr.seg] = arr[addr.seg] ^ (int) Math.pow(2, addr.offs);
        }
    }

    public void printSlots() {
        Arrays.stream(arr).forEach( i -> {
                    char[] c =  Integer.toBinaryString(i).toCharArray();
                    if (c.length < offsize) {
                        c = "0".repeat(offsize - c.length).concat(Integer.toBinaryString(i)).toCharArray();
                    }
                    System.out.printf("%s \n", Arrays.toString(c));
                }
        );
    }

}
