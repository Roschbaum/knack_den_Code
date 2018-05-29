/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knack_den_code;

/**
 * Stellen die Prüfsteine des Spiels da. 1 ist Farbe richtig aber falscher Ort.
 * 2 ist richtiger Ort und richtige Farbe.
 *
 * @author Friedrich
 */
public class Pruefsteinfigur {

    private int Typ;

    /**
     * Pruefstein in der Realitaet
     *
     * @param Typ Art des Steins zwischen 0-2
     */
    public Pruefsteinfigur(int Typ) {
        this.Typ = Typ;
    }

    public int getTyp() {
        return Typ;
    }

}
