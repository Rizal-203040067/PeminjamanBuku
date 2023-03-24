package id.ac.unpas.peminjamanbuku.persistences

import androidx.lifecycle.LiveData
import androidx.room.*
import id.ac.unpas.peminjamanbuku.model.Buku

@Dao
interface BukuDao {
    @Query("SELECT * FROM Buku")
    fun loadAll(): LiveData<List<Buku>>
    @Query("SELECT * FROM Buku WHERE id = :id")
    fun find(id: String): Buku?
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg items: Buku)
    @Delete
    fun delete(item: Buku)
}