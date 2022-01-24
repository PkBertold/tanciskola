/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tanciskola2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Crosshair
 */
public class Tanciskola2 {

    public static void main(String[] args) {
        System.out.println("A 1. feladat megoldása");
        System.out.println("A tancrend.txt fájl beolvasása ");
        
        BufferedReader beolvas = new BufferedReader(new FileReader("C:\\Users\\Crosshair\\Desktop\\tancrend.txt"));
        
        String[] tanc = new String[140];
        String[] lany = new String[140];
        String[] fiu = new String[140];
        int db = 0;
        String sor;
        
        while ((sor = beolvas.readLine()) != null) {
            db++;
            tanc[db - 1] = sor;
            lany[db - 1] = beolvas.readLine();
            fiu[db - 1] = beolvas.readLine();
        }
        beolvas.close();
        System.out.println("A beolvasás megtörtént.\n");
        
        System.out.println("A 2. feladat megoldása ");
        System.out.println("Az elsőként bemutatott tánc neve: " + tanc[0]);
        System.out.println("Az utolsóként bemutatott tánc neve: " + tanc[db - 1]);
        
        System.out.println("\nA 3. feladat megoldása ");
        System.out.println("Hány pár mutatta be a sambát?");
        
        int sambaDb = 0;
        int i;
        for (i = 1; i <= db; i++) {
            if (tanc[i - 1].equals("samba")) {
            sambaDb++;
            }
        }
        System.out.println("A sambát " + sambaDb + " pár mutatta be. \n");
        
        System.out.println("A 4. feladat megoldása ");
        System.out.print("Vilma a következő táncokban szerepelt: ");
        
        for (i = 1; i <= db; i++) {
                if (lany[i - 1].equals("Vilma")) {
                        System.out.print(tanc[i - 1] + " ");
        
                }   
        }


        System.out.println("\n\nAz 5. feladat megoldása ");
        System.out.println("Egy bekért táncot kivel táncolt Vilma? ");
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Kérem a tánc nevét: ");
        String aktTanc = sc.nextLine();
        
        i = 1;
        while (i <= db && !(tanc[i - 1].equals(aktTanc) && lany[i - 1].equals("Vilma"))) {
                i++;
        }
        if (i <= db) {
                System.out.println("A " + aktTanc + " bemutatóján Vilma párja " + fiu[i - 1] + " volt.");
        } else {
                System.out.println("Vilma nem táncolt " + aktTanc + "-t.");
        }
        sc.close();
        
        System.out.println("\nA 6. feladat megoldása ");
        System.out.println("A bemutatón részt vevők listájának kiíratása a szereplok.txt fájlba");       
        
        // A lányok és a fiúk listála és táncaik száma
        String[] lanyLista = new String[20];
        int lanyListaDb = 0;
        int[] lanyTancDb = new int[20];
        String[] fiuLista = new String[20];
        int fiuListaDb = 0;
        int[] fiuTancDb = new int[20];
        
        int j;
        String aktLany, aktFiu;
        for (i = 1; i <= db; i++) {
            aktLany = lany[i - 1];
            j = 1;
            while (j <= lanyListaDb && !(lanyLista[j - 1].equals(aktLany))) {
                    j++;
            }
            if (j <= lanyListaDb) {
                    lanyTancDb[j - 1]++;
            } else {
                    lanyListaDb++;
                    lanyLista[lanyListaDb - 1] = aktLany;
                    lanyTancDb[lanyListaDb - 1] = 1;
            }
            
            aktFiu = fiu[i - 1];
            j = 1;
            while (j <= fiuListaDb && !(fiuLista[j - 1].equals(aktFiu))) {
                    j++;
            }
            if (j <= fiuListaDb) {
                    fiuTancDb[j - 1]++;
            } else {
                    fiuListaDb++;
                    fiuLista[fiuListaDb - 1] = aktFiu;
                    fiuTancDb[fiuListaDb - 1] = 1;
            }
}

        PrintWriter kiir = new PrintWriter(new FileWriter("szereplok.txt"));
        
        kiir.print("Lányok: ");
        for (i = 1; i < lanyListaDb; i++) {
            kiir.print(lanyLista[i - 1] + ", ");
        }
        kiir.println(lanyLista[lanyListaDb - 1]);
        
        kiir.print("Fiúk: ");
        
        for (i = 1; i < fiuListaDb; i++) {
                kiir.print(fiuLista[i - 1] + ", ");
        }
        kiir.println(fiuLista[fiuListaDb - 1]);
        
        kiir.close();
        System.out.println("A szereplok.txt fájl kiíratása megtörtént. \n");
        
        System.out.println("A 7. feladat megoldása ");
        System.out.println("A legtöbbször szereplők nemenként:");
        int lanyMaxDb = 0;
        for (i = 1; i < lanyListaDb; i++) {
                if (lanyTancDb[i - 1] > lanyMaxDb) {
                        lanyMaxDb = lanyTancDb[i - 1];
                }
        }
        
        System.out.print("Lányok:");
        
        for (i = 1; i < lanyListaDb; i++) {
                if (lanyTancDb[i - 1] == lanyMaxDb) {
                        System.out.print(" " + lanyLista[i - 1]);
                }
        }
        
        int fiuMaxDb = 0;
        for (i = 1; i < fiuListaDb; i++) {
                if (fiuTancDb[i - 1] > fiuMaxDb) {
                        fiuMaxDb = fiuTancDb[i - 1];
                }
        }
        System.out.println("");
        System.out.print("Fiúk:");
        
        for (i = 1; i < fiuListaDb; i++) {
            if (fiuTancDb[i - 1] == fiuMaxDb) {
                    System.out.print(" " + fiuLista[i - 1]);
            }
        }
        System.out.println("\n");
    }
}