package games.soloscribe.discord.dtos

import games.soloscribe.discord.WebhookMessage
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

/**
 * The DTO (data transfer object) for executing a Discord webhook.
 *
 * @see https://discord.com/developers/docs/resources/webhook#execute-webhook
 */
@Serializable
internal data class MessageDTO(
    /**
     * The message contents (up to 2000 characters).
     *
     * One of content, embeds and poll must be present.
     */
    val content: String? = null,

    /**
     * Override the default username of the webhook (optional).
     */
    val username: String? = null,

    /**
     * Override the default avatar of the webhook (optional).
     */
    @SerialName("avatar_url")
    val avatarUrl: String? = null,

    /**
     * True if this is a TTS (text-to-speech) message (optional).
     */
    val tts: Boolean? = null,

    /**
     * Embedded rich content (up to 10 embeds).
     */
    val embeds: List<EmbedDTO>? = null,

    /**
     * Allowed mentions for the message (optional).
     */
    @SerialName("allowed_mentions")
    val allowedMentions: AllowedMentionsDTO? = null,

    /**
     * Message flags combined as a bitfield (optional).
     *
     * Only SUPPRESS_EMBEDS (`1 << 2`) and SUPPRESS_NOTIFICATIONS
     * (`1 << 12`) can be set.
     */
    val flags: Int? = null,

    /**
     * Name of thread to create (requires the webhook channel to
     * be a forum or media channel).
     */
    @SerialName("thread_name")
    val threadName: String? = null,

    /**
     * Array of tag IDs to apply to the thread (requires the webhook
     * channel to be a forum or media channel).
     */
    @SerialName("applied_tags")
    val appliedTags: List<String>? = null,

    /**
     * A poll!
     *
     * One of content, embeds and poll must be present.
     */
    val poll: PollDTO? = null,
) {
    init {
        require(content != null || embeds != null || poll != null) {
            "One of content, embeds and poll must be present."
        }
        require((embeds?.size ?: 0) <= 10) {
            "Maximum of 10 embeds allowed."
        }
    }

    constructor(msg: WebhookMessage) : this(
        content = msg.content,
        username = msg.username,
        avatarUrl = msg.avatarUrl?.toString(),
        embeds = msg.embeds.map { EmbedDTO(it) },
        allowedMentions = AllowedMentionsDTO(
            parse = msg.allowedMentionsParse.ifEmpty { null },
            roles = msg.allowedMentionsRoles
                .map { it.toString() }
                .ifEmpty { null },
            users = msg.allowedMentionsUsers
                .map { it.toString() }
                .ifEmpty { null },
            repliedUser = msg.allowedMentionsRepliedUser
        ),
        flags = kotlin.run {
            var flags = 0
            if (msg.suppressEmbeds)
                flags = flags or (1 shl 2)
            if (msg.suppressNotification)
                flags = flags or (1 shl 12)
            flags
        },
        threadName = msg.threadName,
        appliedTags = msg.appliedTags.map { it.toString() },
        poll = msg.poll?.let { PollDTO(it) }
    )

    fun toJson() = Json.encodeToString(this)
}
