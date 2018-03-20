package hanuor.com.rxstuff

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.reactivex.Observable
import io.reactivex.ObservableSource
import java.util.concurrent.Callable

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Using defer here
        

        var mms: Observable<String> = Observable.defer(object: Callable<ObservableSource<String>>{
            override fun call(): ObservableSource<String> {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            return Observable.just("sss")
            }

        })
    }
}
