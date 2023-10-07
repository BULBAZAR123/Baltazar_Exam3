/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baltazar_exam3;

import java.util.Scanner;


public class Baltazar_Exam3 {
private class PriorityQueuesArray{
            
            int priority;
            int data;
          
       PriorityQueuesArray next;           
        }

    private PriorityQueuesArray front = null;
   static int number = 1;
    public int deletion() throws Exception{
          if (front == null){
              throw new Exception("Queue is Empty");
          } 
          int temporary = front.data;
          front = front.next;
            
           return temporary; 
        
        }
    private void insertion(int item, int priority){
            PriorityQueuesArray node = new PriorityQueuesArray();
            node.data=item;
            node.priority = priority;
            node.next = null;
            
            
            if (front == null || priority <= front.priority) {
                node.next = front;
                front = node;
            }
            else{
                PriorityQueuesArray temporary = front;
                while (temporary.next != null && temporary.next.priority <= priority) {                    
                    temporary = temporary.next;
                }
                   node.next = temporary.next;
                   temporary.next = node;
               number++;
               
               }
            
        }
     
        public void display() throws Exception{
            if (front == null){
              throw new Exception("Queue is Empty");
          }
            PriorityQueuesArray temporary = front;
            
            System.out.println("Priority \t\t Pages");
            
            while(temporary != null){
              
                   System.out.println(temporary.priority + "\t\t" + temporary.data);
                temporary = temporary.next;

            }
            System.out.println("\n");
        }
    public static void main(String[] args) throws Exception {
        Baltazar_Exam3 list = new Baltazar_Exam3();
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {            
            System.out.println("Enter Pages: ");
                    int page = scanner.nextInt();
                    System.out.println("Enter Priority: ");
                    int posi = scanner.nextInt();
                      
                    list.insertion(page, posi);
                     if(number > 5){
                         list.deletion();
                     }
                    list.display();
        }
                
    }
    
}