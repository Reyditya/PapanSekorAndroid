    package id.owl.com.papansekor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var counterViewModel: PapanSekorViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        //test

        counterViewModel = ViewModelProvider(this).get(PapanSekorViewModel::class.java)

        initView()

        cvPlusA.setOnClickListener(this)
        cvPlusB.setOnClickListener(this)
        cvMinusA.setOnClickListener(this)
        cvMinusB.setOnClickListener(this)
        cvReset.setOnClickListener(this)

    }

    private fun initView() {
        counterViewModel.getSekorA()?.observe(this, Observer {
            if (it != null) {
                txtTeamA.text = it.toString()
            }
        })
        counterViewModel.getSekorB()?.observe(this, Observer {
            if (it != null) {
                txtTeamB.text = it.toString()
            }
        })
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.cvPlusA -> {
                counterViewModel.plusSekorA()
            }
            R.id.cvPlusB -> {
                counterViewModel.plusSekorB()
            }
            R.id.cvMinusA -> {
                counterViewModel.minSekorA()
            }
            R.id.cvMinusB -> {
                counterViewModel.minSekorB()
            }
            R.id.cvReset -> {
                counterViewModel.reset()
            }
        }
    }
}