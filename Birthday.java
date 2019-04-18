package birthday;

import java.util.Scanner;

public class Birthday {

    
    
    public static void main(String[] args) {
      
        Scanner input = new Scanner(System.in);
        
        int n = input.nextInt();
        
        int [] array1 = new int[n];
        
        for(int i=0;i<array1.length;i++){
            
            array1[i] = input.nextInt();
        }
        
        quicksort(array1,0,array1.length);
        
        int [] array2 = new int[n];
        
        for(int k = 0,j = n-1,i = 0; (j-k >= 0);k++,j--,i+=2){
            
            if(i==n-1){
                array2[k] = array1[i];
            }else{
            
            array2[k] = array1[i];
            array2[j] = array1[i+1];
            }
           
        }
        
        for(int i = 0;i<array2.length;i++){
            
            if(i==n-1)
            System.out.print(array2[i]);
            else
                System.out.print(array2[i] + " ");
        }
        
    }
    
    
    public static void quicksort(int[] A, int p, int r){
        if(p+1<r){
            int q=partition(A, p, r);

            quicksort(A,p,q);
            quicksort(A,q+1,r);
        }
    }

    public static int partition(int[] A,int p,int r){
        int x =A[r-1];
        int i =p-1;
        for(int j=p;j<r-1;j++) {
            if(A[j]<=x){
                
            	i++;
            	
                int k=A[i];
                A[i]=A[j];
                A[j]=k;
            }
        }
        int j=A[i+1];
        A[i+1]=A[r-1];
        A[r-1]=j;
        return i+1;
    }
    
    
}
