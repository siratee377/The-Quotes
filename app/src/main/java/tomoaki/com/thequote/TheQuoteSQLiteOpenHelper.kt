package tomoaki.com.thequote

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class TheQuoteSQLiteOpenHelper(context:Context) :SQLiteOpenHelper(context, null, null, DATABASE_VERSION) {
    companion object {

        const val DATABASE_NAME = "QuoteDatabase"
        const val DATABASE_VERSION = 1

        const val TABLE_CATE_NAME = "QuotesCategory"
        const val KEY_CATE_NAME = "category"
        const val KEY_CATE_ID = "_id"
        const val KEY_CATE_IMAGE = "image_resource_id"

        const val TABLE_QUOTE_NAME = "QuoteText"
        const val KEY_QUOTE_TEXT = "text"
        const val KEY_QUOTE_ID = "category_id"

    }

    override fun onCreate(db: SQLiteDatabase?) {

        val CREATE_CATEGORY_TABLE : String = "CREATE TABLE $TABLE_CATE_NAME" +
                "($KEY_CATE_ID INTEGER PRIMARY KEY, $KEY_CATE_IMAGE TEXT, $KEY_CATE_NAME TEXT)"

        val CREATE_QUOTE_TABLE : String = " CREATE TABLE $TABLE_QUOTE_NAME"+
                "($KEY_QUOTE_TEXT TEXT, $KEY_QUOTE_ID INTEGER)"


        db?.execSQL(CREATE_CATEGORY_TABLE)
        db?.execSQL(CREATE_QUOTE_TABLE)

        //insert
        insertCategoryTable( db, 1, R.drawable.love, "Love")
        insertCategoryTable( db, 2, R.drawable.sad, "Sad")
        insertCategoryTable( db, 3, R.drawable.romantic, "Romantic")
        insertCategoryTable( db, 4, R.drawable.childhood, "Childhood")
        insertCategoryTable( db, 5, R.drawable.success, "Success")
        insertCategoryTable( db, 6, R.drawable.marriage, "Marriage")
        insertCategoryTable( db, 7, R.drawable.alone, "Alone")
        insertCategoryTable( db, 8, R.drawable.birthday, "Birthday")

        insertQuote(db,"You've gotta dance like there's nobody watching,\n" +
                "Love like you'll never be hurt,\n" +
                "Sing like there's nobody listening,\n" +
                "And live like it's heaven on earth.",1)
        insertQuote(db,"As he read, I fell in love the way you fall asleep: slowly, and then all at once.",1)
        insertQuote(db,"We accept the love we think we deserve.",1)
        insertQuote(db,"I love you without knowing how, or when, or from where. I love you simply, without problems or pride: I love you in this way because I do not know any other way of loving but this, in which there is no I or you, so intimate that your hand upon my chest is my hand, so intimate that when I fall asleep your eyes close.",1)
        insertQuote(db,"It is not a lack of love, but a lack of friendship that makes unhappy marriages.",1)

        insertQuote(db,"Don't cry because it's over, smile because it happened.",2)
        insertQuote(db,"When I despair, I remember that all through history the way of truth and love have always won. There have been tyrants and murderers, and for a time, they can seem invincible, but in the end, they always fall. Think of it--always.",2)
        insertQuote(db,"Every man has his secret sorrows which the world knows not; and often times we call a man cold when he is only sad.",2)
        insertQuote(db,"You cannot protect yourself from sadness without protecting yourself from happiness.",2)
        insertQuote(db,"I didn't want to wake up. I was having a much better time asleep. And that's really sad. It was almost like a reverse nightmare, like when you wake up from a nightmare you're so relieved. I woke up into a nightmare.",2)

        insertQuote(db,"A lady's imagination is very rapid; it jumps from admiration to love, from love to matrimony in a moment.",3)
        insertQuote(db,"I heard what you said. I’m not the silly romantic you think. I don’t want the heavens or the shooting stars. I don’t want gemstones or gold. I have those things already. I want…a steady hand. A kind soul. I want to fall asleep, and wake, knowing my heart is safe. I want to love, and be loved.",3)
        insertQuote(db,"My nightmares are usually about losing you. I'm okay once I realize you're here.",3)
        insertQuote(db,"You pierce my soul. I am half agony, half hope...I have loved none but you.",3)
        insertQuote(db,"I'm not sentimental--I'm as romantic as you are. The idea, you know,\n" +
                "is that the sentimental person thinks things will last--the romantic\n" +
                "person has a desperate confidence that they won't.",3)

        insertQuote(db,"“A childhood without books – that would be no childhood. That would be like being shut out from the enchanted place where you can go and find the rarest kind of joy.",4)
        insertQuote(db,"Adults are just obsolete children and the hell with them.",4)
        insertQuote(db,"ll parents damage their children. It cannot be helped. Youth, like pristine glass, absorbs the prints of its handlers. Some parents smudge, others crack, a few shatter childhoods completely into jagged little pieces, beyond repair.",4)
        insertQuote(db,"From childhood's hour I have not been. As others were, I have not seen. As others saw, I could not awaken. My heart to joy at the same tone. And all I loved, I loved alone.",4)
        insertQuote(db,"Literature is a textually transmitted disease, normally contracted in childhood.",4)

        insertQuote(db,"“Success is not final, failure is not fatal: it is the courage to continue that counts",5)
        insertQuote(db,"I can't give you a sure-fire formula for success, but I can give you a formula for failure: try to please everybody all the time.",5)
        insertQuote(db,"I learned this, at least, by my experiment: that if one advances confidently in the direction of his dreams, and endeavors to live the life which he has imagined, he will meet with a success unexpected in common hours.",5)
        insertQuote(db,"If at first you don't succeed, try, try again. Then quit. No use being a damn fool about it.",5)
        insertQuote(db,"Try not to become a man of success. Rather become a man of value.",5)

        insertQuote(db,"The trouble with some women is that they get all excited about nothing - and then marry him.",6)
        insertQuote(db,"When you find a man you wish to marry, Tessa, remember this: You will know what kind of man he is not by the things he says, but by the things he does.",6)
        insertQuote(db,"I know enough to know that no woman should ever marry a man who hated his mother.",6)
        insertQuote(db,"And she's got brains enough for two, which is the exact quantity the girl who marries you will need.",6)
        insertQuote(db,"I don't want to be married just to be married. I can't think of anything lonelier than spending the rest of my life with someone I can't talk to, or worse, someone I can't be silent with.",6)

        insertQuote(db,"We read to know we're not alone",7)
        insertQuote(db,"I would rather walk with a friend in the dark, than alone in the light.",7)
        insertQuote(db,"Remember: the time you feel lonely is the time you most need to be by yourself. Life's cruelest irony.",7)
        insertQuote(db,"Why do people have to be this lonely? What's the point of it all? Millions of people in this world, all of them yearning, looking to others to satisfy them, yet isolating themselves. Why? Was the earth put here just to nourish human loneliness?",7)
        insertQuote(db,"If you're lonely when you're alone, you're in bad company.",7)

        insertQuote(db,"Today you are You, that is truer than true. There is no one alive who is Youer than You.",8)
        insertQuote(db,"“With mirth and laughter let old wrinkles come.",8)
        insertQuote(db,"Life, a good life, a great life is about \"Why not?\" May we never forget it.",8)
        insertQuote(db,"Let gratitude be the pillow upon which you kneel to say your nightly prayer. And let faith be the bridge you build to overcome evil and welcome good.",8)
        insertQuote(db,"Romance novels are birthday cake and life is often peanut butter and jelly. I think everyone should have lots of delicious romance novels lying around for those times when the peanut butter of life gets stuck to the roof of your mouth.",8)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    private fun insertQuote(db: SQLiteDatabase?, text : String, quoteId : Int) {
        val contentValues = ContentValues()
        contentValues.put(KEY_QUOTE_ID, quoteId)
        contentValues.put(KEY_QUOTE_TEXT,text)

        db!!.insert(TABLE_QUOTE_NAME,null,contentValues)
    }

    private fun insertCategoryTable(db: SQLiteDatabase?, id:Int, image_id:Int, category_name :String) {
        val contentValue = ContentValues()
        contentValue.put(KEY_CATE_ID,id)
        contentValue.put(KEY_CATE_IMAGE,image_id)
        contentValue.put(KEY_CATE_NAME,category_name)

        db!!.insert(TABLE_CATE_NAME,null,contentValue)
    }



}