package com.DesignPatterns.observer.Observers;

import com.DesignPatterns.observer.Observable.StockPriceImpl;
import com.DesignPatterns.observer.Observable.StockPriceObservable;

public interface Observers {

    public void update(double stockPrice);
}
