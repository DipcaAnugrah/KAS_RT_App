package id.co.kas_rt

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NotificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        // Mendapatkan data dari intent
        val title = "Kegiatan Gotong Royong"
        val content = "Kegiatan Gotong Royong akan dilaksanakan pada tanggal 24 Mei 2024, mulai pukul 07.00-selesai" +
                " .Untuk lokasi kumpul adalah balai desa, dimohon bagi warga kampung konoha untuk kumpul tepat waktu."

        // Mengatur teks untuk TextView di layout notifikasi
        findViewById<TextView>(R.id.textViewTitle).text = title
        findViewById<TextView>(R.id.textViewContent).text = content
    }
}
