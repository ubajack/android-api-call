package fr.ubalia.callapis

import kotlinx.serialization.Serializable

@Serializable
data class Beer (
    val id: Long,
    val uid: String,
    val brand: String,
    val name: String,
    val style: String,
    val hop: String,
    val yeast: String,
    val malts: String,
    val ibu: String,
    val alcohol: String,
    val blg: String
)