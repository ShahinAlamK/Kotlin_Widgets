package com.example.kotlinwidgets

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var dialogButton:  Button
    private lateinit var snackBarButton:  Button
    private lateinit var toastButton:  Button
    private lateinit var datePickerButton:  Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dialogButton = findViewById(R.id.dialogID)
        snackBarButton = findViewById(R.id.snackBarID)
        toastButton = findViewById(R.id.toastID)
        datePickerButton = findViewById(R.id.dateID)

        dialogButton.setOnClickListener {
          showDialogBox("Yes, Application exit")
        }

        snackBarButton.setOnClickListener { showSnackBar(it,"Hello Kotlin Programmer") }

        toastButton.setOnClickListener {showToast(this,"Hello Kotlin Programmer")}

        datePickerButton.setOnClickListener {

        }

    }

    private fun showToast(context:Context, msg: String){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show()
    }

    private fun showSnackBar(view: View, msg: String){
        Snackbar.make(view,msg,Snackbar.LENGTH_SHORT)
            .setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_FADE)
            .show()
    }

    private fun showDialogBox(msg: String) {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Are you sure")
        dialog.setMessage(msg)
        dialog.setPositiveButton("Yes"){_,_ -> dialog.create().setCancelable(false)}
        dialog.setNegativeButton("Cancel"){_,_ ->dialog.create().setCancelable(true)}
        dialog.show()
    }
}