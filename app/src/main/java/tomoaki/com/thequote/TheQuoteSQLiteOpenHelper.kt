package tomoaki.com.thequote

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class TheQuoteSQLiteOpenHelper(context:Context) :SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {

        private const val DATABASE_NAME = "QuoteDatabase"
        private const val TABLE_CATE_NAME = "QuotesCategory"
        private const val KEY_CATE_NAME = "category"
        private const val KEY_CATE_ID = "_id"
        private const val KEY_CATE_IMAGE = "image_resource_id"
        private const val DATABASE_VERSION = 1

    }

    override fun onCreate(db: SQLiteDatabase?) {

        val createTable = "CREATE TABLE $TABLE_CATE_NAME" +
                "$KEY_CATE_ID INTEGER PRIMARY KEY, $KEY_CATE_IMAGE TEXT, $KEY_CATE_NAME TEXT"
        db?.execSQL(createTable)

        insertCategoryTable( db, 1, R.drawable.love, "Love")
        insertCategoryTable( db, 2, R.drawable.sad, "Sad")
        insertCategoryTable( db, 3, R.drawable.romantic, "Romantic")
        insertCategoryTable( db, 4, R.drawable.childhood, "Childhood")
        insertCategoryTable( db, 5, R.drawable.success, "Success")
        insertCategoryTable( db, 6, R.drawable.marriage, "Marriage")
        insertCategoryTable( db, 7, R.drawable.alone, "Alone")
        insertCategoryTable( db, 8, R.drawable.birthday, "Birthday")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    private fun insertCategoryTable(db: SQLiteDatabase?, id:Int, image_id:Int, category_name :String) {
        val contentValue = ContentValues()
        contentValue.put(KEY_CATE_ID,id)
        contentValue.put(KEY_CATE_IMAGE,image_id)
        contentValue.put(KEY_CATE_NAME,category_name)

        db!!.insert(TABLE_CATE_NAME,null,contentValue)
    }



}