package com.ct.compoundviewsample.view

import android.content.Context
import android.support.annotation.Nullable
import android.support.v7.widget.AppCompatEditText
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.ct.compoundviewsample.R


class OtpView(
    context: Context,
    @Nullable attrs: AttributeSet
) : LinearLayout(context, attrs),
    View.OnKeyListener {

    var edt1: AppCompatEditText? = null
    var edt2: AppCompatEditText? = null
    var edt3: AppCompatEditText? = null
    var edt4: AppCompatEditText? = null
    var edt5: AppCompatEditText? = null
    var edt6: AppCompatEditText? = null


    override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_DEL) {
            when (v!!.id) {
                R.id.edt1 -> {
                    edt1!!.setText("")
                    edt1!!.requestFocus()
                }
                R.id.edt2 -> {
                    edt2!!.setText("")
                    edt1!!.requestFocus()
                }
                R.id.edt3 -> {
                    edt3!!.setText("")
                    edt2!!.requestFocus()
                }
                R.id.edt4 -> {
                    edt4!!.setText("")
                    edt3!!.requestFocus()
                }
                R.id.edt5 -> {
                    edt5!!.setText("")
                    edt4!!.requestFocus()
                }
                R.id.edt6 -> {
                    edt6!!.setText("")
                    edt5!!.requestFocus()
                }
            }
        }
        return false
    }


    init {
        orientation = LinearLayout.HORIZONTAL
        LayoutInflater.from(context).inflate(R.layout.layout_compound, this, true)
        val title: String?
        val subtitle: String?
        val a = context.theme.obtainStyledAttributes(attrs, R.styleable.CustomCompoundView, 0, 0)
        try {
            title = a.getString(R.styleable.CustomCompoundView_customViewTitle)
            subtitle = a.getString(R.styleable.CustomCompoundView_customViewSubtitle)
        } finally {
            a.recycle()
        }
        if (title == null) {
            throw RuntimeException("No title provided")
        }
        if (subtitle == null) {
            throw RuntimeException("No subtitle provided")
        }
        init()
    }


    // Setup views
    private fun init() {
        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        edt3 = findViewById(R.id.edt3)
        edt4 = findViewById(R.id.edt4)
        edt5 = findViewById(R.id.edt5)
        edt6 = findViewById(R.id.edt6)
        edt1!!.requestFocus()

        edt1!!.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                edt2!!.requestFocus()

            }

        })

        edt2!!.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                edt3!!.requestFocus()

            }

        })

        edt3!!.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                edt4!!.requestFocus()
            }

        })

        edt4!!.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                edt5!!.requestFocus()
            }

        })

        edt5!!.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                edt6!!.requestFocus()  }

        })

        edt6!!.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                edt6!!.requestFocus()
            }

        })

        edt1!!.setOnKeyListener(this)
        edt2!!.setOnKeyListener(this)
        edt3!!.setOnKeyListener(this)
        edt4!!.setOnKeyListener(this)
        edt5!!.setOnKeyListener(this)
        edt6!!.setOnKeyListener(this)

    }

}