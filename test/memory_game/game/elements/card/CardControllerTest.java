/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package memory_game.game.elements.card;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ACER
 */
public class CardControllerTest {
    
    public CardControllerTest() {
    }

    /**
     * Test of handleCardAction method, of class CardController.
     */
    @Test
    public void testHandleCardAction() {
        System.out.println("handleCardAction");
        CardController instance = null;
        instance.handleCardAction();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFlipperInstance method, of class CardController.
     */
    @Test
    public void testGetFlipperInstance() {
        System.out.println("getFlipperInstance");
        CardController instance = null;
        Thread expResult = null;
        Thread result = instance.getFlipperInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of flip method, of class CardController.
     */
    @Test
    public void testFlip() throws Exception {
        System.out.println("flip");
        CardController instance = null;
        instance.flip();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
