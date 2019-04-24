package com.zxn.optionspickerdemo;

import com.contrarywind.interfaces.IPickerViewData;

/**
 * Created by zxn on 2019/4/24.
 */
public class ItemInfo implements IPickerViewData {

    public ItemInfo() {
    }

    public String name;

    @Override
    public String getPickerViewText() {
        return name;
    }
}
