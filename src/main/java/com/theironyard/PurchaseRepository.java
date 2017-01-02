package com.theironyard;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

/**
 * Created by dlocke on 12/23/16.
 */
public interface PurchaseRepository extends CrudRepository <Purchase, Integer> {

    List<Purchase> findByCreditCard (String creditCard);
    List<Purchase> findByCategory (String category);
    List<Purchase> findByDate (String date);


}
