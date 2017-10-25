package rafael.barbosa.mvpkotlin.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import rafael.barbosa.mvpkotlin.R
import rafael.barbosa.mvpkotlin.model.Book
import kotlinx.android.synthetic.main.item_book.*
import kotlinx.android.synthetic.main.item_book.view.*

/**
 * Created by dev on 25/10/17.
 */
class BooksAdapter (var mlista: List<Book>,
                    val context: Context) : RecyclerView.Adapter<BooksAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {

        var view = LayoutInflater.from(parent?.context).inflate(R.layout.item_book, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {

        val book = mlista.get(position)

        holder?.itemView?.tv_titulo?.text = book.nome
        holder?.itemView?.tv_data?.text = book.data
        holder?.itemView?.tv_desc?.text = book.descricao

        Picasso
                .with(context)
                .load(book.img)
                .resize(100, 100)
                .centerInside()
                .into(holder?.itemView?.img_book)

    }

    fun replaceData(books:List<Book>){

        mlista = books
        notifyDataSetChanged()

    }

    override fun getItemCount(): Int {
        return mlista.size
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)

}