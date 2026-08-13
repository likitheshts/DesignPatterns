package com.DesignPatterns.observer;

import com.DesignPatterns.observer.Observable.StockPriceImpl;
import com.DesignPatterns.observer.Observable.StockPriceObservable;
import com.DesignPatterns.observer.Observers.EmailNotify;
import com.DesignPatterns.observer.Observers.MobileNotify;
import com.DesignPatterns.observer.Observers.Observers;
import com.DesignPatterns.observer.Observers.User;

public class StratergyService {
    public static void main(String[] args) {
        Observers liki = new MobileNotify();
        Observers rahul = new User();
        Observers sam = new EmailNotify();

        StockPriceImpl stockPriceObservable = new StockPriceImpl(20);
        stockPriceObservable.add(liki);
        stockPriceObservable.add(rahul);
        stockPriceObservable.add(sam);


        stockPriceObservable.setData(100);
    }
}
