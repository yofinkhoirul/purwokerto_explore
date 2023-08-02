package com.tubes.wisata.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.tubes.wisata.database.DatabaseClient;
import com.tubes.wisata.database.dao.WisataDao;
import com.tubes.wisata.model.ModelWisata;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class WisataViewModel extends AndroidViewModel {

    LiveData<List<ModelWisata>> mModelWisata;
    WisataDao wisataDao;

    public WisataViewModel(@NonNull Application application) {
        super(application);

        wisataDao = DatabaseClient.getInstance(application).getAppDatabase().wisataDao();
        mModelWisata = wisataDao.getAll();
    }

    public LiveData<List<ModelWisata>> getDataWisata() {
        return mModelWisata;
    }

    public void deleteAllData() {
        Completable.fromAction(() -> wisataDao.deleteAllData())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }
    public void deleteDataById(final int uid) {
        Completable.fromAction(() -> wisataDao.deleteSingleData(uid))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

}
