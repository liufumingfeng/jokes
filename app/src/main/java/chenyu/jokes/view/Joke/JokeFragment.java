package chenyu.jokes.view.Joke;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import chenyu.jokes.R;
import chenyu.jokes.base.BaseScrollAdapter;
import chenyu.jokes.base.BaseScrollFragment;
import chenyu.jokes.model.Joke;
import chenyu.jokes.presenter.JokePresenter;
import java.util.List;
import nucleus.factory.RequiresPresenter;
import nucleus.view.NucleusSupportFragment;
import org.parceler.Parcels;

/**
 * Created by chenyu on 2017/3/6.
 */

@RequiresPresenter(JokePresenter.class)
public class JokeFragment extends BaseScrollFragment<JokeAdapter,JokePresenter> {

/*
  public JokeFragment() {
    JokeAdapter jokeAdapter = new JokeAdapter();
    Bundle args = new Bundle();
    args.putParcelable(ADAPTER, Parcels.wrap(jokeAdapter));
    this.setArguments(args);
  }
  */

  public static JokeFragment create() {
    JokeFragment jokeFragment = new JokeFragment();

    return jokeFragment;
  }
  @Override public void onCreate(Bundle state){
    super.onCreate(state);
    setAdapter(new JokeAdapter());
  }
  /*
  public static JokeFragment create() {
    JokeFragment jokeFragment = new JokeFragment();
    //Bundle args = new Bundle();
    //args.putString(ARGUMENT_ID, id);
    //jokeFragment.setArguments(args);
    return jokeFragment;
  }
  */
@Override public int getLayout() {
  return R.layout.fragment_joke;
}


  /*
@Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
    Bundle savedInstanceState) {
  View view = inflater.inflate(R.layout.fragment_joke, container, false);
  return view;
}*/

  /*
  @Override public void onViewCreated(View view,Bundle state) {
    super.onViewCreated(view,state);
    ButterKnife.bind(this,view);
  }
*/

/*
  @Override public void onResume() {
    super.onResume();
    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setAdapter(jokeAdapter);

    refreshLayout.setColorSchemeResources(R.color.colorPrimary);
    refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
      @Override public void onRefresh() {
        jokeAdapter.clear();
        getPresenter().start(1);
        currentPage = 1;
        previousTotal = 0;
        jokeAdapter.notifyDataSetChanged();
        refreshLayout.setRefreshing(false);
        Log.d("After Refresh", "count is "+jokeAdapter.getItemCount());
      }
    });

    recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
      @Override public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        int visibleItemCount = recyclerView.getChildCount();
        int totalItemCount = recyclerView.getAdapter().getItemCount();
        int firstVisibleItem =( (LinearLayoutManager)recyclerView.getLayoutManager()).findFirstVisibleItemPosition();

        if(loading) {
          if(totalItemCount > previousTotal) {
            loading = false;
            previousTotal = totalItemCount;
          }
        }
        if(!loading && (totalItemCount - visibleItemCount) <= firstVisibleItem) {

          loading = true;
          currentPage ++;
          onLoadMore();
          previousTotal = totalItemCount;
        }
      }
    });
  }

  public void onItemsNext(List<Joke> items) {
    jokeAdapter.addAll(items);
    jokeAdapter.notifyDataSetChanged();
    loading = false;
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      return;
    }
    Log.d("After load", "count is "+jokeAdapter.getItemCount());
  }

  public void onItemsError(Throwable throwable) {
    Toast.makeText(getContext(), throwable.getMessage(), Toast.LENGTH_SHORT);

  }

  public void onLoadMore(){
    getPresenter().request(currentPage);
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    jokeAdapter.clear();
  }
  */
}