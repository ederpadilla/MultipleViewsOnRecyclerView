package dev.eder.padilla.multiplerecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.LinearLayout

import java.util.ArrayList

class MainActivity : AppCompatActivity() , OnItemSelected{

    internal lateinit var recyclerView: RecyclerView

    internal var models: MutableList<Model> = ArrayList()

    internal lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        myAdapter = MyAdapter(models,this)
        recyclerView.adapter = myAdapter
        addDoomies()
    }

    private fun addDoomies() {
        models.add(Model("Hola Mundo", 1))
        models.add(Model("Hola Mundo 2", 2))
        models.add(Model("Hola Mundo 3", 1))
        models.add(Model("Hola Mundo 4", 2))
        models.add(Model("Hola Mundo 5", 1))
        models.add(Model("Hola Mundo 6", 2))
        models.add(Model("Hola Mundo 7", 1))
        models.add(Model("Hola Mundo 8", 2))
        models.add(Model("Hola Mundo 9", 1))
        models.add(Model("Hola Mundo 10", 2))
        models.add(Model("Hola Mundo 11", 1))
        models.add(Model("Hola Mundo 12", 2))
        models.add(Model("Hola Mundo 13", 1))
        models.add(Model("Hola Mundo 14", 2))
        models.add(Model("Hola Mundo 15", 1))
        models.add(Model("Hola Mundo 16", 2))
        models.add(Model("Hola Mundo 17", 1))
        models.add(Model("Hola Mundo 18", 2))
        myAdapter.notifyDataSetChanged()
    }

    override fun itemSelected(model: Model) {
        Log.e(MainActivity::class.java.simpleName,"Model es ${model.toString()}")
    }
}
