package id.ac.unpas.peminjamanbuku.persistences

import androidx.room.Database
import androidx.room.RoomDatabase
import id.ac.unpas.peminjamanbuku.model.Buku

@Database(entities = [Buku::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun BukuDao(): BukuDao
}