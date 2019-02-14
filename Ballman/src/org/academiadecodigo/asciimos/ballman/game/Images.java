package org.academiadecodigo.asciimos.ballman.game;

public enum Images {

    QUIM ("quim.png"),
    ZE ("ze.png"),
    FATIMA("fatima.png"),
    TO("to.png"),
    JAO("jao.png"),
    MARIA("maria.png"),
    SIDONIO("sidonio.png"),
    TONY("tony.png"),
    TOY("toy.png"),
    ARSENIO("arsenio.png"),
    RUTMARLENE("rutMarlene.png");

    private String path;

    Images(String path) {
        this.path = path;
    }

    public static String getRandom() {
        int i = (int)(Math.random() * Images.values().length);

        return Images.values()[i].path;
    }

}
