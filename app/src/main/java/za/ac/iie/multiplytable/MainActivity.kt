 package za.ac.iie.multiplytable

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Created variables to hold UI elements
        val multiplyBtn = findViewById<Button>(R.id.multiplyBtn)
        val numInput = findViewById<EditText>(R.id.numTxtInput)

        //created a button click listener to listener to listen for the button click
        multiplyBtn.setOnClickListener{
            //create the explicit intent to switch between pages
            //switching from main page to table display page
            val intent = Intent(this, TableDisplay::class.java) //second Intent built in function must be Cap I
          intent.putExtra("tableNumber",numInput.text.toString())
            //Start the activity
            startActivity(intent)

        }





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}