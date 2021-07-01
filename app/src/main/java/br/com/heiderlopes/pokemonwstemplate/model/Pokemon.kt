package br.com.heiderlopes.pokemonwstemplate.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pokemon(
    @SerializedName("name") val nome: String,
    @SerializedName("url") val url: String
) : Parcelable {
    @IgnoredOnParcel lateinit var id: String
    @IgnoredOnParcel lateinit var url_imagem_front: String
    @IgnoredOnParcel lateinit var url_imagem_back: String
}
