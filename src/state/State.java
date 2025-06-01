package state;

import input.Input;
import input.MousePosition;

public class State {
    private Input input;

    public State(Input input) {
        this.input = input;
    }

    public void handleMouseInput() {
        if (input.isMouseClicked()) {
            MousePosition pos = input.getMousePosition();
            System.out.printf("Mouse clicado na posição x:%d y:%d%n", pos.getX(), pos.getY());
            input.clearMouseClicked(); // para resetar o clique
        }
    }
}
