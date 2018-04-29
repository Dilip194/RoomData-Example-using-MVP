package com.myschool.livedatademo.interfaces;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import com.myschool.livedatademo.database.BorrowerModel;
import com.myschool.livedatademo.utils.DateConverter;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by dilip on 20/2/18.
 */

@Dao
@TypeConverters(DateConverter.class)
public interface BorrowModelDao {

    @Query("select * from BorrowerModel")
    LiveData<List<BorrowerModel>> getAllBorrowersItem();

    @Query("select * from BorrowerModel where id = :id")
    BorrowerModel getItemById(String id);

    @Insert(onConflict = REPLACE)
    void addBorrower(BorrowerModel databaseTable);

    @Delete
    void deleteBorrower(BorrowerModel databaseTable);

}
