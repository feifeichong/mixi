package com.lecotec.mixi.model.parameter;

import com.lecotec.mixi.model.entity.Goods;
import com.lecotec.mixi.model.entity.GoodsTag;
import com.lecotec.mixi.model.entity.GoodsType;

import java.util.ArrayList;
import java.util.List;

public class GoodsParamForSave extends Goods {
    private long goodsTypeId;
    private long[] goodsTagIds;

    public long getGoodsTypeId() {
        return goodsTypeId;
    }

    public void setGoodsTypeId(long goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
        GoodsType entity = new GoodsType();
        entity.setId(goodsTypeId);
        super.setGoodsType(entity);
    }

    public long[] getGoodsTagIds() {
        return goodsTagIds;
    }

    public void setGoodsTagIds(long[] goodsTagIds) {
        this.goodsTagIds = goodsTagIds;
        List<GoodsTag> goodsTags = new ArrayList<>();
        for (long tagId : goodsTagIds) {
            GoodsTag tag = new GoodsTag();
            tag.setId(tagId);
            goodsTags.add(tag);
        }
        super.setGoodsTags(goodsTags);
    }
}
