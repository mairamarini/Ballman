package org.academiadecodigo.asciimos.ballman.game;

public enum Images {

    QUIM ("resources/quim.png"),
    ZE ("resources/ze.png"),
    FATIMA("resources/fatima.png"),
    TO("resources/to.png"),
    JAO("resources/jao.png"),
    MARIA("resources/maria.png"),
    SIDONIO("resources/sidonio.png"),
    TONY("resources/tony.png"),
    TOY("resources/toy.png"),
    ARSENIO("resources/arsenio.png"),
    RUTMARLENE("resources/rutMarlene.png");

    private String path;

    Images(String path) {
        this.path = path;
    }

    public static String getRandom() {
        int i = (int)(Math.random() * Images.values().length);

        return Images.values()[i].path;
    }

}
