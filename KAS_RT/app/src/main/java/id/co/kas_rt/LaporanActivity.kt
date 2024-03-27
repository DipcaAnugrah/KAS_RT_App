package id.co.kas_rt
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import id.co.kas_rt.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LaporanActivity : AppCompatActivity() {

    private lateinit var jumlahIuranBulananTextView: TextView
    private lateinit var totalIuranTextView: TextView
    private lateinit var pengeluaranTextView: TextView
    private lateinit var pemanfaatanTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laporan)

        jumlahIuranBulananTextView = findViewById(R.id.jumlahIuranBulananTextView)
        totalIuranTextView = findViewById(R.id.totalIuranTextView)
        pengeluaranTextView = findViewById(R.id.pengeluaranTextView)
        pemanfaatanTextView = findViewById(R.id.pemanfaatanTextView)

        // Panggil fungsi untuk mengambil data dari API
        fetchDataFromApi()
    }

    private fun fetchDataFromApi() {
        val apiService = ApiConfig.getApiService()

        // Lakukan panggilan ke API untuk masing-masing data
        apiService.getJumlahIuranBulanan().enqueue(object : Callback<Int> {
            override fun onResponse(call: Call<Int>, response: Response<Int>) {
                if (response.isSuccessful) {
                    val jumlahIuranBulanan = response.body() ?: 0
                    jumlahIuranBulananTextView.text = "Jumlah Iuran Bulanan: $jumlahIuranBulanan"
                }
            }

            override fun onFailure(call: Call<Int>, t: Throwable) {
                // Handle error ketika gagal mengambil data dari API
            }
        })

        apiService.getTotalIuran().enqueue(object : Callback<Int> {
            override fun onResponse(call: Call<Int>, response: Response<Int>) {
                if (response.isSuccessful) {
                    val totalIuran = response.body() ?: 0
                    totalIuranTextView.text = "Total Iuran: $totalIuran"
                }
            }

            override fun onFailure(call: Call<Int>, t: Throwable) {
                // Handle error ketika gagal mengambil data dari API
            }
        })

        apiService.getPengeluaranIuran().enqueue(object : Callback<Int> {
            override fun onResponse(call: Call<Int>, response: Response<Int>) {
                if (response.isSuccessful) {
                    val pengeluaran = response.body() ?: 0
                    pengeluaranTextView.text = "Pengeluaran: $pengeluaran"
                }
            }

            override fun onFailure(call: Call<Int>, t: Throwable) {
                // Handle error ketika gagal mengambil data dari API
            }
        })

        apiService.getPemanfaatanIuran().enqueue(object : Callback<Int> {
            override fun onResponse(call: Call<Int>, response: Response<Int>) {
                if (response.isSuccessful) {
                    val pemanfaatan = response.body() ?: 0
                    pemanfaatanTextView.text = "Pemanfaatan: $pemanfaatan"
                }
            }

            override fun onFailure(call: Call<Int>, t: Throwable) {
                // Handle error ketika gagal mengambil data dari API
            }
        })
    }
}
