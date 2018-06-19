package dev.eder.padilla.multiplerecyclerview

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import dev.eder.padilla.multiplerecyclerview.Model.Companion.TYPE_ONE
import dev.eder.padilla.multiplerecyclerview.Model.Companion.TYPE_TWO


class MyAdapter(internal var models: List<Model>,internal var onItemSelected: OnItemSelected) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        val model = models[position]
        return model.type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view: View? = null
        when (viewType) {
            TYPE_ONE -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.item_one, parent, false)
                return ViewHolderOne(view)
            }
            TYPE_TWO -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.item_two, parent, false)
                return ViewHolderTwo(view)
            }
        }
        return ViewHolderOne(view!!)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = models[position]
        when (model.type) {
            TYPE_ONE -> {
                (holder as ViewHolderOne).bindModel(model)
                (holder as ViewHolderOne).imageViewOne.setOnClickListener { view -> onItemSelected.itemSelected(model) }
            }
            TYPE_TWO -> {
                (holder as ViewHolderTwo).bindModel(model)
                (holder as ViewHolderTwo).imageViewTwo.setOnClickListener { view -> onItemSelected.itemSelected(model) }
            }
        }
    }

    override fun getItemCount(): Int {
        return models.size
    }

    internal inner class ViewHolderOne(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleOne: TextView
        var imageViewOne : ImageView
        init {
            titleOne = itemView.findViewById(R.id.textViewOne)
            imageViewOne = itemView.findViewById(R.id.imageViewOne)
        }

        fun bindModel(model: Model) {
            titleOne.text = model.title
            /*imageViewOne.setOnClickListener {
                Log.e(MyAdapter::class.java.simpleName,"Click imagen una")
            }*/
        }
    }

    inner class ViewHolderTwo(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var titleTwo: TextView
        internal var imageViewTwo : ImageView
        init {
            titleTwo = itemView.findViewById(R.id.textViewTwo)
            imageViewTwo = itemView.findViewById(R.id.imageViewTwo)
        }

        fun bindModel(model: Model) {
            titleTwo.text = model.title
            /*imageViewTwo.setOnClickListener {
                Log.e(MyAdapter::class.java.simpleName,"Click imagen dos")
            }*/
        }
    }
}
