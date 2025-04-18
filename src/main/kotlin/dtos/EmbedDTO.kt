package games.soloscribe.discord.dtos

import games.soloscribe.discord.Embed
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.format.DateTimeFormatter

/**
 * Represents an embed object in Discord.
 *
 * @see https://discord.com/developers/docs/resources/message#embed-object
 */
@Serializable
internal data class EmbedDTO(
    val title: String? = null,
    val description: String? = null,
    val url: String? = null,
    val timestamp: String? = null,
    val color: Int? = null,
    val footer: Footer? = null,
    val image: MediaObject? = null,
    val thumbnail: MediaObject? = null,
    val video: MediaObject? = null,
    val provider: Provider? = null,
    val author: Author? = null,
    val fields: List<Field>? = null,
) {
    constructor(emded: Embed) : this(
        title = emded.title,
        description = emded.description,
        url = emded.url?.toString(),
        timestamp = emded.timestamp
            ?.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME),
        color = emded.color,
        footer = emded.footer,
        image = emded.image,
        thumbnail = emded.thumbnail,
        video = emded.video,
        provider = emded.provider,
        author = emded.author,
        fields = emded.fields.ifEmpty { null },
    )

    @Serializable
    data class MediaObject(
        val url: String? = null,
        @SerialName("proxy_url")
        val proxyUrl: String? = null,
        val height: Int? = null,
        val width: Int? = null,
    )

    @Serializable
    data class Provider(
        val name: String,
        val url: String? = null,
    )

    @Serializable
    data class Author(
        val name: String,
        val url: String? = null,
        @SerialName("icon_url")
        val iconUrl: String? = null,
        @SerialName("proxy_icon_url")
        val proxyIconUrl: String? = null,
    )

    @Serializable
    data class Footer(
        val text: String,
        @SerialName("icon_url")
        val iconUrl: String? = null,
        @SerialName("proxy_icon_url")
        val proxyIconUrl: String? = null,
    )

    @Serializable
    data class Field(
        val name: String,
        val value: String,
        val inline: Boolean = false,
    )
}