package com.myschool.livedatademo.viewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.myschool.livedatademo.database.BorrowerModel;
import com.myschool.livedatademo.utils.AppDatabase;

import java.util.List;

/**
 * Created by dilip on 20/2/18.
 */

public class BorrowedListViewModel extends AndroidViewModel {

    private final LiveData<List<BorrowerModel>> getAllPersonalList;
    private AppDatabase appDatabase;

    public BorrowedListViewModel(@NonNull Application application) {
        super(application);

        appDatabase = AppDatabase.getInstance(this.getApplication());
        getAllPersonalList = appDatabase.itemAndPersonModel().getAllBorrowersItem();
    }

    public LiveData<List<BorrowerModel>> getGetAllPersonalList(){
        return getAllPersonalList;
    }

    public void deleteItems(BorrowerModel table){
        new DeleteAsyncTask(appDatabase).execute(table);
    }

    private static class DeleteAsyncTask extends AsyncTask<BorrowerModel,Void,Void>{

        private AppDatabase db;

        public DeleteAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(BorrowerModel... databaseTables) {
            db.itemAndPersonModel().deleteBorrower(databaseTables[0]);
            return null;
        }
    }
}
