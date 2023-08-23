package com.example.meinshop.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.meinshop.MainActivity
import com.example.meinshop.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    // Deklariert das Binding-Objekt für die Aktivität
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialisiert das Binding-Objekt
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setzt das Maximum der ProgressBar auf 100
        binding.splashPB.max = 100

        // Startet den eingebauten Countdown der Timer Klasse und läuft nach 3 Sekunden ab
        object: CountDownTimer(3500,30) {
            override fun onTick(millisUntilFinished: Long) {
                // "onTick" die Methode wird jede 30 millisekunden aufgerufen und aktualisiert den Fortschritt der Progressbar
                val progress = ((3500 - millisUntilFinished) / 30).toInt()
                binding.splashPB.progress = progress
            }

            // Methode wird aufgerufen wenn der Countdown abgelaufen ist, die MainActivity startet hier und die SplashActivity wird beendet
            override fun onFinish() {
                //  die Progressbar ist voll wenn der Timer abgelaufen ist
                binding.splashPB.progress = 100
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                finish()
            }
        }.start()   // startet den Timer
    }
}