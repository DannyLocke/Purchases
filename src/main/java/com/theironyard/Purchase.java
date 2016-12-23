package com.theironyard;

import javax.persistence.*;

/**
 * Created by dlocke on 12/23/16.
 */

@Entity
@Table(name="purchases")
public class Purchase {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String date;

    @Column(nullable = false)
    String creditCard;

    @Column(nullable = false)
    String cvv;

    @Column(nullable = false)
    String category;


    //join the two tables together
    @Column(nullable = false)
    String customer;


}
