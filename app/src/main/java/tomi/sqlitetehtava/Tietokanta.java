package tomi.sqlitetehtava;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {MyEntity.class}, version = 1, exportSchema = false)
public abstract class Tietokanta extends RoomDatabase {

    public static final String NIMI = "TIETOKANTA";
    public abstract MyEntityDao myEntityDao();

}
