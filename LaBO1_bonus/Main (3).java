package com.company;
/*
Let n, k be two integers and C_1,...,C_m a number of letters (alphabet), all given as a command line arguments. Validate the arguments!
Create an array of n Strings (called words), each word containing exactly k characters from the given alphabet.
Display on the screen the generated array.
Two words are adjacent (neighbors) if they have a common letter. Create a boolean n x n matrix, representing the adjacency relation of the words. Display the matrix on the screen.
Display the words that have the most, respectively the least, number of neighbors. Check if all words have the same number of neighbors.
For larger n display the running time of the application in nanoseconds (DO NOT display the matrix!). Try n > 30_000. You might want to adjust the JVM Heap Space using the VM options -Xms4G -Xmx4G.
Launch the application from the command line, for example: java Lab1 100 7 A C G T.
 */




/*
pt partea bonus am facut functia connectedGraph care calculeaza numarul de componente conexe din graf. 
Se foloseste de un vector visited pentru a marca nodurile vizitate si de o stiva pe care punem nodurile. 
Cat timp avem noduri pe varful stivei, le luam si cautam noduri adiacente nevizitate si eventual le punem pe stiva 
si le marcam cu numarul componentei conexe din care fac parte. Daca la final graful are o singura componenta conexa, 
inseamna ca este conex.
*/

import javax.sound.midi.Soundbank;
import java.net.SocketOption;

public class Main {

    private static int[] neighbours;
    private static boolean[][] m;
    void compulsory(){
        //sout + TAB
        System.out.println("rwerwrw");
        String languages[] = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int)(Math.random()*1000000);
        System.out.println(n);
        int res = n * 3, sum, c;
        res += Integer.parseInt("10101", 2);
        res += Integer.parseInt("FF", 16);
        res *= 6;
        System.out.println(res);
        while(res>9){
            sum=0;
            while(res!=0){
                c = res % 10;
                res /= 10;
                sum+=c;
            }
            res = sum;
        }
        System.out.println("Willy-nilly, this semester I will learn " + languages[res]);
    }



    static void optional(String[] args){

        int n = 0, k = 0, i;
        StringBuilder c = new StringBuilder();
        if(args.length < 4){
            System.out.println("not enough arguments.");
            return;
        }
        try{
            n = Integer.parseInt(args[0]);
            k = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            // not an integer!
            System.out.println("n/k is not an integer!");
        }
        for(i=2; i<args.length; i++){
            if(!Character.isLetter(args[i].charAt(0))){
                System.out.println("this is not a letter." + args[i].charAt(0));
                return;
            }
            c.append(args[i].charAt(0));
            //System.out.println(c[i-2]);
        }
        String[] generated = generate(n,k,c.toString().toCharArray());
        printGenerated(generated);
        booleanMatrix(n, generated);
        sortWords(generated, neighbours);
        for(i=0;i<n;i++){
            System.out.print("(" + generated[i]+", ");
            System.out.print(neighbours[i]+") ");
        }
        System.out.println("\n");
        checkSameAmountOfN(neighbours);
        connectedGraph(n, generated, m);
    }

    private static void connectedGraph(int n, String[] generated, boolean[][] m) {
        int stack[] = new int[n];
        int visited[] = new int[n];
        int i, j, position, node;
        for (i = 0; i < n; i++) {
            visited[i] = 0;
        }
        int connectedComp = 0;
        for (i = 0; i < n; i++) {
            if (visited[i] == 0) {
                position = 0;
                connectedComp++;
                stack[++position] = i;
                visited[i] = connectedComp;
                while (position > 0) { //cat timp avem pe stiva noduri
                    node = stack[position];
                    position--;
                    for (j = 0; j < n; j++) {
                        if (m[node][j] && visited[j] == 0) {
                            stack[++position] = j;
                            visited[j] = connectedComp;
                        }
                    }
                }
            }
        }
        System.out.println("BONUS: ");
        if (connectedComp == 1) {
            System.out.println("The graph is connected.");
        }
        for (i = 1; i <= connectedComp; i++) {
            System.out.print("Connected component number " + i + " :");
            for (j = 0; j < n; j++) {
                if (visited[j] == i) {
                    System.out.print(" " + generated[i]);
                }
            }
            System.out.println();
        }
    }

    private static void checkSameAmountOfN(int[] neighbours) {
        for (int i = 0; i < neighbours.length - 1; i++) {
            if(neighbours[i]!=neighbours[i+1]){
               return;
            }
        }
        System.out.println("all words have the same number of neighbors");
    }

    private static void sortWords(String[] generated, int[] neighbours) {
        int aux;
        String aux_s;
        for (int i = 0; i < neighbours.length; i++) {
            for (int j = i + 1; j < neighbours.length; j++) {
                if (neighbours[i] < neighbours[j]) {
                    aux = neighbours[i];
                    neighbours[i] = neighbours[j];
                    neighbours[j] = aux;
                    aux_s=generated[i];
                    generated[i] = generated[j];
                    generated[j] = aux_s;
                }
            }
        }
    }

    public static String[] generate(int n, int k, char[] alphabet) {
        int k_cnt;
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            k_cnt = 0;
            while (k_cnt < k) {
                int pos = (int) (Math.random() * (alphabet.length));
                sb.append(alphabet[pos]);
                k_cnt++;
            }
            words[i] = sb.toString();
        }
        return words;
    }

    private static void printGenerated(String[] generated) {
        for(int i=0;i < generated.length;i++) {
            System.out.println(generated[i]);
        }
    }

    private static void booleanMatrix(int n, String[] generated) {
        m = new boolean[n][n];
        neighbours = new int[n];
        int i, j;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if(adjacent(generated[i],generated[j])) {
                    m[i][j] = true;
                    neighbours[i]++;
                }else {
                    m[i][j] = false;
                }
                if(n < 1000) {
                    System.out.print(m[i][j]);
                    System.out.print(' ');
                }
            }
            if(n < 1000) {
                System.out.print('\n');
            }
        }

    }

    private static boolean adjacent(String s, String s1) {
        char[] c = s.toCharArray();
        char[] c1 = s1.toCharArray();
        int i, j;
        for (i = 0; i < c.length; i++) {
            for (j = 0; j < c1.length; j++) {
                if(c[i]==c1[j]) return true;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        //long start = System.nanoTime();  <---- for nanoseconds
        optional(args);
        long end = System.currentTimeMillis();
        long difference = end - start;
        System.out.println("time to run: " + (double)difference/1000 + "s");
    }
}
