package balti.myaddressapp.LocalDb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by BALTI on 3/8/2017.
 */

public class MyDataBase extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "SmartAddressBook.db";

    private static final String TABLE_NAME = "ContectTable";


    //constructor
    public MyDataBase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    //oncreste method
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (id INTEGER PRIMARY KEY,Name TEXT,PhoneNo TEXT,Email Text,Type Text)");

    }


    //onupgrade
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);

    }


}
/*


    //insert Start

    public Boolean insertData(String name){

        SQLiteDatabase db= this.getWritableDatabase();

        ContentValues obj=new ContentValues();
        obj.put("Name",name);


        long result=db.insert(TABLE_NAME,null,obj);


        if (result==-1){
            return  false;

        }
        else return true;



    }


    //Insert Finish





    //getSingleDatabyId

    public Cursor getData(int id){
        SQLiteDatabase db=this.getWritableDatabase();//connection

        String query="SELECT * FROM "+TABLE_NAME+" WHERE ID = "+id;
        Cursor cursor=db.rawQuery(query,null);
        return cursor;
    }

    //end



    //Update

    public void Update(int id ,String name){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("NAME",name);
        db.update(TABLE_NAME,contentValues, "ID = "+id,null);
        db.close();

    }





    //Delete
    public void del(int id){
        SQLiteDatabase db=this.getWritableDatabase();

        db.delete(TABLE_NAME,"  ID = "+id ,null);

    }



}
*/