package com.example.ammgolamyeazdani.calculator;

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ammgolamyeazdani.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityMainBinding
    var result: Float = 0f
    var operation : String = ""
    var isOperationAllowed = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            val buttonList = arrayListOf<TextView>(
                one, two, three, four, five, six, seven, eight, nine, dot, div,
                multi, sub, plus, clear, equals
            )
            for (index in 0 until buttonList.size) {
                buttonList[index].setOnClickListener(this@MainActivity)

            }
            backDelete.setOnClickListener(this@MainActivity)

        }

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.one -> {
                if (binding.display.text != "") {
                    binding.display.append("1")
                    isOperationAllowed = true
                } else {
                    binding.display.text = "1"
                }
            }
            R.id.two -> {
                if (binding.display.text != "") {
                    binding.display.append("2")
                    isOperationAllowed = true
                } else {
                    binding.display.text = "2"
                }
            }
            R.id.three -> {
                if (binding.display.text != "") {
                    binding.display.append("3")
                    isOperationAllowed = true
                } else {
                    binding.display.text = "3"
                }
            }
            R.id.four -> {
                if (binding.display.text != "") {
                    binding.display.append("4")
                    isOperationAllowed = true
                } else {
                    binding.display.text = "4"
                }
            }
            R.id.five -> {
                if (binding.display.text != "") {
                    binding.display.append("5")
                    isOperationAllowed = true
                } else {
                    binding.display.text = "5"
                }
            }
            R.id.six -> {
                if (binding.display.text != "") {
                    binding.display.append("6")
                    isOperationAllowed = true
                } else {
                    binding.display.text = "6"
                }
            }
            R.id.seven -> {
                if (binding.display.text != "") {
                    binding.display.append("7")
                    isOperationAllowed = true
                } else {
                    binding.display.text = "7"
                }
            }
            R.id.eight -> {
                if (binding.display.text != "") {
                    binding.display.append("8")
                    isOperationAllowed = true
                } else {
                    binding.display.text = "8"
                }
            }
            R.id.nine -> {
                if (binding.display.text != "") {
                    binding.display.append("9")
                    isOperationAllowed = true
                } else {
                    binding.display.text = "9"
                }
            }
            R.id.zero -> {
                if (binding.display.text != "") {
                    binding.display.append("0")
                    isOperationAllowed = true
                } else {
                    binding.display.text = "0"
                }
            }

            R.id.plus -> {
                if (binding.display.text != "" &&  isOperationAllowed ) {
                    binding.display.append("+")
                    isOperationAllowed = false
                    operation = "+"
                }
            }
            R.id.div -> {
                if (binding.display.text != ""  &&  isOperationAllowed ) {
                    binding.display.append("%")
                    isOperationAllowed = false
                    operation = "%"
                }
            }
            R.id.multi -> {
                if (binding.display.text != ""  &&  isOperationAllowed ) {
                    binding.display.append("x")
                    isOperationAllowed = false
                    operation = "x"
                }
            }
            R.id.sub -> {
                if (binding.display.text != ""  &&  isOperationAllowed ) {
                    binding.display.append("-")
                    isOperationAllowed = false
                    operation = "-"
                }
            }
            R.id.clear -> {
                binding.display.text = null
            }
            R.id.equals -> {
                if (binding.display.text != "") {
                    calculate(binding.display.text.toString())
                } else {
                    Toast.makeText(this, "Nothing to Calculate", Toast.LENGTH_SHORT).show()
                }
            }
            R.id.dot -> {
                if (binding.display.text != "") {
                    binding.display.append(".")
                } else {
                    binding.display.text = "."
                }
            }
            R.id.backDelete -> {
                if (binding.display.text != "") {
                    val s: String = binding.display.text.toString()
                    if (s.length > 0) {
                        binding.display.text = s.substring(0, s.length - 1)

                    } else {
                        Toast.makeText(this, "Nothing to remove", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "nothing to remove", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    private fun calculate(display: String) {



        val fullExpression : String = binding.display.text.toString()

        when (operation) {
            "+" -> {
                val splicedExpression : List<String> = fullExpression.split("+")
                val result : Float = splicedExpression[0].toFloat() + splicedExpression[1].toFloat()
                binding.display.text = result.toString()
            }
            "-" -> {
                val splicedExpression : List<String> = fullExpression.split("-")
                val result : Float = splicedExpression[0].toFloat() - splicedExpression[1].toFloat()
                binding.display.text = result.toString()
            }
            "x" -> {
                val splicedExpression : List<String> = fullExpression.split("x")
                val result : Float = splicedExpression[0].toFloat() * splicedExpression[1].toFloat()
                binding.display.text = result.toString()
            }
            "%" -> {
                val splicedExpression : List<String> = fullExpression.split("%")
                val result : Float = splicedExpression[0].toFloat() / splicedExpression[1].toFloat()
                binding.display.text = result.toString()
            }
        }



    }

}
