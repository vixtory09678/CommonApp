package com.wannachat.roboticsza.example.recyclerview.model

class ItemCardRight : BaseItem(ItemType.TYPE_CARD_VIEW_RIGHT) {
    private var urlPic:String = ""
    private var content:String = ""

    fun setUrlPic(url: String):ItemCardRight{
        this.urlPic = url
        return this
    }
    fun getUrlPic():String {
        return this.urlPic
    }
    fun setContent(content:String):ItemCardRight{
        this.content = content
        return this
    }
    fun getContent():String{
        return this.content
    }
}