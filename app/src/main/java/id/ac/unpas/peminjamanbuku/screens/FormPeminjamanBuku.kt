package id.ac.unpas.peminjamanbuku.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.benasher44.uuid.uuid4
import id.ac.unpas.peminjamanbuku.model.Buku
import id.ac.unpas.peminjamanbuku.persistences.BukuDao
import id.ac.unpas.peminjamanbuku.ui.theme.Purple700
import id.ac.unpas.peminjamanbuku.ui.theme.Teal200
import kotlinx.coroutines.launch

@Composable
fun FormPencatatanBarang(BukuDao: BukuDao) {
    val judul = remember { mutableStateOf(TextFieldValue("")) }
    val penerbit = remember { mutableStateOf(TextFieldValue("")) }
    val tahunterbit = remember { mutableStateOf(TextFieldValue("")) }
    val waktupinjam = remember { mutableStateOf(TextFieldValue("")) }
    val scope = rememberCoroutineScope()
    Column(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()) {
        OutlinedTextField(
            label = { Text(text = "Judul Buku") },
            value = judul.value,
            onValueChange = {
                judul.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            placeholder = { Text(text = "Judul....") }
        )
        OutlinedTextField(
            label = { Text(text = "Penerit") },
            value = penerbit.value,
            onValueChange = {
                penerbit.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),

            placeholder = { Text(text = "Penerbit...") }
        )
        OutlinedTextField(
            label = { Text(text = "Tahun Terbit") },
            value = tahunterbit.value,
            onValueChange = {
                tahunterbit.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType =
            KeyboardType.Decimal),
            placeholder = { Text(text = "20XX") }
        )
        OutlinedTextField(
            label = { Text(text = "waktu Pinjam") },
            value = waktupinjam.value,
            onValueChange = {
                waktupinjam.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            placeholder = { Text(text = "keterangan...") }
        )

        val loginButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = Purple700,
            contentColor = Teal200
        )
        val resetButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = Teal200,
            contentColor = Purple700
        )
        Row (modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()) {
            Button(modifier = Modifier.weight(5f), onClick = {
                val id = uuid4().toString()
                val item = Buku(id, judul.value.text,
                    penerbit.value.text, tahunterbit.value.text, waktupinjam.value.text)
                scope.launch {
                    BukuDao.insertAll(item)
                }
                judul.value = TextFieldValue("")
                penerbit.value = TextFieldValue("")
                tahunterbit.value = TextFieldValue("")
                waktupinjam.value = TextFieldValue("")
            }, colors = loginButtonColors) {
                Text(
                    text = "Simpan",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }
            Button(modifier = Modifier.weight(5f), onClick = {
                judul.value = TextFieldValue("")
                penerbit.value = TextFieldValue("")
                tahunterbit.value = TextFieldValue("")
                waktupinjam.value = TextFieldValue("")
            }, colors = resetButtonColors) {
                Text(
                    text = "Reset",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}