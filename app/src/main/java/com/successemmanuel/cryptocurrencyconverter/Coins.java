package com.successemmanuel.cryptocurrencyconverter;

/**
 * Created by SuccessEmmanuel on 11/20/2017.
 */

public class Coins {

    /** The converting from coin image */
    private int mFromCoinImageID;

    /** The converting from coin Name */
    private String mFromCoinName;

    /** The conversion rate */
    private String mRate;


    public Coins(int fromCoinImageID, String fromCoinName, String rate){
        mFromCoinImageID = fromCoinImageID;
        mFromCoinName = fromCoinName;
        mRate = rate;
    }

    /**
     * Get the converting from coin image ID
     * @return image ID as int
     */
    public int getFromCoinImageID() {
        return mFromCoinImageID;
    }

    /**
     * Get the converting From coin Name
     * @return coin name as String
     */
    public String getFromCoinName() {
        return mFromCoinName;
    }

    public String getRate() {
        return mRate;
    }
}
