package q4_LucasRangel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class multiplicarMatriz {
    int[][] matrizA;
    int[][] matrizB;
    FileReader fr;
    FileReader frb;
    BufferedReader bf;
    BufferedReader bfb;
    public String[] listalinha;
    public String[] listalinhab;
    public String linha;
    public Integer contador = 0;

    public void lerMatrizA() throws IOException {
        fr = new FileReader("C:\\Users\\PICHAU\\Desktop\\AV2_POO\\src\\q4_LucasRangel\\matriz.txt");
        bf = new BufferedReader(fr);
        listalinha = new String[100];
        for (linha = bf.readLine(); linha != null; linha = bf.readLine()) {
            listalinha[contador] = linha;
            contador++;
        }
        matrizA = new int[contador][];
        for (int i = 0; i < contador; i++) {
            String[] elementos = listalinha[i].split(" ");
            matrizA[i] = new int[elementos.length];
            for (int j = 0; j < elementos.length; j++) {
                matrizA[i][j] = Integer.parseInt(elementos[j]);
            }
        }
        bf.close();
        fr.close();
    }
    public void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void lerMatrizB() throws IOException {
        frb = new FileReader("C:\\Users\\PICHAU\\Desktop\\AV2_POO\\src\\q4_LucasRangel\\matrizb.txt");
        bfb = new BufferedReader(frb);
        listalinhab = new String[100];
        contador = 0;
        for (linha = bfb.readLine(); linha != null; linha = bfb.readLine()) {
            listalinhab[contador] = linha;
            contador++;
        }
        matrizB = new int[contador][];
        for (int i = 0; i < contador; i++) {
            String[] elementosb = listalinhab[i].split(" ");
            matrizB[i] = new int[elementosb.length];
            for (int j = 0; j < elementosb.length; j++) {
                matrizB[i][j] = Integer.parseInt(elementosb[j]);
            }
        }
        bfb.close();
        frb.close();
    }

    public int[][] multiplicar(int[][] matrizA, int[][] matrizB) {
        int numColunasA = matrizA[0].length;
        int numLinhasB = matrizB.length;
        if (numColunasA == numLinhasB) {
            int linhasA = matrizA.length;
            int colunasA = matrizA[0].length;
            int colunasB = matrizB[0].length;
            int[][] matrizC = new int[linhasA][colunasB];
            for (int i = 0; i < linhasA; i++) {
                for (int j = 0; j < colunasB; j++) {
                    int soma = 0;
                    for (int k = 0; k < colunasA; k++) {
                        soma += matrizA[i][k] * matrizB[k][j];
                    }
                    matrizC[i][j] = soma;
                }
            }
            return matrizC;
        } else {
            throw new IllegalArgumentException("As matrizes não podem ser multiplicadas.");
        }
    }

    public static void main(String[] args) throws IOException {
        multiplicarMatriz m = new multiplicarMatriz();
        m.lerMatrizA();
        m.lerMatrizB();
        int[][] matrizC = m.multiplicar(m.matrizA, m.matrizB);
        System.out.println("\n");
        m.imprimirMatriz(m.matrizA);
        System.out.println("+");
        m.imprimirMatriz(m.matrizB);
        System.out.println("---------");
        m.imprimirMatriz(matrizC);

    }
}