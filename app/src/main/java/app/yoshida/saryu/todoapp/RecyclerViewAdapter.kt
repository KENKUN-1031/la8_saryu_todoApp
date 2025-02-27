package app.yoshida.saryu.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import app.yoshida.saryu.todoapp.databinding.ItemTodoDataCellBinding

class RecyclerViewAdapter: ListAdapter<TodoData, TodoDataViewHolder> (diffCallback) {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoDataViewHolder {
                val view = ItemTodoDataCellBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return TodoDataViewHolder(view)
        }

        override fun onBindViewHolder(holder: TodoDataViewHolder, position: Int) {
                val item = getItem(position)
                holder.binding.taskTextView.text = item.task
        }

        companion object {
                private val diffCallback = object : DiffUtil.ItemCallback<TodoData>() {
                        override fun areItemsTheSame(oldItem: TodoData, newItem: TodoData) =
                                oldItem.id == newItem.id

                        override fun areCOntentsTheSame(oldItem: TodoData, newItem: TodoData) =
                                oldItem == newItem
                }
        }
}

class TodoDataViewHolder(val binding: ItemTodoDataCellBinding) :
        RecyclerView.ViewHolder(binding.root)