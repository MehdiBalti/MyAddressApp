package balti.myaddressapp.LocalDb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import balti.myaddressapp.MOdel.Contacts;


/**
 * Created by BALTI on 3/9/2017.
 */

public class TableControllerContact extends MyDataBase {



    public TableControllerContact(Context context) {
        super(context);
    }

    public boolean syndata(Contacts objectStudent){


        boolean updateSuccessful = update(objectStudent);

        if(updateSuccessful){
            return true;
        }else{




            boolean createSuccessful = create(objectStudent);


            if(createSuccessful){
                return true;
            }else{
                return false;

            }
        }





    }


    public boolean create(Contacts objectStudent) {

        ContentValues values = new ContentValues();

        values.put("id", objectStudent.getId());
        values.put("Name", objectStudent.getName());
        values.put("Email", objectStudent.getEmail());
        values.put("PhoneNo", objectStudent.getPhoneNo());
        values.put("Type",objectStudent.getType());

        SQLiteDatabase db = this.getWritableDatabase();

        boolean createSuccessful = db.insert("ContectTable", null, values) > 0;
        db.close();

        return createSuccessful;
    }





    public boolean update(Contacts objectStudent) {

        ContentValues values = new ContentValues();
values.put("id",objectStudent.getId());
        values.put("Name", objectStudent.getName());
        values.put("Email", objectStudent.getEmail());
        values.put("PhoneNo", objectStudent.getPhoneNo());


        String where = "id = ?";

        String[] whereArgs = { Integer.toString(objectStudent.getId()) };

        SQLiteDatabase db = this.getWritableDatabase();

        boolean updateSuccessful = db.update("ContectTable", values, where, whereArgs) > 0;
        db.close();

        return updateSuccessful;

    }


    public boolean updatetype(Contacts objectStudent) {

        ContentValues values = new ContentValues();
        values.put("id",objectStudent.getId());
        values.put("Name", objectStudent.getName());
        values.put("Email", objectStudent.getEmail());
        values.put("PhoneNo", objectStudent.getPhoneNo());
values.put("Type",objectStudent.getType());

        String where = "id = ?";

        String[] whereArgs = { Integer.toString(objectStudent.getId()) };

        SQLiteDatabase db = this.getWritableDatabase();

        boolean updateSuccessful = db.update("ContectTable", values, where, whereArgs) > 0;
        db.close();

        return updateSuccessful;

    }


    public  ArrayList<Contacts> getAllContacts(String type) {
        ArrayList<Contacts> contactList = new ArrayList<Contacts>();
        // Select All Query
        String selectQuery = "SELECT  * FROM ContectTable Where Type = "+type;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Contacts contact = new Contacts();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPhoneNo(cursor.getString(2));
                contact.setEmail(cursor.getString(3));
                contact.setType(cursor.getString(4));

                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }





}
