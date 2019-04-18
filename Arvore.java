package arvore;

import java.util.Scanner;

public class Arvore {

   
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
      
  Tree t = new Tree();
  
  int [] inserindo = {7, 2, 14, 21, 3, 4, 9};
  
  for(int i = 0; i < inserindo.length; i++){
      
      t.insert(inserindo[i]);
  }
  
  t.preOrder(t.root);
  System.out.println();
  t.inOrder(t.root);
  System.out.println();
  t.postOrder(t.root);
   
    }
    
    
    public static class Node{
        
        Node filhoDireita;
        Node filhoEsquerda;
        int valor;
        
        public Node(int valor){
            this.valor = valor;
            this.filhoEsquerda = null;
            this.filhoDireita = null;
        }
        
    }
    
    public static class Tree{
        
        Node root;
        
        public Tree(){
            
            root = null;
        }
        
        public int insert(int add){
            
            root = insertNumber(root, add);
            
            return add;
        }
        
        public void preOrder(Node no){
            
            if(no == null){
                return;
            }
            
            System.out.print(no.valor);
            preOrder(no.filhoEsquerda);
            preOrder(no.filhoDireita);
        }
        
        public void inOrder(Node no){
            
            if(no == null){
                return;
            }
            
            inOrder(no.filhoEsquerda);
            System.out.print(no.valor);
            inOrder(no.filhoDireita);
        }
        
        public void postOrder(Node no){
            
            if(no == null){
                return;
        }
            
            postOrder(no.filhoEsquerda);
            postOrder(no.filhoDireita);
            System.out.print(no.valor);
        }
        
        private Node insertNumber(Node no, int c){
            
            if(no == null){
                
                return new Node(c);
            }
            
            if(no.valor > c){
                no.filhoEsquerda = insertNumber(no.filhoEsquerda, c);
            }else{
                
                no.filhoDireita = insertNumber(no.filhoDireita, c);
                
            }
            
            return no;
        }
        
    }
    
}
