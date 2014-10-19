package com.nk.oald

import chrome.chrome

val menuItem = chrome.contextMenus.create(chrome.CreateProperties(
    title = "Search '%s' with OALD",
    contexts = array("selection"),
    onclick = { (obj : chrome.contextMenus.OnClickData, tab: Any) -> openTranslation(obj) }
))

fun openTranslation(info: chrome.contextMenus.OnClickData) {
    val word = getFirstWord(info.selectionText!!)
    if (word != null) {
        chrome.tabs.create(object {
            val url = "http://www.oxfordlearnersdictionaries.com/search/english/direct/?q=$word"
        })
    }
}

fun getFirstWord(text: String) : String? {
    return text.replace("""/[^\w\s]|_/g""", "").replace("""/\s+/g""", " ").split(" ", 1).firstOrNull()
}
