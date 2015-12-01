/*
 * TCSS 305 – Autumn 2014
 * Assignment 2 - ShoppingCart
 */
package tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import model.Item;
import model.ItemOrder;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests ItemOrder class.
 * 
 * @author Robbie Nichols
 * @version Autumn 2014
 */
public class ItemOrderTest {
    /** An Item to be used in testing. */
    private final Item myTestItem = new Item("TestName", new BigDecimal("19.99"));
    /** An Item to be used in testing. */
    private final Item myTestBulK = new Item("BulkName", new BigDecimal("19.99"), 6, 
                                             new BigDecimal("107.94"));
    /** An ItemOrder to test. */
    private ItemOrder myOrder1;
    /** An ItemOrder to test. */
    private ItemOrder myOrder2;

    /**
     * Initializes ItemOrder to test before each test.
     */
    @Before
    public void setUp() {
        myOrder1 = new ItemOrder(myTestItem, 5);
        myOrder2 = new ItemOrder(myTestBulK, 7);
    }

    //no constructor test, handled by setUp

    /**
     * Test method for {@link model.ItemOrder#calculateOrderTotal()}.
     */
    @Test
    public void testCalculateOrderTotal() {
        //19.99 * 5 = 99.95
        assertEquals(myOrder1.calculateOrderTotal(), new BigDecimal("99.95"));
        //17.99 * 6 + 19.99 * 1 = 127.93
        assertEquals(myOrder2.calculateOrderTotal(), new BigDecimal("127.93"));
        assertNotEquals(myOrder1.calculateOrderTotal(), myOrder2.calculateOrderTotal());
    }

    /**
     * Test method for {@link model.ItemOrder#getItem()}.
     */
    @Test
    public void testGetItem() {
        assertEquals(myOrder1.getItem(), myTestItem);
        assertNotEquals(myOrder1.getItem(), myOrder2.getItem());
    }

    /**
     * Test method for {@link model.ItemOrder#toString()}.
     */
    @Test
    public void testToString() {
        assertEquals(myOrder2.toString(), "BulkName, $19.99 (6 for $107.94), Quantity: 7");
    }

}
