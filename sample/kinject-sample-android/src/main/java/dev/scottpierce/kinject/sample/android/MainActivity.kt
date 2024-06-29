package dev.scottpierce.kinject.sample.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.scottpierce.kinject.sample.android.ui.theme.KinjectTheme
import kinject.compose.ObjectGraphProvider
import kinject.compose.viewmodel.getViewModel
import kinject.objectGraph
import kinject.viewmodel.viewModel
import kotlinx.coroutines.delay

private val objectGraph = objectGraph {
    viewModel { TestViewModel() }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KinjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ObjectGraphProvider(objectGraph = objectGraph) {
                        val vm: TestViewModel = getViewModel()
                        val name by vm.state.collectAsState()

                        LaunchedEffect(Unit) {
                            delay(1000)
                            vm.updateName("New Name")
                        }

                        Greeting(
                            name = name,
                            modifier = Modifier.padding(innerPadding),
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KinjectTheme {
        Greeting("Android")
    }
}
