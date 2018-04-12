package com.example.sudhasri.babynames.view

import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import com.example.sudhasri.babynames.R
import com.example.sudhasri.babynames.contract.NameScreenContract
import com.example.sudhasri.babynames.model.NameDTO
import kotlinx.android.synthetic.main.frag_list.view.*

class NameListFragment : Fragment(), NameScreenContract.View {

    private val presenter : NameScreenContract.Presenter = NameScreenContract.Factory.getPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.frag_list, container, false)
        rootView.search_view.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                presenter.searchName(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (TextUtils.isEmpty(newText)){
                    presenter.searchName(newText)
                }
                return false
            }

        })
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onCreateView(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter.loadData()
    }

    override fun showLoader() {
        hideAllViews()
        view?.progressbar?.visibility = View.VISIBLE
    }

    override fun showDataInView(sourceList: List<NameDTO>) {
        hideAllViews()
        view?.main_content?.visibility = View.VISIBLE
        val recyclerView : RecyclerView? = view?.findViewById(R.id.recycler_view)
        recyclerView?.layoutManager = LinearLayoutManager(context)
        recyclerView?.adapter = NameListAdapter(sourceList)
    }

    override fun showErrorView() {
        hideAllViews()
        view?.error_text?.visibility = View.VISIBLE
    }

    private fun hideAllViews(){
        view?.main_content?.visibility = View.GONE
        view?.progressbar?.visibility = View.GONE
        view?.error_text?.visibility = View.GONE
    }
    override fun onDestroyView() {
        super.onDestroyView()
        presenter.onDestroyView()
    }

    companion object {
        fun getInstance(): NameListFragment {
            return NameListFragment()
        }
    }
}
