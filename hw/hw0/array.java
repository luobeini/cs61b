public class array {
    /** Returns the maximum value from m. */
    public static int max(int[] m) {
        int i=0;
        int len=m.length;
        int mac = 0;
        while(i<len)
        {
            if (mac<m[i])
            {
                mac=m[i];
            }
            i++;
        }

        return mac;
    }
    public static void main(String[] args) {
        int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
        int k=max(numbers);
        System.out.println(k);
    }
}