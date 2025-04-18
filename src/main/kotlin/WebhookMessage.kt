@file:Suppress("NAME_SHADOWING")

package games.soloscribe.discord

import games.soloscribe.discord.dtos.EmbedDTO
import games.soloscribe.discord.dtos.MessageDTO
import games.soloscribe.discord.dtos.PollDTO
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpRequest.BodyPublishers
import java.net.http.HttpResponse.BodyHandlers
import java.time.OffsetDateTime

/**
 * Execute a webhook request to Discord.
 *
 * The target webhook is given by [url], and [block] builds the
 * message to send.
 */
fun executeWebhook(url: URI, block: WebhookMessage.() -> Unit) {
    val msg = WebhookMessage().apply(block)
    val dto = MessageDTO(msg)

    val req = HttpRequest.newBuilder(url)
        .header("Content-Type", "application/json")
        .POST(BodyPublishers.ofString(dto.toJson()))
        .build()
    val client = HttpClient.newBuilder()
        .version(HttpClient.Version.HTTP_2)
        .build()

    val resp = client.send(req, BodyHandlers.ofString())
    check(resp.statusCode() == 204) {
        "Webhook request ${resp.statusCode()}: ${resp.body()}"
    }
}

/**
 * Build a webhook message, returning the JSON string of the message.
 *
 * Can be used if you want to send the message to Discord yourself.
 * Otherwise, see [executeWebhook].
 */
fun webhookMessage(block: WebhookMessage.() -> Unit): String {
    val msg = WebhookMessage().apply(block)
    val dto = MessageDTO(msg)
    return dto.toJson()
}

@DslMarker
annotation class WebhookDsl

/**
 * The Discord webhook message.
 *
 * Used with [executeWebhook] or [webhookMessage].
 *
 * @see https://discord.com/developers/docs/resources/webhook#execute-webhook
 * @see executeWebhook For building and sending a webhook message.
 * @see webhookMessage For building a webhook message.
 */
@WebhookDsl
class WebhookMessage {
    /**
     * Override the default username of the webhook (optional).
     */
    var username: String? = null

    /**
     * Override the default avatar of the webhook (optional).
     */
    var avatarUrl: URI? = null

    /**
     * Name of thread to create (requires the webhook channel to
     * be a forum or media channel).
     */
    var threadName: String? = null

    /**
     * Array of tag IDs to apply to the thread (requires the webhook
     * channel to be a forum or media channel).
     */
    var appliedTags: MutableList<Snowflake> = mutableListOf()

    /**
     * True if this is a TTS (text-to-speech) message (optional).
     */
    var tts: Boolean? = null

    /**
     * Suppress embeds in the message (optional).
     */
    var suppressEmbeds: Boolean = false

    /**
     * Suppress notifications for the message (optional).
     */
    var suppressNotification: Boolean = false

    internal val allowedMentionsParse: MutableList<String> = mutableListOf()
    internal val allowedMentionsRoles: MutableList<Snowflake> = mutableListOf()
    internal val allowedMentionsUsers: MutableList<Snowflake> = mutableListOf()
    internal var allowedMentionsRepliedUser: Boolean? = null

    /**
     * The message contents (up to 2000 characters).
     *
     * One of content, embeds and poll must be present.
     */
    var content: String? = null
    internal val embeds: MutableList<Embed> = mutableListOf()
    internal var poll: Poll? = null

    /**
     * Allowed mentions for the message (optional).
     */
    fun allowedMention(
        parse: String? = null,
        role: Snowflake? = null,
        user: Snowflake? = null,
        repliedUser: Boolean? = null
    ) {
        if (parse != null)
            allowedMentionsParse += parse
        if (role != null)
            allowedMentionsRoles += role
        if (user != null)
            allowedMentionsUsers += user
        if (repliedUser != null)
            allowedMentionsRepliedUser = repliedUser
    }

    /**
     * Embedded rich content (up to 10 embeds).
     */
    fun embed(block: Embed.() -> Unit) {
        embeds += Embed().apply(block)
    }

    /**
     * A poll!
     *
     * One of content, embeds and poll must be present.
     */
    fun poll(block: Poll.() -> Unit) {
        poll = Poll().apply(block)
    }
}

/**
 * A builder of an embed object in Discord.
 *
 * Used as part of [WebhookMessage].
 *
 * @see https://discord.com/developers/docs/resources/message#embed-object
 */
@WebhookDsl
class Embed {
    /**
     * Title of embed
     */
    var title: String? = null

    /**
     * Description of embed
     */
    var description: String? = null

    /**
     * Url of embed
     */
    var url: URI? = null

    /**
     * Timestamp of embed content
     */
    var timestamp: OffsetDateTime? = null

    /**
     * Color code of the embed
     */
    var color: Int? = null

    internal var footer: EmbedDTO.Footer? = null
    internal var image: EmbedDTO.MediaObject? = null
    internal var thumbnail: EmbedDTO.MediaObject? = null
    internal var video: EmbedDTO.MediaObject? = null
    internal var provider: EmbedDTO.Provider? = null
    internal var author: EmbedDTO.Author? = null
    internal var fields: MutableList<EmbedDTO.Field> = mutableListOf()

    /**
     * Set footer information
     */
    fun footer(text: String, icon: URI, proxyIcon: URI? = null) {
        footer = EmbedDTO.Footer(
            text,
            icon.toString(),
            proxyIcon.toString()
        )
    }

    /**
     * Set image information
     */
    fun image(
        url: URI,
        proxyUrl: URI? = null,
        height: Int? = null,
        width: Int? = null
    ) {
        val url = url.toString()
        val proxyUrl = proxyUrl.toString()
        image = EmbedDTO.MediaObject(url, proxyUrl, height, width)
    }

    /**
     * Set thumbnail information
     */
    fun thumbnail(
        url: URI,
        proxyUrl: URI? = null,
        height: Int? = null,
        width: Int? = null
    ) {
        val url = url.toString()
        val proxyUrl = proxyUrl.toString()
        thumbnail = EmbedDTO.MediaObject(url, proxyUrl, height, width)
    }

    /**
     * Set video information
     */
    fun video(
        url: URI,
        proxyUrl: URI? = null,
        height: Int? = null,
        width: Int? = null
    ) {
        val url = url.toString()
        val proxyUrl = proxyUrl.toString()
        video = EmbedDTO.MediaObject(url, proxyUrl, height, width)
    }

    /**
     * Set provider information
     */
    fun provider(name: String, url: URI? = null) {
        provider = EmbedDTO.Provider(name, url?.toString())
    }

    /**
     * Set author information
     */
    fun author(
        name: String,
        url: URI? = null,
        iconUrl: URI? = null,
        proxyIconUrl: URI? = null
    ) {
        val url = url?.toString()
        val iconUrl = iconUrl.toString()
        val proxyIconUrl = proxyIconUrl.toString()
        author = EmbedDTO.Author(name, url, iconUrl, proxyIconUrl)
    }

    /**
     * Add a field to the fields information
     */
    fun addField(
        name: String,
        value: String,
        inline: Boolean = false
    ) {
        fields.add(EmbedDTO.Field(name, value, inline))
    }
}

/**
 * A builder of a poll object for Discord.
 *
 * Used as part of [WebhookMessage].
 *
 * @see https://discord.com/developers/docs/resources/poll#poll-create-request-object
 */
@WebhookDsl
class Poll {
    /**
     * The question of the poll.
     */
    var question: String? = null

    /**
     * Number of hours the poll should be open for, up to 32 days.
     * Defaults to 24.
     */
    var duration: Int? = null

    /**
     * Whether a user can select multiple answers.
     */
    var allowMultiselect: Boolean? = null

    internal val answers: MutableList<PollDTO.Answer> = mutableListOf()

    /**
     * Add an answer to the poll.
     *
     * An emoji can either be a custom emoji (id) or a default emoji (name).
     */
    fun addAnswer(
        text: String,
        emojiId: Snowflake? = null,
        emojiName: String? = null,
    ) {
        val emoji = if (emojiId != null) {
            PollDTO.Emoji(id = emojiId.id)
        } else if (emojiName != null) {
            PollDTO.Emoji(name = emojiName)
        } else {
            null
        }
        val media = PollDTO.MediaObject(text, emoji)
        answers.add(PollDTO.Answer(media))
    }
}

/**
 * A unique identifier for a Discord object.
 *
 * @see https://discord.com/developers/docs/reference#snowflakes
 */
@JvmInline
value class Snowflake(val id: String) {
    constructor(id: UInt) : this(id.toString())
    constructor(id: ULong) : this(id.toString())

    init {
        requireNotNull(id.toULongOrNull()) {
            "Invalid snowflake: $id"
        }
    }
}
