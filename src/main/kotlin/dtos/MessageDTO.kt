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
    val content: String? = null,
    val username: String? = null,
    @SerialName("avatar_url")
    val avatarUrl: String? = null,
    val tts: Boolean? = null,
    val embeds: List<EmbedDTO>? = null,
    @SerialName("allowed_mentions")
    val allowedMentions: AllowedMentionsDTO? = null,
    /**
     * Message flags combined as a bitfield (optional).
     *
     * Only SUPPRESS_EMBEDS (`1 << 2`) and SUPPRESS_NOTIFICATIONS
     * (`1 << 12`) can be set.
     */
    val flags: Int? = null,
    @SerialName("thread_name")
    val threadName: String? = null,
    @SerialName("applied_tags")
    val appliedTags: List<String>? = null,
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
        tts = msg.tts,
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
