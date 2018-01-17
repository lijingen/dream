package com.yy.dream.core.api.bean;
public class GiftInfo extends ShardBean{
    private Long id;

    private Long uid;

    private String giftName;

    private Integer giftPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    public Integer getGiftPrice() {
        return giftPrice;
    }

    public void setGiftPrice(Integer giftPrice) {
        this.giftPrice = giftPrice;
    }
}