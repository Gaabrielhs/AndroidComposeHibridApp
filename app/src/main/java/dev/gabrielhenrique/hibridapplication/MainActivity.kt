package dev.gabrielhenrique.hibridapplication

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import dev.gabrielhenrique.hibridapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.StateFlow

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.button.setOnClickListener {
            viewModel.increaseCounter()
        }

        binding.counterFlow.setContent {
            CounterFlow(viewModel.counterFlow)
        }

        binding.counterLivedata.setContent {
            CounterLiveData(viewModel.counterLiveData)
        }

        viewModel.counterLiveData.observe(this) {
            binding.counterSimple.setContent {
                CounterSimple(it)
            }
        }
    }
}

val textSize = 18.sp

@Composable
fun CounterFlow(counterState: StateFlow<Int>) {
    val counter = counterState.collectAsState()
    Text(
        text = "Counter Flow: ${counter.value}",
        fontSize = textSize
    )
}

@Composable
fun CounterLiveData(counterState: LiveData<Int>) {
    val counter = counterState.observeAsState()
    Text(
        text = "Counter LiveData: ${counter.value}",
        fontSize = textSize
    )
}

@Composable
fun CounterSimple(counter: Int) {
    Text(
        text = "Counter Simple: $counter",
        fontSize = textSize
    )
}