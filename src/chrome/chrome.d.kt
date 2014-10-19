package chrome

data class CreateProperties(
        val title: String,
        val contexts: Array<String>,
        val onclick: (info: chrome.contextMenus.OnClickData, tab: Any) -> Unit
)

[suppress("UNUSED_PARAMETER")]
native
object chrome {
    public object contextMenus {
        public trait OnClickData {
            val selectionText: String?
        }

        public fun create(options: CreateProperties? = null): Unit = noImpl
    }

    [suppress("UNUSED_PARAMETER")]
    native
    public object tabs {
        fun create(options: Any? = null): Unit = noImpl
    }
}
