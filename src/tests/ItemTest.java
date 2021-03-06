/*
 * TCSS 305 � Autumn 2014
 * Assignment 2 - ShoppingCart
 */

package tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import model.Item;
import org.junit.Before;
import org.junit.Test;



/**
 * Tests Item class. 
 * 
 * @author Robbie Nichols
 * @version Autumn 2014
 */
public class ItemTest {

    /** A test Item. */
    private Item myItem;
    /** A test bulk Item. */
    private Item myBulkItem;
    /** Price for setUp. */
    private final BigDecimal myPrice = new BigDecimal("19.99");
    /** Bulk price for setUp. */
    private final BigDecimal myBulkPrice = new BigDecimal("100.00");
    /** Quantity for BulkQuantity.*/

    /**
     * Initializes Items to test before each test.
     */
    @Before
    public void setUp() {
        myItem = new Item("TestName", myPrice);
        myBulkItem = new Item("TestNameBulk", myPrice, 6, myBulkPrice);
    }

    /**
     * Test method for {@link model.Item#hashCode()}.
     */
    @Test
    public void testHashCode() {
        assertEquals(myItem.hashCode(), new Item("TestName", myPrice).hashCode());
        assertEquals(myBulkItem.hashCode(), myBulkItem.hashCode());
        assertNotEquals(myItem.hashCode(), myBulkItem.hashCode());
    }

    /**
     * Test method for {@link model.Item#calculateItemTotal(int)}.
     */
    @Test
    public void testCalculateItemTotal() {
        assertEquals(myBulkItem.calculateItemTotal(7).toString(), "119.99");
        assertEquals(myItem.calculateItemTotal(5).toString(), "99.95");
    }

    /**
     * Test method for {@link model.Item#toString()}.
     */
    @Test
    public void testToString() {
        assertEquals(myItem.toString(), "TestName, $19.99");
        assertEquals(myBulkItem.toString(), "TestNameBulk, $19.99 (6 for $100.00)");
    }

    /**
     * Test method for {@link model.Item#equals(java.lang.Object)}.
     */
    @Test
    public void testEqualsObject() {
        final Item aBulkItem = new Item("TestNameBulk", myPrice, 6, myBulkPrice);
        final String foo = "bar";
        assertEquals(myItem, myItem);
        assertEquals(myBulkItem, aBulkItem);
        assertNotEquals(myItem, myBulkItem);
        assertNotEquals(myItem, foo);
        assertNotEquals(myItem, null);
    }

}
