//[discord](../../index.md)/[games.soloscribe.discord](index.md)/[executeWebhook](execute-webhook.md)

# executeWebhook

[jvm]\
fun [executeWebhook](execute-webhook.md)(url: [URI](https://docs.oracle.com/javase/8/docs/api/java/net/URI.html), block: [WebhookMessage](-webhook-message/index.md).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-unit/index.html))

Execute a webhook request to Discord.

The target webhook is given by [url](execute-webhook.md), and [block](execute-webhook.md) builds the message to send.
