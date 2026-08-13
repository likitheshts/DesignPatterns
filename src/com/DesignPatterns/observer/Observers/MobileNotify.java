package com.DesignPatterns.observer.Observers;

import com.DesignPatterns.observer.Observable.StockPriceObservable;

public class MobileNotify implements Observers{
    @Override
    public void update(double stockPrice) {
        System.out.println("Mobile done"+stockPrice);

    }
}
