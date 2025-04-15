import java.nio.channels.Pipe.SourceChannel;
import java.util.*;

public class App {
    private static Scanner input = new Scanner(System.in);

    public static boolean metodoRicorsivoPalindromo(String a){
        if (a.length()==1){
            return true;
        } else if (a.charAt(0) == a.charAt(a.length()-1)){
            if (a.length()==2){
                return true;
            } else{
                return metodoRicorsivoPalindromo(a.substring(1, a.length()-1)); 
            }
            
        } else {
            return false;
        }
    }

    public static int occorrenze(int [] a, int n, int i){
        if (i >= 0){
            if (n == a[i]){
                i--;
                return 1 + occorrenze(a, n, i);
            } else {
                i--;
                return 0 + occorrenze(a, n, i);
            }
        } else {
            return 0;
        }
    }

    public static boolean numeroPrimo(int numero){
        if (numero == 1){
            return true;
        } else {
            if (numero % 2 == 0){
                return false;
            } else {
                return numeroPrimo(numero-1);
            }
        }
    }

    public static void metodoStringaInvertita(String a){
        if (a.length()==1){
            System.out.print(a.charAt(0));
        } else {
            System.out.print(a.charAt(a.length()-1));
            metodoStringaInvertita(a.substring(0, a.length()-1));
        }
    }

    public static int valoreMinimo(int [] a, int index){
        if (index == 0){
            return a[index];
        }
        if (a[index]<valoreMinimo(a, index-1)){
            return a[index];
        } else {
            return valoreMinimo(a, index-1);
        }
    }

    public static int consonanti(String a){
        if (a.length()==0){
            return 0;
        } else {
            a = a.toLowerCase();
            if (a.charAt(a.length()-1)>=97 && a.charAt(a.length()-1)<= 122 && a.charAt(a.length()-1)!='a' && a.charAt(a.length()-1)!='e'&&a.charAt(a.length()-1)!='i' && a.charAt(a.length()-1)!='o' && a.charAt(a.length()-1)!='u'){
                return 1 + consonanti(a.substring(0, a.length()-1));
            } else {
                return consonanti(a.substring(0, a.length()-1));
            }
        }
    }

    public static String metodoStringaInvertita2(String a){
        if (a.length()<=0){
            return "";
        } else {
            return a.charAt(a.length()-1) + metodoStringaInvertita2(a.substring(0, a.length()-1));
        }
    }
    
    public static int trovato(int [] a, int n, int i){
        if (a[i] < n){
            return -1;
        } else {
            if (a[i]==n){
                return i;
            } else {
                i--;
                return trovato(a,n,i);
            }
        }
    }

    public static int trovato2(int [] a, int n, int min, int max){
        if (min == max){
            if (a[min]==n){
                return min;
            } else {
                return -1;
            }
        } 
        if (a[(min+max)/2] == n){
            return (min+max)/2;
        } else {
            if (a[(min+max)/2]<n){
                min = (min+max)/2+1;
            } else {
                max = (min+max)/2-1;
                
            }
            return trovato2(a,n,min,max);
        }
    }

    public static int somma(int n){
        if (n == 1){
            return n;
        } else {

            return n + somma(n-1);
        }
    }
    //public static int [][] labirinto(int [][] a){
        
    //}


    
    public static void main(String[] args) throws Exception {
        //System.out.println(metodoRicorsivo(input.nextLine()));
        //metodoStringaInvertita(input.nextLine());
        int [] a = {3,54,6,20,3,6};
        int dati[]={5,12,17,23,38,44,77,84,90};
        //System.out.println(valoreMinimo(a, 1, a[0]));
        //System.out.println(metodoStringaInvertita2("ciao"));
        //System.out.println(valoreMinimo(a, a.length-1));
        //System.out.println(somma(5));
        //System.out.println(prova.size());
        //System.out.println(occorrenze(a, 3, a.length-1));
        //System.out.println(numeroPrimo(7));
        //System.out.println(consonanti("CIAo"));
        System.out.println(trovato2(dati,77, 0, dati.length-1));
    }
}
