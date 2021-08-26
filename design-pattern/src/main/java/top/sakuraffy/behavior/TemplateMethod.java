package top.sakuraffy.behavior;

abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    /**
     * 模板方法设置为 final，这样它就不会被重写
      */
    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }
}

class Cricket extends Game {

    @Override
    void endPlay() {
        System.out.println("Cricket Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }
}

class Football extends Game {

    @Override
    void endPlay() {
        System.out.println("Football Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }
}

public class TemplateMethod {
    public static void main(String[] args) {
        Game game1 = new Football();
        game1.play();

        Game game2 = new Football();
        game2.play();
    }
}
