/*
 * TCSS 305 � Autumn 2014
 * Assignment 2 - ShoppingCart
 */

package model;

import java.math.BigDecimal;
    /**
     * Represents an ItemOrder.
     * 
     * @author Robbie Nichols eibbor08@uw.edu
     * @version Autumn 2014
     */
public final class ItemOrder {
    
    /** Type of Item held within a specific ItemOrder. */
    private final Item myItem;
    
    /** The quantity of the Item. */
    private final int myQuantity;
    
    /**
     * Constructs an ItemOrder with specified Item and Quantity.
     * 
     * @param theItem The Item type held within a specific ItemOrder passed to the constructor.
     * @param theQuantity   Quantity of the Item passed to the constructor.
     */
    public ItemOrder(final Item theItem, final int theQuantity) {
        myQuantity = theQuantity;
        myItem = theItem;
       
    }

    /**
     * Calculates total for an ItemOrder. Based on fields myItem and myQuantity.
     * 
     * @return Returns total price of the order as a BigDecimal.
     */
    public BigDecimal calculateOrderTotal() {
        return myItem.calculateItemTotal(myQuantity);
    }

    /**
     * Returns a reference to the Item stored in an ItemOrder.
     * 
     * @return Returns a reference to myItem.
     */
    public Item getItem() {
        return myItem;
    }

    /**
     * Returns a String representation of an ItemOrder.
     * 
     * {@inheritDoc}                   
     */
    @Override
    public String toString() {
        return this.getItem().toString() + ", Quantity: " + this.myQuantity;
    }

}
