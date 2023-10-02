import java.lang.Math;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Polynomial{
    double[] coefficient;
    int [] exponents ;
    

    public Polynomial(){
    coefficient= new double[1]; 
    coefficient[0]=0;
    exponents=  new int[1]; 
    exponents[0]=0;
    }// this is the end of he no arguements case 
    
    public Polynomial(double[] numb, int[]expo){
    coefficient = new double[numb.length]; 
    exponents = new int[expo.length];
    for(int i=0; i < numb.length ;  i++ ){ 
        coefficient[i] = numb[i]; 
    }
    for (int i=0; i<expo.length; i++){
        exponents[i]=expo[i];
    }
    }// this is the end of the arguements case  

    public Polynomial(File p_file)throws IOException{ 
        BufferedReader reads = new BufferedReader(new FileReader(p_file) ); 
        String line = reads.readLine();
        if (line == null){
            throw new IllegalArgumentException("The String is empty");
        }

        String[] sub_lines = line.split("[+-]");
        double [] coefficient = new double[sub_lines.length]; 
        int[] exponents =  new int[sub_lines.length];
        for (int i=0;  i<sub_lines.length ; i++){ 
            String subline= sub_lines[i];
            String[] components =  subline.split("[xX]");
            if (components.length==1){ 
                coefficient[i]= Double.parseDouble(components[0]);
                exponents[i]= 0 ;
            } else{
                coefficient[i]= Double.parseDouble(components[0]);
                exponents[i] =Integer.parseInt(components[1]);
            }

            if (subline.startsWith("-")){
                coefficient[i]*=-1; 
            }
            
        } 
        reads.close();


    }

    public Polynomial add ( Polynomial numb){
        int[] new_ex; 
        double[] new_co; 
        new_ex = this.all_exponents(numb.exponents);
        new_co= new double[new_ex.length];
        for (int i=0; i<new_ex.length; i++){
            for(int j=0; j<this.exponents.length; j++){ 
                if(new_ex[i]==this.exponents[j]){
                    new_co[i]+=this.coefficient[j];

                }
            } 

        } 

        for (int i=0; i<new_ex.length; i++){
            for(int j=0; j<numb.exponents.length; j++){ 
                if(new_ex[i]==numb.exponents[j]){
                    new_co[i]+=numb.coefficient[j];

                }
            
            }
        } 

        Polynomial result = new Polynomial(new_co, new_ex);
        return result;

 
    }// end of the add method



    //This will be a method that takes in two polynomials and returns an array of both of their exponents
    public int[] all_exponents(int[] arr_2){ 
        ArrayList<Integer> Ex = new ArrayList<Integer>(); 
        for (int i=0; i<this.exponents.length;i++){
            if (Ex.contains(this.exponents[i])==false){
                Ex.add(this.exponents[i]); 
            }
        }
         for (int i=0; i<arr_2.length;i++){
            if (Ex.contains(arr_2[i])==false){
                Ex.add(arr_2[i]); 
            }
        }
        int[] new_arr= new int[Ex.size()]; 
        for(int i=0; i<Ex.size(); i++){ 
            new_arr[i]= Ex.get(i); 
            //System.out.println(new_arr[i]);
        }
        return new_arr; 


    }

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



    public Polynomial multiply(Polynomial numb){
        int[] new_ex; 
        double[] new_co;
        ArrayList<Integer> full_ex = new ArrayList<Integer>();  
        ArrayList<Double> full_co = new ArrayList<Double>();  
        for (int i=0; i<this.exponents.length;i++){ 
            for(int j=0; j<numb.exponents.length; j++){ 
                int res_ex= this.exponents[i]+numb.exponents[j]; 
                double res_co= this.coefficient[i]*numb.coefficient[j];
                if(full_ex.contains(res_ex)==false){ 
                    full_ex.add(res_ex); 
                    full_co.add(res_co);
                }
                else{ 
                    int indx= full_ex.indexOf(res_ex);
                    double ncoe= full_co.get(indx)+ res_co; 
                    full_co.set(indx, ncoe);
                }


            }
        }
        new_ex = new int[full_ex.size()]; 
        new_co = new double[full_ex.size()];
        for (int k=0; k<full_ex.size(); k++){ 
            new_ex[k]=full_ex.get(k); 
            new_co[k]= full_co.get(k);

        }

        Polynomial new_numb=  new Polynomial(new_co, new_ex); 
        return new_numb;
    }

    public void saveToFile(File file) throws IOException{ 
        BufferedWriter author =  new BufferedWriter(new FileWriter(file)); 
        for (int i=0;i<this.coefficient.length; i++){ 
            double coef= coefficient[i]; 
            int expo= exponents[i]; 
            if (i>0 &&coef>=1){
                author.write("+");
            }

            if(coef!=0){
                author.write(Double.toString(coef));
            }
            if (expo!=0){ 
                author.write("x"); 
                author.write(Integer.toString(expo));
            }


        }
        author.close();



    }





    
    }// this is the end of the class constuctor