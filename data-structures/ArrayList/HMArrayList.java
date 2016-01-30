public class HMArrayList {
    private static final int SIZE = 2;
    private int[] arr = new int[SIZE];
    private int counter = 0;
    
    private void append(int a) {
        if (counter == arr.length) {
            System.out.println("Expanding array from size " + arr.length + " to size " + arr.length*2);
            int[] newArr = new int[arr.length * 2];
            int c = 0;
            for (int i : arr) {
                newArr[c] = i;
                c++;
            }
            arr = newArr;
        }
        arr[counter] = a;
        counter++;
    }

    public static void main(String[] args) {
        HMArrayList arl = new HMArrayList();
        for (int a = 0; a <= 256; a++) {
            arl.append(a);
        }
        for (int a : arl.arr) {
            System.out.print(a + ", ");
        }
    }
}
