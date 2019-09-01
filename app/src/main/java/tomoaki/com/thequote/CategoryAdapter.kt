package tomoaki.com.thequote

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(val context : Context, val category : List<Category>) : RecyclerView.Adapter <CategoryAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.category_item,parent,false)
        val myViewHolder = MyViewHolder(view)

        return myViewHolder
    }

    override fun getItemCount(): Int {
        return category.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(category[position],context)
    }


    inner class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        val categoryImage = itemView.findViewById<ImageView>(R.id.imageViewCategoryImage)
        val categoryName = itemView.findViewById<TextView>(R.id.textViewCategoryName)
        fun bindData(category : Category, context: Context)
        {
            categoryImage.setImageResource(category.resourceId)
            categoryName.text = category.name
        }
    }
}