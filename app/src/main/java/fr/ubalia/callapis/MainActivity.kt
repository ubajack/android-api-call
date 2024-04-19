package fr.ubalia.callapis

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import fr.ubalia.callapis.ui.theme.CallAPIsTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CallAPIsTheme {
                val scope = rememberCoroutineScope()

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Button(onClick = {
                            try {
                                scope.launch(Dispatchers.IO) {
                                    val result = CreditCardApi.retrofitService.getCreditCard()
                                    Log.d("API", result.toString())
                                }

                            } catch (e: IOException) {
                                e.printStackTrace()
                            }
                        }) {
                            Text(text = "Get Credit Card")
                        }
                        Button(onClick = {
                            try {
                                scope.launch(Dispatchers.IO) {
                                    val result = BeerApi.retrofitService.getBeer()
                                    Log.d("API", result.toString())
                                }

                            } catch (e: IOException) {
                                e.printStackTrace()
                            }
                        }) {
                            Text(text = "Get Beer")
                        }
                    }
                }
            }
        }
    }
}