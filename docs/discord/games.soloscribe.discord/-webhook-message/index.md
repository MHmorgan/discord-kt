//[discord](../../../index.md)/[games.soloscribe.discord](../index.md)/[WebhookMessage](index.md)

# WebhookMessage

class [WebhookMessage](index.md)

The Discord webhook message.

Used with [executeWebhook](../execute-webhook.md) or [webhookMessage](../webhook-message.md).

#### See also

| | |
|---|---|
| https | ://discord.com/developers/docs/resources/webhook#execute-webhook |
| [executeWebhook](../execute-webhook.md) | For building and sending a webhook message. |
| [webhookMessage](../webhook-message.md) | For building a webhook message. |

## Constructors

| | |
|---|---|
| [WebhookMessage](-webhook-message.md) | [jvm]<br>constructor() |

## Properties

| Name | Summary |
|---|---|
| [appliedTags](applied-tags.md) | [jvm]<br>var [appliedTags](applied-tags.md): [MutableList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.collections/-mutable-list/index.html)&lt;[Snowflake](../-snowflake/index.md)&gt;<br>Array of tag IDs to apply to the thread (requires the webhook channel to be a forum or media channel). |
| [avatarUrl](avatar-url.md) | [jvm]<br>var [avatarUrl](avatar-url.md): [URI](https://docs.oracle.com/javase/8/docs/api/java/net/URI.html)?<br>Override the default avatar of the webhook (optional). |
| [content](content.md) | [jvm]<br>var [content](content.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html)?<br>The message contents (up to 2000 characters). |
| [suppressEmbeds](suppress-embeds.md) | [jvm]<br>var [suppressEmbeds](suppress-embeds.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-boolean/index.html)<br>Suppress embeds in the message (optional). |
| [suppressNotification](suppress-notification.md) | [jvm]<br>var [suppressNotification](suppress-notification.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-boolean/index.html)<br>Suppress notifications for the message (optional). |
| [threadName](thread-name.md) | [jvm]<br>var [threadName](thread-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html)?<br>Name of thread to create (requires the webhook channel to be a forum or media channel). |
| [tts](tts.md) | [jvm]<br>var [tts](tts.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-boolean/index.html)?<br>True if this is a TTS (text-to-speech) message (optional). |
| [username](username.md) | [jvm]<br>var [username](username.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html)?<br>Override the default username of the webhook (optional). |

## Functions

| Name | Summary |
|---|---|
| [allowedMention](allowed-mention.md) | [jvm]<br>fun [allowedMention](allowed-mention.md)(parse: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html)? = null, role: [Snowflake](../-snowflake/index.md)? = null, user: [Snowflake](../-snowflake/index.md)? = null, repliedUser: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-boolean/index.html)? = null)<br>Allowed mentions for the message (optional). |
| [embed](embed.md) | [jvm]<br>fun [embed](embed.md)(block: [Embed](../-embed/index.md).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-unit/index.html))<br>Embedded rich content (up to 10 embeds). |
| [poll](poll.md) | [jvm]<br>fun [poll](poll.md)(block: [Poll](../-poll/index.md).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-unit/index.html))<br>A poll! |
