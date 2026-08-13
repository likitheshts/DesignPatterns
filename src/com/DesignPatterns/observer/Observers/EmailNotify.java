package com.DesignPatterns.observer.Observers;

import com.DesignPatterns.observer.Observable.StockPriceObservable;

public class EmailNotify implements Observers{
    @Override
    public void update(double stockPrice) {
        System.out.println("Email done"+stockPrice);
    }
}
