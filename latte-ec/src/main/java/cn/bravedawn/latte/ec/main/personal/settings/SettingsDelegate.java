package cn.bravedawn.latte.ec.main.personal.settings;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.bravedawn.latte.delegates.LatteDelegate;
import cn.bravedawn.latte.ec.R;
import cn.bravedawn.latte.ec.R2;
import cn.bravedawn.latte.ec.main.personal.address.AddressDelegate;
import cn.bravedawn.latte.ec.main.personal.list.ListAdapter;
import cn.bravedawn.latte.ec.main.personal.list.ListBean;
import cn.bravedawn.latte.ec.main.personal.list.ListItemType;
import cn.bravedawn.latte.util.callback.CallBackManager;
import cn.bravedawn.latte.util.callback.CallBackType;

/**
 * Created by 冯晓 on 2017/10/1.
 */

public class SettingsDelegate extends LatteDelegate{

    @BindView(R2.id.rv_settings)
    RecyclerView mRecyclerView = null;


    @Override
    public Object setLayout() {
        return R.layout.delegate_settings;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        final ListBean push = new ListBean.Builder()
                .setItemType(ListItemType.ITEM_SWITCH)
                .setId(1)
                .setDelegate(new AddressDelegate())
                .setText("消息推送")
                .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked){
                            CallBackManager.getInstance().getCallBack(CallBackType.TAG_OPEN_PUSH)
                                    .executeCallBack(null);
                            Toast.makeText(getContext(), "打开推送", Toast.LENGTH_LONG).show();
                        } else{
                            CallBackManager.getInstance().getCallBack(CallBackType.TAG_STOP_PUSH)
                                    .executeCallBack(null);
                            Toast.makeText(getContext(), "关闭推送", Toast.LENGTH_LONG).show();
                        }
                    }
                })
                .build();
        final ListBean about = new ListBean.Builder()
                .setItemType(ListItemType.ITEM_NORMAL)
                .setId(2)
                .setText("关于")
                .setDelegate(new AboutDelegate())
                .build();
        final List<ListBean> data = new ArrayList<>();
        data.add(push);
        data.add(about);

        // 设置RecyclerView
        final LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(manager);
        final ListAdapter adapter = new ListAdapter(data);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addOnItemTouchListener(new SettingsClickListener(this));
    }
}