package com.DesignPatterns.observer.Observable;

import com.DesignPatterns.observer.Observers.Observers;

import java.util.ArrayList;
import java.util.List;

public class StockPriceImpl implements StockPriceObservable{

    List<Observers> observersList = new ArrayList<>();
    double stockPrice = 0;

    public StockPriceImpl(double stockPrice) {
        this.stockPrice = stockPrice;
    }
    @Override
    public void add(Observers observers) {
        observersList.add(observers);
    }

    @Override
    public void remove(Observers observers) {
        observersList.remove(observers);
    }

    @Override
    public void notifyObservers() {
        for(Observers ov : observersList) {
            ov.update(stockPrice);
        }
    }

    @Override
    public void setData(double price) {
        if(stockPrice == 0) {
            notifyObservers();
        }
        this.stockPrice = price;
    }
}
