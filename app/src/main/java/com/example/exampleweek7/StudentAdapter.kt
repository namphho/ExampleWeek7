package com.example.exampleweek7

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.exampleweek7.databinding.StudentItemBinding
import com.example.exampleweek7.db.Student

/**
 * Created by nampham on 5/15/21.
 */

class StudentListAdapter : ListAdapter<Student, StudentListAdapter.WordViewHolder>(StudentComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    class WordViewHolder(private val itemViewBinding: StudentItemBinding) : RecyclerView.ViewHolder(itemViewBinding.root) {


        fun bind(item: Student) {
            itemViewBinding.item = item
        }

        companion object {
            fun create(parent: ViewGroup): WordViewHolder {
                val binding = StudentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return WordViewHolder(binding)
            }
        }
    }

    class StudentComparator : DiffUtil.ItemCallback<Student>() {
        override fun areItemsTheSame(oldItem: Student, newItem: Student): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Student, newItem: Student): Boolean {
            return oldItem.name == newItem.name
        }
    }
}