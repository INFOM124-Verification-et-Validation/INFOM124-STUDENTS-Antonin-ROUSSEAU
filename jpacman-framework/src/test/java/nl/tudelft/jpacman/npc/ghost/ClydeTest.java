package nl.tudelft.jpacman.npc.ghost;

import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.level.*;
import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ClydeTest {

    /**
     * Special Map parser used to construct boards for this test suite.
     */
    private GhostMapParser parser;
    private PlayerFactory players;

    @BeforeEach
    void setUp() {
        PacManSprites sprites = new PacManSprites();
        GhostFactory ghosts = new GhostFactory(sprites);
        parser = new GhostMapParser(
            new LevelFactory(sprites, ghosts),
            new BoardFactory(sprites),
            new GhostFactory(sprites)
        );
        players = new PlayerFactory(sprites);
    }

    @Test
    void testNextAiMoveAtLimitGetCloser() {
        char[][] map = {"#############".toCharArray(),
                        "#           #".toCharArray(),
                        "#P        C #".toCharArray(),
                        "#           #".toCharArray(),
                        "#############".toCharArray()};
        Level level = parser.parseMap(map);
        Player newPlayer = players.createPacMan();
        level.registerPlayer(newPlayer);
        newPlayer.setDirection(Direction.EAST);
        Clyde clyde = Navigation.findUnitInBoard(Clyde.class, level.getBoard());
        assertThat(clyde.nextAiMove()).isNotIn(Direction.NORTH, Direction.EAST);
    }

    @Test
    void testNextAiMoveAtLimitGetFarther() {
        char[][] map = {"#############".toCharArray(),
                        "#           #".toCharArray(),
                        "#P       C  #".toCharArray(),
                        "#           #".toCharArray(),
                        "#############".toCharArray()};
        Level level = parser.parseMap(map);
        Player newPlayer = players.createPacMan();
        level.registerPlayer(newPlayer);
        newPlayer.setDirection(Direction.EAST);
        Clyde clyde = Navigation.findUnitInBoard(Clyde.class, level.getBoard());
        assertThat(clyde.nextAiMove()).isNotIn(Direction.WEST);
    }

    @Test
    void testNextAiMoveGetCloser() {
        char[][] map = {"#######################".toCharArray(),
                        "#                     #".toCharArray(),
                        "#P               C    #".toCharArray(),
                        "#                     #".toCharArray(),
                        "#######################".toCharArray()};
        Level level = parser.parseMap(map);
        Player newPlayer = players.createPacMan();
        level.registerPlayer(newPlayer);
        newPlayer.setDirection(Direction.EAST);
        Clyde clyde = Navigation.findUnitInBoard(Clyde.class, level.getBoard());
        assertThat(clyde.nextAiMove()).isNotIn(Direction.NORTH, Direction.SOUTH, Direction.EAST);
    }

    @Test
    void testNextAiMoveGetFarther() {
        char[][] map = {"#############".toCharArray(),
                        "#           #".toCharArray(),
                        "#PC         #".toCharArray(),
                        "#           #".toCharArray(),
                        "#############".toCharArray()};
        Level level = parser.parseMap(map);
        Player newPlayer = players.createPacMan();
        level.registerPlayer(newPlayer);
        newPlayer.setDirection(Direction.EAST);
        Clyde clyde = Navigation.findUnitInBoard(Clyde.class, level.getBoard());
        assertThat(clyde.nextAiMove()).isNotIn(Direction.WEST);
    }

    @Test
    void testNextAiMoveAvoidObstacle() {
        char[][] map = {"####".toCharArray(),
                        "#PC#".toCharArray(),
                        "## #".toCharArray(),
                        "####".toCharArray()};
        Level level = parser.parseMap(map);
        Player newPlayer = players.createPacMan();
        level.registerPlayer(newPlayer);
        newPlayer.setDirection(Direction.EAST);
        Clyde clyde = Navigation.findUnitInBoard(Clyde.class, level.getBoard());
        assertThat(clyde.nextAiMove()).isIn(Optional.ofNullable(Direction.SOUTH));
    }
}
