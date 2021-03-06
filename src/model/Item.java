/*
 * TCSS 305 � Autumn 2014
 * Assignment 2 - ShoppingCart
 */

package model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Objects;
/**
 * Represents an Item.
 * 
 * @author Robbie Nichols eibbor08@uw.edu
 * @version Autumn 2014
 */
public final class Item {
    
    /** Formatter for representing prices in Strings. */
    private static final NumberFormat FORMAT = NumberFormat.getCurrencyInstance();
    
    /** Name of the Item. */
    private final String myName;
    
    /** Standard price of the Item. */
    private final BigDecimal myPrice;
    
    /** Bulk price of the Item. */
    private final BigDecimal myBulkPrice;
    
    /**
     * Bulk quantity of the Item. This is the quantity of the Item at which the 
     * discounted bulk price is applied.
     */
    private final int myBulkQuantity;
    
    /** 
     * Constructs an Item with the specified name and price. myBulkQuantity and myBulkPrice set
     * to sentinel values of -1.
     * 
     * @param theName   The name of the Item.
     * @param thePrice  The standard price of the Item.
     */
    public Item(final String theName, final BigDecimal thePrice) {
        myName = theName;
        myPrice = thePrice;
        //set other fields to 0 to make other methods simpler?
        myBulkQuantity = -1;    //if removed, will break calculateItemTotal
        myBulkPrice = new BigDecimal(-1);
    }

    /**
     * Constructs an Item with the specified name, price, bulk quantity, and bulk price.
     * 
     * @param theName           The name of the Item.
     * @param thePrice          The standard price for a single Item.
     * @param theBulkQuantity   Quantity at which bulk pricing is introduced.
     * @param theBulkPrice      Discounted bulk price.
     */
    public Item(final String theName, final BigDecimal thePrice, final int theBulkQuantity,
                final BigDecimal theBulkPrice) {
        myName = theName;
        myPrice = thePrice;
        myBulkQuantity = theBulkQuantity;
        myBulkPrice = theBulkPrice;
    }

    /**
     * Calculates the total price of the the specified number of items, taking bulk pricing 
     * into account if possible.
     * 
     * @param theQuantity The quantity of Items to price out.
     * @return Returns the total price, applying bulk discount if applicable.
     */
    public BigDecimal calculateItemTotal(final int theQuantity) {
        BigDecimal returnTotal;
        if (this.myBulkQuantity == -1) {    //Uses sentinel value of -1 to check if 
                                            //myBulkQuantity has been set.
            returnTotal = new BigDecimal(this.myPrice.multiply(new BigDecimal(theQuantity)).
                                         toString());
        } else {
            final BigDecimal[] mixedQuantity =  new BigDecimal(theQuantity).
                            divideAndRemainder(new BigDecimal(this.myBulkQuantity));
        // [0] = bulk total, [1] = remainder (full priced), found in Java API
        // This means if theQuantity = 7 and BulkQuantity = 6, then [0] = 1 and [1] = 1.
            returnTotal = new BigDecimal(mixedQuantity[0].multiply(this.myBulkPrice).
                add(mixedQuantity[1].multiply(this.myPrice)).toString());
        }
        return returnTotal;
    }
    /**
     * Returns a String representation of the the Item's name, Price, and BulkQuantity pricing.
     * 
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        final StringBuffer returnString = new StringBuffer(this.myName);
        returnString.append(", ");
        if (this.myBulkQuantity == -1) {
            returnString.append(FORMAT.format(this.myPrice));
        } else {
            returnString.append(FORMAT.format(this.myPrice) + " ("
                                            + this.myBulkQuantity + " for "
                                            + FORMAT.format(this.myBulkPrice) + ")");
        }
        return returnString.toString();
    }

    /**
     * Returns true if the object being compared has the same values and name. False otherwise.
     * 
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object theOther) {
        boolean equalsFlag = false;
        if (this == theOther) {
            equalsFlag = true;
        } else if (theOther != null && this.getClass() == theOther.getClass()) {
            final Item temp = (Item) theOther;
            equalsFlag = this.toString().equals(temp.toString());
        }    
        return equalsFlag;
    }

    /**
     * Generates a hash code for an Item object which will be the same if all the fields are 
     * the same.
     * 
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return 11 * Objects.hashCode(this.myName) + 13 * this.myPrice.intValue() 
                        + 15 * this.myBulkPrice.intValue() + 17 * this.myBulkQuantity;
    }

}
