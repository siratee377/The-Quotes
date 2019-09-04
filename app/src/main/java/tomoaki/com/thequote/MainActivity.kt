package tomoaki.com.thequote

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {

        const val INTENT_KEY = "QUOTE_CATEGORY_ID"
    }

    var db : SQLiteDatabase? = null
    var cursor : Cursor? = null
    var categoryAdapter : CategoryAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = TheQuoteSQLiteOpenHelper(this).readableDatabase
        cursor = db!!.query(TheQuoteSQLiteOpenHelper.TABLE_CATE_NAME,
            arrayOf(TheQuoteSQLiteOpenHelper.KEY_CATE_NAME,TheQuoteSQLiteOpenHelper.KEY_CATE_IMAGE,TheQuoteSQLiteOpenHelper.KEY_CATE_ID),
            null,null,null,null,null)

        var listOfCategories = mutableListOf<Category>()

        while (cursor!!.moveToNext()) {

            val categoryId = cursor!!.getInt(2)
            val categoryResourceId = cursor!!.getInt(1)
            val categoryName = cursor!!.getString(0)
            Log.d("TAG","MainActivity while loop : $categoryName")

            val category = Category(categoryId,categoryResourceId,categoryName)
            listOfCategories.add(category)
        }

        categoryAdapter = CategoryAdapter(this,listOfCategories) {categoryId ->
            val intent = Intent(this, QuoteDetailActivity::class.java)
            intent.putExtra(INTENT_KEY, categoryId)
            startActivity(intent)

        }

        recyclerViewQuoteCategories.adapter = categoryAdapter
        recyclerViewQuoteCategories.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
    }

    override fun onDestroy() {
        super.onDestroy()
        db!!.close()
        cursor!!.close()
    }
}
