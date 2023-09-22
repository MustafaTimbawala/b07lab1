import java.lang.Math;
public class Polynomial{
    double[] coefficient;

    public Polynomial(){
    coefficient= new double[1];
    }// this is the end of he no arguements case 
    
    public Polynomial(double[] numb){
    coefficient = new double[numb.length]; 
    for(int i=0; i < numb.length ;  i++ ){ 
        coefficient[i] = numb[i]; 
    }
    }// this is the end of he no arguements case  

    public Polynomial add ( Polynomial numb){
        if (coefficient.length > numb.coefficient.length){
            // add the the numb to the coefficient and then return  the resulting polynomial
            for (int i=0; i<numb.coefficient.length; i++){
                coefficient[i] += numb.coefficient[i]; 
            }
            return new Polynomial(coefficient); 
        } 
        else{ 
            // add the coeffieemt to the numb and return the resultingn numb
                for (int i=0; i<coefficient.length; i++){
                numb.coefficient[i] +=coefficient[i]; 
        }
        return numb; 

        }   
    }// end of the add method

    public double evaluate (double x){
        double result=0 ; 
        for(int i=0; i< coefficient.length;  i++){ 
            result += coefficient[i]*Math.pow(x, i); 
        }

        return result; 
    }

    public boolean hasRoot(double x ){
        if (evaluate(x)==0){ 
            return true;

        }
        else{ 
            return false; 

        }
    } 





    
    }// this is the end of the class constuctor