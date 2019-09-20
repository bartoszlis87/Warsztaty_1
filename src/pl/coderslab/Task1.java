/*
POWRÓT
Warsztaty I Java
v3.2
Jak zacząć?
Następnie wykonaj commit zmian komendą:
git commit -m "nazwa_commita"
Wypchnij zmiany do swojego repozytorium na GitHubie. Użyj do tego komendy
git push origin master
Zadania
Gra w zgadywanie liczb
Symulator LOTTO
Gra w zgadywanie liczb 2
Kostka do gry
Wyszukiwarka najpopularniejszych słów
Gra w zgadywanie liczb
Napisz prostą grę w zgadywanie liczb. Komputer ma wylosować liczbę w zakresie od 1 do 100. Następnie:

wypisać: "Zgadnij liczbę" i pobrać liczbę z klawiatury;
sprawdzić, czy wprowadzony napis, to rzeczywiście liczba i w razie błędu wyświetlić komunikat: "To nie jest liczba", po czym wrócić do pkt. 1;
jeśli liczba podana przez użytkownika jest mniejsza niż wylosowana, wyświetlić komunikat: "Za mało!", po czym wrócić do pkt. 1;
jeśli liczba podana przez użytkownika jest większa niż wylosowana, wyświetlić komunikat: "Za dużo!", po czym wrócić do pkt. 1;
jeśli liczba podana przez użytkownika jest równa wylosowanej, wyświetlić komunikat: "Zgadłeś!", po czym zakończyć działanie programu.
 */

package pl.coderslab;

import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        final int min = 1;
        final int max = 10;
    //generator liczb losowych
        Random r = new Random();
        int intDrawn = r.nextInt(max - min)+ 1;// ustawienie osi zeby liczyl od 1


//        Random rand = new Random();
//        int intDrawn = rand.nextInt(max)+min;
        System.out.println("Wylosowana liczba: " + intDrawn);

        Scanner scan = new Scanner(System.in);
        int intUser = 0;
        int noOfDraws = 0;
        String prompt = "Podaj numer (w przedziale od " + min + " do " + max + "): ";
        do {
            noOfDraws ++;
            System.out.println();
            intUser = readIntRangeMinMax(prompt, min, max, scan);
            if (intUser == intDrawn) {
                System.out.println("Trafiłeś " + noOfDraws + " " + "razem " + "Zgadłeś:)\n Jesteś super :)");
            } else if (intUser < intDrawn) {
                System.out.println("Zbyt mała wartość: " + noOfDraws);
            } else {
                System.out.println("Zbyt duża wartość: " + noOfDraws);
            }
        } while (intUser != intDrawn);

    }
//Sprawdzenie czy dana liczba znajduje sie w  final int max.
    static int readIntRangeMinMax(String prompt, int min, int max, Scanner scan) {
        int inInt = 0;
        do {
            System.out.print(prompt);
            while (!scan.hasNextInt()) {
                System.out.println("Niepoprawne dane: ");
                scan.next();
                System.out.print(prompt);
            }
            inInt = scan.nextInt();
            if ((inInt < min) || (inInt > max)) {
                System.out.println("Niepoprawne dane: !!! podaj liczbę od 1 do 10");
            }
        } while ((inInt < min) || (inInt > max));
        return inInt;
    }
}