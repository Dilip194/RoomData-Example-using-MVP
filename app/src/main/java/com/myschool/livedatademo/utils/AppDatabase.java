package com.myschool.livedatademo.utils;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.myschool.livedatademo.database.BorrowerModel;
import com.myschool.livedatademo.interfaces.BorrowModelDao;

/**
 * Created by dilip on 20/2/18.
 */

@Database(entities = {BorrowerModel.class},version = 1)
public abstract class AppDatabase extends RoomDatabase{

    public static AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context){

        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"borrower_db")
                    .build();
        }
        return INSTANCE;
    }

    public abstract BorrowModelDao itemAndPersonModel();
}
