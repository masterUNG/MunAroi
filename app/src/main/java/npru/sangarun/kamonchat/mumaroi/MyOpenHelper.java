package npru.sangarun.kamonchat.mumaroi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by USER on 12/11/2558.
 */
public class MyOpenHelper extends SQLiteOpenHelper {


    //Explicit
    private static final String DATABASE_NAME = "aroi.db";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_RESTAURANT_TABLE = "create table restaurantTABLE (" +
            "_id integer primary key, " +
            "Type text, " +
            "Name text, " +
            "Image integer, " +
            "Detail text, " +
            "Potential text, " +
            "Lat double, " +
            "Lng double, " +
            "Remark text);";


    public MyOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    } // Constructor

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_RESTAURANT_TABLE);

        String[] strCreate = new String[21];
        strCreate[0] = "insert into restaurantTABLE VALUES (null,'ชาบู-สุกี้/ปิ้งย่าง', 'Shabu Indy1', 0, 'Detail1', 'Potenial1', 13.80511, 100.0906 , 'Remark1' );";
        strCreate[1] = "insert into restaurantTABLE VALUES (null,'ข้าวต้ม/โจ๊ก', 'ข้าวต้มอ้วน1', 1, 'Detail1', 'Potenial1', 13.81635, 100.0508, 'Remark1' );";
        strCreate[2] = "insert into restaurantTABLE VALUES (null,'สเต็ก', 'สเต็กลุง1', 2, 'Detail1', 'Potenial1', 13.819525, 100.052181, 'Remark1' );";
        strCreate[3] = "insert into restaurantTABLE VALUES (null,'ก๋วยเตี๋ยว', ' ก๋วยเตี๋ยวต้มยำโบราณ ร้านเปลว1', 3, 'Detail1', 'Potenial1', 13.84055, 100.04308, 'Remark1' );";
        strCreate[4] = "insert into restaurantTABLE VALUES (null,'ส้มตำ', 'ลาบยโย1', 4, 'Detail1', 'Potenial1', 13.8196, 100.05339, 'Remark1' )";
        strCreate[5] = "insert into restaurantTABLE VALUES (null,'เครื่องดื่ม/เบเกอรี่', 'Way Coffee1', 5, 'Detail1', 'Potenial1', 13.81305, 100.04568, 'Remark1' );";
        strCreate[6] = "insert into restaurantTABLE VALUES (null,'ซีฟู้ด', '888ซีฟู๊ต บุฟเฟ่ต์1', 6, 'Detail1', 'Potenial1', 13.81268, 100.06603, 'Remark1' )";
        strCreate[7] = "insert into restaurantTABLE VALUES (null,'ชาบู-สุกี้/ปิ้งย่าง', 'Shabu Indy2', 7, 'Detail1', 'Potenial1', 13.80511, 100.0906 , 'Remark1' );";
        strCreate[8] = "insert into restaurantTABLE VALUES (null,'ข้าวต้ม/โจ๊ก', 'ข้าวต้มอ้วน2', 8, 'Detail1', 'Potenial1', 13.81635, 100.0508, 'Remark1' );";
        strCreate[9] = "insert into restaurantTABLE VALUES (null,'สเต็ก', 'สเต็กลุง2', 9, 'Detail1', 'Potenial1', 13.819525, 100.052181, 'Remark1' );";
        strCreate[10] = "insert into restaurantTABLE VALUES (null,'ก๋วยเตี๋ยว', ' ก๋วยเตี๋ยวต้มยำโบราณ ร้านเปลว2', 10, 'Detail1', 'Potenial1', 13.84055, 100.04308, 'Remark1' );";
        strCreate[11] = "insert into restaurantTABLE VALUES (null,'ส้มตำ', 'ลาบยโย2', 11, 'Detail1', 'Potenial1', 13.8196, 100.05339, 'Remark1' )";
        strCreate[12] = "insert into restaurantTABLE VALUES (null,'เครื่องดื่ม/เบเกอรี่', 'Way Coffee2', 12, 'Detail1', 'Potenial1', 13.81305, 100.04568, 'Remark1' );";
        strCreate[13] = "insert into restaurantTABLE VALUES (null,'ซีฟู้ด', '888ซีฟู๊ต บุฟเฟ่ต์2', 13, 'Detail1', 'Potenial1', 13.81268, 100.06603, 'Remark1' )";
        strCreate[14] = "insert into restaurantTABLE VALUES (null,'ชาบู-สุกี้/ปิ้งย่าง', 'Shabu Indy3', 14, 'Detail1', 'Potenial1', 13.80511, 100.0906 , 'Remark1' );";
        strCreate[15] = "insert into restaurantTABLE VALUES (null,'ข้าวต้ม/โจ๊ก', 'ข้าวต้มอ้วน3', 15, 'Detail1', 'Potenial1', 13.81635, 100.0508, 'Remark1' );";
        strCreate[16] = "insert into restaurantTABLE VALUES (null,'สเต็ก', 'สเต็กลุง3', 16, 'Detail1', 'Potenial1', 13.819525, 100.052181, 'Remark1' );";
        strCreate[17] = "insert into restaurantTABLE VALUES (null,'ก๋วยเตี๋ยว', ' ก๋วยเตี๋ยวต้มยำโบราณ ร้านเปลว3', 17, 'Detail1', 'Potenial1', 13.84055, 100.04308, 'Remark1' );";
        strCreate[18] = "insert into restaurantTABLE VALUES (null,'ส้มตำ', 'ลาบยโย3', 18, 'Detail1', 'Potenial1', 13.8196, 100.05339, 'Remark1' )";
        strCreate[19] = "insert into restaurantTABLE VALUES (null,'เครื่องดื่ม/เบเกอรี่', 'Way Coffee3', 19, 'Detail1', 'Potenial1', 13.81305, 100.04568, 'Remark1' );";
        strCreate[20] = "insert into restaurantTABLE VALUES (null,'ซีฟู้ด', '888ซีฟู๊ต บุฟเฟ่ต์3 ', 20, 'Detail1', 'Potenial1', 13.81268, 100.06603, 'Remark1' )";


        int intTimes = 0;
        while (intTimes < strCreate. length) {


            try {
                db.execSQL(strCreate[intTimes]);
            }catch (Exception  e){

            }
            intTimes += 1;
        }

    }// onCreate

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
} // Main Class
