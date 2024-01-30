package com.example.questoesfibee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.math.RoundingMode

class ResultsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        var acertos = findViewById<TextView>(R.id.hitsScore)
        var erros = findViewById<TextView>(R.id.errorsScore)
        var pontuacaoFinal = findViewById<TextView>(R.id.finalScore)

        var intent = intent
        var hitsScore = intent.getStringExtra("HITS_SCORE")
        var errorsScore = intent.getStringExtra("ERRORS_SCORE")
        var finalScore = intent.getStringExtra("FINAL_SCORE")
        val finalScoreDouble = finalScore?.toDouble()
        val roundedUp = finalScoreDouble?.toBigDecimal()?.setScale(2, RoundingMode.UP)?.toDouble()
        val finalScoreString = roundedUp.toString()


        pontuacaoFinal.text = "$finalScoreString%"
        acertos.text = hitsScore
        erros.text = errorsScore

    }

    fun recomecar (view: View) {
        val restartButton = findViewById<Button>(R.id.recomecar)
        restartButton.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
    }
}