//[discord](../../index.md)/[games.soloscribe.discord](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [Embed](-embed/index.md) | [jvm]<br>class [Embed](-embed/index.md)<br>A builder of an embed object in Discord. |
| [Poll](-poll/index.md) | [jvm]<br>class [Poll](-poll/index.md)<br>A builder of a poll object for Discord. |
| [Snowflake](-snowflake/index.md) | [jvm]<br>@[JvmInline](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin.jvm/-jvm-inline/index.html)<br>value class [Snowflake](-snowflake/index.md)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html))<br>A unique identifier for a Discord object. |
| [WebhookDsl](-webhook-dsl/index.md) | [jvm]<br>@[DslMarker](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-dsl-marker/index.html)<br>annotation class [WebhookDsl](-webhook-dsl/index.md) |
| [WebhookMessage](-webhook-message/index.md) | [jvm]<br>class [WebhookMessage](-webhook-message/index.md)<br>The Discord webhook message. |

## Functions

| Name | Summary |
|---|---|
| [executeWebhook](execute-webhook.md) | [jvm]<br>fun [executeWebhook](execute-webhook.md)(url: [URI](https://docs.oracle.com/javase/8/docs/api/java/net/URI.html), block: [WebhookMessage](-webhook-message/index.md).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-unit/index.html))<br>Execute a webhook request to Discord. |
| [webhookMessage](webhook-message.md) | [jvm]<br>fun [webhookMessage](webhook-message.md)(block: [WebhookMessage](-webhook-message/index.md).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-unit/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html)<br>Build a webhook message, returning the JSON string of the message. |
