package com.ctlb.schoolbustracking

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ViewBusActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewbuses)

        val listView = findViewById<ListView>(R.id.Viewbuses_listview)
        listView.adapter = MyCustomAdapter(this) // this needs to be my custom adapter telling my list what to render
    }
    private class MyCustomAdapter(context:Context): BaseAdapter() {
        private val busnumber = arrayListOf<String>(
                // here we will take the buses from the database
                "UP80 AH 8776", "UP80 PO 9872" ,"UP80 BH 9907" , "UP80 KM 6235" ,"UP80 AB 1223"
        )
        private  val drivername = arrayListOf<String>(
                "Rajesh", "Hrishikesh" ,"Vishal", "Charan(The GOD)" , "Aviral"
        )


        private val mContext: Context

        init {
            mContext = context
        }

        // responsible for how many rows in my list
        override fun getCount(): Int {
            // here we will take size of busnumber variable which we take from database
            return busnumber.size
        }
        //ignore
        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        //ignore
        override fun getItem(position: Int): Any {

            return "Test String"
        }

        // responsile for rendering out each row
        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(mContext)
            val row_viewbuses = layoutInflater.inflate(R.layout.row_viewbuses, viewGroup,false)

            //here we providing the numbers to the BusNumber{which is in the layout} from the database
            val bus_number_textview = row_viewbuses.findViewById<TextView>(R.id.bus_number)
            bus_number_textview.text = busnumber.get(position)
            // here we are providing the nams to the DriverName{which is in the layout} from the database
            val driver_name_textview = row_viewbuses.findViewById<TextView>(R.id.driver_name)
            driver_name_textview.text = drivername.get(position)



            return row_viewbuses

        }

    }

}