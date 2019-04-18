package javaapplication7;

import java.util.Scanner;

public class Stack {

    public static void main(String[] args) {

        
        Scanner input = new Scanner(System.in);
        
        
     String entrada = input.nextLine();
     char [] c = entrada.toCharArray();
     Pilha pilha = new Pilha();
     
     int resposta = 0;
     
     for (int i = 0; i < c.length; i++) {

            if (c[i] == '(') {
                pilha.push(c[i]);
            
            }else{
                
                if(!pilha.isEmpty()){
                    pilha.pop();
                    resposta += 2;
                }
            }
        }

        System.out.println(resposta);
        
        
    }
    
    public static class Node{
        
        private char valor;
        private Node next;
        
        public Node(char valor){
            
            this.valor = valor;
            this.next = null;
        
    }
        
    }
    
    
    public static class Pilha{
        
        private Node top;
        private int tam;
        
        
        public Pilha(){
            
            this.top = null;
            this.tam = 0;
          
        }
        
        public boolean isEmpty(){
            
            return (top == null);
            
        }
        
        public void push(char v){
            
            Node elemento = new Node(v);
            elemento.next = top;
            top = elemento;
            tam++;
            
        }
        
        public void pop(){
            
            if(!isEmpty()){
                
                
                top = top.next;
                tam--;
                
            }
            
        }
        
       
        
    }
    
}