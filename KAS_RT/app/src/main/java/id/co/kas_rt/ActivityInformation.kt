package id.co.kas_rt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import id.co.kas_rt.databinding.ActivityInformationBinding
import id.co.kas_rt.model.DataItem

class ActivityInformation : AppCompatActivity() {

    private lateinit var binding: ActivityInformationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    private fun displayUserData(userData: DataItem) {
        // Menampilkan gambar pengguna menggunakan Glide
        Glide.with(this)
            .load(userData.gambar)
            .placeholder(R.drawable.icon_avatar) // Placeholder jika gambar tidak tersedia
            .error(R.drawable.icon_avatar) // Gambar kesalahan jika ada masalah saat memuat gambar
            .transform(CircleCrop()) // Mengubah gambar menjadi lingkaran
            .into(binding.itemAvatar)

        // Menampilkan nama pengguna
        binding.itemName.text = "${userData.nama_depan} ${userData.nama_belakang}"

        // Menampilkan email pengguna
        binding.itemEmail.text = userData.email

        // Menampilkan alamat pengguna
        binding.itemAddress.text = userData.alamat

        // Menampilkan total iuran pengguna
        binding.itemTotalIuran.text = userData.total_iuran_individu.toString() // Ubah ke string karena TextView menerima string
    }
}
