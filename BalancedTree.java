package projeto;

import java.util.Scanner;

public class BalancedTree {

	   
    public static void main(String[] args) {
        
  /*      Scanner input = new Scanner(System.in);
      
  Tree t = new Tree();
  
  int [] inserindo = {7, 2, 14, 21, 3, 4, 9};
  
  for(int i = 0; i < inserindo.length; i++){
      
      t.insert(inserindo[i]);
  }*/
  /*int n = 0;
  while(true){
      n = input.nextInt();
      t.insert(n);
      t.calcPeso(t.root);
      t.root = t.escolherRotacao(t.root);
      t.preOrder(t.root);
  }
  
   /*System.out.print("\n\n\n\n\n");
   *///t.preOrder(t.root);
  
  
    }
    
    
    public static class Node{
        
        Node filhoDireita;
        Node filhoEsquerda;
        int valor;
        int peso;
        
        public Node(int valor){
            this.valor = valor;
            this.filhoEsquerda = null;
            this.filhoDireita = null;
            this.peso = 0;
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
            
            System.out.println("[Nó atual: "+no.valor+"] Altura: "+ calcAltura(no)+" Peso: "+no.peso);
            if(no.filhoEsquerda != null)
                System.out.print("ESQ: "+no.filhoEsquerda.valor+" ");
            else{
                System.out.print("ESQ: Null ");
            }
            
            if(no.filhoDireita != null)
                System.out.println("DIR: "+no.filhoDireita.valor);
            else{
                System.out.println("DIR: Null ");
            }
            
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
        
       public void calcPeso(Node no){
           
           if(no.filhoEsquerda == null && no.filhoDireita == null){
               no.peso = 0;
           }else if(no.filhoDireita != null && no.filhoEsquerda == null){
               no.peso = calcAltura(no.filhoDireita) - 0;
           }else if(no.filhoDireita == null && no.filhoEsquerda != null){
               no.peso = 0 - calcAltura(no.filhoEsquerda);
           }else{
               no.peso = calcAltura(no.filhoDireita) - calcAltura(no.filhoEsquerda);
           }
           
           if(no.filhoEsquerda != null)
               calcPeso(no.filhoEsquerda);
           if(no.filhoDireita != null)
               calcPeso(no.filhoDireita);
       }
        
        public int calcAltura(Node no){
            int height = 0;
            if(no.filhoEsquerda == null && no.filhoDireita == null){
                height = 1;
            }else if(no.filhoDireita != null && no.filhoEsquerda != null){
                height = 1 + Math.max(calcAltura(no.filhoDireita), calcAltura(no.filhoEsquerda));
            }else if(no.filhoDireita != null && no.filhoEsquerda == null){
                height = 1 + calcAltura(no.filhoDireita);
            }else if(no.filhoDireita == null && no.filhoEsquerda != null){
                height = 1 + calcAltura(no.filhoEsquerda);
            }
            return height;
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
        
        public Node simplesDir(){
            
            Node dir;
            
            
            dir = this.root.filhoDireita;
            this.root.filhoDireita = this.root.filhoDireita.filhoEsquerda;
            dir.filhoEsquerda = this.root;
            
            return dir;
        }
        
        public Node simplesEsq(){
           
            Node esq;
            
            
            esq = this.root.filhoEsquerda;
            this.root.filhoEsquerda = this.root.filhoEsquerda.filhoDireita;
            esq.filhoDireita = this.root;
            
            return esq;
            
        } 
        
        public Node duplaDir(){
            
            Node dir;
            Node esqDir;
            Node noExtra;
            
            dir = this.root.filhoDireita;
            esqDir = dir.filhoEsquerda;
            noExtra = esqDir.filhoDireita;
            
            dir.filhoEsquerda = noExtra;
            esqDir.filhoDireita = dir;
            this.root.filhoDireita = esqDir;
            
            Node dir2 = this.root.filhoDireita;
            this.root.filhoDireita = null;
            dir2.filhoEsquerda = this.root;
            
            return dir2;
        }
        
        public Node duplaEsq(){
            
        	Node esq;
            Node dirEsq;
            Node noExtra;
            
            esq = this.root.filhoEsquerda;
            dirEsq = esq.filhoDireita;
            noExtra = dirEsq.filhoEsquerda;
            
            esq.filhoDireita = noExtra;
            dirEsq.filhoEsquerda = esq;
            this.root.filhoEsquerda = dirEsq;
            
            Node esq2 = this.root.filhoEsquerda;
            this.root.filhoEsquerda = null;
            esq2.filhoDireita = this.root;
            
            return esq2;
        	
        	
        }
        
        public Node escolherRotacao(Node no){
            
            if(no.peso > 1 || no.peso < -1){
                
                if(no.peso > 1){
                    if(no.filhoDireita.peso > 0){
                        System.out.println("Simples DIREITA");
                        return this.simplesDir();
                    }else{
                        System.out.println("Dupla DIREITA");
                        return this.duplaDir();
                    }
                    
                }else if(no.peso < -1){
                    if(no.filhoEsquerda.peso < 0){
                        System.out.println("Simples ESQUERDA");
                        return this.simplesEsq();
                    }else{
                        System.out.println("Dupla ESQUERDA");
                        return this.duplaEsq();
                    }
                    
                }
                
            }
            if(no.filhoDireita != null)
                escolherRotacao(no.filhoDireita);
            if(no.filhoEsquerda != null)
                escolherRotacao(no.filhoEsquerda);
            
            return this.root;
        }
        
        
    }
    
}