package com.icanerdogan.recyclerviewfundamentals.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.icanerdogan.recyclerviewfundamentals.databinding.ListItemBinding
import com.icanerdogan.recyclerviewfundamentals.model.Fruit

class MyRecyclerViewAdapter(private val fruitList: List<Fruit>, private val clickListener : (Fruit) -> Unit) : RecyclerView.Adapter<MyRecyclerViewAdapter.RowHolder>() {

    class RowHolder(val listItemBinding : ListItemBinding) : RecyclerView.ViewHolder(listItemBinding.root){
        fun bind(fruit: Fruit, clickListener : (Fruit) -> Unit){
            listItemBinding.textViewListItem.text = fruit.fruitName
            listItemBinding.textViewListItem.setOnClickListener {
                clickListener(fruit)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRecyclerViewAdapter.RowHolder {
        return RowHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyRecyclerViewAdapter.RowHolder, position: Int) {
        //val fruit = fruitList.get(position)
        //holder.listItemBinding.textViewListItem.text = fruit.fruitName

        // ROW HOLDER İÇİNDEKİ BIND FONKSİYONU
        holder.bind(fruitList[position], clickListener)
    }

    override fun getItemCount(): Int {
        return fruitList.size
    }
}
