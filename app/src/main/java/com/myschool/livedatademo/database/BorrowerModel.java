package com.myschool.livedatademo.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.myschool.livedatademo.utils.DateConverter;

import java.util.Date;

/**
 * Created by dilip on 13/2/18.
 */

@Entity
public class BorrowerModel {

    @PrimaryKey(autoGenerate = true)
    public int id;

    private String itemName;
    private String personName;

   /* @TypeConverters(DateConverter.class)
    private Date borrowDate;
*/
    private String borrowDate;

    public BorrowerModel(String itemName, String personName, String borrowDate) {
        this.itemName = itemName;
        this.personName = personName;
        this.borrowDate = borrowDate;
    }

    public String getItemName() {
        return itemName;
    }

    public String getPersonName() {
        return personName;
    }

    public String getBorrowDate() {
        return borrowDate;
    }
}
