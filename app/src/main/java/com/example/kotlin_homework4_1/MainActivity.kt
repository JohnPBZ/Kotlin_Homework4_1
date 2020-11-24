package com.example.kotlin_homework4_1


import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.ListView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private val items1 = ArrayList<Item>()
    private val items2 = ArrayList<Item>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var imgArray = resources.obtainTypedArray(R.array.tran_imgArray)
        var nameArray = resources.getStringArray(R.array.tran_nameArray)
        for(i in 0 until imgArray.length())
            items1.add(Item(imgArray.getResourceId(i,0), nameArray[i]))
        imgArray.recycle()
        val spinner = findViewById<Spinner>(R.id.spinner)
        spinner.adapter=MyAdapter2(R.layout.trans_list,items1)

        imgArray = resources.obtainTypedArray(R.array.cube_imgArray)
        nameArray = resources.getStringArray(R.array.cube_nameArray)
        for(i in 0 until imgArray.length())
            items2.add(Item(imgArray.getResourceId(i,0), nameArray[i]))
        imgArray.recycle()
        val gridView = findViewById<GridView>(R.id.gridView)
        gridView.adapter=MyAdapter2(R.layout.cubee_list,items2)
        gridView.numColumns = 3
        val listView = findViewById<ListView>(R.id.listView)
        listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,
            arrayListOf("訊息1","訊息2","訊息3","訊息4","訊息5","訊息6"))
    }
}

data class Item(
        val photo: Int,     //圖片Resource
        val name: String    //名稱
)