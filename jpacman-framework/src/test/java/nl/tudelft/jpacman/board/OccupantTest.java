package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test suite to confirm that {@link Unit}s correctly (de)occupy squares.
 *
 * @author Jeroen Roosen 
 *
 */
class OccupantTest {

    /**
     * The unit under test.
     */
    private Unit unit;

    /**
     * Resets the unit under test.
     */
    @BeforeEach
    void setUp() {
        unit = new BasicUnit();
    }

    /**
     * Asserts that a unit has no square to start with.
     */
    @Test
    void noStartSquare() {
        assertThat(unit.hasSquare()).isEqualTo(false);
    }

    /**
     * Tests that the unit indeed has the target square as its base after
     * occupation.
     */
    @Test
    void testOccupy() {
        Square testSquare = new BasicSquare();
        unit.occupy(testSquare);
        assertThat(unit.getSquare()).isEqualTo(testSquare);
        /* test à faire mais qui ne rentre pas dans l'exercice
        assertThat(testSquare.getOccupants()).contains(unit); */
    }

    /**
     * Test that the unit indeed has the target square as its base after
     * double occupation.
     */
    @Test
    void testReoccupy() {
        Square firstSquare = new BasicSquare();
        Square expectedSquare = new BasicSquare();
        unit.occupy(firstSquare);
        unit.occupy(expectedSquare);
        assertThat(unit.getSquare()).isEqualTo(expectedSquare);
        /* tests à faire mais qui ne rentrent pas dans l'exercice
        assertThat(expectedSquare.getOccupants()).contains(unit);
        assertThat(firstSquare.getOccupants()).doesNotContain(unit); */
    }
}
