package com.example.super_news_nks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.super_news_nks.databinding.BigTablItemBinding

class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {
    val NewsList= ArrayList<tabl>()           //то от куда считывает
    class ViewHolder(item: View): RecyclerView.ViewHolder(item) {    //хранит ссылки на элементы
        val binding = BigTablItemBinding.bind(item)

        fun bind(tabl: tabl) = with(binding){
            tvTitle.text=tabl.title
            im.setImageResource(tabl.imageId)
            tvDescription.text=tabl.description

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {   // надувает шаблон
        val view = LayoutInflater.from(parent.context).inflate(R.layout.big_tabl_item,parent,false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {          //выдаёт только созданное
        holder.bind(NewsList[position])
    }

    override fun getItemCount(): Int {             // для знания сколько элементов в списке
        return NewsList.size
    }
    //fun addNews(tabl: tabl){     //Добавляет элементы
    //    NewsList.add(tabl)
    //    notifyDataSetChanged()   //проверяет и добовляет 1 элемент
    //}
    fun addAll (List: List<tabl>){ //Весь список сразу добавляется
        NewsList.clear()
        NewsList.addAll(List)
        notifyDataSetChanged()


    }
}