package id.ac.unpas.peminjamanbuku.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Buku(
    @PrimaryKey val id: String,
    val juduBuku: String,
    val penerbit: String,
    val tahunterbit: String,
    val waktuPinjam: String
)
