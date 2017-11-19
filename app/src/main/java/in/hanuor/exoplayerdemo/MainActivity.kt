package `in`.hanuor.exoplayerdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.android.exoplayer.ExoPlayer
import com.google.android.exoplayer.ExoPlayer.Factory.newInstance

class MainActivity : AppCompatActivity() {

    var exoPlayer: ExoPlayer ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        exoPlayer = newInstance(1)

        setContentView(R.layout.activity_main)



    }


}
