package com.myschool.livedatademo.viewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.myschool.livedatademo.database.BorrowerModel;
import com.myschool.livedatademo.utils.AppDatabase;

/**
 * Created by dilip on 20/2/18.
 */

public class AddItemViewModel extends AndroidViewModel{

    private AppDatabase appDatabase;

    public AddItemViewModel(@NonNull Application application) {
        super(application);
        appDatabase = AppDatabase.getInstance(this.getApplication());
    }

    public void addBorrow(final BorrowerModel borrowModel) {
        new addAsyncTask(appDatabase).execute(borrowModel);
    }

    private static class addAsyncTask extends AsyncTask<BorrowerModel, Void, Void> {

        private AppDatabase db;

        addAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final BorrowerModel... params) {
            db.itemAndPersonModel().addBorrower(params[0]);
            return null;
        }

    }
}
