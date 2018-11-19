public class Solution {

    public static void main(String[] args) {

        FastReader.FastReaderIO reader = new FastReader.FastReaderIO();
        int t = reader.nextInt();
        int[] arrayNumbers = new int[t];
        int mean = 0, sum = 0, quartile1=0,quartile2=0,quartile3=0;
        for (int i = 0; i < t; i++) {
            int num = reader.nextInt();
            arrayNumbers[i] = num;
        }
        Arrays.sort(arrayNumbers);
        int mid = arrayNumbers.length/2;
        
        if (arrayNumbers.length % 2 != 0) {
            quartile1 = getMedian(arrayNumbers, 0, arrayNumbers.length);
            quartile2 = getMedian(arrayNumbers, 0, mid);
            quartile3 = getMedian(arrayNumbers, mid + 1, arrayNumbers.length);
        } else {
            quartile1 = getMedian(arrayNumbers, 0, arrayNumbers.length);
            quartile2 = getMedian(arrayNumbers, 0, mid);
            quartile3 = getMedian(arrayNumbers, mid, arrayNumbers.length);
        }
        
        
        System.out.println(quartile2);
        System.out.println(quartile1);
        System.out.println(quartile3);
    }
    
    static int getMedian(int[] array, int start, int end){
        int median=0;
        int mid = (start+end) / 2;
        int a[] = Arrays.copyOfRange(array, start, end);
        if (a.length % 2 == 0) {
            median = (array[mid] + array[mid - 1]) / 2;
        } else {
            median = array[mid];
        }
        return median;
    }
}
