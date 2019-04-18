package javaapplication8;

import java.util.Scanner;
public class Fila {

  
    public static void main(String[] args) {
     
        Scanner input = new Scanner(System.in);
      while(input.hasNext()){  
          
        int n = input.nextInt();
       
        if(n==0)
            break;
        
        Queue q = new Queue(n);
        
        for(int i=1;i<=n;i++){
            
            q.inQueue(i);
           
        }
        
        System.out.print("Discarded cards:");
        
        while(q.tam > 1){
            
            if(q.tam != 2){
                
                System.out.print(" " + q.deQueue() + ",");
                int x = q.deQueue();
                q.inQueue(x);
        }else{
        
                System.out.print(" " + q.deQueue());
            }
        
        }
        
        System.out.println("\nRemaining card: " + q.fila[q.front]);
      
      }
        
    }
    
    public static class Queue{
        
        private int [] fila;
        private int tam;
        private int front;
        private int end;
        
        public Queue(int x){
            
            fila = new int [x];
            tam = 0;
            front = 0;
            end = 0;
            
        }
        
        
        public void inQueue(int x){
            
            fila[end] = x;
            end = (end + 1) % fila.length;
            tam++;
        }
        
        public int deQueue(){
            
            int x = fila[front];
            front = (front + 1)% fila.length;
            tam--;
            
            return x;
            
        }
        
    }
    
    
}
