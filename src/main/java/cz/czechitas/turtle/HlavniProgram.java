package cz.czechitas.turtle;

import dev.czechitas.java1.turtle.engine.Turtle;

import java.awt.*;
import java.util.Optional;

public class HlavniProgram {
    private Turtle zofka = new Turtle();

    public static void main(String[] args) {
        new HlavniProgram().start();
    }

    public void start() {
        //TODO Tady bude kód pro kreslení želví grafiky.

        /*
        nakresliObdelnik(200, 150, Color.GRAY);
        nakresliCtverecek(250, Color.YELLOW);
        nakresliRovnostrannyTrojuhelnik(150d, 60, Color.CYAN);
        nakresliKolecko(100, 24, Color.RED);
        nakresliRovnoramennyPravouhlyTrojuhelnik(160, Color.GREEN);
        */


        nakresliZmrzlinu();

        nakresliSnehulaka();

        nakresliMasinku();

    }

    public void nakresliObdelnik(int delsiStrana, int kratsiStrana, Color barva) {
        zofka.setPenColor(barva);
        for (int i = 0; i < 2; i++) {
            zofka.move(delsiStrana);
            zofka.turnRight(90);
            zofka.move(kratsiStrana);
            zofka.turnRight(90);
        }
    }

    public void nakresliKolecko(int polomer, int pocetStran, Color barva) {
        zofka.setPenColor(barva);
        int uhel = 360 / pocetStran;
        int delkaStrany = (int) (Math.sin(Math.PI * (double) uhel / 360d) * polomer * 2);
        zofka.turnRight(90);

        for (int i = 0; i < pocetStran; i++) {
            zofka.move(delkaStrany);
            zofka.turnRight(uhel);
        }
        zofka.turnLeft(90);
    }

    public void nakresliCtverecek(double delkaStrany, Color barva) {
        zofka.setPenColor(barva);
        for (int i = 0; i < 4; i++) {
            zofka.move(150);
            zofka.turnRight(90);
        }
    }

    public void nakresliRovnostrannyTrojuhelnik(double delkaStrany, Color barva) {
        zofka.setPenColor(barva);
        zofka.turnRight(30);
        for (int i = 0; i < 3; i++) {
            zofka.move(delkaStrany);
            zofka.turnRight(180 - 60);
        }
        zofka.turnLeft(30);
    }

    public void nakresliRovnoramennyPravouhlyTrojuhelnik(double velikostStrany, Color barva) {
        var velikostPrepony = Math.sqrt(2 * Math.pow(velikostStrany, 2));
        zofka.setPenColor(barva);
        zofka.turnRight(45);
        zofka.move(velikostPrepony);
        zofka.turnRight(135);
        zofka.move(velikostStrany);
        zofka.turnRight(90);
        zofka.move(velikostStrany);
        zofka.turnRight(90);
    }

    public void novaPoziceZmrzlina() {
        zofka.penUp();
        zofka.turnLeft(90);
        zofka.move(250);
        zofka.turnRight(90);
        zofka.penDown();
    }

    public void novaPoziceSnehulak() {
        zofka.penUp();
        zofka.turnLeft(90);
        zofka.move(280);
        zofka.turnLeft(90);
        zofka.move(280);
        zofka.penDown();
    }

    public void novaPoziceMasinka() {
        zofka.penUp();
        zofka.turnRight(90);
        zofka.move(270);
        zofka.penDown();
    }

    public void nakresliZmrzlinu() {
        this.novaPoziceZmrzlina();
        this.nakresliKolecko(85, 20, Color.RED);
        zofka.penUp();
        zofka.turnLeft(180);
        zofka.move(110);
        zofka.turnLeft(90);
        zofka.move(90);
        zofka.turnRight(90);
        zofka.penDown();
        this.nakresliRovnostrannyTrojuhelnik(160, new Color(0x615406));
    }

    public void nakresliSnehulaka() {
        this.novaPoziceSnehulak();
        this.nakresliKolecko(65, 20, new Color(0x0A9CEA));
        zofka.turnRight(180);
        zofka.penUp();
        zofka.move(130);
        zofka.penDown();
        zofka.turnRight(180);
        this.nakresliKolecko(90, 24, new Color(0x0A9CEA));
        zofka.turnRight(178);
        zofka.penUp();
        zofka.move(90);
        zofka.turnLeft(90);
        zofka.move(94);
        zofka.turnLeft(180);
        zofka.penDown();
        this.nakresliKolecko(30, 18, Color.BLUE);
        zofka.penUp();
        zofka.move(184);
        zofka.turnLeft(90);
        zofka.penDown();
        this.nakresliKolecko(30, 18, Color.BLUE);
        zofka.penUp();
        zofka.turnLeft(90);
        zofka.move(90);
        zofka.turnRight(90);
        zofka.move(90);
        zofka.turnRight(180);
        zofka.penDown();
        this.nakresliKolecko(120, 24, new Color(0x0A9CEA));
    }

    public void nakresliMasinku() {
        this.novaPoziceMasinka();
        this.nakresliObdelnik(230, 130, Color.BLACK);
        zofka.turnRight(90);
        zofka.move(130);
        zofka.turnLeft(90);
        zofka.move(230);
        zofka.turnLeft(90);
        this.nakresliObdelnik(260, 150, Color.GREEN);
        zofka.turnLeft(70);
        this.nakresliKolecko(80, 24, Color.BLACK);
        zofka.turnLeft(70);
        zofka.penUp();
        zofka.move(50);
        zofka.turnLeft(120);
        zofka.penDown();
        this.nakresliKolecko(40, 25, Color.PINK);
        zofka.turnRight(180);
        zofka.penUp();
        zofka.move(85);
        zofka.turnRight(180);
        zofka.penDown();
        this.nakresliKolecko(40, 25, Color.PINK);
        zofka.penUp();
        zofka.turnLeft(175);
        zofka.move(210);
        zofka.turnRight(95);
        zofka.penDown();
        this.nakresliRovnoramennyPravouhlyTrojuhelnik(90, Color.MAGENTA);
    }
}