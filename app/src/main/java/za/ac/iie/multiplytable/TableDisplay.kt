package za.ac.iie.multiplytable

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TableDisplay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_table_display)

        //assigning data from main page to variables
        val bundle: Bundle? = intent.extras

        // getting the number entered by the user as a string
        val tableString: String? = bundle?.getString("tableNumber")

        //converting the string back into a number ready for multiplcation
        val tableNumber = tableString!!.toInt() //changed from ? to !!
        val multiplyTable = findViewById<TextView>(R.id.tableDisplayTxt)
        var timesDisplay: String = "$tableNumber x tables\n\n"

        //creating counter for while loop
        var count = 1

        //Displaying the number the user entered on the second page next to the text "x tables"
        multiplyTable.text = timesDisplay

        while (count <= 10) {

            //adding a continue
            if (count == 4){
                count++
                continue
                //Adding a break
                //break 
            }

            //example user enters 5 and count is 1 then display 5x1
            val answer = tableNumber * count
            /*displays as
             5 x tables

             5x1=5
             */
            timesDisplay += "$tableNumber x $count = ${answer}\n" //we use += because we adding on if we use = then it doesnt add on
         //increasing count
            count++
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}