// Problem Statement:

// You are given a read-only array of N integers with values also in the range [1, N] both inclusive.
// Each integer appears exactly once except A which appears twice and B which is missing.
// The task is to find the repeating and missing numbers A and B where A repeats twice and B is missing.

public class solution {
    public static int[] findMissingRepeatingNumbers(int []a) {
        int n = a.length;
        int xr = 0;
        for(int i = 0; i< n; i++){
            xr ^= a[i];
            xr ^= i+1;
        }
        
        int num = xr & ~(xr-1);

        int zero = 0 ;
        int one = 0;
        
        for(int i = 0; i < n; i++){
            if((a[i] & num) != 0){
                one ^= a[i];
            }
            else{
                zero ^= a[i];
            }
            
        }

        for(int i = 1; i <= n; i++){
            if((i & num) != 0){
                one ^= i;
            }
            else{
                zero ^= i;
            }
            
        }
        
        int count = 0;
        for(int i = 0; i < n; i++){
            if(a[i] == zero){
                count++;
            }
        }
        
        if(count == 2){
            return new int[] {zero, one};
        } 
        
        return new int[] {one, zero};
    }    
}
