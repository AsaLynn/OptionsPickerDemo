package com.zxn.optionspicker.adapter;


import com.contrarywind.adapter.WheelAdapter;
import com.contrarywind.interfaces.IPickerViewData;

import java.util.List;

public class SimpleWheelsAdapter<T extends IPickerViewData> implements WheelAdapter {


    private List<T> items;


    public SimpleWheelsAdapter(List<T> items) {
        this.items = items;
    }

    @Override
    public Object getItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return "";
    }

    @Override
    public int getItemsCount() {
        return items.size();
    }

    @Override
    public int indexOf(Object o) {
        return items.indexOf(o);
    }

}
