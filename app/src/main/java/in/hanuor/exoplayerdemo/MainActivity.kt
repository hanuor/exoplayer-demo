package `in`.hanuor.exoplayerdemo

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.android.exoplayer.ExoPlayer
import com.google.android.exoplayer.ExoPlayer.Factory.newInstance
import com.google.android.exoplayer.MediaCodecAudioTrackRenderer
import com.google.android.exoplayer.extractor.ExtractorSampleSource
import com.google.android.exoplayer.upstream.Allocator
import com.google.android.exoplayer.upstream.DataSource
import com.google.android.exoplayer.upstream.DefaultAllocator
import com.google.android.exoplayer.upstream.DefaultUriDataSource
import com.google.android.exoplayer.util.Util

class MainActivity : AppCompatActivity() {
    companion object {
        var  BUFFER_SEGMENT_SIZE = 64 * 1024
        var BUFFER_SEGMENT_COUNT = 256
    }

    var exoPlayer: ExoPlayer ?= null
    var audioUri: Uri?= null
    var allocator: Allocator ?= null
    var dataSource: DataSource?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        exoPlayer = newInstance(1)
        setContentView(R.layout.activity_main)
        audioUri = Uri.parse("android.resource://" + packageName + "/assets/parkly")
        allocator = DefaultAllocator(BUFFER_SEGMENT_SIZE)
        var userAgent = Util.getUserAgent(this, "ExoPlayerDemo")
        dataSource = DefaultUriDataSource(this, null, userAgent)
        var sampleSource = ExtractorSampleSource(audioUri, dataSource, allocator, BUFFER_SEGMENT_SIZE* BUFFER_SEGMENT_COUNT)
        var audioRenderer = MediaCodecAudioTrackRenderer(sampleSource)
        exoPlayer?.prepare(audioRenderer)
        exoPlayer?.playWhenReady = true

    }


}
