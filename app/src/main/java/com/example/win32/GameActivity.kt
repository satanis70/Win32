package com.example.win32

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.example.win32.databinding.ActivityGameBinding
import com.example.win32.model.Image
import com.example.win32.retrofit.CardApi
import com.onesignal.OneSignal
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory

class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding
    private var arrayListImages = ArrayList<Image>()
    private lateinit var button1: AppCompatButton
    private lateinit var button2: AppCompatButton
    private lateinit var button3: AppCompatButton
    private lateinit var button4: AppCompatButton
    private lateinit var button5: AppCompatButton
    private lateinit var button6: AppCompatButton
    private lateinit var button7: AppCompatButton
    private lateinit var button8: AppCompatButton
    private lateinit var button9: AppCompatButton
    private lateinit var button10: AppCompatButton
    private lateinit var button11: AppCompatButton
    private lateinit var button12: AppCompatButton
    private lateinit var button13: AppCompatButton
    private lateinit var button14: AppCompatButton
    private lateinit var button15: AppCompatButton
    private lateinit var button16: AppCompatButton
    private lateinit var button17: AppCompatButton
    private lateinit var button18: AppCompatButton
    private var currentClick = false
    private var currentImg: String = ""
    private lateinit var currentButton: AppCompatButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        LoadImage.load(binding.linearLayoutGame, this)
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId(APP_ID)
        initButtons()
        getImagesCard()
    }

    private fun getImagesCard(){
        CoroutineScope(Dispatchers.IO).launch {
            val api = CardApi::class.java
            val apiInterface = Retrofit.Builder()
                .baseUrl("http://49.12.202.175/win32/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(api)
            val call = apiInterface.getImages().awaitResponse()
            if (call.isSuccessful) {
                arrayListImages.addAll(call.body()!!.images)
                arrayListImages.addAll(call.body()!!.images)
            }
            launch(Dispatchers.Main) {
                Log.i("array", arrayListImages.toString())
                arrayListImages.shuffle()

                button1.setOnClickListener {
                    disableButtons()
                    setImageCard(button1, arrayListImages[0].url)
                    Handler(Looper.getMainLooper()).postDelayed({
                        if (!currentClick){
                            currentImg = arrayListImages[0].url
                            currentClick=true
                            currentButton = button1
                            enableButtons()
                        } else {
                            if (arrayListImages[0].url==currentImg){
                                button1.visibility = View.INVISIBLE
                                currentButton.visibility = View.INVISIBLE
                                currentClick = false
                                enableButtons()
                                checkForVictory()
                            } else {
                                button1.setBackgroundResource(R.drawable.button_card_gradient)
                                currentButton.setBackgroundResource(R.drawable.button_card_gradient)
                                currentClick = false
                                enableButtons()
                            }
                        }
                    }, 1000)
                }
                button2.setOnClickListener {
                    disableButtons()
                    setImageCard(button2, arrayListImages[1].url)
                    Handler(Looper.getMainLooper()).postDelayed({
                        if (!currentClick){
                            currentImg = arrayListImages[1].url
                            currentClick=true
                            currentButton = button2
                            enableButtons()
                        } else {
                            if (arrayListImages[1].url==currentImg){
                                button2.visibility = View.INVISIBLE
                                currentButton.visibility = View.INVISIBLE
                                currentClick = false
                                enableButtons()
                                checkForVictory()
                            } else {
                                button2.setBackgroundResource(R.drawable.button_card_gradient)
                                currentButton.setBackgroundResource(R.drawable.button_card_gradient)
                                currentClick = false
                                enableButtons()
                            }
                        }
                    }, 1000)
                }
                button3.setOnClickListener {
                    disableButtons()
                    setImageCard(button3, arrayListImages[2].url)
                    Handler(Looper.getMainLooper()).postDelayed({
                        if (!currentClick){
                            currentImg = arrayListImages[2].url
                            currentClick=true
                            currentButton = button3
                            enableButtons()
                        } else {
                            if (arrayListImages[2].url==currentImg){
                                button3.visibility = View.INVISIBLE
                                currentButton.visibility = View.INVISIBLE
                                currentClick = false
                                enableButtons()
                                checkForVictory()
                            } else {
                                button3.setBackgroundResource(R.drawable.button_card_gradient)
                                currentButton.setBackgroundResource(R.drawable.button_card_gradient)
                                currentClick = false
                                enableButtons()
                            }
                        }
                    }, 1000)
                }
                button4.setOnClickListener {
                    disableButtons()
                    setImageCard(button4, arrayListImages[3].url)
                    Handler(Looper.getMainLooper()).postDelayed({
                        if (!currentClick){
                            currentImg = arrayListImages[3].url
                            currentClick=true
                            currentButton = button4
                            enableButtons()
                        } else {
                            if (arrayListImages[3].url==currentImg){
                                button4.visibility = View.INVISIBLE
                                currentButton.visibility = View.INVISIBLE
                                currentClick = false
                                enableButtons()
                                checkForVictory()
                            } else {
                                button4.setBackgroundResource(R.drawable.button_card_gradient)
                                currentButton.setBackgroundResource(R.drawable.button_card_gradient)
                                currentClick = false
                                enableButtons()
                            }
                        }
                    }, 1000)
                }
                button5.setOnClickListener {
                    disableButtons()
                    setImageCard(button5, arrayListImages[4].url)
                    Handler(Looper.getMainLooper()).postDelayed({
                        if (!currentClick){
                            currentImg = arrayListImages[4].url
                            currentClick=true
                            currentButton = button5
                            enableButtons()
                        } else {
                            if (arrayListImages[4].url==currentImg){
                                button5.visibility = View.INVISIBLE
                                currentButton.visibility = View.INVISIBLE
                                currentClick = false
                                enableButtons()
                                checkForVictory()
                            } else {
                                button5.setBackgroundResource(R.drawable.button_card_gradient)
                                currentButton.setBackgroundResource(R.drawable.button_card_gradient)
                                currentClick = false
                                enableButtons()
                            }
                        }
                    }, 1000)
                }
                button6.setOnClickListener {
                    disableButtons()
                    setImageCard(button6, arrayListImages[5].url)
                    Handler(Looper.getMainLooper()).postDelayed({
                        if (!currentClick){
                            currentImg = arrayListImages[5].url
                            currentClick=true
                            currentButton = button6
                            enableButtons()
                        } else {
                            if (arrayListImages[5].url==currentImg){
                                button6.visibility = View.INVISIBLE
                                currentButton.visibility = View.INVISIBLE
                                currentClick = false
                                enableButtons()
                                checkForVictory()
                            } else {
                                button6.setBackgroundResource(R.drawable.button_card_gradient)
                                currentButton.setBackgroundResource(R.drawable.button_card_gradient)
                                currentClick = false
                                enableButtons()
                            }
                        }
                    }, 1000)
                }
                button7.setOnClickListener {
                    disableButtons()
                    setImageCard(button7, arrayListImages[6].url)
                    Handler(Looper.getMainLooper()).postDelayed({
                        if (!currentClick){
                            currentImg = arrayListImages[6].url
                            currentClick=true
                            currentButton = button7
                            enableButtons()
                        } else {
                            if (arrayListImages[6].url==currentImg){
                                button7.visibility = View.INVISIBLE
                                currentButton.visibility = View.INVISIBLE
                                currentClick = false
                                enableButtons()
                                checkForVictory()
                            } else {
                                button7.setBackgroundResource(R.drawable.button_card_gradient)
                                currentButton.setBackgroundResource(R.drawable.button_card_gradient)
                                currentClick = false
                                enableButtons()
                            }
                        }
                    }, 1000)
                }
                button8.setOnClickListener {
                    disableButtons()
                    setImageCard(button8, arrayListImages[7].url)
                    Handler(Looper.getMainLooper()).postDelayed({
                        if (!currentClick){
                            currentImg = arrayListImages[7].url
                            currentClick=true
                            currentButton = button8
                            enableButtons()
                        } else {
                            if (arrayListImages[7].url==currentImg){
                                button8.visibility = View.INVISIBLE
                                currentButton.visibility = View.INVISIBLE
                                currentClick = false
                                enableButtons()
                                checkForVictory()
                            } else {
                                button8.setBackgroundResource(R.drawable.button_card_gradient)
                                currentButton.setBackgroundResource(R.drawable.button_card_gradient)
                                currentClick = false
                                enableButtons()
                            }
                        }
                    }, 1000)
                }
                button9.setOnClickListener {
                    disableButtons()
                    setImageCard(button9, arrayListImages[8].url)
                    Handler(Looper.getMainLooper()).postDelayed({
                        if (!currentClick){
                            currentImg = arrayListImages[8].url
                            currentClick=true
                            currentButton = button9
                            enableButtons()
                        } else {
                            if (arrayListImages[8].url==currentImg){
                                button9.visibility = View.INVISIBLE
                                currentButton.visibility = View.INVISIBLE
                                currentClick = false
                                enableButtons()
                                checkForVictory()
                            } else {
                                button9.setBackgroundResource(R.drawable.button_card_gradient)
                                currentButton.setBackgroundResource(R.drawable.button_card_gradient)
                                currentClick = false
                                enableButtons()
                            }
                        }
                    }, 1000)
                }
                button10.setOnClickListener {
                    disableButtons()
                    setImageCard(button10, arrayListImages[9].url)
                    Handler(Looper.getMainLooper()).postDelayed({
                        if (!currentClick){
                            currentImg = arrayListImages[9].url
                            currentClick=true
                            currentButton = button10
                            enableButtons()
                        } else {
                            if (arrayListImages[9].url==currentImg){
                                button10.visibility = View.INVISIBLE
                                currentButton.visibility = View.INVISIBLE
                                currentClick = false
                                enableButtons()
                                checkForVictory()
                            } else {
                                button10.setBackgroundResource(R.drawable.button_card_gradient)
                                currentButton.setBackgroundResource(R.drawable.button_card_gradient)
                                currentClick = false
                                enableButtons()
                            }
                        }
                    }, 1000)
                }
                button11.setOnClickListener {
                    disableButtons()
                    setImageCard(button11, arrayListImages[10].url)
                    Handler(Looper.getMainLooper()).postDelayed({
                        if (!currentClick){
                            currentImg = arrayListImages[10].url
                            currentClick=true
                            currentButton = button11
                            enableButtons()
                        } else {
                            if (arrayListImages[10].url==currentImg){
                                button11.visibility = View.INVISIBLE
                                currentButton.visibility = View.INVISIBLE
                                currentClick = false
                                enableButtons()
                                checkForVictory()
                            } else {
                                button11.setBackgroundResource(R.drawable.button_card_gradient)
                                currentButton.setBackgroundResource(R.drawable.button_card_gradient)
                                currentClick = false
                                enableButtons()
                            }
                        }
                    }, 1000)
                }
                button12.setOnClickListener {
                    disableButtons()
                    setImageCard(button12, arrayListImages[11].url)
                    Handler(Looper.getMainLooper()).postDelayed({
                        if (!currentClick){
                            currentImg = arrayListImages[11].url
                            currentClick=true
                            currentButton = button12
                            enableButtons()
                        } else {
                            if (arrayListImages[11].url==currentImg){
                                button12.visibility = View.INVISIBLE
                                currentButton.visibility = View.INVISIBLE
                                currentClick = false
                                enableButtons()
                                checkForVictory()
                            } else {
                                button12.setBackgroundResource(R.drawable.button_card_gradient)
                                currentButton.setBackgroundResource(R.drawable.button_card_gradient)
                                currentClick = false
                                enableButtons()
                            }
                        }
                    }, 1000)
                }
                button13.setOnClickListener {
                    disableButtons()
                    setImageCard(button13, arrayListImages[12].url)
                    Handler(Looper.getMainLooper()).postDelayed({
                        if (!currentClick){
                            currentImg = arrayListImages[12].url
                            currentClick=true
                            currentButton = button13
                            enableButtons()
                        } else {
                            if (arrayListImages[12].url==currentImg){
                                button13.visibility = View.INVISIBLE
                                currentButton.visibility = View.INVISIBLE
                                currentClick = false
                                enableButtons()
                                checkForVictory()
                            } else {
                                button13.setBackgroundResource(R.drawable.button_card_gradient)
                                currentButton.setBackgroundResource(R.drawable.button_card_gradient)
                                currentClick = false
                                enableButtons()
                            }
                        }
                    }, 1000)
                }
                button14.setOnClickListener {
                    disableButtons()
                    setImageCard(button14, arrayListImages[13].url)
                    Handler(Looper.getMainLooper()).postDelayed({
                        if (!currentClick){
                            currentImg = arrayListImages[13].url
                            currentClick=true
                            currentButton = button14
                            enableButtons()
                        } else {
                            if (arrayListImages[13].url==currentImg){
                                button14.visibility = View.INVISIBLE
                                currentButton.visibility = View.INVISIBLE
                                currentClick = false
                                enableButtons()
                                checkForVictory()
                            } else {
                                button14.setBackgroundResource(R.drawable.button_card_gradient)
                                currentButton.setBackgroundResource(R.drawable.button_card_gradient)
                                currentClick = false
                                enableButtons()
                            }
                        }
                    }, 1000)
                }
                button15.setOnClickListener {
                    disableButtons()
                    setImageCard(button15, arrayListImages[14].url)
                    Handler(Looper.getMainLooper()).postDelayed({
                        if (!currentClick){
                            currentImg = arrayListImages[14].url
                            currentClick=true
                            currentButton = button15
                            enableButtons()
                        } else {
                            if (arrayListImages[14].url==currentImg){
                                button15.visibility = View.INVISIBLE
                                currentButton.visibility = View.INVISIBLE
                                currentClick = false
                                enableButtons()
                                checkForVictory()
                            } else {
                                button15.setBackgroundResource(R.drawable.button_card_gradient)
                                currentButton.setBackgroundResource(R.drawable.button_card_gradient)
                                currentClick = false
                                enableButtons()
                            }
                        }
                    }, 1000)
                }
                button16.setOnClickListener {
                    disableButtons()
                    setImageCard(button16, arrayListImages[15].url)
                    Handler(Looper.getMainLooper()).postDelayed({
                        if (!currentClick){
                            currentImg = arrayListImages[15].url
                            currentClick=true
                            currentButton = button16
                            enableButtons()
                        } else {
                            if (arrayListImages[15].url==currentImg){
                                button16.visibility = View.INVISIBLE
                                currentButton.visibility = View.INVISIBLE
                                currentClick = false
                                enableButtons()
                                checkForVictory()
                            } else {
                                button16.setBackgroundResource(R.drawable.button_card_gradient)
                                currentButton.setBackgroundResource(R.drawable.button_card_gradient)
                                currentClick = false
                                enableButtons()
                            }
                        }
                    }, 1000)
                }
                button17.setOnClickListener {
                    disableButtons()
                    setImageCard(button17, arrayListImages[16].url)
                    Handler(Looper.getMainLooper()).postDelayed({
                        if (!currentClick){
                            currentImg = arrayListImages[16].url
                            currentClick=true
                            currentButton = button17
                            enableButtons()
                        } else {
                            if (arrayListImages[16].url==currentImg){
                                button17.visibility = View.INVISIBLE
                                currentButton.visibility = View.INVISIBLE
                                currentClick = false
                                enableButtons()
                                checkForVictory()
                            } else {
                                button17.setBackgroundResource(R.drawable.button_card_gradient)
                                currentButton.setBackgroundResource(R.drawable.button_card_gradient)
                                currentClick = false
                                enableButtons()
                            }
                        }
                    }, 1000)
                }
                button18.setOnClickListener {
                    disableButtons()
                    setImageCard(button18, arrayListImages[17].url)
                    Handler(Looper.getMainLooper()).postDelayed({
                        if (!currentClick){
                            currentImg = arrayListImages[17].url
                            currentClick=true
                            currentButton = button18
                            enableButtons()
                        } else {
                            if (arrayListImages[17].url==currentImg){
                                button18.visibility = View.INVISIBLE
                                currentButton.visibility = View.INVISIBLE
                                currentClick = false
                                enableButtons()
                                checkForVictory()
                            } else {
                                button18.setBackgroundResource(R.drawable.button_card_gradient)
                                currentButton.setBackgroundResource(R.drawable.button_card_gradient)
                                currentClick = false
                                enableButtons()
                            }
                        }
                    }, 1000)
                }
            }
        }
    }

    private fun checkForVictory(){
        if (button1.visibility == View.INVISIBLE &&
            button2.visibility == View.INVISIBLE &&
            button3.visibility == View.INVISIBLE &&
            button4.visibility == View.INVISIBLE &&
            button5.visibility == View.INVISIBLE &&
            button6.visibility == View.INVISIBLE &&
            button7.visibility == View.INVISIBLE &&
            button8.visibility == View.INVISIBLE &&
            button9.visibility == View.INVISIBLE &&
            button10.visibility == View.INVISIBLE &&
            button11.visibility == View.INVISIBLE &&
            button12.visibility == View.INVISIBLE &&
            button13.visibility==View.INVISIBLE &&
            button14.visibility == View.INVISIBLE &&
            button15.visibility == View.INVISIBLE &&
            button16.visibility == View.INVISIBLE &&
            button17.visibility == View.INVISIBLE &&
            button18.visibility == View.INVISIBLE
        ) {
            binding.textViewWin.visibility = View.VISIBLE
            binding.buttonAgain.visibility = View.VISIBLE
            binding.buttonAgain.setOnClickListener {
                startActivity(Intent(this, GameActivity::class.java))
                finish()
            }
        }
    }

    private fun initButtons(){
        button1 = binding.button
        button2 = binding.button2
        button3 = binding.button3
        button4 = binding.button4
        button5 = binding.button5
        button6 = binding.button6
        button7 = binding.button7
        button8 = binding.button8
        button9 = binding.button9
        button10 = binding.button10
        button11 = binding.button11
        button12 = binding.button12
        button13 = binding.button13
        button14 = binding.button14
        button15 = binding.button15
        button16 = binding.button16
        button17 = binding.button17
        button18 = binding.button18
    }

    private fun disableButtons(){
        button1.isEnabled = false
        button2.isEnabled = false
        button3.isEnabled = false
        button4.isEnabled = false
        button5.isEnabled = false
        button6.isEnabled = false
        button7.isEnabled = false
        button8.isEnabled = false
        button9.isEnabled = false
        button10.isEnabled = false
        button11.isEnabled = false
        button12.isEnabled = false
        button13.isEnabled = false
        button14.isEnabled = false
        button15.isEnabled = false
        button16.isEnabled = false
        button17.isEnabled = false
        button18.isEnabled = false
    }
    private fun enableButtons(){
        button1.isEnabled = true
        button2.isEnabled = true
        button3.isEnabled = true
        button4.isEnabled = true
        button5.isEnabled = true
        button6.isEnabled = true
        button7.isEnabled = true
        button8.isEnabled = true
        button9.isEnabled = true
        button10.isEnabled = true
        button11.isEnabled = true
        button12.isEnabled = true
        button13.isEnabled = true
        button14.isEnabled = true
        button15.isEnabled = true
        button16.isEnabled = true
        button17.isEnabled = true
        button18.isEnabled = true
    }

    private fun setImageCard(appCompatButton: AppCompatButton, urlImage: String){
        Glide.with(this)
            .load(urlImage)
            .into(object : SimpleTarget<Drawable?>() {
                override fun onResourceReady(
                    resource: Drawable,
                    transition: Transition<in Drawable?>?
                ) {
                    appCompatButton.setBackgroundDrawable(resource)
                }
            })
    }

}