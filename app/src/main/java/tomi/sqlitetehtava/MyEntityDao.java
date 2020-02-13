package tomi.sqlitetehtava;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MyEntityDao {

    @Query("Select * from MyEntity") List<MyEntity> lista();

    @Insert
    void InsertMyEntity(MyEntity myEntity);

    @Query("DELETE FROM MyEntity")public void nukeTable();

}
