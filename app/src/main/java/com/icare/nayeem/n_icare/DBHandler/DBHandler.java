package com.icare.nayeem.n_icare.DBHandler;

/**
 * Created by Mobile App Develop on 10-6-15.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.icare.nayeem.n_icare.iCarePersonalProfile;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "db_iCare";
    public static final String TABLE_ICARE = "tb1_iCare";

    private static final String KEY_ID = "id";
    private static final String KEY_PERSONAL_NAME = "iCare_name";
    private static final String KEY_PERSONAL_PHONE = "personal_phone";
    private static final String KEY_PERSONAL_EMAIL = "personal_email";
    private static final String KEY_PERSONAL_ADDRESS = "personal_address";
    private static final String KEY_PERSONAL_Dob = "personal_Dob";

    private static final String KEY_PERSONAL_Photo = "personal_Photo";
    private static final String KEY_PERSONAL_BloodGroup = "personal_BloodGroup";
    private static final String KEY_PERSONAL_Major = "personal_Major";
    private static final String KEY_PERSONAL_PresentHealth = "personal_PresentHealth";
    private static final String KEY_PERSONAL_SugarLabel = "personal_SugarLabel";
    private static final String KEY_PERSONAL_BloodPressure = "personal_BloodPressure";
    private static final String KEY_PERSONAL_Status = "personal_Status";

    SQLiteDatabase sqLiteDatabase;


    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_EMPLOYEE_TABLE = "CREATE TABLE " +
                TABLE_ICARE + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_PERSONAL_NAME
                + " TEXT," + KEY_PERSONAL_PHONE
                + " TEXT," + KEY_PERSONAL_EMAIL
                + " TEXT," + KEY_PERSONAL_ADDRESS
                + " TEXT," + KEY_PERSONAL_Dob
                + " TEXT," + KEY_PERSONAL_Photo
                + " TEXT," + KEY_PERSONAL_BloodGroup
                + " TEXT," + KEY_PERSONAL_Major
                + " TEXT," + KEY_PERSONAL_PresentHealth
                + " TEXT," + KEY_PERSONAL_SugarLabel
                + " TEXT," + KEY_PERSONAL_BloodPressure
                + " TEXT," + KEY_PERSONAL_Status
                + " TEXT" + ")";


        db.execSQL(CREATE_EMPLOYEE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ICARE);
        onCreate(db);

    }

    public void addiCarePersonalProfile(iCarePersonalProfile personalProfile) {

        SQLiteDatabase sqLiteDatabase = super.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_PERSONAL_NAME, personalProfile.getName());
        values.put(KEY_PERSONAL_PHONE, personalProfile.getPhone());
        values.put(KEY_PERSONAL_EMAIL, personalProfile.getEmail());
        values.put(KEY_PERSONAL_ADDRESS, personalProfile.getAddress());

        values.put(KEY_PERSONAL_Dob, personalProfile.getDob());
        values.put(KEY_PERSONAL_Photo, personalProfile.getPhoto());
        values.put(KEY_PERSONAL_BloodGroup, personalProfile.getBloodGroup());
        values.put(KEY_PERSONAL_Major, personalProfile.getMajor());
        values.put(KEY_PERSONAL_PresentHealth, personalProfile.getPresentHealth());
        values.put(KEY_PERSONAL_SugarLabel, personalProfile.getSugarLabel());
        values.put(KEY_PERSONAL_BloodPressure, personalProfile.getBloodPressure());
        values.put(KEY_PERSONAL_Status, personalProfile.getStatus());

        sqLiteDatabase.insert(TABLE_ICARE, null, values);
        sqLiteDatabase.close();

    }

    public List<iCarePersonalProfile> getAllPersonalProfile() {
        List<iCarePersonalProfile> personalProfiles = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_ICARE;
        sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                iCarePersonalProfile personalProfile = new iCarePersonalProfile();

                personalProfile.setName(cursor.getString(1));
                personalProfile.setPhone(cursor.getString(2));
                personalProfile.setEmail(cursor.getString(3));
                personalProfile.setAddress(cursor.getString(4));

                personalProfile.setDob(cursor.getString(5));
                personalProfile.setPhoto(cursor.getString(6));
                personalProfile.setBloodGroup(cursor.getString(7));
                personalProfile.setMajor(cursor.getString(8));
                personalProfile.setPresentHealth(cursor.getString(9));
                personalProfile.setSugarLabel(cursor.getString(10));
                personalProfile.setBloodPressure(cursor.getString(11));
                personalProfile.setStatus(cursor.getString(12));

                personalProfiles.add(personalProfile);

            } while (cursor.moveToNext());

        }
        return personalProfiles;
    }
    /*public void deleteEmployee(){
        sqLiteDatabase = this.getWritableDatabase();
        String selectQuery = "DELETE FROM " + TABLE_EMPLOYEE;
        sqLiteDatabase.execSQL(selectQuery);

        sqLiteDatabase.close();
    }
    public void deleteEmployeeSearch(String id){

        sqLiteDatabase= this.getWritableDatabase();
        String searchDelete= "DELETE FROM " + TABLE_EMPLOYEE + " WHERE"+" "+KEY_ID + "="+ id;

        sqLiteDatabase.execSQL(searchDelete);
        sqLiteDatabase.close();

    }
    public long updateEmployeeInfo(String id, Employee employee) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_EMPLOYEE_NAME,
                employee.getName().toString());
        contentValues.put(KEY_PHONE,
                employee.getPhone().toString());
        contentValues.put(KEY_EMAIL,
                employee.getEmail().toString());
        contentValues.put(KEY_ADDRESS,
                employee.getAddress().toString());


        return db.update(TABLE_EMPLOYEE, contentValues, "id = ? ",
                new String[] { id });
        // return true;
    }*/
}



