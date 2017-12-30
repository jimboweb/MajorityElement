import java.util.*;
import java.io.*;
public class MajorityElement {
	static boolean debug = false;
	static HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    private static int getMajorityElement(int[] a, int left, int right) {
    	
    	/*if(debug){
    		System.out.printf("left = %d right = %d a[left] = %d a[right] = %d%n",
    							left, right, a[left], a[right]);
    	}*/
    	
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return a[left];
        }
        //write your code here
        int majorityAmount = (right-left)/2;
        for(int i=0;i<right;i++){

        	if(debug){
        		System.out.printf("i = %d, a[i] = %d%n", i, a[i]);
        	}
        	
	        if(hm.containsKey(a[i])){
	        	hm.put(a[i], hm.get(a[i])+1);
	        	
	        	if(debug){
	        		System.out.printf("the element in %d has %d elements%n", 
	        				a[i], hm.get(a[i]));
	        	}
	        	
	        	if(hm.get(a[i])>majorityAmount)
	        	{
	        		
	        		if(debug){
	        			System.out.printf("returning element %d%n", 
		        				hm.get(a[i]));
	        		}
	        		
	        		return a[i];
	        	}
	        } else {
	        	
	        	if(debug){
	        	System.out.printf("adding element at %d%n", 
        				a[i]);
	        	}
	        	
	        	hm.put(a[i], 1);
	        }
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

