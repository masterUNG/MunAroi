package npru.sangarun.kamonchat.mumaroi;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by USER on 12/11/2558.
 */
public class ManageTABLE {

    //Explicit
    private MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

    public static final String DATABASE_TABLE = "restaurantTABLE";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TYPE = "Type";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_IMAGE = "Image";
    public static final String COLUMN_DETAIL = "Detail";
    public static final String COLUMN_POTENTIAL = "Potential";
    public static final String COLUMN_LAT = "Lat";
    public static final String COLUMN_LNG = "Lng";
    public static final String COLUMN_REMARK = "Remark";


    public ManageTABLE(Context context) {

        //Create & Connected Database
        objMyOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = objMyOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMyOpenHelper.getReadableDatabase();

    }   // Constructor

    //Read All Data
    public String[] readAllData(int intColumn) {

        String[] strResult = null;
        Cursor objCursor = readSqLiteDatabase.query(DATABASE_TABLE,
                new String[]{COLUMN_ID, COLUMN_TYPE, COLUMN_NAME, COLUMN_IMAGE, COLUMN_DETAIL, COLUMN_POTENTIAL, COLUMN_LAT, COLUMN_LNG, COLUMN_REMARK},
                null, null, null, null, null);
        if (objCursor != null) {

            objCursor.moveToFirst();
            strResult = new String[objCursor.getCount()];

            for (int i = 0; i < objCursor.getCount(); i++) {

                switch (intColumn) {
                    case 1:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_TYPE));
                        break;
                    case 2:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_NAME));
                        break;
                    case 3:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_IMAGE));
                        break;
                    case 4:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_DETAIL));
                        break;
                    case 5:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_POTENTIAL));
                        break;
                    case 6:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_LAT));
                        break;
                    case 7:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_LNG));
                        break;
                    case 8:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_REMARK));
                        break;
                }   // switch

                objCursor.moveToNext();

            }   // for

        }   // if

        objCursor.close();

        return strResult;
    }

}   // Main Class