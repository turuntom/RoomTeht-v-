package tomi.sqlitetehtava;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MyEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String text_from_edittext;
    public String time;

    public MyEntity(String text_from_edittext, String time) {
        this.text_from_edittext = text_from_edittext;
        this.time = time;
    }
}

