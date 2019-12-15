# OptionsPickerDemo
底部弹框,滑动选择选项
# 配置
```
implementation 'com.zxn.optionspicker:optionspicker:1.0.0'
```
# 代码中使用
```
mMerchantOptions = new OptionPickerBuilder(getContext(), this).build();
mMerchantOptions.setPicker(mPresenter.getMerchants());
mMerchantOptions.setSelectOptions(0);
mMerchantOptions.show();
```
