package org.luxoft.tutor.maze.view;

import org.luxoft.tutor.mazeframework.domain.Command;
import org.luxoft.tutor.mazeframework.domain.MazeGame;
import org.luxoft.tutor.mazeframework.domain.Side;
import org.luxoft.tutor.mazeframework.domain.View;
import org.luxoft.tutor.mazeframework.view.Menu;

public class MenuImpl extends Menu {

    @Override
    protected String getResourceId() {
        return "Main Menu";
    }

    public MenuImpl(View implementation, MazeGame mazeGame) {
        super(implementation);
        persist("Q", new ExitCommand(mazeGame));
        persist("W", new GoToCommand(mazeGame, Side.WEST));
        persist("E", new GoToCommand(mazeGame, Side.EAST));
        persist("S", new GoToCommand(mazeGame, Side.SOUTH));
        persist("N", new GoToCommand(mazeGame, Side.NORTH));
        persist("?", new HelpCommand());
    }

    @SuppressWarnings("unchecked")
    @Override
    protected Command makeUnknownCommand() {
        return new UnknownCommand();
    }

    private class ExitCommand extends Command {

        private final MazeGame mazeGame;

        public ExitCommand(MazeGame mazeGame) {
            super();
            this.mazeGame = mazeGame;
        }

        @Override
        public void execute() {
            info("Good bay!");
            mazeGame.terminate();
        }
    }

    private class GoToCommand extends Command {

        private final MazeGame mazeGame;
        private final Side side;

        public GoToCommand(MazeGame mazeGame, Side side) {
            this.mazeGame = mazeGame;
            this.side = side;
        }

        @Override
        public void execute() {
            info(side.toString());
            mazeGame.goTo(side);
            mazeGame.show();
        }
    }

    private class HelpCommand extends Command {
        @Override
        public void execute() {
            show();
        }
    }

    private class UnknownCommand extends Command {
        @Override
        public void execute() {
            error("Unknown command");
        }
    }

}
