/*
 * TCSS 305 – Autumn 2014
 * Assignment 2 - ShoppingCart
 */

package model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a ShoppingCart object.
 * 
 * @author Robbie Nichols eibbor08@uw.edu
 * @version Autumn 2014
 */
public class ShoppingCart {
    
    /** Map containing ItemOrders with Item as the key and ItemOrder as the value. */
    private final Map<Item, ItemOrder> myItemOrders;
    
    /** Boolean flag specifying membership (for discounting in calculateTotal). */
    private boolean myMembership;
    
    /**
     * Constructs an empty ShoppingCart item. myMembership set to false as default.
     */
    public ShoppingCart() {
        myItemOrders = new HashMap<Item, ItemOrder>();
        myMembership = false;
    }

    /**
     * Adds specified ItemOrder to a ShoppingCart's hashmap (myItemQuantities). Replaces
     * existing ItemOrders that have equivalent Items.
     * 
     * @param theOrder ItemOrder type to store in myItemQuantites.
     */
    public void add(final ItemOrder theOrder) {
        this.myItemOrders.put(theOrder.getItem(), theOrder);
    }

    /**
     * Sets myMembership to specified boolean. Default is false.
     * 
     * @param theMembership Parameter specifying membership.
     */
    public void setMembership(final boolean theMembership) {
        this.myMembership = theMembership;
    }

    /**
     * Returns the total price of a ShoppingCart as a BigDecimal. Takes into account 
     * current membership status and current total >= 20.
     * 
     * @return Total price of all items in a ShoppingCart.
     */
    public BigDecimal calculateTotal() {
        BigDecimal returnTotal = BigDecimal.ZERO;
        for (final Item key : myItemOrders.keySet()) {
            returnTotal = returnTotal.add(myItemOrders.get(key).calculateOrderTotal());
        }
        if (myMembership && returnTotal.compareTo(new BigDecimal("20.00")) >= 0) {
            //this test is True if membership == true AND the difference between returnTotal
            // and 20 is greater than or equal to 0 (in other words, if returnTotal >= 20).
            returnTotal = returnTotal.multiply(new BigDecimal(".9")).
                            setScale(2, BigDecimal.ROUND_HALF_DOWN);
        }
        return returnTotal;
    }
    
    /**
     * Returns a String representation of a ShoppingCart.
     * 
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        final String line = "\n"; //Violations overview gets really mad when I append an "\n".
        final StringBuffer returnString = new StringBuffer();
        for (final Item key : myItemOrders.keySet()) {
            returnString.append(myItemOrders.get(key).toString()).append(line);
        }
        return returnString.toString();
    }

}
