package id.ac.unpas.peminjamanbuku

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import id.ac.unpas.peminjamanbuku.screens.PeminjamanBukuScreen
import id.ac.unpas.peminjamanbuku.ui.theme.PeminjamanBukuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PeminjamanBukuTheme {
// A surface container using the 'background' color from the
                theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    PeminjamanBukuScreen()
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PeminjamanBukuTheme {
        PeminjamanBukuScreen()
    }
}