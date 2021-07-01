package br.com.heiderlopes.pokemonwstemplate.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pokemon(
    @SerializedName("name") val nome: String,
    @SerializedName("url") val url: String,
    @SerializedName("id") var id: String,
    @SerializedName("urlfront") var url_imagem_front: String,
    @SerializedName("urlback") var url_imagem_back: String
) : Parcelable {
}
