package tomoaki.com.thequote

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_quote_detail.*

class QuoteDetailActivity : AppCompatActivity() {

    var codeCategoryId = 0
    var db : SQLiteDatabase? = null
    var cursor : Cursor? = null

    var quoteAdapter : QuoteAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quote_detail)

        codeCategoryId = intent.extras.getInt(MainActivity.INTENT_KEY)

        //Read data from database
        val theQuoteHelper = TheQuoteSQLiteOpenHelper(this)
        db = theQuoteHelper.readableDatabase
        cursor = db!!.query(TheQuoteSQLiteOpenHelper.TABLE_QUOTE_NAME, arrayOf(TheQuoteSQLiteOpenHelper.KEY_QUOTE_TEXT),
            TheQuoteSQLiteOpenHelper.KEY_QUOTE_ID+"=?",
            arrayOf(codeCategoryId.toString()),null,null,null)

        var listOfQuote = mutableListOf<String>()
        while (cursor!!.moveToNext())
        {
            listOfQuote.add(cursor!!.getString(0))
        }

        //Create adapter object
        quoteAdapter = QuoteAdapter(this,listOfQuote){quote ->
            var shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.putExtra(Intent.EXTRA_TEXT,quote)
            shareIntent.type = "text/plain"
            startActivity(shareIntent)

        }
        //Use layout manager
        val layOutManager = LinearLayoutManager(this)

        //Connect layoutManager and  adapter to recyclerView
        recyclerView_quote.layoutManager = layOutManager
        recyclerView_quote.adapter = quoteAdapter

    }

    override fun onDestroy() {
        super.onDestroy()

        db!!.close()
        cursor!!.close()
    }
}
