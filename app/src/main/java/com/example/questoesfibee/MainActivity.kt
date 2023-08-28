package com.example.questoesfibee

import android.app.AlertDialog
import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var idquestao: Int = 1
    var acertos: Int = 0
    var erros: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }



    fun responder(view: View) {
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)

        val rb1 = findViewById<RadioButton>(R.id.radioButton1)
        val rb2 = findViewById<RadioButton>(R.id.radioButton2)
        val rb3 = findViewById<RadioButton>(R.id.radioButton3)
        val rb4 = findViewById<RadioButton>(R.id.radioButton4)
        val rb5 = findViewById<RadioButton>(R.id.radioButton5)

        if (radioGroup.checkedRadioButtonId === -1) {
            Toast.makeText(this, "Chute ao menos uma ai, pow!!!!", 3000).show()
        } else {
            val btResponder = findViewById<Button>(R.id.responder)
            btResponder.isClickable = false
            btResponder.setBackgroundColor(Color.GRAY)
            val selectedId: Int = radioGroup.checkedRadioButtonId
            val selectedRadioButton = findViewById<RadioButton>(selectedId)

            if(selectedRadioButton.getText().toString() == getString(
                this.resources.getIdentifier("certa$idquestao", "string", this.packageName))){
                Toast.makeText(applicationContext, "Acertou!!!!!", Toast.LENGTH_SHORT).show()
                selectedRadioButton.setTextColor(Color.GREEN)
                acertos += 1
            } else {
                if (rb1.text !== getString(
                        this.resources.getIdentifier("certa$idquestao", "string", this.packageName))) {
                    rb1.setTextColor(Color.LTGRAY)
                    rb1.isClickable = false
                } else {
                    rb1.setTextColor(Color.GREEN)
                }
                if (rb2.text !== getString(
                        this.resources.getIdentifier("certa$idquestao", "string", this.packageName))) {
                    rb2.setTextColor(Color.LTGRAY)
                    rb2.isClickable = false
                } else {
                    rb2.setTextColor(Color.GREEN)
                }
                if (rb3.text !== getString(
                        this.resources.getIdentifier("certa$idquestao", "string", this.packageName))) {
                    rb3.setTextColor(Color.LTGRAY)
                    rb3.isClickable = false
                } else {
                    rb3.setTextColor(Color.GREEN)
                }
                if (rb4.text !== getString(
                        this.resources.getIdentifier("certa$idquestao", "string", this.packageName))) {
                    rb4.setTextColor(Color.LTGRAY)
                    rb4.isClickable = false
                } else {
                    rb4.setTextColor(Color.GREEN)
                }
                if (rb5.text !== getString(
                        this.resources.getIdentifier("certa$idquestao", "string", this.packageName))) {
                    rb5.setTextColor(Color.LTGRAY)
                    rb5.isClickable = false
                } else {
                    rb5.setTextColor(Color.GREEN)
                }

                erros += 1
            }
        }

    }

    fun proximo(view: View) {
        val rb1 = findViewById<RadioButton>(R.id.radioButton1)
        val rb2 = findViewById<RadioButton>(R.id.radioButton2)
        val rb3 = findViewById<RadioButton>(R.id.radioButton3)
        val rb4 = findViewById<RadioButton>(R.id.radioButton4)
        val rb5 = findViewById<RadioButton>(R.id.radioButton5)

        rb1.isClickable = true
        rb2.isClickable = true
        rb3.isClickable = true
        rb4.isClickable = true
        rb5.isClickable = true

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        radioGroup.clearCheck()


        val btResponder = findViewById<Button>(R.id.responder)
        btResponder.isClickable = true
        btResponder.setBackgroundColor(Color.rgb(103, 79, 163))

        if (idquestao < getString(R.integer.quantidade).toInt()){

            idquestao += 1

            val enunciado = findViewById<TextView>(R.id.enunciado)
            val titulo = findViewById<TextView>(R.id.titulo)

            enunciado.text = getString(this.resources.getIdentifier("enum$idquestao", "string", this.packageName))
            titulo.text = getString(this.resources.getIdentifier("titulo$idquestao", "string", this.packageName))

            rb1.text = getString(this.resources.getIdentifier("a$idquestao", "string", this.packageName))
            rb1.setTextColor(Color.BLACK)
            rb2.text = getString(this.resources.getIdentifier("b$idquestao", "string", this.packageName))
            rb2.setTextColor(Color.BLACK)
            rb3.text = getString(this.resources.getIdentifier("c$idquestao", "string", this.packageName))
            rb3.setTextColor(Color.BLACK)
            rb4.text = getString(this.resources.getIdentifier("d$idquestao", "string", this.packageName))
            rb4.setTextColor(Color.BLACK)
            rb5.text = getString(this.resources.getIdentifier("e$idquestao", "string", this.packageName))
            rb5.setTextColor(Color.BLACK)

        }else{
            Toast.makeText(this, "Acabou, irmão, vai fazer outra coisa!!!!", 3000).show()
        }
    }

    fun anterior(view: View) {

        if (idquestao > 1){
            idquestao -= 1

            val enunciado = findViewById<TextView>(R.id.enunciado)
            val titulo = findViewById<TextView>(R.id.titulo)

            val rb1 = findViewById<RadioButton>(R.id.radioButton1)
            val rb2 = findViewById<RadioButton>(R.id.radioButton2)
            val rb3 = findViewById<RadioButton>(R.id.radioButton3)
            val rb4 = findViewById<RadioButton>(R.id.radioButton4)
            val rb5 = findViewById<RadioButton>(R.id.radioButton5)

            rb1.text = getString(this.resources.getIdentifier("a$idquestao", "string", this.packageName))
            rb1.setTextColor(Color.BLACK)
            rb2.text = getString(this.resources.getIdentifier("b$idquestao", "string", this.packageName))
            rb2.setTextColor(Color.BLACK)
            rb3.text = getString(this.resources.getIdentifier("c$idquestao", "string", this.packageName))
            rb3.setTextColor(Color.BLACK)
            rb4.text = getString(this.resources.getIdentifier("d$idquestao", "string", this.packageName))
            rb4.setTextColor(Color.BLACK)
            rb5.text = getString(this.resources.getIdentifier("e$idquestao", "string", this.packageName))
            rb5.setTextColor(Color.BLACK)

            enunciado.text = getString(this.resources.getIdentifier("enum$idquestao", "string", this.packageName))
            titulo.text = getString(this.resources.getIdentifier("titulo$idquestao", "string", this.packageName))

            rb1.text = getString(this.resources.getIdentifier("a$idquestao", "string", this.packageName))
            rb2.text = getString(this.resources.getIdentifier("b$idquestao", "string", this.packageName))
            rb3.text = getString(this.resources.getIdentifier("c$idquestao", "string", this.packageName))
            rb4.text = getString(this.resources.getIdentifier("d$idquestao", "string", this.packageName))
            rb5.text = getString(this.resources.getIdentifier("e$idquestao", "string", this.packageName))
        } else {
            Toast.makeText(this, "Calma ai irmão, tenta alguma coisa ao menos!!!!", 3000).show()
        }


    }

    fun pontuacao(view: View){

        val builder = AlertDialog.Builder(this)
        var total: Int = acertos + erros
        with(builder)
        {
            setTitle("Desempenho")
            setMessage("Acertos: $acertos/$total \nErros: $erros/$total" )
            setNeutralButton("Ok", neutralButtonClick)
            show()
        }
    }

    val neutralButtonClick = { dialog: DialogInterface, which: Int ->
        Toast.makeText(applicationContext,
            "Vamos lá!!!", Toast.LENGTH_SHORT).show()
    }
}