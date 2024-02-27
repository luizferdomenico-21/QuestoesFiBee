package com.example.questoesfibee

import android.app.AlertDialog
import android.content.DialogInterface
import java.util.Collections
import android.content.Intent
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
    val grayButton = Color.LTGRAY
    val greenButton = Color.GREEN
    var acertos: Int  = 0
    var idquestao: Int = 1
    var erros: Int  = 0
    var answerQuestions: Int = 0
    var numberOfQuestions = 4
    var acertosDouble = acertos.toDouble()
    var finalScore = acertosDouble / numberOfQuestions * 100
    var listQuestions = mutableListOf<Int>()
    var listController = mutableListOf<Int>()
    var radioBtnColors = mutableListOf<Int>()
    var listRadioBtns = mutableListOf<Int>()
    var listAnswers = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun responder(view: View) {

        //var questoesList = (1..3).map {
        //    (1..getString(R.integer.quantidade).toInt()).random()
        //}

        //idquestao = questoesList[0]

        val rb1 = findViewById<RadioButton>(R.id.radioButton1)
        val rb2 = findViewById<RadioButton>(R.id.radioButton2)
        val rb3 = findViewById<RadioButton>(R.id.radioButton3)
        val rb4 = findViewById<RadioButton>(R.id.radioButton4)
        val rb5 = findViewById<RadioButton>(R.id.radioButton5)
        val btResponder = findViewById<Button>(R.id.responder)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)

        if (radioGroup.checkedRadioButtonId === -1) {
            Toast.makeText(applicationContext, "Uma alternativa deve ser selecionada", Toast.LENGTH_SHORT).show()
        } else {
            listAnswers.add(idquestao)
            answerQuestions++

            val selectedId: Int = radioGroup.checkedRadioButtonId
            val selectedRadioButton = findViewById<RadioButton>(selectedId)

            if(selectedRadioButton.getText().toString() == getString(
                    this.resources.getIdentifier("certa$idquestao", "string", this.packageName))){
                Toast.makeText(applicationContext, "Correto", Toast.LENGTH_SHORT).show()
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
            listQuestions.addAll(listOf(idquestao, rb1.currentTextColor,rb2.currentTextColor,
                rb3.currentTextColor,rb4.currentTextColor,rb5.currentTextColor,))
            radioGroup.isClickable = false
        }

    }

    fun proximo(view: View) {

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val rb1 = findViewById<RadioButton>(R.id.radioButton1)
        val rb2 = findViewById<RadioButton>(R.id.radioButton2)
        val rb3 = findViewById<RadioButton>(R.id.radioButton3)
        val rb4 = findViewById<RadioButton>(R.id.radioButton4)
        val rb5 = findViewById<RadioButton>(R.id.radioButton5)

        if (listAnswers.contains(idquestao + 1)) {
            val btResponder = findViewById<Button>(R.id.responder)
            btResponder.isClickable = false
            btResponder.setBackgroundColor(Color.GRAY)

            val indexIdquestao = listQuestions.indexOf(idquestao + 1)
            radioBtnColors = listQuestions.slice(indexIdquestao..indexIdquestao + 5).toMutableList()

            rb1.setTextColor(radioBtnColors.get(1))
            rb2.setTextColor(radioBtnColors.get(2))
            rb3.setTextColor(radioBtnColors.get(3))
            rb4.setTextColor(radioBtnColors.get(4))
            rb5.setTextColor(radioBtnColors.get(5))

                acertos++
                acertosDouble = acertos.toDouble()
                finalScore = acertosDouble / numberOfQuestions * 100

            erros += 1

            // CODIGO COMENTADO POIS  NÃO É PRIORIDADE NO MOMENTO
            //if (answerQuestions == numberOfQuestions && idquestao == listController.last()) {
            //val answerButton = findViewById<Button>(R.id.proximo)
            //answerButton.setOnClickListener {
                //    val testObject = UserResults(acertos.toString(), erros.toString(), finalScore.toString())
                //    val intent = Intent(this, ResultsActivity::class.java)
                //    intent.putExtra("HITS_SCORE", acertos.toString())
                //    intent.putExtra("ERRORS_SCORE", erros.toString())
                //    intent.putExtra("FINAL_SCORE", finalScore.toString())
                //    intent.putExtra("OBJECT", testObject)
                //    startActivity(intent)
                //    }
            //}


        } else {
            val btResponder = findViewById<Button>(R.id.responder)
            btResponder.isClickable = true
            btResponder.setBackgroundColor(Color.rgb(103, 79, 163))

            rb1.setTextColor(Color.BLACK)
            rb2.setTextColor(Color.BLACK)
            rb3.setTextColor(Color.BLACK)
            rb4.setTextColor(Color.BLACK)
            rb5.setTextColor(Color.BLACK)
            radioGroup.clearCheck()
        }

        if (idquestao < getString(R.integer.quantidade).toInt()){

            idquestao += 1

            val enunciado = findViewById<TextView>(R.id.enunciado)
            val titulo = findViewById<TextView>(R.id.titulo)

            enunciado.text = getString(this.resources.getIdentifier("enum$idquestao", "string", this.packageName))
            titulo.text = getString(this.resources.getIdentifier("titulo$idquestao", "string", this.packageName))

            rb1.text = getString(this.resources.getIdentifier("a$idquestao", "string", this.packageName))
            rb2.text = getString(this.resources.getIdentifier("b$idquestao", "string", this.packageName))
            rb3.text = getString(this.resources.getIdentifier("c$idquestao", "string", this.packageName))
            rb4.text = getString(this.resources.getIdentifier("d$idquestao", "string", this.packageName))
            rb5.text = getString(this.resources.getIdentifier("e$idquestao", "string", this.packageName))

        }else{
            rb1.text = getString(this.resources.getIdentifier("a$idquestao", "string", this.packageName))
            rb2.text = getString(this.resources.getIdentifier("b$idquestao", "string", this.packageName))
            rb3.text = getString(this.resources.getIdentifier("c$idquestao", "string", this.packageName))
            rb4.text = getString(this.resources.getIdentifier("d$idquestao", "string", this.packageName))
            rb5.text = getString(this.resources.getIdentifier("e$idquestao", "string", this.packageName))
        }
    }

    fun anterior(view: View) {

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val rb1 = findViewById<RadioButton>(R.id.radioButton1)
        val rb2 = findViewById<RadioButton>(R.id.radioButton2)
        val rb3 = findViewById<RadioButton>(R.id.radioButton3)
        val rb4 = findViewById<RadioButton>(R.id.radioButton4)
        val rb5 = findViewById<RadioButton>(R.id.radioButton5)
        val enunciado = findViewById<TextView>(R.id.enunciado)
        val titulo = findViewById<TextView>(R.id.titulo)

        if (listAnswers.contains(idquestao - 1)) {
            val btResponder = findViewById<Button>(R.id.responder)
            btResponder.isClickable = false
            btResponder.setBackgroundColor(Color.GRAY)

            val indexIdquestao = listQuestions.indexOf(idquestao - 1)
            radioBtnColors = listQuestions.slice(indexIdquestao..indexIdquestao + 5).toMutableList()


        } else {
            val btResponder = findViewById<Button>(R.id.responder)
            btResponder.isClickable = true
            btResponder.setBackgroundColor(Color.rgb(103, 79, 163))

            rb1.setTextColor(Color.BLACK)
            rb2.setTextColor(Color.BLACK)
            rb3.setTextColor(Color.BLACK)
            rb4.setTextColor(Color.BLACK)
            rb5.setTextColor(Color.BLACK)
            radioGroup.clearCheck()
        }

        if (idquestao > 1){
            idquestao -= 1

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
