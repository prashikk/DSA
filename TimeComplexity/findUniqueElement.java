package TimeComplexity;

public class findUniqueElement {
    public static int findUnique(int[] arr) {
		//Your code goes here
			int n=arr.length;
		int ans=arr[0];
		
		for(int i=1;i<n;i++) {
		
			ans=ans^arr[i];
			
		}
		return ans;
	}
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 4, 3, 2};
        System.out.println("Unique element in arr1: " + findUnique(arr1)); // Expected Output: 4
    }
}
