package com.example.addfragmentstotasklist.view
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.addfragmentstotasklist.R
import com.example.addfragmentstotasklist.model.UserData


class TaskAdapter(val contxt: Context, val taskList: ArrayList<UserData>) :
    RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
//Review Context passed as parameter of TaskAdapter

    inner class TaskViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val userInput = view.findViewById<TextView>(R.id.taskName)
        val description = view.findViewById<TextView>(R.id.taskTxt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item, parent, false)
        return TaskViewHolder(view)
        //Review inflater
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val tempList = taskList[position]
        holder.userInput.text = tempList.userTask
        holder.description.text = tempList.userDescription
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

}
