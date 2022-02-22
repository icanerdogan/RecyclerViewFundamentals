package com.icanerdogan.recyclerviewfundamentals

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.icanerdogan.recyclerviewfundamentals.adapter.MyRecyclerViewAdapter
import com.icanerdogan.recyclerviewfundamentals.databinding.ActivityMainBinding
import com.icanerdogan.recyclerviewfundamentals.model.Fruit

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    val fruitList = listOf(
        Fruit("Mango", "İbrahim"),
        Fruit("Apple", "Atilla"),
        Fruit("Elma", "Can"),
        Fruit("Armut", "Erdoğan"),
        Fruit("Çilek", "Ali"),
        Fruit("Kiraz", "Ayşegül"),
        Fruit("Karpuz", "Leyla"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.myRecyclerView.setBackgroundColor(Color.YELLOW)
        binding.myRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.myRecyclerView.adapter = MyRecyclerViewAdapter(fruitList, {selectedFruitItem : Fruit -> listItemClicked(selectedFruitItem)})
    }

    private fun listItemClicked(fruit: Fruit){
        Toast.makeText(this, "Supplier Name is ${fruit.supplier}", Toast.LENGTH_LONG).show()
    }
}