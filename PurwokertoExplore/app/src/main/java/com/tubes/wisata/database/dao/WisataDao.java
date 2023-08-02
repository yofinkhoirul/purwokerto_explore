package com.tubes.wisata.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.tubes.wisata.model.ModelWisata;

import java.util.List;


@Dao
public interface WisataDao {

    @Query("SELECT * FROM tbl_wisata")
    LiveData<List<ModelWisata>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertData(ModelWisata... modelLaundries);

    @Query("DELETE FROM tbl_wisata")
    void deleteAllData();

    @Query("DELETE FROM tbl_wisata WHERE uid= :uid")
    void deleteSingleData(int uid);

    @Query("UPDATE tbl_wisata SET nama_jasa = :nama_jasa, items = :items, alamat = :alamat, harga = :harga WHERE uid = :uid")
    void updateData(String nama_jasa, int items, String alamat, int harga, int uid);

}
