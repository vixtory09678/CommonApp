package com.wannachat.roboticsza.example.recyclerview.model

class ItemCardLeft : BaseItem(ItemType.TYPE_CARD_VIEW_LEFT) {
    private var urlPic:String = ""
    private var content:String = ""

    fun setUrlPic(url: String):ItemCardLeft{
        this.urlPic = url
        return this
    }
    fun getUrlPic():String {
        return this.urlPic
    }
    fun setContent(content:String):ItemCardLeft{
        this.content = content
        return this
    }
    fun getContent():String{
        return this.content
    }
}