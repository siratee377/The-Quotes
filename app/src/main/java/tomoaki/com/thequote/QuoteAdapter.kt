package tomoaki.com.thequote

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class QuoteAdapter(val context : Context, val quotes:List<String>, val onItemLongClick : (String) -> Unit) : RecyclerView.Adapter<QuoteAdapter.MyViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.quote_item, parent,false)
        val myViewHolder = MyViewHolder(view, onItemLongClick)
        return  myViewHolder
    }

    override fun getItemCount(): Int {
        return quotes.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder!!.bindQuote(quotes[position])
    }

    inner class MyViewHolder(itemView : View, onItemLongClick : (String) -> Unit) : RecyclerView.ViewHolder(itemView)
    {
        val quoteTextView = itemView.findViewById<TextView>(R.id.textViewQuote)

        fun bindQuote(quote : String)
        {
            quoteTextView.text = quote
            itemView.setOnLongClickListener {
                onItemLongClick(quote)
                true
            }
        }

    }
}