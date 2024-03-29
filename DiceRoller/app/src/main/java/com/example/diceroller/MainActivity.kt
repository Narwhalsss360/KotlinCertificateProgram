package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

open class Dice(val sides: Int) {
    var lastRoll: Int = 0
        private set

    fun roll(): Int {
        lastRoll = (1..sides).random()
        return  lastRoll
    }
}

/**
 * Roll the dice and update the screen with the result.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button) //Getting the button element in the activity.
        rollButton.setOnClickListener { rollDice() }

        rollDice()
    }

    /**
    * Roll the dice and update the screen with the result.
    */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll the dice
        val diceRoll = Dice(6).roll()

        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
    }
}