package pri.weiqiang.liyujapanese.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.List;

import butterknife.BindView;
import pri.weiqaing.common.base.BaseApplication;
import pri.weiqaing.common.base.BaseFragment;
import pri.weiqaing.common.base.mvp.BasePresenter;
import pri.weiqiang.liyujapanese.R;
import pri.weiqiang.liyujapanese.mvp.bean.gojuon.GojuonTab;
import pri.weiqiang.liyujapanese.mvp.presenter.gojuon.GojuonTabFragmentPresenterImpl;
import pri.weiqiang.liyujapanese.mvp.view.gojuon.GojuonTabFragmentView;
import pri.weiqiang.liyujapanese.ui.adapter.GojuonTabPagerAdapter;

public class GojuonTabFragment extends BaseFragment implements GojuonTabFragmentView {


    private static final String TAG = GojuonTabFragment.class.getSimpleName();
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    private BasePresenter.GojuonTabFragmentPresenter presenter;


    @Override
    protected int getViewId() {
        return R.layout.fragment_tab;
    }

    @Override
    protected void initVariable(@Nullable Bundle savedInstanceState) {

        presenter = new GojuonTabFragmentPresenterImpl(this);
        setHasOptionsMenu(false);
        initTabLayout();
        initViewPager();

    }

    private void initTabLayout() {
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initViewPager() {

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                BaseApplication.CURRENT_ITEM = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    @Override
    protected void doAction() {

        presenter.initGojuonTabFragment();

    }

    @Override
    public void setData(List<GojuonTab> data) {
        //JPStartTabPagerAdapter中获得JPStartFragment
        mViewPager.setAdapter(new GojuonTabPagerAdapter(getChildFragmentManager(), data));

    }

    @Override
    public void scrollViewPager(int position) {
        mViewPager.setCurrentItem(position, true);
    }
}
