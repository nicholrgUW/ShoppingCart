/*
 * TCSS 305 � Autumn 2014 Assignment 2 - ShoppingCart
 */

package tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import model.Item;
import model.ItemOrder;
import model.ShoppingCart;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests ShoppingCart class.
 * 
 * @author Robbie Nichols
 * @version Autumn 2014
 */
public class ShoppingCartTest {
    /** A test Item to be used in testing. */
    private final Item myTestItem = new Item("TestName", new BigDecimal("20.00"));
    /** An ItemOrder to be used in testing. */
    private final ItemOrder myTestOrder1 = new ItemOrder(myTestItem, 7);
    /** An ItemOrder to be used in testing. */
    private final ItemOrder myTestOrder2 = new ItemOrder(myTestItem, 1);
    /** A ShoppingCart to be used in testing. */
    private ShoppingCart myTestCart;

    /**
     * Initializes ShoppingCart to test before each test.
     */
    @Before
    public void setUp() {
        myTestCart = new ShoppingCart();
    }

    // no constructor test -- handled by setUp

    /**
     * Test method for {@link model.ShoppingCart#add(model.ItemOrder)}.
     */
    @Test
    public void testAdd() {
        myTestCart.add(myTestOrder1);
        assertEquals(myTestCart.toString(), myTestOrder1.toString() + "\n");
        myTestCart.add(myTestOrder2);
        assertEquals(myTestCart.toString(), myTestOrder2.toString() + "\n");
    }

    /**
     * Test method for {@link model.ShoppingCart#setMembership(boolean)}.
     */
    @Test
    public void testSetMembership() {
        myTestCart.add(myTestOrder2);
        assertEquals(myTestCart.calculateTotal(), new BigDecimal("20.00"));
        myTestCart.setMembership(true);
        assertEquals(myTestCart.calculateTotal(), new BigDecimal("18.00"));
    }

    /**
     * Test method for {@link model.ShoppingCart#calculateTotal()}.
     */
    @Test
    public void testCalculateTotal() {
        final ShoppingCart foo = new ShoppingCart();
        foo.add(new ItemOrder(new Item("bar", new BigDecimal("5.00")), 2));
        foo.setMembership(true);
        assertEquals(foo.calculateTotal(), new BigDecimal("10.00"));
        myTestCart.add(myTestOrder1);
        assertEquals(myTestCart.calculateTotal().toString(), myTestOrder1.
                     calculateOrderTotal().toString());
    }

    // toString() covered in testAdd

}
