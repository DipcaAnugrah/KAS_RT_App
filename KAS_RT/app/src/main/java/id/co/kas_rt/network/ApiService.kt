package id.co.kas_rt.network

import id.co.kas_rt.model.ResponseUser

import retrofit2.Call

import retrofit2.http.GET

interface ApiService {
    @GET(".")
    fun getUsers(): Call<ResponseUser>
    @GET("jumlah_iuran_bulanan")
    fun getJumlahIuranBulanan(): Call<Int>

    @GET("total_iuran")
    fun getTotalIuran(): Call<Int>

    @GET("pengeluaran_iuran_warga")
    fun getPengeluaranIuran(): Call<Int>

    @GET("pemanfaatan_iuran")
    fun getPemanfaatanIuran(): Call<Int>
}
