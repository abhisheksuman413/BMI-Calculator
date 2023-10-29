package com.fps69.bmicalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.fps69.bmicalc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.heightSeekbar.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

                binding.tvHeightValue.text="$p1"

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })

        binding.btnCalculateBmi.setOnClickListener{

            if(binding.age.text.toString().isNotEmpty()&&binding.etWeight.text.toString().isNotEmpty()){
                val age=Integer.parseInt(binding.age.text.toString())
                val weight=Integer.parseInt(binding.etWeight.text.toString())
                val height = Integer.parseInt(binding.tvHeightValue.text.toString())
                calculateBmi(age,weight,height)

            }

        }


    }

    private fun calculateBmi(age:Int,weight:Int,height:Int){


        val heightInMeter :Double =height/100.0
        val bmi :Double = weight.toDouble()/(heightInMeter*heightInMeter)
        Toast.makeText(this,"Result is $bmi ",Toast.LENGTH_SHORT).show()

        val bmiCategory :String = when{
            bmi <16 -> "Severely UnderWeight"
            bmi <18.5 -> " UnderWeight"
            bmi <25 -> "Normal"
            bmi <30 -> "OverWeight"
            else -> "Obese"
        }

        val bmiResult = "Your Bmi is :- %.2f \n Category :- $bmiCategory".format(bmi)

        binding.tvResultView.visibility = View.VISIBLE
        binding.tvResultView.text = bmiResult

        val alertDialog = AlertDialog.Builder(this)
            .setTitle("BMI RESULT ")
            .setMessage(bmiResult)
            .setPositiveButton("OK",null)
            .create()
        alertDialog.show()
    }
}