package com.tubes.wisata.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.tubes.wisata.database.DatabaseClient;
import com.tubes.wisata.database.dao.WisataDao;
import com.tubes.wisata.model.ModelWisata;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class AddDataViewModel extends AndroidViewModel {

    WisataDao pengeluaranDao;

    public AddDataViewModel(@NonNull Application application) {
        super(application);

        pengeluaranDao = DatabaseClient.getInstance(application).getAppDatabase().wisataDao();
    }

    public void addDataWisata(final String nama_jasa, final int items, final String alamat, final int price) {
        Completable.fromAction(() -> {
            ModelWisata pengeluaran = new ModelWisata();
            pengeluaran.nama_jasa = nama_jasa;
            pengeluaran.items = items;
            pengeluaran.alamat = alamat;
            pengeluaran.harga = price;
            pengeluaranDao.insertData(pengeluaran);
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

    public void updateDataWisata(final int uid, final String nama_jasa, final int items, final String alamat, final int price) {
        Completable.fromAction(() -> pengeluaranDao.updateData(nama_jasa, items, alamat, price, uid))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

}
