package cz.czechitas.turtle;

import dev.czechitas.java1.turtle.engine.Turtle;

import java.awt.*;

public class HlavniProgram {
    private Turtle zofka = new Turtle();

    public static void main(String[] args) {
        new HlavniProgram().start();
    }

    public void start() {
        //TODO Tady bude kód pro kreslení želví grafiky.

        nakresliObdelnik(200, 150, Color.GRAY);
        nakresliCtverecek(250, Color.YELLOW);
        nakresliRovnostrannyTrojuhelnik(150d, 60, Color.CYAN);
        nakresliKolecko(100, 24, Color.RED);
        nakresliRovnoramennyPravouhlyTrojuhelnik(160, Color.GREEN);

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

    public void nakresliRovnostrannyTrojuhelnik(double delkaStrany, int velikostUhlu, Color barva) {
        zofka.setPenColor(barva);
        zofka.turnRight(30);
        for (int i = 0; i < 3; i++) {
            zofka.move(delkaStrany);
            zofka.turnRight(180 - velikostUhlu);
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

}