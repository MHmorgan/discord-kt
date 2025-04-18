//[discord](../../index.md)/[games.soloscribe.discord](index.md)/[webhookMessage](webhook-message.md)

# webhookMessage

[jvm]\
fun [webhookMessage](webhook-message.md)(block: [WebhookMessage](-webhook-message/index.md).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-unit/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html)

Build a webhook message, returning the JSON string of the message.

Can be used if you want to send the message to Discord yourself. Otherwise, see [executeWebhook](execute-webhook.md).
