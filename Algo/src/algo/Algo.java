/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algo;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;



/**
 *
 * @author D1uma
 */
public class Algo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
            PrintWriter out = new PrintWriter("/Users/D1uma/Documents/output.txt");
          FileInputStream cultFis = new FileInputStream("/Users/D1uma/Documents/culture.txt");
          FileInputStream sportFis=new FileInputStream("/Users/D1uma/Documents/sport.txt");
          String cult=readFile(cultFis);
          String sport=readFile(sportFis);
          ArrayList<String> cultLis = new ArrayList<String>();
          ArrayList<String> sportLis = new ArrayList<String>();
          addWord(cultLis,cult);
          addWord(sportLis,sport);
          removeDot(cultLis);
          removeDot(sportLis);
          Map<String, Integer> cultFreq = new HashMap<String, Integer>();
          Map<String, Integer> sportFreq = new HashMap<String, Integer>();
          cultFreq=countFrequency(cultLis);
          sportFreq=countFrequency(sportLis);
          double k=cultFreq.get("мира");
          double l=sportFreq.get("мира");
          System.out.println("мира культура ="+k);
          System.out.println("мира спорт ="+l);
          double countCult=cultLis.size();
          double countSport=sportLis.size();
          System.out.println("count1 = "+countCult);
          System.out.println("count2 = "+countSport);
          
          int vocab=cultFreq.size()+sportFreq.size();
          System.out.println("vocabulary = "+vocab);
          double probCult=(double)((k+1)/(countCult+vocab));
          double probSport=(double)((l+1)/(countSport+vocab));
         
          System.out.println("probCult = "+probCult);
          System.out.println("probSport = "+probSport);
          
    }
//podchishayu string c pomoshyu methoda replaceAll
    public static void removeDot(ArrayList <String> arrLis){
   String newItem="";
   int l=0;
  
   for(int i=0;i<arrLis.size();i++){
      
       l=arrLis.get(i).length();
       //System.out.println(arrLis.get(i));
       for (int j=0;j<l;j++){
           if((arrLis.get(i).charAt(j)=='.') || (arrLis.get(i).charAt(j)==',') || (arrLis.get(i).charAt(j)==':')){
             
             newItem=replaceAll(arrLis.get(i),"");
             arrLis.set(i,newItem);
             break;
             //System.out.println(arrLis.get(i));
           }
       }
       
   }
   
  // out.println(arrLis);
  // out.close();
   
  // countFrequency(arrLis);
    }
    public static String replaceAll(String regex, String replacement){
        regex=regex.replace(".", replacement);
        regex=regex.replace(",", replacement);
        return regex;
    }
    public static Map<String, Integer> countFrequency(ArrayList <String> arrLis){
        Map<String, Integer> freq = new HashMap<String, Integer>();
       // Map<String, Double> prob=new HashMap<String,Double>();
    //    double probTi=0;
     //   double probDC=1;
for (String string : arrLis) {

    if(freq.keySet().contains(string)){
        freq.put(string, freq.get(string)+1);

    }
    else{
        freq.put(string, 1);
    }
}

System.out.println("freq="+freq);

return freq;
    }
public static String readFile(FileInputStream fis){
     Scanner in = new Scanner(fis);
      
       String str="";
      // reading input file
        while(in.hasNextLine()){
            str=in.nextLine();  
        }
        return str;
}
public static void addWord(ArrayList <String> arrLis, String str){
       int n=0;
       String key="";
      StringTokenizer st = new StringTokenizer(str, "§"); 
   
 //dobavlyau slova v arrLis
while(st.hasMoreTokens()) { 
key = st.nextToken(); 
n++;
StringTokenizer strTkn = new StringTokenizer(key, " ");
while(strTkn.hasMoreTokens())
    arrLis.add(strTkn.nextToken());
}
//System.out.println(n);
}
}
/*
for (String st : arrLis){
    if (freq.keySet().contains(st)){
     //   System.out.println("st "+st);
      //  System.out.println("get me "+freq.get(st));
        probTi=(double)(freq.get(st))/arrLis.size();
        prob.put(st,probTi);
    }
}
    for (String s :arrLis){
        if (freq.keySet().contains(s)){
            
            probDC=probDC*prob.get(s);
             String round = String.format("%1.5f", probDC);
             //d = Double.valueOf(round);
             System.out.println("value = "+probDC);
             System.out.println(round);
           
        }
    }
*/

//System.out.println("prob="+prob);
//System.out.println("probDC="+probDC);
        
    

       
    



