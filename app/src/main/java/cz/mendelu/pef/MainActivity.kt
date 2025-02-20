package cz.mendelu.pef

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cz.mendelu.pef.ui.theme.TodoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    innerPadding -> ShowGUI(paddingValues = innerPadding)
                }
            }
        }
    }
}

@Composable
fun WritableScreenContent(paddingValues: PaddingValues, text: String, onValueChange:(String) -> Unit) {
    Column(modifier = Modifier.padding(paddingValues)) {
        TextField(
            value = text,
            onValueChange = onValueChange,
            placeholder = { Text("Write something!") },
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Red,
                unfocusedTextColor = Color.Green
            )
        )
    }
}

@Composable
fun ShowGUI(paddingValues: PaddingValues) {
    var text by rememberSaveable { mutableStateOf("") }

    WritableScreenContent(paddingValues, text = text, onValueChange = { text = it })
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TodoTheme {
        Greeting("Android")
    }
}