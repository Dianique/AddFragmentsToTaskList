package com.example.addfragmentstotasklist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.addfragmentstotasklist.model.UserData
import com.example.addfragmentstotasklist.view.TaskAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {

    private lateinit var addButton: FloatingActionButton
    private lateinit var recycler: RecyclerView
    private lateinit var taskList: ArrayList<UserData>
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addButton = findViewById(R.id.addingBtn)
        recycler = findViewById(R.id.recycler_view)
        taskList = ArrayList()
        taskAdapter = TaskAdapter(this, taskList)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = taskAdapter
        addButton.setOnClickListener { add() }
    }

    private fun add() { //Use a function to keep from rewriting code.
        val inflater = LayoutInflater.from(this)
        val view = inflater.inflate(R.layout.add_item, null)
        val addTask = view.findViewById<EditText>(R.id.editTask)
        val addTaskDescription = view.findViewById<EditText>(R.id.editTaskDescription)

        val messageBox = AlertDialog.Builder(this)
        messageBox.setView(view)
        messageBox.setPositiveButton("Ok") { dialog, _ ->
            val taskChanger = addTask.text.toString()
            val descriptionChanger = addTaskDescription.text.toString()
            taskList.add(UserData(taskChanger, descriptionChanger))
            taskAdapter.notifyDataSetChanged()
            dialog.dismiss()
        }
        messageBox.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }
        messageBox.create()
        messageBox.show()
    }
}







