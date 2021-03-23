package me.ivaangb.aboutme_codelab

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import me.ivaangb.aboutme_codelab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var doneButton: Button
    lateinit var nicknameTextView: TextView
    lateinit var nicknameEditText: EditText
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        doneButton = findViewById(R.id.done_button)
        nicknameTextView = findViewById(R.id.nickname_tv)
        nicknameEditText = findViewById(R.id.nickname_et)
        doneButton.setOnClickListener { addNickname(it, nicknameTextView, nicknameEditText) }

        nicknameTextView.setOnClickListener { updateNickname(it, doneButton, nicknameEditText) }

    }

    private fun addNickname(view: View, textView: TextView, editText: EditText) {
        val snackbar = Snackbar.make(view, getString(R.string.nickname_snackbar_error), Snackbar.LENGTH_SHORT)


        if (!editText.text.isNullOrEmpty()) {
            textView.text = editText.text
            editText.visibility = View.GONE
            view.visibility = View.GONE
            textView.visibility = View.VISIBLE
        }
        else {
            snackbar.show()
        }

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname (view: View, button: Button, editText: EditText) {
        editText.visibility = View.VISIBLE
        button.visibility = View.VISIBLE
        view.visibility = View.GONE

        editText.requestFocus()
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(editText, 0)

    }


}
