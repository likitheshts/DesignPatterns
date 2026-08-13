package com.DesignPatterns.observer.Observable;

import com.DesignPatterns.observer.Observers.Observers;

import java.util.List;

public interface StockPriceObservable {

    public void add(Observers observers);

    public void remove(Observers observers);

    public void notifyObservers();

    public void setData(double price);
}

