package TimeComplexity;

public class arrayEquilibriumIndex {
    public static int arrayEquilibriumIndex(int[] arr){  
		//Your code goes here
		int sumf=0,suml=0,eq=0,flag=0;

		if(arr.length==0){
			return -1;
		}
		
		for(int i=0;i<arr.length;i++)
		{
			sumf=sumf+arr[i];
			for(int j=arr.length-1;j!=i;j--)
			{
				suml=suml+arr[j];
				
				if(sumf==suml)
				{
					eq=i+1;
					flag=1;
					break;
				}
			}
			suml=0;
			if(flag==1)
				break;
		}
		if(eq==0){
			return -1;
		}
		return eq;
	}
    public static void main(String[] args) {
        int[] arr1 = {1, 7, 3, 6, 5, 6};
        System.out.println("Equilibrium index for arr1: " + arrayEquilibriumIndex(arr1)); // Expected Output: 3
    }
}
