public class Solution {
   
    public static void main(String[] args) {
        
       FastReader.FastReaderIO reader = new FastReader.FastReaderIO();
        int t = reader.nextInt();
        double[] array = new double[t];
        double mean=0.0d, median = 0.0d, sum=0.0d;
        int mode = 0;
        for(int i=0;i<t;i++){
            double num = reader.nextDouble();
            array[i]=num;
            sum+=num;
        }
        
        Arrays.sort(array);
        median = (array[array.length/2]+array[array.length/2-1])/2;
        
        
        Map<Double, Integer> frequency = new HashMap<>();
        for(double value:array){
            if(frequency.keySet().contains(value)){
                frequency.put(value,frequency.get(value)+1);
            }
            else
            {
                frequency.put(value, 1);
            }
        }
        int max = Collections.max(frequency.values());
        Set<Double> maxKeys = new TreeSet<>();
        for(Map.Entry<Double, Integer> map:frequency.entrySet()){
            if(map.getValue()==max){
                maxKeys.add(map.getKey());
            }
        }
        
        System.out.printf("%.1f \n",(sum/array.length));
        System.out.printf("%.1f \n", median);
        System.out.printf("%.0f", maxKeys.iterator().next());
        
        
        
        
        
    }
}
