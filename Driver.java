public class Driver {
  public static void main(String [] args){
   Polynomial p = new Polynomial();
   System.out.println(p.evaluate(3));   
   double [] c1 = {6,5};  
   int [] c1b= {0, 3} ;
   Polynomial p1 = new Polynomial(c1,c1b);   
   double [] c2 = {-2,-9}; 
   int [] c2b= {1, 4};   
   Polynomial p2 = new Polynomial(c2, c2b);   
   Polynomial s = p1.add(p2); 
   Polynomial t = p1.multiply(p2);
   for(int i=0; i<s.exponents.length;i++){
    //System.out.println(s.exponents[i]+"e");
   // System.out.println(s.coefficient[i]+"c");

   }  
   for(int i=0; i<t.exponents.length;i++){
    System.out.println(t.exponents[i]+"e");
    System.out.println(t.coefficient[i]+"c");

   }  
  // System.out.println("s(0.1) = " + s.evaluate(0.1));  
 //if(s.hasRoot(1))
    //System.out.println("1 is a root of s");   
//else
    //System.out.println("1 is not a root of s"); 
 } 

} 